package com.example.kotlinbasic

fun main(){
   var myCar = Car()
   println("brand is : ${myCar.myBrand}")
   myCar.maxSpeed = 200
   println("Maxspeed is ${myCar.maxSpeed}")
   println(myCar.owner)
//   myCar.myModel = "M3" private set 선언되어 있어서 바꿀 수 없음
   println("My model is ${myCar.myModel}") // private get 선언은 되어있지 않기에 값을 가져오는건
                                           // 가능하다.
}

class Car(){
   lateinit var owner : String

   val myBrand: String = "BMW"
   get() {
         return field.toLowerCase()       // Custom getter , custom field
   }

   var maxSpeed: Int = 250
      get() = field // custom field 가 아님 기본
      set(value){
         // set value, custom setter 라고 볼 수 있다? 정확한 명칭은 안나옴
         field = if(value > 0) value else throw IllegalArgumentException("Maxspeed can not nagative")
      }

   var myModel : String = "M5"
      private set // 한가지 클래스 현재는 Car 클래스 내에서만 값을 바꿀 수 있음

   init {
      this.owner = "Frank"
      myModel = "M3" // Car 클래스 내부에서 private set 선언이 되어있기때문에 변수값을 바꿀 수 있다.
   }
      // 변수를 만들 시 Kotlin에서 자동으로 생성해주는 코드
//      get() = field
//      set(value){
//         field = value
}