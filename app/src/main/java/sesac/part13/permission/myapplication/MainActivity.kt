package sesac.part13.permission.myapplication

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // test2
        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ){
            if(it) {
                Toast.makeText(this, "granted...", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "denied...", Toast.LENGTH_SHORT).show()
            }
        }

        val status = ContextCompat.checkSelfPermission(
            this,
            "android.permission.ACCESS_FINE_LOCATION"
        )
        if(status == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "granted...", Toast.LENGTH_SHORT).show()
        }else {
            // test1
//            ActivityCompat.requestPermissions(
//                this,
//                arrayOf<String>("android.permission.ACCESS_FINE_LOCATION"),
//                100
//            )

            // test2
            requestPermissionLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "granted...", Toast.LENGTH_SHORT).show()
        }else {
            Toast.makeText(this, "denied...", Toast.LENGTH_SHORT).show()
        }
    }
}