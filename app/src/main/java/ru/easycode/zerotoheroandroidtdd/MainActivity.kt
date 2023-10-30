package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.translation.UiTranslationStateCallback
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var uiState: UiState = UiState.Base("0")
    val btn: Button by lazy { findViewById(R.id.incrementButton) }
    val tv: TextView by lazy { findViewById(R.id.countTextView) }
    var count = Count.Base(2, 4)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            uiState = count.increment(tv.text.toString())
            uiState.updateState(tv, btn)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, uiState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = savedInstanceState.getSerializable(KEY) as UiState
        uiState.updateState(tv, btn)
    }

    companion object {
        private const val KEY = "key"
    }
}