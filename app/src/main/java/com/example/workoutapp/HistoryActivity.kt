package com.example.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workoutapp.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {
    private var binding:ActivityHistoryBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setupToolbar()
    }

    private fun setupToolbar(){
        setSupportActionBar(binding?.tbHistory)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.tbHistory?.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
       this@HistoryActivity.title = "History"
    }
}