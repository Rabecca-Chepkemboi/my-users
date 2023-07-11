package com.example.myusers.models

import android.provider.ContactsContract.CommonDataKinds.Phone

data class User(
    var id:Int,
    var firstName:String,
    var lastName:String,
    var maidenName:String,
    var age:Int,
    var email:String,
    var phone:String,
    var userName:String,
    var password:String,
    var birthDate:String,
    var image:String,
)