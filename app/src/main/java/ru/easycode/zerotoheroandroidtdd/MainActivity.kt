package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.contains

class MainActivity : AppCompatActivity() {

    val ll: LinearLayout by lazy { findViewById(R.id.rootLayout) }
    val tv: TextView by lazy { findViewById(R.id.titleTextView) }
    val btn: Button by lazy { findViewById(R.id.removeButton) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            ll.removeView(tv)
        }
    }

    private fun isViewExist(): Boolean {
        return ll.contains(tv)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.getBoolean("1", isViewExist())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (isViewExist()) {
            ll.removeView(tv)
        }
    }
}