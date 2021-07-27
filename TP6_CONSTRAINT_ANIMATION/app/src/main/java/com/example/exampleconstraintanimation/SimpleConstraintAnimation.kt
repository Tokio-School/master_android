package com.example.exampleconstraintanimation

import android.os.Bundle

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.Transition
import androidx.transition.TransitionInflater
import androidx.transition.TransitionManager
import kotlinx.android.synthetic.main.simpleconstraint_scene1.*

class SimpleConstraintAnimation : AppCompatActivity() {

    private lateinit var transition2: Transition
    private lateinit var transition: Transition
    private var isDetailView: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.simpleconstraint_scene1)
        //Transicion con animación simple por xml
        transition = TransitionInflater.from(this).inflateTransition(R.transition.simple_animation)
        //Transicion controlando los fade de los AppCompatTextView
        transition2 = TransitionInflater.from(this).inflateTransition(R.transition.simple_animation2)
        constraintLayout.setOnClickListener { actionEventTouch() }

    }

    private fun actionEventTouch() {
        if (isDetailView) {
            swapScenes(R.layout.simpleconstraint_scene1)
        } else {
            swapScenes(R.layout.simpleconstraint_scene2)
        }
    }

    private fun swapScenes(@LayoutRes idLayout: Int) {
        val constraintSet = ConstraintSet()
        constraintSet.clone(this, idLayout)
        TransitionManager.beginDelayedTransition(constraintLayout, transition2)
        constraintSet.applyTo(constraintLayout)
        isDetailView = !isDetailView
    }


}
