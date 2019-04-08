package com.medal.bronze.jsnader.arkhamweakness.weaknesses;
import com.medal.bronze.jsnader.arkhamweakness.R;
import com.medal.bronze.jsnader.arkhamweakness.scenarios.Scenario;
import com.medal.bronze.jsnader.arkhamweakness.scenarios.ScenarioBuilder;
import com.medal.bronze.jsnader.arkhamweakness.scenarios.ScenarioType;
import com.medal.bronze.jsnader.arkhamweakness.support.CampaignAffinity;
import com.medal.bronze.jsnader.arkhamweakness.support.CardTrait;

import java.util.ArrayList;

/**
 * A class that is meant to build a list of weaknesses that would define what should be included
 * within the ScenarioAdapter class.
 *
 * Created by Jeremiah on 3/24/2018.
 */
public class WeaknessBuilder {
    private ArrayList<Weakness> mFullWeaknessList = new ArrayList<>();
    private ArrayList<Weakness> mWeaknesses = new ArrayList<>();

    public WeaknessBuilder(ScenarioType pScenarioType){
        setupFullWeaknessList();

        switch (pScenarioType){
            case GENERAL:
                buildGeneralWeaknessList();
                break;
            case UNDIMENSIONED_AND_UNSEEN:
                buildUndimensionedWeaknessList();
                break;
            case BLACK_STARS_RISE:
                buildBlackStarsRiseWeaknessList();
                break;
        }
    }

    public ArrayList<Weakness> getWeaknessList(){
        return mWeaknesses;
    }

    private void buildGeneralWeaknessList(){
        for (Weakness weakness : mFullWeaknessList){
            for(int index = 0; index < weakness.getNumAvailable(); index++){
                mWeaknesses.add(weakness);
            }
        }
    }

    private void buildUndimensionedWeaknessList(){
        ArrayList<CardTrait> traits = new ScenarioBuilder().getScenario(ScenarioType.UNDIMENSIONED_AND_UNSEEN).getTraits();
        updateListWithTraits(traits);
    }

    private void buildBlackStarsRiseWeaknessList(){
        ArrayList<CardTrait> traits = new ScenarioBuilder().getScenario(ScenarioType.BLACK_STARS_RISE).getTraits();
        updateListWithTraits(traits);
    }

    private void updateListWithTraits(ArrayList<CardTrait> pScenarioTraits){
        for (Weakness weakness : mFullWeaknessList){
            for(CardTrait trait: pScenarioTraits){ //Step through each possible trait that the weakness could have.
                if(weakness.getCardTraits().contains(trait)) {
                    for (int index = 0; index < weakness.getNumAvailable(); index++) { //If there are more than one card, add it multiple times.
                        mWeaknesses.add(weakness);
                    }
                    break; //If one trait is found in the search, then proceed to the next weakness;
                }
            }
        }
    }

