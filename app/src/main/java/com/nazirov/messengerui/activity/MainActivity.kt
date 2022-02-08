package com.nazirov.messengerui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nazirov.messengerui.R
import com.nazirov.messengerui.adapter.Chatadapter
import com.nazirov.messengerui.model.Chat
import com.nazirov.messengerui.model.Message
import com.nazirov.messengerui.model.Room

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this,1)

        refreshAdapter(gettAllChats())
    }

    private fun gettAllChats(): ArrayList<Chat> {
        val stories:ArrayList<Room> = ArrayList()
        stories.add(Room(R.drawable.img_2,"Nazirov ELmurod"))
        stories.add(Room(R.drawable.img_3,"Nazirov ELmurod"))
        stories.add(Room(R.drawable.img_4,"Nazirov ELmurod"))
        stories.add(Room(R.drawable.img_5,"Nazirov ELmurod"))
        stories.add(Room(R.drawable.img_6,"Nazirov ELmurod"))
        stories.add(Room(R.drawable.img_7,"Nazirov ELmurod"))
        stories.add(Room(R.drawable.img_8,"Nazirov ELmurod"))
        stories.add(Room(R.drawable.img_9,"Nazirov ELmurod"))
        stories.add(Room(R.drawable.img_2,"Nazirov ELmurod"))
        stories.add(Room(R.drawable.img_2,"Nazirov ELmurod"))
        stories.add(Room(R.drawable.img_3,"Nazirov ELmurod"))
        stories.add(Room(R.drawable.img_4,"Nazirov ELmurod"))
        stories.add(Room(R.drawable.img_5,"Nazirov ELmurod"))
        stories.add(Room(R.drawable.img_6,"Nazirov ELmurod"))
        stories.add(Room(R.drawable.img_7,"Nazirov ELmurod"))
        stories.add(Room(R.drawable.img_8,"Nazirov ELmurod"))
        stories.add(Room(R.drawable.img_9,"Nazirov ELmurod"))
        stories.add(Room(R.drawable.img_2,"Nazirov ELmurod"))

        val  chats:ArrayList<Chat> = ArrayList()

        chats.add(Chat(stories))

        chats.add(Chat(Message(R.drawable.img_2,"Elmurod",false)))
        chats.add(Chat(Message(R.drawable.img_3,"Elmurod",false)))
        chats.add(Chat(Message(R.drawable.img_4,"Elmurod",true)))
        chats.add(Chat(Message(R.drawable.img_5,"Elmurod",false)))
        chats.add(Chat(Message(R.drawable.img_6,"Elmurod",true)))
        chats.add(Chat(Message(R.drawable.img_7,"Elmurod",false)))
        chats.add(Chat(Message(R.drawable.img_8,"Elmurod",false)))
        chats.add(Chat(Message(R.drawable.img_4,"Elmurod",true)))
        chats.add(Chat(Message(R.drawable.img_6,"Elmurod",false)))
        chats.add(Chat(Message(R.drawable.img_9,"Elmurod",false)))
        chats.add(Chat(Message(R.drawable.img_7,"Elmurod",false)))
        chats.add(Chat(Message(R.drawable.img_3,"Elmurod",false)))
        chats.add(Chat(Message(R.drawable.img_4,"Elmurod",false)))

        return chats

    }

    private fun refreshAdapter(chats: ArrayList<Chat>) {
        var  adapter = Chatadapter(this,chats)
        recyclerView!!.adapter =adapter

    }
}