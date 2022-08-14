package com.example.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import com.example.a7minutesworkout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding : ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        // viewBinding 을 이용한 setContentView
        // Constraint Layout 이 전체 binding 객체의 root 이다.
        setContentView(binding?.root)
        //기존 setContentView
        //setContentView(R.layout.activity_main)

        // viewBinding 을 사용하여 진행.
        binding?.flStart?.setOnClickListener{
            Toast.makeText(this@MainActivity, "Exercise", Toast.LENGTH_SHORT).show()
        }

        // viewBinding 을 사용 하지 않고 진행.
//        val flStartButton : FrameLayout = findViewById(R.id.flStart)
//        flStartButton.setOnClickListener{
//            Toast.makeText(this@MainActivity, "Exercise", Toast.LENGTH_SHORT).show()
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // 메모리 누락 방지를 위해 binding 을 해제하는 깔끔한 방법.
        // onDestroy 를 사용할 때 꼭 확인해야함
        binding = null
    }
}