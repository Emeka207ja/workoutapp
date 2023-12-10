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
    private var exerciseList :ArrayList<ExerciseModel>? = null
    private var binding : ActivityExerciseBinding? = null
    private var currentExercisePosition:Int = -1
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
        exerciseList = Constants.getExerciseList()
        setUpRestView()

    }

    private fun setUpRestView(){
        binding?.flCounter?.visibility = View.VISIBLE
        binding?.tvStart?.visibility = View.VISIBLE
        binding?.tvStart?.visibility = View.VISIBLE
        binding?.tvExerciseName?.visibility = View.INVISIBLE
        binding?.flExerciseView?.visibility = View.INVISIBLE
        binding?.ivExerciseIcons?.visibility = View.INVISIBLE
        binding?.tvExerciseLabel?.visibility = View.VISIBLE
        binding?.tvUpcomingExerciseName?.visibility = View.VISIBLE
        if(restTimer != null){
            restTimer?.cancel()
            restProgress = 0
        }

        binding?.tvUpcomingExerciseName?.text = exerciseList!![currentExercisePosition+1].getName()
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
                currentExercisePosition++
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
               if(currentExercisePosition<exerciseList!!.size-1){
                   setUpRestView()
               }else{
                   Toast.makeText(this@ExerciseActivity,"finished",Toast.LENGTH_SHORT).show()
               }
            }
        }.start()
    }

    private fun setupExerciseView(){
        binding?.flCounter?.visibility = View.INVISIBLE
        binding?.tvStart?.visibility = View.INVISIBLE
        binding?.tvExerciseName?.visibility = View.VISIBLE
        binding?.flExerciseView?.visibility = View.VISIBLE
        binding?.ivExerciseIcons?.visibility = View.VISIBLE
        binding?.tvExerciseLabel?.visibility = View.INVISIBLE
        binding?.tvUpcomingExerciseName?.visibility = View.INVISIBLE
        if(exerciseTimer != null){
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }
        setupExerciseProgressTimer()
        binding?.ivExerciseIcons?.setImageResource(exerciseList!![currentExercisePosition].getImage())
        binding?.tvExerciseName?.text = exerciseList!![currentExercisePosition].getName()
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