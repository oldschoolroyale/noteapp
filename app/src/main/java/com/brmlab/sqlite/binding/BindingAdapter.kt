package com.brmlab.sqlite.binding

import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import com.brmlab.sqlite.R

class BindingAdapter {

    companion object{
        @BindingAdapter("android:toUpgradeFragment")
        @JvmStatic
        fun toUpgradeFragment(view: CardView, navigate: Boolean){
            view.setOnClickListener {
                if (navigate){
                    view.findNavController().navigate(R.id.action_listFragment_to_updateFragment)
                }
            }

        }
    }
}