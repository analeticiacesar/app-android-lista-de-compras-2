package com.analeticiacesar.listadecompras

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import com.analeticiacesar.listadecompras.databinding.ActivityMainBinding

class MainActivity : Activity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}