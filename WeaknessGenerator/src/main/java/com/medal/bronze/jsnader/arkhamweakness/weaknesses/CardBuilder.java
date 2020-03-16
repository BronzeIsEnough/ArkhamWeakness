package com.medal.bronze.jsnader.arkhamweakness.weaknesses;
import com.medal.bronze.jsnader.arkhamweakness.Card;
import com.medal.bronze.jsnader.arkhamweakness.R;
import com.medal.bronze.jsnader.arkhamweakness.locations.Location;
import com.medal.bronze.jsnader.arkhamweakness.scenarios.ScenarioBuilder;
import com.medal.bronze.jsnader.arkhamweakness.scenarios.ScenarioType;
import com.medal.bronze.jsnader.arkhamweakness.support.CampaignAffinity;
import com.medal.bronze.jsnader.arkhamweakness.support.CardTrait;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A class that is meant to build a list of weaknesses that would define what should be included
 * within the ScenarioAdapter class.
 *
 * Created by Jeremiah on 3/24/2018.
 */
public class CardBuilder {
    private ScenarioType        mScenarioType;
    private ArrayList<Weakness> mFullWeaknessList = new ArrayList<>();
    private ArrayList<Card>     mCardList = new ArrayList<>();

    public CardBuilder(ScenarioType pScenarioType){
        mScenarioType = pScenarioType;

        setupFullWeaknessList();

        switch (pScenarioType){
            case GENERAL:
                buildGeneralWeaknessList();
                break;
            case UNDIMENSIONED_AND_UNSEEN_WEAKNESS:
                buildUndimensionedWeaknessList();
                break;
            case UNDIMENSIONED_AND_UNSEEN_LOCATION:
                buildUndimensionedLocationList();
                break;
            case BLACK_STARS_RISE:
                buildBlackStarsRiseWeaknessList();
                break;
        }
    }

    public ArrayList<Card> getCardList(){
        return mCardList;
    }

    private void buildGeneralWeaknessList(){
        for (Weakness weakness : mFullWeaknessList){
            for(int index = 0; index < weakness.getNumAvailable(); index++){
                mCardList.add(weakness);
            }
        }
    }

    private void buildUndimensionedWeaknessList(){
        ArrayList<CardTrait> traits = new ScenarioBuilder().getScenario(ScenarioType.UNDIMENSIONED_AND_UNSEEN_WEAKNESS).getTraits();
        updateListWithTraits(traits);
    }

