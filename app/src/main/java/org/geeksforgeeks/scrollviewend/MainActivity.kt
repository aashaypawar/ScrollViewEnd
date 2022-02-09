package org.geeksforgeeks.scrollviewend

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewTreeObserver
import android.widget.ScrollView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnTouchListener, ViewTreeObserver.OnScrollChangedListener {

    private lateinit var mScrollView: ScrollView

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mScrollView = findViewById(R.id.scroll_view_1)

        mScrollView.setOnTouchListener(this)
        mScrollView.viewTreeObserver.addOnScrollChangedListener(this)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        return false
    }

    override fun onScrollChanged() {
        val view = mScrollView.getChildAt(mScrollView.childCount - 1)
        val topDetector = mScrollView.scrollY
        val bottomDetector: Int = view.bottom - (mScrollView.height + mScrollView.scrollY)
        if (bottomDetector == 0) {
            Toast.makeText(baseContext, "Scroll View bottom reached", Toast.LENGTH_SHORT).show()
        }
        if (topDetector <= 0) {
            Toast.makeText(baseContext, "Scroll View top reached", Toast.LENGTH_SHORT).show()
        }
    }
}