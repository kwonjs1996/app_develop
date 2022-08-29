// 널 안전성
// null 이란 객체가 선언되었지만 초기화되지 않은 상태를 의미
// 객체는 데이터가 저장된 주소를 참조하므로 참조 변수라고 한다.
// 데이터가 메모리에 저장되면 어디에 저장됐는지 알아야 이용할 수 있는데 이때 해당 메모리 위치를 식별하는 것이 주소이다.
// 객체에는 주소가 저장되며 이 주소로 메모리에 접근해서 데이터를 이용한다.
// 그런데 널은 객체가 주소를 가지지 못한 상태를 나타낸다.

val data1: String = "hello"
val data2: String? = null
// data1 변수에 "hello"라는 데이터를 저장했다. 그런데 실제로는
// "hello"라는 문자열 데이터가 저장된 주소가 대입되며 그 주소로 문자열 데이터를 이용한다.
// data2 변수에는 null 을 대입했다. 이렇게하면 data2 변수는 아직 주소값을 가지지 못한다.
// 즉 변수가 선언되었지만 이용할 수 없는 상태이다.

// 이처럼 널인 상태의 객체를 이용하면 널 포인트 예외(NullPointException)가 발생한다.
// 널 포인트 예외는 널인 상태의 객체를 이용할 수 없다는 오류이다.

// 이때 널 안정성이란 널 포인트 예외가 발생하지 않도록 코드를 작성하는 것을 말한다.
// 널 포인트 예외는 오류이므로 당연히 발생하지 않게 작성해야 하지만 중요한 건 !!이런 노력을 누가 하는가!!이다.

// 널 안전성을 개발자가 고려한 코드
fun main(){
    var data: String? = null
    val length = if(data == null){
        0
    } else{
        data.length
    }
    println("data length : $length")              // data length : 0
}

// if 문으로 data 가 null 인지 확인한 뒤 null 이면 0 을 반환하고 null 이 아니면 data.length 를 반환하게 작성
// 이렇게 하면 데이터가 null 이어도 오류는 발생하지 않는다.
// 이런 노력을 개발자가 한다면 객체가 null 인지 일일이 점검하는 코드를 작성해야 한다. 즉 널 안전성이
// 오롯이 개발자의 몫이라는 이야기.

// 코틀린이 제공하는 널 안전성 연산자를 이용한 코드
fun main(){
    var data: String? = null
    println("data length : ${data?.length ?: 0}")      // data length : 0
}

// 프로그래밍 언어가 널 안전성을 지원한다는 것은 객체가 널인 상황에서 널 포인터 예외가 발생하지 않도록
// 연산자를 비롯해 여러 기법을 제공한다는 의미이다.

// 널 안전성 연산자
// 널 허용   ? 연산자
var data1: String = "ggam"
data1 = null   // 오류

var data2: String? = "ggam"
data2 = null   // 성공

// 널 안전성 호출   ?.  연산자

var data3: String? = "ggam"
var length = data3.length       // 오류

var data4: String? = "ggam"
var length = data4?.length    // 성공

// 엘비스     ?:  연산자
// 엘비스 연산자란 ?: 기호를 말한다. 이 연산자는 변수가 널이면 널을 반환한다.
// 그런데 어떤 경우에는 변수가 널일 때 대입해야 하는 값이나 실행해야 하는 구문이 있을 수도 있다.
// 이때 엘비스 연산자를 이용한다.

fun main(){
    var data: String? = "ggam"
    println("data = $data : ${data?.length ?: -1}")
    data = null
    println("data = $data : ${data?.length ?: -1}")
}
// 실행 결과
// data = ggam : 4
// data = null : -1

// 예외 발생   !! 연산자
// !! 는 객체가 널일 때 예외 를 일으키는 연산자이다. 객체가 널일 때 ?. 또는 ?: 연산자를 이용해
// 널포인트 예외가 발생하지 않게 작성할 수도 있지만, 또 어떤 경우에는 널 포인트
// 예외를 발생시켜야 할 때도 있따. 이때 !! 연산자를 이용한다.
fun some(data: String?): Int{
    return data!!.length
}
fun main(){
    println(some("ggam"))
    println(some(null))
}
// 실행 결과
// 4
// Exception in thread "main" java.lang.NullPointException

// 위 소스는 some() 함수에 문자열을 전달하면 오류 없이 정상으로 실행되고, null을 전달하면
// data!!.length 코드로 예외 메시지를 출력하는 것을 보여준다.







