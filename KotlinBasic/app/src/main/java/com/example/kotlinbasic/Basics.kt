package com.example.kotlinbasic

// abstract class
// 그 자체로 인스턴스화 될 수 없는 클래스
// 여러 클래스의 공통적인 부분을 모아놓은 클래스
// 내부 변수나 함수도 abstract 로 만들 수 있다.
// abstract 로 만들어진 값들은 미완성 된 값들이므로 interface 처럼 무조건 abstract class 를
// 구현하는 곳(상속받은 class)에서 구현해야한다.
// abstract 로 구현 할 때 override 하여 선언한다.
// abstract class 내부에 abstract 로 선언되지 않은 fun, var, val 은 구현하는 곳에서
// 바로 사용이 가능하다.
abstract class Mammal(val name: String, val origin: String,
                      val weight: Double) {   // Concrete (Non Abstract) Properties

    // Abstract Property (Must be overridden by Subclasses)
    abstract var maxSpeed: Double

    // Abstract Methods (Must be implemented by Subclasses)
    abstract fun run()
    abstract fun breath()

    // Concrete (Non Abstract) Method
    fun displayDetails() {
        println("Name: $name, Origin: $origin, Weight: $weight, " +
                "Max Speed: $maxSpeed")
    }
}

class Human(name: String, origin: String, weight: Double,
            override var maxSpeed: Double): Mammal(name, origin, weight) {

    override fun run() {
        // Code to run
        println("Runs on two legs")
    }

    override fun breath() {
        // Code to breath
        println("Breath through mouth or nose")
    }
}

class Elephant(name: String, origin: String, weight: Double,
               override var maxSpeed: Double): Mammal(name, origin, weight) {

    override fun run() {
        // Code to run
        println("Runs on four legs")
    }

    override fun breath() {
        // Code to breath
        println("Breath through the trunk")
    }
}

fun main() {
    val human = Human("Denis", "Russia",
        70.0, 28.0)
    val elephant = Elephant("Rosy", "India",
        5400.0, 25.0)

    human.run()
    elephant.run()

    human.breath()
    elephant.breath()
    human.displayDetails()

}