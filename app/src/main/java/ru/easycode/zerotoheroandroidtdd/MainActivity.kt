package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val buttonChange: Button by lazy { findViewById(R.id.changeButton) }
    val textView: TextView by lazy { findViewById(R.id.titleTextView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonChange.setOnClickListener {
            textView.text = "I am an Android Developer!"
        }
    }
}