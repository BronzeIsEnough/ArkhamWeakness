package com.medal.bronze.jsnader.arkhamweakness.scenarios;

import com.medal.bronze.jsnader.arkhamweakness.R;
import com.medal.bronze.jsnader.arkhamweakness.support.CardTrait;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that is meant to build a list of scenarios that would define what should be included
 * within the ScenarioAdapter class.
 *
 * Created by Jeremiah on 3/24/2018.
 */
public class ScenarioBuilder {
    private ArrayList<CardTrait> mCardTraits = new ArrayList<>();

    public ScenarioBuilder(){

    }

    public List<Scenario> buildScenarioList(){
        ArrayList<Scenario> scenarios = new ArrayList<>();

        addGeneralAllInclusive(scenarios);
        addUndimensioned(scenarios);
        addBlackStarsRise(scenarios);

        return scenarios;
    }

    public Scenario getScenario(ScenarioType pScenarioType){
        ArrayList<Scenario> scenarios = new ArrayList<>();

        switch (pScenarioType){
            case GENERAL:
                addGeneralAllInclusive(scenarios);
                break;
            case UNDIMENSIONED_AND_UNSEEN:
                addUndimensioned(scenarios);
                break;
            case BLACK_STARS_RISE:
                addBlackStarsRise(scenarios);
                break;
        }

        return scenarios.get(0);
    }

    private void addGeneralAllInclusive(ArrayList<Scenario> pScenarios){
        Scenario allInclusive = new Scenario(ScenarioType.GENERAL, "General Weakness", "All Inclusive", R.drawable.general_weakness);
        mCardTraits.clear();
        mCardTraits.add(CardTrait.ALL);
        allInclusive.setTraits(new ArrayList<CardTrait>(mCardTraits));
        pScenarios.add(allInclusive);
    }

    private void addUndimensioned(ArrayList<Scenario> pScenarios){
        Scenario undimensioned = new Scenario(ScenarioType.UNDIMENSIONED_AND_UNSEEN,"Undimensioned & Unseen", "in the Dunwich Horror campaign", R.drawable.undimensioned_and_unseen);
        mCardTraits.clear();
        mCardTraits.add(CardTrait.MADNESS);
        mCardTraits.add(CardTrait.INJURY);
        mCardTraits.add(CardTrait.PACT);
        undimensioned.setTraits(new ArrayList<CardTrait>(mCardTraits));
        pScenarios.add(undimensioned);
    }

    private void addBlackStarsRise(ArrayList<Scenario> pScenarios){
        Scenario blackStarsRise = new Scenario(ScenarioType.BLACK_STARS_RISE,"Black Stars Rise", "in the Path to Carcosa campaign", R.drawable.black_stars_rise);
        mCardTraits.clear();
        mCardTraits.add(CardTrait.MADNESS);
        mCardTraits.add(CardTrait.PACT);
        mCardTraits.add(CardTrait.CULTIST);
        mCardTraits.add(CardTrait.DETECTIVE);
        blackStarsRise.setTraits(new ArrayList<CardTrait>(mCardTraits));
        pScenarios.add(blackStarsRise);
    }
}
