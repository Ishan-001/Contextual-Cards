package com.fampay.contextualcards.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fampay.contextualcards.api.model.Cards
import com.fampay.contextualcards.databinding.*
import com.fampay.contextualcards.ui.`interface`.ItemClickListener
import com.fampay.contextualcards.ui.holder.*

class CardAdapter(
    private val cards: ArrayList<Cards>,
    private val listener: ItemClickListener,
    private val viewType: Int,
    private val height: Int,
    private val position: Int
        ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): RecyclerView.ViewHolder {
        when (viewType){
            6 -> {
                val itemBinding = LayoutCardHc6Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ArrowCardViewHolder(itemBinding)
            }
            5 -> {
                val itemBinding = LayoutCardHc5Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ImageCardViewHolder(itemBinding)
            }
            1 -> {
                val itemBinding = LayoutCardHc1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return SmallDisplayCardViewHolder(itemBinding)
            }
            9 -> {
                val itemBinding = LayoutCardHc9Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return DynamicWidthCardViewHolder(itemBinding)
            }
            3 -> {
                val itemBinding = LayoutCardHc3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return BigDisplayCardViewHolder(itemBinding)
            }
            else -> {
                val itemBinding = LayoutCardHc6Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ArrowCardViewHolder(itemBinding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, mPosition: Int) {
        when (viewType) {
            6 -> (holder as ArrowCardViewHolder).bind(cards[mPosition], listener)
            5 -> (holder as ImageCardViewHolder).bind(cards[mPosition], listener)
            1 -> (holder as SmallDisplayCardViewHolder).bind(cards[mPosition], listener)
            9 -> (holder as DynamicWidthCardViewHolder).bind(cards[mPosition], height, listener)
            3 -> (holder as BigDisplayCardViewHolder).bind(cards[mPosition], listener, position)
        }
    }

    override fun getItemCount(): Int {
        return cards.size
    }

}