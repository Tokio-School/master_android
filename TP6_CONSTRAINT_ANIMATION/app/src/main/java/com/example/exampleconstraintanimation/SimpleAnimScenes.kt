package com.example.exampleconstraintanimation

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.transition.Scene
import androidx.transition.Transition
import androidx.transition.TransitionInflater
import androidx.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_anim.*


class SimpleAnimScenes : AppCompatActivity() {

    private lateinit var scene1: Scene
    private lateinit var scene2: Scene
    private lateinit var currentScene: Scene
    private lateinit var transition: Transition

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim)

        //Primero cargamos las escenas con las que vamos a trabajar.
        scene1 = Scene.getSceneForLayout(constraintLayout, R.layout.anim_set_scene1, this)
        scene2 = Scene.getSceneForLayout(constraintLayout, R.layout.anim_set_scene2, this)
        //Podemos customizar la animación cargando transitions desde xml o bien programaticamente.
        transition = TransitionInflater.from(this).inflateTransition(R.transition.anim_scenes)

        //Indicamos que escena se carga en la vista e indicamos que es la escena actual
        scene1.enter()
        currentScene = scene1

        constraintLayout.setOnClickListener { swapScenes() }


    }


    private fun swapScenes() {
        // Generar la animación o cambio de Scenes e igualamos la Scene que entra como la actual.
        currentScene = if (currentScene === scene1) {
            TransitionManager.go(scene2, transition)
            scene2
        } else {
            TransitionManager.go(scene1, transition)
            scene1
        }

    }
}
