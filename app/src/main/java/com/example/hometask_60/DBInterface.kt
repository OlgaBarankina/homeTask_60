package com.example.hometask_60

interface DBInterface {
     fun addMessage(message: String)
     fun getAllMessages(callback: DbCallBack)
}