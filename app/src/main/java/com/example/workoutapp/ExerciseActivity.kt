package com.example.workoutapp

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.example.workoutapp.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {
    private var restTimer : CountDownTimer? = null
    private var restProgress:Int = 0
    private var exerciseTimer :CountDownTimer? = null
    private var exerciseProgress:Int = 0

    private var binding : ActivityExerciseBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarExercise)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarExercise?.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        setUpRestView()
    }

    private fun setUpRestView(){
        if(restTimer != null){
            restTimer?.cancel()
            restProgress = 0
        }
        setRestProgress()
    }
    private  fun setRestProgress() {
        binding?.pbProgress?.progress = restProgress
        restTimer = object: CountDownTimer(10000,1000){
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                binding?.pbProgress?.progress = 10-restProgress
                binding?.tvTimer?.text = (10-restProgress).toString()
            }

            override fun onFinish() {
                setupExerciseView()
            }

        }.start()
    }

    private  fun setupExerciseProgressTimer(){
        binding?.ExerciseProgress?.progress = exerciseProgress
        exerciseTimer = object :CountDownTimer(30000,1000){
            override fun onTick(millisUntilFinished: Long) {
                exerciseProgress++
                binding?.ExerciseProgress?.progress = 30- exerciseProgress
                binding?.ExerciseTimer?.text = (30-exerciseProgress).toString()
            }

            override fun onFinish() {
                Toast.makeText(this@ExerciseActivity,"30 seconds over",Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

    private fun setupExerciseView(){
        binding?.flCounter?.visibility = View.INVISIBLE
        binding?.tvStart?.text = "Exercise name"
        binding?.flExerciseView?.visibility = View.VISIBLE
        if(exerciseTimer != null){
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }
        setupExerciseProgressTimer()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(restTimer != null){
            restTimer?.cancel()
            restProgress = 0
        }
        if(exerciseTimer != null){
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }
        binding = null
    }
}