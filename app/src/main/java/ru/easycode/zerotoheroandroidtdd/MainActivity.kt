package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val ll: LinearLayout by lazy { findViewById(R.id.rootLayout) }
    val tv: TextView by lazy { findViewById(R.id.titleTextView) }
    val btn: Button by lazy { findViewById(R.id.removeButton) }

    private var isButtonClicked: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            onButtonClicked()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("1", isButtonClicked)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val isButtonClicked = savedInstanceState.getBoolean("1")
        if (isButtonClicked) {
            onButtonClicked()
        }
    }

    private fun onButtonClicked() {
        isButtonClicked = true
        ll.removeView(tv)
        btn.isEnabled = false
    }
}