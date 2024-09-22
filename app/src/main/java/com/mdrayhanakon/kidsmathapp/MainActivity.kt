package com.mdrayhanakon.kidsmathapp

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etFirstNumber = findViewById<EditText>(R.id.et_first_number)
        val etSecondNumber = findViewById<EditText>(R.id.et_second_number)
        val btnAdd = findViewById<Button>(R.id.btn_add)
        val btnSubtract = findViewById<Button>(R.id.btn_subtract)
        val tvResult = findViewById<TextView>(R.id.tv_result)

        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        mediaPlayer = MediaPlayer.create(this, R.raw.click_sound)

        btnAdd.setOnClickListener {
            mediaPlayer.start()
            val firstNumber = etFirstNumber.text.toString().toIntOrNull()
            val secondNumber = etSecondNumber.text.toString().toIntOrNull()

            if (firstNumber != null && secondNumber != null) {
                val result = firstNumber + secondNumber
                tvResult.text = "Result: $result"
                tvResult.startAnimation(fadeIn)
            } else {
                tvResult.text = "Please enter valid numbers!"
                tvResult.startAnimation(fadeIn)
            }
        }

        btnSubtract.setOnClickListener {
            mediaPlayer.start()
            val firstNumber = etFirstNumber.text.toString().toIntOrNull()
            val secondNumber = etSecondNumber.text.toString().toIntOrNull()

            if (firstNumber != null && secondNumber != null) {
                val result = firstNumber - secondNumber
                tvResult.text = "Result: $result"
                tvResult.startAnimation(fadeIn)
            } else {
                tvResult.text = "Please enter valid numbers!"
                tvResult.startAnimation(fadeIn)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        this.mediaPlayer.release()
    }
}
