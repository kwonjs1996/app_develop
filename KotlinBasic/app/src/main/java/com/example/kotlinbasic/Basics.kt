package com.example.kotlinbasic

interface Drivable{
    val maxSpeed: Double
    fun drive(): String
    fun brake(){
        println("The drivable is braking")
    }
}


// Super Class, Parent Class, Base Class of ElectricCar
open class Car(val name: String, val brand: String){
    open var range: Double = 0.0
    fun extendRange(amount: Double){
        if(amount > 0){
            range += amount
        }
    }
    open fun drive(distance: Double){
        println("Drove for $distance KM")
    }
}
// Sub Class, Child Class, Derived Class of Car
// Parent Class의 매개변수가 "모두" 입력되어야 함, 추가적인 매개변수 또한 입련 가능
class ElectricCar(name: String,brand: String, batteryLife: Double)
    : Car(name, brand){

    var chargerType = "Type1"

    override var range = batteryLife/6

    override fun drive(distance: Double) {
        println("Drove for $distance KM on electricity")
    }
    fun drive(){
        println("Drove for $range KM on Electricity")
    }
}

fun main(){
    var audiA3 = Car("A3", "Audi")
    var teslaS = ElectricCar("S-Model", "Tesla", 85.0)

    teslaS.extendRange(200.0)
    audiA3.drive(200.0)
    teslaS.drive(200.0)
    println(teslaS.range)

}