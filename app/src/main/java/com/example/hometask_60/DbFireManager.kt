package com.example.hometask_60

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DbFireManager: DBInterface {
    private val database = FirebaseDatabase.getInstance()

    override fun addMessage(message: String) {
        val reference = database.getReference("db").child("chat") // path to my chat
        val messageId = reference.push().key

        if (messageId != null)
            reference.child(messageId).setValue(message)
    }

    override fun getAllMessages(callback: DbCallBack) {
        val messages = ArrayList<String>()
        val reference = database.getReference("db").child("chat")

        reference.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                   messages.clear()

                for (item in snapshot.children) {

                    val value: String? =
                        item.getValue(String::class.java) // or item.getValue(ArrayList<String>::class.java)
                    if (value != null) messages.add(value)
                }
                callback.onAllMessages(messages)
            }

            override fun onCancelled(error: DatabaseError) {}

        })


    }
}

    interface DbCallBack {
        fun onAllMessages(messages: ArrayList<String>)
    }

