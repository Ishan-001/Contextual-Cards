package com.fampay.contextualcards.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fampay.contextualcards.api.model.CardGroups
import com.fampay.contextualcards.databinding.LayoutCardGroupBinding
import com.fampay.contextualcards.ui.`interface`.ItemClickListener

class CardGroupAdapter(
    private val cardGroups : ArrayList<CardGroups>,
    private val listener : ItemClickListener,
    private val context : Context
) :
    RecyclerView.Adapter<CardGroupAdapter.CardGroupViewHolder>() {

    class CardGroupViewHolder(private val binding : LayoutCardGroupBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cardGroup: CardGroups, listener: ItemClickListener, context : Context, position: Int){
            val adapter = CardAdapter(cardGroup.cards, listener, cardGroup.designType!![2].toInt() - 48, cardGroup.height!!, position)
            binding.apply {
                if (cardGroup.designType != "HC1") {
                    cardRecyclerView.adapter = adapter
                    cardRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                }
                else {
                    cardRecyclerView.adapter = adapter
                    if (cardGroup.isScrollable!!)
                        cardRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    else
                        cardRecyclerView.layoutManager = GridLayoutManager(context, cardGroup.cards.size)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardGroupViewHolder {
        val itemBinding = LayoutCardGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardGroupViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: CardGroupViewHolder, position: Int) {
        holder.bind(cardGroups[position], listener, context, position)
    }

    override fun getItemCount(): Int {
        return cardGroups.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(cardGroups[position].designType) {
            "HC6" -> 6
            "HC5" -> 5
            "HC1" -> 1
            "HC9" -> 9
            "HC3" -> 3
            else -> 0
        }
    }
    
    fun removeItem(position: Int){
        cardGroups.removeAt(position)
        notifyItemRemoved(position)
    }
}