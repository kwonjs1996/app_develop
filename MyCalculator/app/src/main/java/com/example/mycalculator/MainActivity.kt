package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var tvInput : TextView? = null
    // tvInput 이라는 변수를 널러블로 선언한다 그리고 안에 tvInput 을 Id 로 찾아서 객체로 만든다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInput = findViewById(R.id.tvInput)
    }

    fun onDigit(view : View){
        // view == 각각 불러오는 button 과 같다.
        // null 을 체크함으로 인해서 일일히 if 문으로 확인하지 않더라도 값이 null 이면 코드를 실행시키지 않는다.
        tvInput?.append((view as Button).text)
        // view 가 Button 이면 text 를 가져오라는 뜻, view 에는 text 프로퍼티가 없음.
        // 이라는 설명인데 잘은 모르겠음 지금 현재로서는
    }
    fun onClear(view: View){
        tvInput?.text = ""
    }
}