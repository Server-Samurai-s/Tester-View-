package com.example.testerviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout

class CustomView2 @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var closeButton: Button

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_view_layout, this, true)

        // Initialize views
        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        closeButton = findViewById(R.id.closeButton)

        // Set OnClickListener for the close button
        closeButton.setOnClickListener {
            // Animate the view to move to the right
            animateHideView()
        }
    }

    private fun animateHideView() {
        // Load animation
        val slideOutAnimation: Animation = AnimationUtils.loadAnimation(context, R.anim.slide_out_right)
        // Set listener to remove the view after animation
        slideOutAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                visibility = View.GONE // Hide the view after animation
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })
        // Start animation
        startAnimation(slideOutAnimation)
    }
}
