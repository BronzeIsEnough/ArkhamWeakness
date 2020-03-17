package com.medal.bronze.jsnader.arkhamweakness

import android.content.Context
import android.os.Bundle
import android.os.Vibrator
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.*
import android.view.animation.Animation.AnimationListener
import android.widget.ImageView
import android.widget.TextView
import com.medal.bronze.jsnader.arkhamweakness.locations.Location
import com.medal.bronze.jsnader.arkhamweakness.scenarios.ScenarioType
import com.medal.bronze.jsnader.arkhamweakness.weaknesses.CardBuilder
import com.medal.bronze.jsnader.arkhamweakness.weaknesses.Weakness
import java.util.*
import kotlin.math.ceil

/**
 * Created by Jeremiah on 3/24/2018.
 */
class ResultPage : AppCompatActivity() {
    private var mScenarioType: ScenarioType? = null
    private var mCards: ArrayList<Card?>? = null
    private var mRandom: Random? = null
    private var mFloatingButton: FloatingActionButton? = null
    private var mImageViewCard: ImageView? = null
    private var mTextViewWeaknessNumber: TextView? = null
    private var mAnimationSet: AnimationSet? = null
    private var mNumberOfTheseWeaknessesAvailable = 0
    override fun onCreate(pSavedInstanceState: Bundle?) {
        super.onCreate(pSavedInstanceState)
        setContentView(R.layout.activity_result_screen)
        mImageViewCard = findViewById<View?>(R.id.imageViewCard) as ImageView
        mTextViewWeaknessNumber = findViewById<View?>(R.id.textViewDisplayNumber) as TextView
        mScenarioType = intent.getSerializableExtra(getString(R.string.scenario_type)) as ScenarioType
        mFloatingButton = findViewById<View?>(R.id.fab) as FloatingActionButton
        mFloatingButton!!.setOnClickListener(View.OnClickListener {
            handleRandomCard()
            provideHapticFeedback()
        })
        mCards = CardBuilder(mScenarioType).getCardList()
        mRandom = Random()
        handleRandomCard()
    }

    private fun provideHapticFeedback() {
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(50)
    }

    private fun handleRandomCard() {
        val availableCard = mCards?.get(0)
        if (mAnimationSet == null) {
            setupAnimation()
        }
        if (availableCard is Weakness) {
            randomlyGenerateWeakness()
        } else if (availableCard is Location) {
            randomlyGenerateLocation()
        }
    }

    private fun randomlyGenerateWeakness() {
        val randomWeakness = getRandomCard() as Weakness?
        mNumberOfTheseWeaknessesAvailable = (randomWeakness?.getNumAvailable() ?: displayCard(randomWeakness)) as Int
    }

    private fun randomlyGenerateLocation() {
        val randomLocation = getRandomCard() as Location?
        displayCard(randomLocation)
    }

    private fun getRandomCard(): Card? {
        val randomPosition = mCards?.size?.let { mRandom?.nextInt(it) }
        return randomPosition?.let { mCards?.get(it) }
    }

    private fun setupAnimation() {
        mAnimationSet = AnimationSet(true)
        val rotateAnimation = RotateAnimation(0F, 360F, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        rotateAnimation.duration = 1000
        rotateAnimation.interpolator = LinearInterpolator()
        mAnimationSet!!.addAnimation(rotateAnimation)
        val growAnimation = ScaleAnimation(0.0f, 1.00f, 0f, 1.0f)
        growAnimation.duration = 1000
        growAnimation.interpolator = LinearInterpolator()
        mAnimationSet!!.addAnimation(growAnimation)
        mImageViewCard?.setAnimation(mAnimationSet)
        mAnimationSet!!.setAnimationListener(MyAnimationListener())
    }

    private fun displayCard(pCard: Card?) {
        mImageViewCard?.startAnimation(mAnimationSet)
        pCard?.getDrawableResource()?.let { mImageViewCard?.setImageResource(it) }
    }

    override fun onCreateOptionsMenu(pMenu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_selection_screen, pMenu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
    }

    private inner class MyAnimationListener : AnimationListener {
        override fun onAnimationStart(animation: Animation?) {
            mFloatingButton?.setEnabled(false)
            mTextViewWeaknessNumber?.setText("")
        }

        override fun onAnimationEnd(animation: Animation?) {
            mFloatingButton?.setEnabled(true)
            val chosenPosition = ceil(Math.random() * mNumberOfTheseWeaknessesAvailable).toInt()
            mTextViewWeaknessNumber?.setText("$chosenPosition of $mNumberOfTheseWeaknessesAvailable")
        }

        override fun onAnimationRepeat(animation: Animation?) {}
    }
}