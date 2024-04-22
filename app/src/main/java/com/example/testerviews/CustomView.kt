package com.example.testerviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var button: Button
    private lateinit var textView: TextView
    private var isExpanded = false // Flag to track the state

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_view_layout, this, true)

        // Initialize views
        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)

        // Set OnClickListener for the button
        button.setOnClickListener {
            if (isExpanded) {
                // Shrink the TextView
                shrinkTextView()
            } else {
                // Expand the TextView
                expandTextView()
            }
            // Toggle the state
            isExpanded = !isExpanded
        }
    }

    private fun expandTextView() {
        val scaleAnimation = ScaleAnimation(
            1f, 2f, // From scale 1 to 2 in X-axis
            1f, 2f, // From scale 1 to 2 in Y-axis
            Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point X
            Animation.RELATIVE_TO_SELF, 0.5f  // Pivot point Y
        )
        scaleAnimation.duration = 500 // Duration in milliseconds
        scaleAnimation.fillAfter = true // Maintain the final state after animation
        textView.startAnimation(scaleAnimation)
    }

    private fun shrinkTextView() {
        val scaleAnimation = ScaleAnimation(
            2f, 1f, // From scale 2 to 1 in X-axis
            2f, 1f, // From scale 2 to 1 in Y-axis
            Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point X
            Animation.RELATIVE_TO_SELF, 0.5f  // Pivot point Y
        )
        scaleAnimation.duration = 500 // Duration in milliseconds
        scaleAnimation.fillAfter = true // Maintain the final state after animation
        textView.startAnimation(scaleAnimation)
    }
}