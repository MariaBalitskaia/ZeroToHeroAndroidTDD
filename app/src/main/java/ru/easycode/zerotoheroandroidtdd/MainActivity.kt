package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val buttonHide: Button by lazy { findViewById(R.id.hideButton) }
    val titleTextView: TextView by lazy { findViewById(R.id.titleTextView) }
    val linearLayout: LinearLayout by lazy { findViewById(R.id.rootLayout) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonHide.setOnClickListener {
            titleTextView.setVisibility(View.INVISIBLE)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("1", titleTextView.visibility)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        titleTextView.visibility = savedInstanceState.getInt("1")
    }
}
