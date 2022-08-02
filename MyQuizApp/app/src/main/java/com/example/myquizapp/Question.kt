package com.example.myquizapp

// Question DataClass 만들어서 형식 만들기
data class Question(
    val id: Int,
    val question: String,
    val image: Int,
    val optionOne : String,
    val optionTwo : String,
    val optionThree : String,
    val optionFour : String,
    val correctAnswer :Int,
)
