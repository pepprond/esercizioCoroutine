package com.android.example.eserciziocoroutine

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {

    private var number: Int = 0

    private lateinit var button: Button

    private lateinit var input: EditText

    private lateinit var output: TextView

    private var firstClick = true


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button_plus)
        input = findViewById(R.id.input_number)
        output = findViewById(R.id.output)

    }


    override fun onStart() {
        super.onStart()


        button.setOnClickListener {
            if (firstClick) {
                number = input.text.toString().toInt()
                output.text = number.toString()
                firstClick = false
            } else {
                output.text = number.toString()
              }
            lifecycleScope.launch {
                process()

            }

        }
    }

    suspend fun process() {
        delay(2000)
        number++

        withContext(Dispatchers.Main) {
            output.text = number.toString()

        }


    }
}
