package com.example.kotlinbasic

fun main(){

    val numbers = ArrayList<Double>()
    numbers.add(1.1)
    numbers.add(1.2)
    numbers.add(1.3)
    numbers.add(1.4)
    numbers.add(1.5)
    var result  = 0.0
    for (number in numbers){
        result += number
    }
    var aver: Double = result / numbers.size
    println(aver)
    val sum:(Int, Int) -> Int = {a : Int, b : Int -> a + b}
    println(sum(10,5))

    val sum2 = {a : Int, b : Int -> println(a + b)}
    sum2(10,5)

}