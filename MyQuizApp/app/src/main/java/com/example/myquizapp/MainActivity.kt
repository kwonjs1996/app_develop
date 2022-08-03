package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart : Button = findViewById(R.id.btnStart)
        val etName : EditText = findViewById(R.id.etName)
        btnStart.setOnClickListener {
            if (etName.text.isEmpty()){
                Toast.makeText(this,
                    "Please enter your name", Toast.LENGTH_SHORT).show()
            }else{
                // intent 인스턴스 생성 this(현재 페이지 == MainActivity)에서 QuizQuestionActivity 로
                // 보내준다.
               val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, etName.text.toString())
                // intent 로 etName 을 받아서 Constants.USER_NAME 이라는 이름으로
                // QuizQuestionsActivity 로 보내준다.
                startActivity(intent)
                finish()
            }
        }
    }
}