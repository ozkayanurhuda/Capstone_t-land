package com.nurozkaya.capstone_t_land.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nurozkaya.capstone_t_land.databinding.CardTasarimBinding
import com.nurozkaya.capstone_t_land.entity.Tisortler
import com.nurozkaya.capstone_t_land.fragments.TisortlerFragment
import com.nurozkaya.capstone_t_land.viewmodels.UrunlerViewModel
import com.squareup.picasso.Picasso

class UrunlerAdapter (var mContext:Context, var tisortList:List<Tisortler>, var viewModel:UrunlerViewModel)
    :RecyclerView.Adapter<UrunlerAdapter.CardTasarimTutucu>()
{
        inner class CardTasarimTutucu(cardTasarimBinding: CardTasarimBinding)
            :RecyclerView.ViewHolder(cardTasarimBinding.root) {

            var cardView:CardTasarimBinding=cardTasarimBinding
//            init {
//                this.cardView=cardTasarimBinding
//            }


            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater=LayoutInflater.from(mContext)
        val view=CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(view)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val tisort= tisortList[position]
        holder.cardView.tisortNesnesi=tisort

        //detaya geciş
//        holder.cardTasarimBinding.cardView.setOnClickListener {
//
//        }

        val tisortResim_url=tisort.urun_gorsel_url
        Picasso.get().load(tisortResim_url).into(holder.cardView.tisortResim)

    }

    override fun getItemCount(): Int {
        return tisortList.size
    }


}