package com.fampay.contextualcards

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.fampay.contextualcards.api.RetrofitApi
import com.fampay.contextualcards.api.model.CardGroups
import com.fampay.contextualcards.databinding.ActivityMainBinding
import com.fampay.contextualcards.ui.`interface`.ItemClickListener
import com.fampay.contextualcards.ui.adapter.CardGroupAdapter
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val job =  SupervisorJob()
    private val ioScope by lazy { CoroutineScope(job + Dispatchers.IO) }
    
    private val listener = object: ItemClickListener {
        override fun openLink(url: String) {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent)
        }

        override fun dismissItem(position: Int) {
            cardGroupAdapter.removeItem(position)
        }
    }

    private lateinit var cardGroupAdapter: CardGroupAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.refresh.setOnRefreshListener {
            binding.progressBar.visibility = View.VISIBLE
            launchCoroutine()
            binding.refresh.isRefreshing = false
        }

        launchCoroutine()
    }

    private fun launchCoroutine(){
        ioScope.launch {
            val cardGroups = fetchData()
            cardGroupAdapter = CardGroupAdapter(cardGroups, listener, baseContext)
            withContext(Dispatchers.Main){
                binding.container.apply {
                    adapter = cardGroupAdapter
                    layoutManager = LinearLayoutManager(context)
                }
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    private suspend fun fetchData(): ArrayList<CardGroups> {
        return RetrofitApi.service.getCards().body()!!.cardGroups
    }
}