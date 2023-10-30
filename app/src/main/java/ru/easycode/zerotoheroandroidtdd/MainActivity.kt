package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val countTextView: TextView by lazy { findViewById(R.id.countTextView) }
    val incrementButton: Button by lazy { findViewById(R.id.incrementButton) }

    var count = Count.Base(2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("log", "onCreate")


        incrementButton.setOnClickListener {
            Log.d("log", "click")
            countTextView.text = count.increment(countTextView.text.toString())
            Log.d("log", "text view: ${countTextView.text}")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("log", "onSaveInstanceState")
        super.onSaveInstanceState(outState)
        outState.putString(key, countTextView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d("log", "onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
        val savedValue = savedInstanceState.getString(key)
        countTextView.text = savedValue
        Log.d("log", "text view: ${countTextView.text}")
    }

    companion object {
        private const val key = "KEY"
    }
}