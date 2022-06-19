package com.fampay.contextualcards.ui.holder

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fampay.contextualcards.api.model.Cards
import com.fampay.contextualcards.databinding.LayoutCardHc1Binding
import com.fampay.contextualcards.ui.`interface`.ItemClickListener

class SmallDisplayCardViewHolder(private val binding: LayoutCardHc1Binding) : RecyclerView.ViewHolder(binding.root){
    fun bind(card: Cards, listener: ItemClickListener) {
        binding.apply {
            cardTitle.text = card.title

            card.backgroundColor?.let { color -> smallDisplayCard.setBackgroundColor(Color.parseColor(color)) }

            if (card.icon?.imageUrl != null && card.icon?.imageType == EXT)
                Glide.with(binding.root).load(card.icon?.imageUrl).into(cardImage)

            smallDisplayCard.setOnClickListener { card.url?.let { url -> listener.openLink(url) } }
        }
    }

    companion object ImageType {
        const val EXT = "ext"
    }
}