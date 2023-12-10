package com.example.workoutapp

object Constants {
    private var exerciseList = ArrayList<ExerciseModel>()

    private val jumpingJack:ExerciseModel = ExerciseModel(
        1,
        "jumping jack",
        R.drawable.ic_jumping_jacks,
        false,
        false
    )
    private val plank:ExerciseModel = ExerciseModel(
        2,
        "plank",
        R.drawable.ic_plank,
        false,
        false,
    )
    private val pushUp:ExerciseModel = ExerciseModel(
        3,
        "push up",
        R.drawable.ic_push_up,
        false,
        false,
    )
    private val squat :ExerciseModel = ExerciseModel(
        4,
        "squat",
        R.drawable.ic_squat,
        false,
        false
    )
    private val lunge :ExerciseModel = ExerciseModel(
        5,
        "lunge",
        R.drawable.ic_lunge,
        false,
        false
    )
    fun getExerciseList():ArrayList<ExerciseModel>{
        addExerciseToList(jumpingJack)
        addExerciseToList(plank)
        addExerciseToList(pushUp)
        addExerciseToList(lunge)
        addExerciseToList(squat)
        return exerciseList
    }

    private fun addExerciseToList(exercise:ExerciseModel){
        exerciseList.add(exercise)
    }
}