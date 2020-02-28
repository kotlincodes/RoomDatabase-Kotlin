package com.kotlincodes.roomdatabasekotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlincodes.roomdatabasekotlin.R
import com.kotlincodes.roomdatabasekotlin.model.UserModel


class RecyAdapter(var context: Context, private var list: List<UserModel>) :
    RecyclerView.Adapter<RecyAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.list_item_user,
                viewGroup,
                false
            )
        )
    }




    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val textName: TextView = itemView!!.findViewById(R.id.txtName)
        val textMob: TextView = itemView!!.findViewById(R.id.txtMob)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rowItem=list[position]

        holder.textName.text=rowItem.name
        holder.textMob.text=rowItem.mobile
    }

    override fun getItemCount(): Int {
        return list.size
    }


}