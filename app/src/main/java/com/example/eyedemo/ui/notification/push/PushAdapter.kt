package com.example.eyedemo.ui.notification.push

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eyedemo.R
import com.example.eyedemo.extension.inflate
import com.example.eyedemo.logic.model.PushMessage

class PushAdapter(val fragment: PushFragment, var dataList: List<PushMessage.Message>) :
    RecyclerView.Adapter<PushAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holder = ViewHolder(R.layout.item_notification_push.inflate(parent))
        holder.itemView.setOnClickListener {
            val item = dataList[holder.]
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}