package com.example.myusers.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myusers.viewmodel.UsersViewModel
import com.example.myusers.databinding.ActivityMainBinding


class MainActivity() : AppCompatActivity() {
    val usersViewModel: UsersViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        usersViewModel.fetchUsers()
        usersViewModel.usersLiveData.observe(this, Observer { usersList ->
            Toast.makeText(
                baseContext,
                "fetched ${usersList?.size} users",
                Toast.LENGTH_LONG
            ).show()
            binding.rvUsers.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvUsers.adapter=UsersRvAdapter(usersList)

        })
        usersViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(
                baseContext, error,
                Toast.LENGTH_LONG
            ).show()
        })

    }}