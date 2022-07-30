package com.example.myfirstapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button = findViewById(R.id.btnDatePicker)
        btnDatePicker.setOnClickListener {
            clickDataPicker()
        }

    }

    fun clickDataPicker() {
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        // 버튼 클릭시 캘린더 구현, ok 눌렀을 때 토스트 메시지 구현, cancel에는 토스트메시지 구현되지 않음.
        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                Toast.makeText(this, "preesed", Toast.LENGTH_LONG).show()
            },
            year,
            month,
            day
        ).show()
//         DatePickerDialog(this, {_,_,_,_ ->
//             Toast.makeText(this, "preesed", Toast.LENGTH_LONG).show()
//         },year,month,day).show()
        // 둘 다 똑같이 작동한다. 왜인지는 아직 알 수 없음.

    }
}