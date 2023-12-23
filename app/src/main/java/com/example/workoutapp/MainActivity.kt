package com.example.workoutapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import com.example.workoutapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding : ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.flStartCounter?.setOnClickListener {
            activityIntent(this@MainActivity,ExerciseActivity::class.java)
        }
         binding?.flBmi?.setOnClickListener {
            this.activityIntent(this@MainActivity,BMIActivity::class.java)
        }
        binding?.flHistory?.setOnClickListener {
            this.activityIntent(this@MainActivity,HistoryActivity::class.java)
        }

    }

    private fun activityIntent(context: Context,targetActivity:Class<out Activity>){
        val intent = Intent(context,targetActivity)
        startActivity(intent)
    }
    override fun onDestroy(){
        super.onDestroy()
        binding = null
    }
}