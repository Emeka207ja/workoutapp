package com.example.workoutapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.workoutapp.databinding.ActivityBmiactivityBinding

class BMIActivity : AppCompatActivity() {
    private var binding :ActivityBmiactivityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBmiactivityBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)
        setupToolbar()

        binding?.btnCalBMI?.setOnClickListener {
            val userHeight = binding?.etHeight?.text.toString()
            val userWeight = binding?.etWeight?.text.toString()
            calculateBmi(userHeight,userWeight)
        }
    }

    private fun setupToolbar(){
        setSupportActionBar(binding?.toolbarBMI)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarBMI?.setNavigationOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }
        this@BMIActivity.title = "calculate BMI"
    }
    private fun validateInput():Boolean{
        var isValid = true

        if(binding?.etHeight?.text.toString().isEmpty() || binding?.etWeight?.text.toString().isEmpty()){
            isValid  = false
        }
        return isValid
    }


    private fun calculateBmi(height:String,weight:String){
        if(!this.validateInput()){
            Toast.makeText(this@BMIActivity,"empty input",Toast.LENGTH_SHORT).show()
            return
        }else{
            val userHeight = this.formatStringToDouble(height)
            val userWeight = this.formatStringToDouble(weight)
            val bmi = calBMI(userWeight,userHeight)
            val bmiString = formatDoubleToDecimalUnit(bmi)
            setBmiToScreen(bmiString,bmi)
        }
    }

    private fun formatDoubleToDecimalUnit(value: Float): String {
        return String.format("%.2f", value)
    }

    private fun formatStringToDouble(value:String):Float{
        return value.toFloat()
    }

    private fun calBMI(weight:Float,height:Float):Float{
        val meterHeight = height/100
        return weight/(meterHeight*meterHeight)
    }
    private fun setBmiToScreen(value: String,bmiVal:Float){
        binding?.llBMI?.visibility = View.VISIBLE
        binding?.tvBMIval?.text = value
        apprasial(bmiVal)
    }

    private fun apprasial(value:Float){
        if(value<3 && value>0.02){
            setLabelAndRecommendation("you are underweight","you need to take good care of yourself")
        }else{
            setLabelAndRecommendation("you are in good shape", "keep taking care of yourself")
        }

    }
    private  fun setLabelAndRecommendation(label:String,rec:String){
        binding?.tvBmiLabel?.text = label
        binding?.tvBMIRec?.text = rec
    }
}