package com.example.event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
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

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when(keyCode){
            KeyEvent.KEYCODE_BACK -> Log.d("ggam", "BACK BUTTON 을 눌렀네요")
            KeyEvent.KEYCODE_VOLUME_UP -> Log.d("ggam", "KEYCODE_VOLUME_UP 을 눌렀네요")
            KeyEvent.KEYCODE_VOLUME_DOWN -> Log.d("ggam", "KEYCODE_VOLUME_DOWN 을 눌렀네요")
        }

        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("ggam", "onKeyUp")
        return super.onKeyUp(keyCode, event)
    }
}