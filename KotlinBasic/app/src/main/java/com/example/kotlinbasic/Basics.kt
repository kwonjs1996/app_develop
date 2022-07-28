package com.example.kotlinbasic

data class User(val id: Long, var name: String)
// data class 는 데이터 보관 목적으로 만든 클래스, toString(), hashCode(), equals(), copy()
// 메소드를 자동으로 만들어줌, -> 보일러플레이트 코드를 만들지 않아도 됌
// 데이터클래스의 생성자(primary constructor)는 1개 이상의 프로퍼티를 선언해야함
// 데이터클래스의 프로퍼티는 val or var로 선언해야함
// 데이터 클래스에 abstract, open, sealed, inner 를 붙일 수 없음.
// 클래스에서 toString(), hashCode(), equals(), copy()를 override하면, 그 함수는 직접 구현된 코드를 사용
// 데이터 클래스는 상속 받을 수 없음.

fun main(){
   val user1 = User(1, "Denis")

//   val name = user1.name
//   println(name)

   user1.name = "Michael"

   val user2 = User(1, "Michael")

//   println(user1.equals(user2)) ==
   println(user1 == user2)

   println("User Details: $user1")

   val updatedUser = user1.copy(name = "Denis Panjuta")
   println(user1)
   println(updatedUser)





   //Destructuring Declarations
   val(id, name) = updatedUser
   //작동원리
   println(updatedUser.component1()) // prints 1
   println(updatedUser.component2()) // prints Denis panjuta
   // 주의할 점
   // 생성자에 정의된 프로퍼티의 순서대로 변수에 대입한다.
//   val(name2, id2) = user2
//   println(name2)
   // 결과값은 1 즉 id의 값이 출력된다.


}