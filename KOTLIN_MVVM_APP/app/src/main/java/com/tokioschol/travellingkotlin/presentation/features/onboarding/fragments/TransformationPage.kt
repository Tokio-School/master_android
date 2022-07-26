package com.tokioschol.travellingkotlin.presentation.features.onboarding.fragments

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import java.lang.Math.abs
import java.lang.Math.max

class TransformationPage() : ViewPager2.PageTransformer {

    override fun transformPage(page: View, position: Float) {

        //popTransformation(page,position)
        zoomOutTransformation(page,position)

    }

    private fun zoomOutTransformation(page: View, position: Float) {
        when {
            position < -1 -> // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.alpha = 0f
            position <= 1 -> { // [-1,1]

                page.scaleX = max(MIN_SCALE, 1 - abs(position))
                page.scaleY = max(MIN_SCALE, 1 - abs(position))
                page.alpha = max(MIN_ALPHA, 1 - abs(position))

            }
            else -> // (1,+Infinity]
                // This page is way off-screen to the right.
                page.alpha = 0f
        }

    }
    companion object {

        private val MIN_SCALE = 0.65f
        private val MIN_ALPHA = 0.3f
    }

    fun popTransformation(page: View, position: Float) {
        page.translationX = -position * page.width

        if (abs(position) < 0.5) {
            page.visibility = View.VISIBLE
            page.scaleX = 1 - abs(position)
            page.scaleY = 1 - abs(position)
        } else if (abs(position) > 0.5) {
            page.visibility = View.GONE
        }
    }
}