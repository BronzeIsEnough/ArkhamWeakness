package com.medal.bronze.jsnader.arkhamweakness;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.medal.bronze.jsnader.arkhamweakness.locations.Location;
import com.medal.bronze.jsnader.arkhamweakness.scenarios.ScenarioType;
import com.medal.bronze.jsnader.arkhamweakness.weaknesses.CardBuilder;
import com.medal.bronze.jsnader.arkhamweakness.weaknesses.Weakness;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Jeremiah on 3/24/2018.
 */
public class ResultPage extends AppCompatActivity {
    private ScenarioType            mScenarioType;
    private ArrayList<Card>         mCards;
    private Random                  mRandom;
    private FloatingActionButton    mFloatingButton;
    private ImageView               mImageViewCard;
    private TextView                mTextViewWeaknessNumber;
    private AnimationSet            mAnimationSet;
    private int                     mNumberOfTheseWeaknessesAvailable;

    @Override
    protected void onCreate(Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.activity_result_screen);

        mImageViewCard = (ImageView)findViewById(R.id.imageViewCard);
        mTextViewWeaknessNumber = (TextView)findViewById(R.id.textViewDisplayNumber);
        mScenarioType = (ScenarioType)getIntent().getSerializableExtra(getString(R.string.scenario_type));

        mFloatingButton = (FloatingActionButton) findViewById(R.id.fab);
        mFloatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleRandomCard();
                provideHapticFeedback();
            }
        });

        mCards = new CardBuilder(mScenarioType).getCardList();

        mRandom = new Random();

        handleRandomCard();
    }

    private void provideHapticFeedback(){
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(50);
    }

    private void handleRandomCard(){
        Card availableCard = mCards.get(0);

        if(mAnimationSet == null){
            setupAnimation();
        }

        if(availableCard instanceof Weakness){
            randomlyGenerateWeakness();
        }else if(availableCard instanceof Location){
            randomlyGenerateLocation();
        }
    }

    private void randomlyGenerateWeakness(){
        Weakness randomWeakness = (Weakness)getRandomCard();
        mNumberOfTheseWeaknessesAvailable = randomWeakness.getNumAvailable();
        displayCard(randomWeakness);
    }

    private void randomlyGenerateLocation(){
        Location randomLocation = (Location)getRandomCard();
        displayCard(randomLocation);
    }

    private Card getRandomCard(){
        int randomPosition = mRandom.nextInt(mCards.size());
        return mCards.get(randomPosition);
    }

    private void setupAnimation(){
        mAnimationSet = new AnimationSet(true);

        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        mAnimationSet.addAnimation(rotateAnimation);

        ScaleAnimation growAnimation = new ScaleAnimation(0.0f, 1.00f, 0f, 1.0f);
        growAnimation.setDuration(1000);
        growAnimation.setInterpolator(new LinearInterpolator());
        mAnimationSet.addAnimation(growAnimation);
        mImageViewCard.setAnimation(mAnimationSet);

        mAnimationSet.setAnimationListener(new MyAnimationListener());
    }

    private void displayCard(Card pCard){
        mImageViewCard.startAnimation(mAnimationSet);
        mImageViewCard.setImageResource(pCard.getDrawableResource());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu pMenu) {
        getMenuInflater().inflate(R.menu.menu_selection_screen, pMenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    private class MyAnimationListener implements Animation.AnimationListener{
        @Override
        public void onAnimationStart(Animation animation) {
            mFloatingButton.setEnabled(false);
            mTextViewWeaknessNumber.setText("");
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            mFloatingButton.setEnabled(true);
            int chosenPosition = (int)Math.ceil(Math.random() * mNumberOfTheseWeaknessesAvailable);
            mTextViewWeaknessNumber.setText(chosenPosition + " of " + mNumberOfTheseWeaknessesAvailable);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
