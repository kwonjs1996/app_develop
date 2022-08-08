package com.example.coroutinesdemo

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private var customProgressDialog : Dialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnExecute: Button = findViewById(R.id.btn_execute)
        btnExecute.setOnClickListener {
            // lifecycleScope 는 모든 액티비티 클래스의 코루틴을 적절하게 처리하기 위해 구축된 코루틴 블록이다.
            showProgressDialog()
            lifecycleScope.launch{
                execute("Task executed successfully")
            }
        }
    }

    private suspend fun execute(result: String) {
        // suspend, withContext(Dispatchers.IO) ==> Koroutine 을 쓰기 위해 필요함
        // suspend fun 은 일시중단 가능한 함수를 지칭한다. 해당 함수는 무조건 코루틴 내부에서 수행되어야 한다.
        // suspend fun 은 suspend fun 내부에서 수행될 수 있다.
        // withContext 는 지정된 코루틴 컨텍스트로 지정된 일시 중단 블록을 호출하고 완료될 때까지 일시 중단하고 결과를 반환합니다.
        // withContext(Dispatchers.IO) ==> 안에있는 실행을 메인쓰레드(== UI 쓰레드)가 아닌 Dispatchers.IO 쓰레드에 가서 실행하라.
        // IO == input output 쓰레드.
        withContext(Dispatchers.IO) {
            for (i in 1..1000000) {
                Log.e("delay", "" + i)
            }
            runOnUiThread{
                cancelProgressDialog()
                Toast.makeText(this@MainActivity, result, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun cancelProgressDialog(){
        if(customProgressDialog != null){
            customProgressDialog?.dismiss()
            customProgressDialog = null
        }
    }

    private fun showProgressDialog(){
        customProgressDialog = Dialog(this@MainActivity)
        // set the screen content from a layout resource.
        // the resource will be inflated, adding all top_level views to the screen.
        customProgressDialog?.setContentView(R.layout.dialog_custom_progress)

        //Start the dialog and display it on screen.
        customProgressDialog?.show()
    }

}