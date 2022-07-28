package com.example.kotlinbasic


fun main(){
   val phone = MobilePhone("Android", "Samsung","S20")
   println(phone.battery)
   phone.chargeBattery(50)
   println(phone.battery)
}
class MobilePhone(osName: String, brand: String, model: String){
   var battery = 0
   init {
      println("The phone $model from $brand uses $osName as its Operating System")
   }
   fun chargeBattery(chargedBy : Int){
      battery += chargedBy
   }
}