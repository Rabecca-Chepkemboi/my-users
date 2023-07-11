package com.example.myusers.models

import com.example.myusers.models.User

data class UsersResponse(
    var users:List<User>,
    var total:Int,
    var skip:Int,
    var limit:Int
)
