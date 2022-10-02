package com.example.event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN ->{
                Log.d("ggam",
                    "Touch down event x: ${event.x}, ${event.rawX}")
            }
            MotionEvent.ACTION_UP -> {
                Log.d("ggam", "Touch up event")
            }
        }
        return super.onTouchEvent(event)
    }
}