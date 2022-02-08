package com.nazirov.messengerui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.nazirov.messengerui.R
import com.nazirov.messengerui.model.Chat
import com.nazirov.messengerui.model.Room


class Chatadapter(var context: Context, var items: ArrayList<Chat>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_ITEM_ROOM = 0
    private val TYPE_ITEM_MESSAGE = 1

    override fun getItemViewType(position: Int): Int {
        val feed = items[position]
        if (feed.rooms.size > 0)
            return TYPE_ITEM_ROOM
        return TYPE_ITEM_MESSAGE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_ROOM) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_chat_room, parent, false)
            return RoomViewHolder(context, view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_chat_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = items[position]

        if (holder is RoomViewHolder) {
            var recyclerView = holder.recyclerView
            refreshAdapter(message.rooms, recyclerView)
        }

        if (holder is MessageViewHolder) {
            val ivProfile = holder.ivProfile
            val tvFullName = holder.tvFullName
            val isOnline = holder.isOnline

            ivProfile.setImageResource(message.message!!.profile)
            tvFullName.text = message.message!!.fullname
            if (message.message!!.isOnline) {
                isOnline.visibility = View.VISIBLE
            }else {
                isOnline.visibility = View.GONE
            }
        }
    }

    private fun refreshAdapter(rooms: ArrayList<Room>, recyclerView: RecyclerView) {
        val adapter = RoomAdapter(context, rooms)
        recyclerView.adapter = adapter
    }

    override fun getItemCount(): Int {
        return items.size
    }

    // holders

    private class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivProfile: ShapeableImageView = view.findViewById(R.id.iv_profile)
        var tvFullName: TextView = view.findViewById(R.id.tv_fullname)
        var isOnline: LinearLayout = view.findViewById(R.id.is_online)
    }

    private class RoomViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {
        var recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        init {
            val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.layoutManager = manager
        }
    }
}