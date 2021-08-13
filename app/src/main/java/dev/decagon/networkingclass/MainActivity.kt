package dev.decagon.networkingclass

import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.image_view)
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val waitingMsg = findViewById<TextView>(R.id.wait_message)
    }
}