package com.medal.bronze.jsnader.arkhamweakness

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.*
import android.view.animation.Animation.AnimationListener
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.medal.bronze.jsnader.arkhamweakness.locations.Location
import com.medal.bronze.jsnader.arkhamweakness.scenarios.ScenarioType
import com.medal.bronze.jsnader.arkhamweakness.weaknesses.CardBuilder
import com.medal.bronze.jsnader.arkhamweakness.weaknesses.Weakness
import java.util.*
import kotlin.math.ceil

/**
 * Created by Jeremiah on 2/25/2021.
 */
class ResultPage : AppCompatActivity() {
    private val STEPS_OF_YOTH = "Steps of Yoth"
    private val YOTH_LOC_MAX = 5;
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
        mScenarioType =
                intent.getSerializableExtra(getString(R.string.scenario_type)) as ScenarioType
        mFloatingButton = findViewById<View?>(R.id.fab) as FloatingActionButton
        mFloatingButton!!.setOnClickListener {
            handleRandomCard()
            provideHapticFeedback()
        }
        mRandom = Random()
        mCards = getCardList()
        handleRandomCard()
    }

    private fun provideHapticFeedback() {
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(150,10))
        } else {
            @Suppress("DEPRECATION")
            vibrator.vibrate(150)
        }
    }

    private fun getCardList() : ArrayList<Card?>? {
        var cards : ArrayList<Card?>? = CardBuilder(mScenarioType).getCardList()
        // This scenario wants a random subset of locations.  So we create a subset of locations to
        // start with that MUST include the Steps of Yoth in it.
        if (mScenarioType == ScenarioType.DEPTHS_OF_YOTH_LOCATION) {
            while(cards?.size!! > YOTH_LOC_MAX) {
                val index = mRandom?.nextInt(cards.size)
                val card : Card = index?.let { cards.get(it) }!!
                if (card is Location && !card.mName.equals(STEPS_OF_YOTH)) {
                    cards.remove(card)
                }
            }
        }
        return cards
    }

    private fun handleRandomCard() {
        // There are cases where we are removing entries, so make sure we have one to start with.
        if (mCards?.size!! <= 0) return;
        // If cards are available, then continue.
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
        mNumberOfTheseWeaknessesAvailable = randomWeakness?.getNumAvailable() as Int
        displayCard(randomWeakness)
    }

    private fun randomlyGenerateLocation() {
        var randomLocation = getRandomCard() as Location?
        // As we set one up, we need to remove another that has already been used.
        if (mScenarioType == ScenarioType.DEPTHS_OF_YOTH_LOCATION) {
            // Per the scenario, you can't have the initial location be the steps.
            while(mCards?.size == YOTH_LOC_MAX && randomLocation?.mName.equals(STEPS_OF_YOTH)) {
                randomLocation = getRandomCard() as Location?
            }
            mCards?.remove(randomLocation)
        }
        displayCard(randomLocation)
    }

    private fun getRandomCard(): Card? {
        val randomPosition = mCards?.size?.let { mRandom?.nextInt(it) }
        return randomPosition?.let { mCards?.get(it) }
    }

    private fun setupAnimation() {
        mAnimationSet = AnimationSet(true)
        val rotateAnimation =
                RotateAnimation(0F,
                        360F, Animation.RELATIVE_TO_SELF,
                        0.5f,
                        Animation.RELATIVE_TO_SELF,
                        0.5f)
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
        @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
    }

    private inner class MyAnimationListener : AnimationListener {
        override fun onAnimationStart(animation: Animation?) {
            mFloatingButton?.isEnabled = false
            mTextViewWeaknessNumber?.text = ""
        }

        override fun onAnimationEnd(animation: Animation?) {
            mFloatingButton?.isEnabled = true
            var chosenPosition = ceil(Math.random() * mNumberOfTheseWeaknessesAvailable).toInt()
            //If the card doesn't have this attribute then assume value 1 of 1
            if (chosenPosition == 0 || mNumberOfTheseWeaknessesAvailable == 0) {
                chosenPosition = 1;
                mNumberOfTheseWeaknessesAvailable = 1;
            }
            mTextViewWeaknessNumber?.text = "$chosenPosition of $mNumberOfTheseWeaknessesAvailable"
        }

        override fun onAnimationRepeat(animation: Animation?) {}
    }
}