package com.example.kotlinbasic

fun main(){
    print("Hello World")
    var age = 3
    if(age >= 21)

    var season = 3
    when(season){
        1 -> println("Spring")
        2 -> println("Summer")
        3 -> {
            println("Fall")
            println("Autumn")
        }
        4 -> println("Winter")
        else -> println("Invalid Season")
    }

    var month = 3
    when(month){
        in 3..5 -> println("Spring")
        in 6..8 -> println("Summer")
        in 9..11 -> println("Fall")
        12, 1, 2 -> println("Winter")
        else -> println("Invalid Season")
    }

    var y = 1
    while (y <= 10){
        print("$y")
        y++
    }
    print("\nWhile is done")

    var x = 100
    while (0 <= x) {
        print("$x")
        x-= 2
    }
    print("\nWhile is done")
    for (i in 0 until 10000){
        print(i)
        if(i == 9001){
            println("IT'S OVER 9000!")
        }

    }

}

