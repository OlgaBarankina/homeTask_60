package com.example.hometask_60

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val dbManager = DbFireManager()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // add
        //implementation platform('com.google.firebase:firebase-bom:29.0.2')
        //implementation 'com.google.firebase:firebase-analytics'


        dbManager.addMessage("Olga: Hi!")
        dbManager.addMessage("Vlad: Hi!")
        dbManager.addMessage("Olga: This is my first chat on Firebase!")
        dbManager.addMessage("Vlad: Great! Congratulations!")
        dbManager.addMessage("Olga: I'm so happy!")
        dbManager.addMessage("Vlad: Yes, you should be proud of yourself! Keep going")
        dbManager.addMessage("Olga: I will")
        dbManager.getAllMessages(object : DbCallBack {
            override fun onAllMessages(messages: ArrayList<String>) {

                var formatedMessage = ""

                for(message in messages) {
                    formatedMessage += ("\n" + message)
                }

                tvChat.text = formatedMessage
            }
        })
    }
}