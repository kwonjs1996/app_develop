package com.example.permissiondemo

import android.Manifest
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private val cameraResultLauncher : ActivityResultLauncher<String> =
        // register 로 결과를 불러와서, .RequestPermission 메소드에 입력하고 람다식으로 승인됐는지 확인한다.
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()){
                isGranted ->
                if (isGranted){
                    Toast.makeText(this, "Permission granted for camera", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Permission denied for camera", Toast.LENGTH_SHORT).show()
                }
            }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnPermissionCamera : Button = findViewById(R.id.btn_permission_camera)
        btnPermissionCamera.setOnClickListener{
            // if 안드로이드 버전이 몇인지, 카메라에 대한 permission 이 수락 되었는지 확인
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                    shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                showRationaleDialog("Camera Permission", "Can not be used, denied permission")
            }else{
                cameraResultLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }

    private fun showRationaleDialog (title: String, message : String){
        val builder : AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle(title)
            .setMessage(message)
            .setPositiveButton("Cancel"){dialog, _ ->
                dialog.dismiss()
            }
        builder.create().show()
    }
}