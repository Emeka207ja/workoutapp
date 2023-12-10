package com.example.workoutapp

class ExerciseModel(
    private var id:Int,
    private var name:String,
    private var image:Int,
    private var isCompleted:Boolean,
    private var isSelected:Boolean
) {
    fun getId():Int{
        return id
    }

    fun setId(id:Int){
        this.id = id
    }

    fun getImage():Int{
        return image
    }
    fun setImage(imgId:Int){
        this.image = imgId
    }
    fun getName():String{
        return name
    }
    fun setName(name:String){
        this.name = name
    }
    fun getIsCompleted():Boolean{
        return isCompleted
    }
    fun setIsCompleted(isComplete:Boolean){
        this.isCompleted = isComplete
    }
    fun getIsSelected():Boolean{
        return isSelected
    }
    fun setIsSelected(selected:Boolean){
        this.isSelected = selected
    }
}