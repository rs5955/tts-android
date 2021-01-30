package com.example.ttsbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    lateinit var button : Button
    lateinit var text : EditText
    lateinit var tts : TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        text = findViewById(R.id.editTextTextMultiLine)

//        button.setOnClickListener { text.setText("hello") }

        tts = TextToSpeech(this, this)

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onInit(status: Int) {
        button.setOnClickListener { speak() }
    }

    private fun speak() {
        tts.speak(text.text.toString(), TextToSpeech.QUEUE_FLUSH,null,"")
    }
}
