package dev.decagon.networkingclass

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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

        println("Thread Name: Outside thread ${Thread.currentThread().name}")

        Thread {
            println("Thread Name: Inside thread ${Thread.currentThread().name}")
            try {
                val imageUrl = URL("https://www.wallpaperup.com/uploads/wallpapers/2013/03/21/55924/3b61c716155c6fa88f321da6d4655767.jpg")

                val connection = imageUrl.openConnection() as HttpURLConnection
                connection.doInput = true
                connection.connect()


                val inputStream = connection.inputStream

                val bitmap = BitmapFactory.decodeStream(inputStream)

                runOnUiThread {
                    println("Thread Name: runOnUi ${Thread.currentThread().name}")
                    imageView.setImageBitmap(bitmap)
                }

            } catch (e: UnknownHostException) {
                println("Thread Name: Inside catch ${Thread.currentThread().name}")
                Snackbar.make(imageView, "No internet connection, please turn on your internet and try again", Snackbar.LENGTH_LONG).show()
                e.printStackTrace()
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
                Snackbar.make(imageView, "Resources not found, be sure you entered valid URL", Snackbar.LENGTH_LONG).show()
            } catch (e: Throwable) {
                e.printStackTrace()
                Snackbar.make(imageView, "Unknown error occurred!", Snackbar.LENGTH_LONG).show()
            } finally {
                runOnUiThread {
                    progressBar.visibility = View.GONE
                    waitingMsg.visibility = View.GONE
                }
            }

        }.start()
    }
}