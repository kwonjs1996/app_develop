package com.example.event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.widget.Toast
import com.example.event.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // 뒤로가기 버튼을 누른 시각을 저장하는 속성
    var initTime = 0L

    // 멈춘 시각을 저장하는 속성
    var pauseTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.startButton.setOnClickListener {
            binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
            binding.chronometer.start()
            // 버튼 표시 여부 조정
            binding.stopButton.isEnabled = true
            binding.resetButton.isEnabled = true
            binding.startButton.isEnabled = false
        }
        binding.stopButton.setOnClickListener {
            pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            binding.stopButton.isEnabled = false
            binding.resetButton.isEnabled = true
            binding.startButton.isEnabled = true
        }
        binding.resetButton.setOnClickListener {
            pauseTime = 0L
            binding.chronometer.stop()
            binding.stopButton.isEnabled = false
            binding.resetButton.isEnabled = false
            binding.startButton.isEnabled = true
        }
    }
    // 뒤로가기 버튼 이벤트 핸들러
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // 뒤로가기 버튼을 눌렀을 때 처리
        if(keyCode === KeyEvent.KEYCODE_BACK){
            if (System.currentTimeMillis() - initTime > 3000){
                // 뒤로가기 버튼을 처음 눌렀을 때나 누른지 3초가 지났을 때 처리
                Toast.makeText(this, "종료하려면 한번 더 누르세요!",
                    Toast.LENGTH_SHORT).show()
                initTime = System.currentTimeMillis()
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}