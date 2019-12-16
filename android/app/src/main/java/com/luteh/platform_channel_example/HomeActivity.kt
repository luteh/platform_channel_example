package com.luteh.platform_channel_example

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import io.flutter.app.FlutterActivity
import kotlinx.android.synthetic.main.home_activity.*

class HomeActivity : FlutterActivity() {

    private val TAG = "HomeActivity"

    private val REQUEST_IMAGE_CAPTURE = 111


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        onInit()
    }

    private fun onInit() {

        btn_home_open_camera.setOnClickListener {
            onTakePicture()
        }
    }

    private fun onTakePicture() {
        // Do request camera, if allow/denied run onRequestPermissionsResult(...) below
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), REQUEST_IMAGE_CAPTURE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
            when (requestCode) {
                REQUEST_IMAGE_CAPTURE -> Toast.makeText(this, "Camera Permission Granted", Toast.LENGTH_SHORT).show()
            }
        } else
            Toast.makeText(this, "Camera Permission not Granted", Toast.LENGTH_SHORT).show()
    }
}
