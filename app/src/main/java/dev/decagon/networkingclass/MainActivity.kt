package dev.decagon.networkingclass

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import java.io.FileNotFoundException
import java.net.HttpURLConnection
import java.net.URL
import java.net.UnknownHostException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.image_view)
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val waitingMsg = findViewById<TextView>(R.id.wait_message)
    }
}