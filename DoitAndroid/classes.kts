// data Class

class NonDataClass(val name: String, val email: String, val age: Int)
data class DataClass(val name: String, val email: String, val age: Int)

main(){
    val non1 = NonDataClass("ggam","a@a.com",10)
    val non2 = NonDataClass("ggam","a@a.com",10)

    val data1 = DataClass("ggam","a@a.com",10)
    val data2 = DataClass("ggam","a@a.com",10)
    println(non1.equals(non2)) // False
    println(data1.equals(data2)) // True
    // 일반 클래스는 각 객체를 비교하기 때문에 False
    // 데이터 클래스는 각 객체의 데이터를 비교하기 때문에 True
    // * 주 생성자의 매개변수만 같다면 constructor의 일부 멤버 변수가 다르더라도 같다고 취급한다 *
    // 즉 데이터 클래스의 equals()는 주 생성자의 매개변수만 같은지만 확인한다.
}
// object Class

val obj = object {
    var data = 10
    fun some(){
        println("data: $data")
    }
}
fun main(){
    obj.data = 20 // 오류
    obj.some()  // 오류
}
// object 클래스는 선언과 동시에 객체가 생성된다.
// 현재 이 클래스는 타입을 정하지 않았기 때문에 Any 타입으로 생성된다.
// Any 타입에는 data, some() 이라는 멤버가 존재하지 않기때문에 접근 할 수 없다.
// object{} 이렇게 선언 할 수 있지만 보통 object : 타입  이런 식으로 뒤에 클래스의 상위 혹은
// 인터페이스를 같이 선언한다.