    private void setupFullWeaknessList(){
        ArrayList<CardTrait> cardTraits = new ArrayList<>();
        Weakness amnWeakness = new Weakness("Amnesia", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 2, R.drawable.weakness_amnesia);
        cardTraits.add(CardTrait.MADNESS);
        amnWeakness.setCardTraits(cardTraits);
        cardTraits.clear();

        Weakness chrWeakness = new Weakness("Chronophobia", CampaignAffinity.DUNWICH_LEGACY, 2, R.drawable.weakness_chronophobia);
        cardTraits.add(CardTrait.MADNESS);
        chrWeakness.setCardTraits(cardTraits);
        cardTraits.clear();

        Weakness drwSignWeakeness = new Weakness("Drawing the Sign", CampaignAffinity.PATH_TO_CARCOSA, 1, R.drawable.weakness_drawing_the_sign);
        cardTraits.add(CardTrait.MADNESS);
        cardTraits.add(CardTrait.PACT);
        drwSignWeakeness.setCardTraits(cardTraits);
        cardTraits.clear();

        Weakness hauWeakness = new Weakness("Haunted", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_haunted);
        cardTraits.add(CardTrait.CURSE);
        hauWeakness.setCardTraits(cardTraits);
        cardTraits.clear();

        Weakness hypWeakness = new Weakness("Hypochondria", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_hypochondria);
        cardTraits.add(CardTrait.MADNESS);
        hypWeakness.setCardTraits(cardTraits);
        cardTraits.clear();

        Weakness indWeakness = new Weakness("Indebted", CampaignAffinity.DUNWICH_LEGACY, 2, R.drawable.weakness_indebted);
        cardTraits.add(CardTrait.FLAW);
        indWeakness.setCardTraits(cardTraits);
        cardTraits.clear();

        Weakness intWeakness = new Weakness("Internal Injury", CampaignAffinity.DUNWICH_LEGACY, 2, R.drawable.weakness_internal_injury);
        cardTraits.add(CardTrait.INJURY);
        intWeakness.setCardTraits(cardTraits);
        cardTraits.clear();

        Weakness mobWeakness = new Weakness("Mob Enforcer", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_mob_enforcer);
        cardTraits.add(CardTrait.HUMANOID);
        cardTraits.add(CardTrait.CRIMINAL);
        mobWeakness.setCardTraits(cardTraits);
        cardTraits.clear();

        Weakness ovrWeakness = new Weakness("Overzealous", CampaignAffinity.PATH_TO_CARCOSA, 2, R.drawable.weakness_overzealous);
        cardTraits.add(CardTrait.FLAW);
        ovrWeakness.setCardTraits(cardTraits);
        cardTraits.clear();

        Weakness parWeakness = new Weakness("Paranoia", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 2, R.drawable.weakness_paranoia);
        cardTraits.add(CardTrait.MADNESS);
        parWeakness.setCardTraits(cardTraits);
        cardTraits.clear();

        Weakness psyWeakness = new Weakness("Psychosis", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_psychosis);
        cardTraits.add(CardTrait.MADNESS);
        psyWeakness.setCardTraits(cardTraits);
        cardTraits.clear();

        Weakness silWeakness = new Weakness("Silver Twilight Acolyte", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_silver_twilight_acolyte);
        cardTraits.add(CardTrait.HUMANOID);
        cardTraits.add(CardTrait.CULTIST);
        cardTraits.add(CardTrait.SILVER_TWILIGHT);
        silWeakness.setCardTraits(cardTraits);
        cardTraits.clear();

        Weakness stbWeakness = new Weakness("Stubborn Detective", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_stubbor_detective);
        cardTraits.add(CardTrait.HUMANOID);
        cardTraits.add(CardTrait.DETECTIVE);
        stbWeakness.setCardTraits(cardTraits);
        cardTraits.clear();

        Weakness thgWeakness = new Weakness("The Thing That Follows", CampaignAffinity.PATH_TO_CARCOSA, 1, R.drawable.weakness_the_thing_that_follows);
        cardTraits.add(CardTrait.MONSTER);
        cardTraits.add(CardTrait.CURSE);
        thgWeakness.setCardTraits(cardTraits);
        cardTraits.clear();

        mFullWeaknessList.add(amnWeakness);
        mFullWeaknessList.add(chrWeakness);
        mFullWeaknessList.add(drwSignWeakeness);
        mFullWeaknessList.add(hauWeakness);
        mFullWeaknessList.add(hypWeakness);
        mFullWeaknessList.add(indWeakness);
        mFullWeaknessList.add(intWeakness);
        mFullWeaknessList.add(mobWeakness);
        mFullWeaknessList.add(ovrWeakness);
        mFullWeaknessList.add(parWeakness);
        mFullWeaknessList.add(psyWeakness);
        mFullWeaknessList.add(silWeakness);
        mFullWeaknessList.add(stbWeakness);
        mFullWeaknessList.add(thgWeakness);
    }
}

