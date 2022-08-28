// 람다 함수

// 일반적으로 함수는 fun 키워드로 선언하지만 람다 함수는 fun 키워드를 이용하지 않고 함수 이름이 없다.
// 람다 함수는 중괄호 { } 로 표현한다.

fun 함수명(매개변수) { 함수 본문 } // 일반 함수

{ 매개변수 -> 함수 본문 } // 람다 함수

// 람다 함수를 사용하는 규칙
// 람다 함수는 {} 로 표현한다.
// {} 안에 화살표( -> )가 있으며 화살표 왼쪽은 매개변수 오른쪽은 함수 본문이다.
// 함수의 반환값은 함수 본문의 마지막 표현식이다.

// 일반 함수 선언
fun sum(no1: Int, no2: Int): Int {
    return no1 + no2
}
// 람다 함수 선언
// 람다 함수는 이름이 없으므로 함수명으로 호출할 수 없다. 그래서 보통 람다 함수를 변수에 대입해 사용한다.
// 아래의 예는 람다 함수를 sum 이라는 변수에 대입하여 사용.
val sum = {no1: Int, no2: Int -> no1 + no2}

// 람다 함수 선언과 호출
// 무조건 람다 함수를 변수에 담아서 사용해야만 하는 것은 아니다 람다 함수를 선언 하자마자 호출하려면 아래의
// 방법을 사용 하면 된다.
{no1: Int, no2: Int -> no1 + no2}(10, 20)

// 매개변수가 없는 람다 함수
{-> println("function call")}
// 화살표를 생략한 람다 함수
{println("function call")}

// 매개변수가 1개인 람다 함수
fun main(){
    val some = {no: Int -> println(no)}
    some(10)                // 10
}

// 매개변수가 1개일 람다 함수에 it 키워드 사용
// 람다 함수의 중괄호 안에 화살표가 없으므로 배개변수가 없는 것처럼 보인다.
// 하지만 람다 함수 앞에 (Int) -> Unit 이 매개변수가 1개일 람다 함수임을 알려준다.
fun main(){
    val some: (Int) -> Unit = { println(it)}
    some(10)                // 10
}

// 람다 함수에서 it 을 이용해 매개변수를 사용하는 것은 해당 매개변수의 타입을 식별할 수 있을 때만 가능.
// 타입을 식별할 수 없어 오류 발생
val some ={println(it)} // 오류

// 타입 식별 가능
val some: (Int) -> Unit = { println(it)}   // 성공

// 람다 함수의 반환
// 람다 함수도 함수이므로 자신이 호출한 곳에 결괏값을 반환해야 할 때가 있다.
// 그렇지만 람다 함수에선 return 문을 사용 할 수 없다.
val some = {no1: Int, no2: Int -> return no1 * no2}  // 오류
// 람다 함수의 반환값은 본문에서 마지막 줄의 실행 결과이다.


// 함수 타입 선언
// 일반 함수 선언, Int 형 배개변수 2개를 받아 Int타입 결과값을 반환하는 함수
fun some(no1: Int, no2: Int): Int{
    return no1 + no2
}

// 함수 타입을 이용해 함수를 변수에 대입
            // 함수 타입 //     //          함수내용            //
val some: (Int,Int) -> Int = {no1: Int, no2: Int -> no1 + no2}

// 함수 타입 별칭
// (Int, Int) -> Boolean 타입을 MyFunType 라는 별칭으로 선언했다.
// 이제 MyFunType으로 선언한 변수에는 (Int, Int) -> Boolean 타입에 맞는 함수를 대입해야 한다.
typealias MyFunType = (Int, Int) -> Boolean

fun main(){
    val someFun : MyFunType = {no1: Int, no2: Int ->
        no1 > no2
    }
    println(someFun(10, 20))
    println(someFun(20, 10))
}

// 매개변수 타입 생략
// 매개변수 타입을 생략한 함수 선언
typealias MyFunType = (Int, Int) -> Boolean
val someFun : MyFunType = {no1, no2 ->
    no1 > no2
}
// 매개변수 타입 선언 생략
val someFun: (Int, Int) -> Boolean = {no1, no2 ->
    no1 > no2
}
// 변수 선언 시 타입 생략
val someFun = {no1: Int, no2: Int -> no1 > no2}

// 고차 함수(high order function)
// 고차 함수는 다른 함수를 인자로 받거나 함수를 반환하는 함수.
// 코틀린에서는 람다나 함수 참조를 사용해 함수의 값으로 표현할 수 있다.
// 따라서 고차 함수는 람다나 함수 참조로 인자를 넘길 수 있거나 람다나 함수 참조를 반환하는 함수다.

// (A,B)->C  A타입과 B타입 값을 매개변수로 받고, C 타입의 값을 반환한다.
// ()->C    매개변수가 없고, C타입의 값을 반환한다.
fun hofFun(arg: (Int) -> Boolean) : () -> String {
    val result = if(arg(10)){
        "valid"
    } else {
        "invalid"
    }
    return {"hofFun result : $result"}
}

fun main() {
    val result = hofFun({no -> no > 0})
    println(result())
}
