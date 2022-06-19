package com.fampay.contextualcards.ui.holder

import android.graphics.Color
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fampay.contextualcards.R
import com.fampay.contextualcards.api.model.Cards
import com.fampay.contextualcards.databinding.LayoutCardHc3Binding
import com.fampay.contextualcards.ui.`interface`.ItemClickListener

class BigDisplayCardViewHolder(private val binding: LayoutCardHc3Binding) : RecyclerView.ViewHolder(binding.root){
    fun bind(card: Cards, listener: ItemClickListener, position: Int) {
        binding.apply {
            cardTitle.text = card.title
            cardDescription.text = card.description

            if (card.backgroundImage.imageUrl != null && card.backgroundImage.imageType == EXT)
                Glide.with(binding.root).load(card.backgroundImage.imageUrl).into(background)

            if (card.cta.size > 0) {
                val actionData = card.cta[0]
                actionButton.apply {
                    text = actionData.text
                    setBackgroundColor(Color.parseColor(actionData.bgColor))
                    setTextColor(Color.parseColor(actionData.textColor))
                    setOnClickListener { actionData.url?.let { url -> listener.openLink(url) } }
                }
            }

            bigDisplayCard.setBackgroundColor(Color.parseColor(card.backgroundColor))

            root.setOnLongClickListener {
                sideButtons.visibility = View.VISIBLE
                true
            }

            sideButtons.findViewById<LinearLayout>(R.id.dismiss_button)
                .setOnClickListener { listener.dismissItem(position) }

            sideButtons.findViewById<LinearLayout>(R.id.remind_button)
                .setOnClickListener { listener.dismissItem(position) }
        }
    }

    companion object ImageType {
        const val EXT = "ext"
    }
}