    private void buildUndimensionedLocationList(){
        ArrayList<Location> locationList = new ScenarioBuilder().getScenario(ScenarioType.UNDIMENSIONED_AND_UNSEEN_LOCATION).getLocations();
        for (Location location : locationList){
            mCardList.add(location);
        }
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
                        mCardList.add(weakness);
                    }
                    break; //If one trait is found in the search, then proceed to the next weakness;
                }
            }
        }
    }

    private void setupFullWeaknessList(){ //Keep alphabetical for easy reference later.
        ArrayList<CardTrait> cardTraits = new ArrayList<>();
        Weakness amnWeakness = new Weakness("Amnesia", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 2, R.drawable.weakness_amnesia);
        assignCardTraits(amnWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.MADNESS)));

        Weakness chrWeakness = new Weakness("Chronophobia", CampaignAffinity.DUNWICH_LEGACY, 2, R.drawable.weakness_chronophobia);
        assignCardTraits(chrWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.MADNESS)));

        Weakness drkPctWeakness = new Weakness("Dark Pact", CampaignAffinity.THE_FORGOTTEN_AGE, 1, R.drawable.weakness_dark_pact);
        assignCardTraits(drkPctWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.PACT)));

        Weakness dmdPctWeakness = new Weakness("Doomed", CampaignAffinity.THE_FORGOTTEN_AGE, 1, R.drawable.weakness_doomed);
        assignCardTraits(dmdPctWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.CURSE)));

        Weakness drwSignWeakeness = new Weakness("Drawing the Sign", CampaignAffinity.PATH_TO_CARCOSA, 1, R.drawable.weakness_drawing_the_sign);
        assignCardTraits(drwSignWeakeness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.MADNESS, CardTrait.PACT)));

        Weakness hauWeakness = new Weakness("Haunted", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_haunted);
        assignCardTraits(hauWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.CURSE)));

        Weakness hypWeakness = new Weakness("Hypochondria", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_hypochondria);
        assignCardTraits(hypWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.MADNESS)));

        Weakness indWeakness = new Weakness("Indebted", CampaignAffinity.DUNWICH_LEGACY, 2, R.drawable.weakness_indebted);
        assignCardTraits(indWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.FLAW)));

        Weakness intWeakness = new Weakness("Internal Injury", CampaignAffinity.DUNWICH_LEGACY, 2, R.drawable.weakness_internal_injury);
        assignCardTraits(intWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.INJURY)));

        Weakness klptoWeakness = new Weakness("Kleptomania", CampaignAffinity.DREAM_EATERS, 1, R.drawable.weakness_kleptomania);
        assignCardTraits(klptoWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.MADNESS, CardTrait.TALENT)));

        Weakness mobWeakness = new Weakness("Mob Enforcer", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_mob_enforcer);
        assignCardTraits(mobWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.HUMANOID, CardTrait.CRIMINAL)));

        Weakness nrcWeakness = new Weakness("Narcolepsy", CampaignAffinity.DREAM_EATERS, 1, R.drawable.weakness_narcolepsy);
        assignCardTraits(nrcWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.MADNESS)));

        Weakness ovrWeakness = new Weakness("Overzealous", CampaignAffinity.PATH_TO_CARCOSA, 2, R.drawable.weakness_overzealous);
        assignCardTraits(ovrWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.FLAW)));

        Weakness parWeakness = new Weakness("Paranoia", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 2, R.drawable.weakness_paranoia);
        assignCardTraits(parWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.MADNESS)));

        Weakness psyWeakness = new Weakness("Psychosis", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_psychosis);
        assignCardTraits(psyWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.MADNESS)));

        Weakness slfCntWeakness = new Weakness("Self-Centered", CampaignAffinity.DREAM_EATERS, 1, R.drawable.weakness_self_centered);
        assignCardTraits(slfCntWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.FLAW)));

        Weakness silWeakness = new Weakness("Silver Twilight Acolyte", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_silver_twilight_acolyte);
        assignCardTraits(silWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.HUMANOID, CardTrait.CULTIST, CardTrait.SILVER_TWILIGHT)));

        Weakness stbWeakness = new Weakness("Stubborn Detective", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_stubbor_detective);
        assignCardTraits(stbWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.HUMANOID, CardTrait.DETECTIVE)));

        Weakness thrtnVisWeakness = new Weakness("The 13th Vision", CampaignAffinity.CIRCLE_UNDONE, 1, R.drawable.weakness_thirteenth_vision);
        assignCardTraits(thrtnVisWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.OMEN)));

        Weakness thgWeakness = new Weakness("The Thing That Follows", CampaignAffinity.PATH_TO_CARCOSA, 1, R.drawable.weakness_the_thing_that_follows);
        assignCardTraits(thgWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.MONSTER, CardTrait.CURSE)));

        Weakness twrXviWeakenss = new Weakness("The Tower - XVI: Circumstances Beyond Your Control", CampaignAffinity.CIRCLE_UNDONE, 2, R.drawable.weakness_the_tower);
        assignCardTraits(twrXviWeakenss, new ArrayList<CardTrait>(Arrays.asList(CardTrait.OMEN, CardTrait.TAROT)));

        Weakness thrDaGtsWeakness = new Weakness("Through the Gates", CampaignAffinity.CIRCLE_UNDONE, 1, R.drawable.weakness_through_the_gates);
        assignCardTraits(thrDaGtsWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.PACT, CardTrait.MYSTERY)));

        Weakness unspBldWeakness = new Weakness("Unspeakable Oath (Bloodthirst)", CampaignAffinity.RETURN_TO_PATH_TO_CARCOSA, 1, R.drawable.weakness_unspeakable_oath_bloodthirst);
        assignCardTraits(unspBldWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.MADNESS, CardTrait.PACT)));

        Weakness unspCwrdWeakness = new Weakness("Unspeakable Oath (Cowardice)", CampaignAffinity.RETURN_TO_PATH_TO_CARCOSA, 1, R.drawable.weakness_unspeakable_oath_cowardice);
        assignCardTraits(unspCwrdWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.MADNESS, CardTrait.PACT)));

        Weakness unspCurWeakness = new Weakness("Unspeakable Oath (Curiosity)", CampaignAffinity.RETURN_TO_PATH_TO_CARCOSA, 1, R.drawable.weakness_unspeakable_oath_curiosity);
        assignCardTraits(unspCurWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.MADNESS, CardTrait.PACT)));

        Weakness ywnWeakness = new Weakness("Your Worst Nightmare", CampaignAffinity.DREAM_EATERS, 1, R.drawable.weakness_your_worst_nightmare);
        assignCardTraits(ywnWeakness, new ArrayList<CardTrait>(Arrays.asList(CardTrait.MONSTER)));

        mFullWeaknessList.add(amnWeakness);
        mFullWeaknessList.add(chrWeakness);
        mFullWeaknessList.add(drwSignWeakeness);
        mFullWeaknessList.add(drkPctWeakness);
        mFullWeaknessList.add(dmdPctWeakness);
        mFullWeaknessList.add(hauWeakness);
        mFullWeaknessList.add(hypWeakness);
        mFullWeaknessList.add(indWeakness);
        mFullWeaknessList.add(intWeakness);
        mFullWeaknessList.add(klptoWeakness);
        mFullWeaknessList.add(mobWeakness);
        mFullWeaknessList.add(nrcWeakness);
        mFullWeaknessList.add(ovrWeakness);
        mFullWeaknessList.add(parWeakness);
        mFullWeaknessList.add(psyWeakness);
        mFullWeaknessList.add(slfCntWeakness);
        mFullWeaknessList.add(silWeakness);
        mFullWeaknessList.add(stbWeakness);
        mFullWeaknessList.add(thrtnVisWeakness);
        mFullWeaknessList.add(thgWeakness);
        mFullWeaknessList.add(twrXviWeakenss);
        mFullWeaknessList.add(thrDaGtsWeakness);
        mFullWeaknessList.add(unspBldWeakness);
        mFullWeaknessList.add(unspCurWeakness);
        mFullWeaknessList.add(unspCwrdWeakness);
        mFullWeaknessList.add(ywnWeakness);
    }

    private synchronized void assignCardTraits(Weakness pWeakness, ArrayList<CardTrait> pCardTraits){
        for (CardTrait trait: new ArrayList<CardTrait>(pCardTraits)) {
            pCardTraits.add(trait);
        }
        pWeakness.setCardTraits(pCardTraits);
        pCardTraits.clear();
    }
}

