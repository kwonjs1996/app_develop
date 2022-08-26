
// lazy

val data4: Int by lazy {
    println("in lazy........")
    10
}

fun main(){
    println("in main........")
    println(data4 + 10)
    println(data4 + 10)
}

class User(name: String, count: Int){
    init {
        println("name: $name, count: $count") // 성공
    }
    fun someFun(){
        println("name: $name, count: $count") // 실패
    }
}
// User 클래스의 매개변수는 지역변수이기 때문에 다른 함수에서 사용 할 수 없음.


class User(name : String, count : Int){
    var name : String
    var count: Int
    init {
        this.name = name
        this.count = count
    }
    fun someFun(){
        println("name: $name, count: $count") // 성공
    }
}
fun main(){
    val user = User("ggam", 10)
    user.someFun()
}
// 매개변수를 멤버변수처럼 사용하는 방법
// 클래스의 멤버함수 someFun()에서 생성자의 매개변수를 사용하기 위해 클래스의 멤버 변수를 생성하고,
// 주 생성자의 본문이 init 영역에서 매개변수값을 클래스의 멤버변수에 대입.

// 좀 더 간단하게 쓸 수 있는 코드
class User(val name: String, val count: Int){
    fun someFun(){
        println("name: $name, count: $count")
    }
}
fun main(){
    val user = User("ggam", 10)
    user.someFun()
}
// 원래 함수에서 매개변수를 생성 할 때 val, var 키워드를 사용 할 수 없다.
// 주 생성자에서만 매개변수에 val, var 키워드를 사용 할 수 있고, 이렇게 선언된 매개변수는 생성자의
// 멤버변수가 된다. 그래서 someFun() 에서 매개변수를 멤버변수로 사용 할 수 있게 된다.

