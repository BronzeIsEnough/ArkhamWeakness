package com.medal.bronze.jsnader.arkhamweakness.scenarios;

import com.medal.bronze.jsnader.arkhamweakness.R;
import com.medal.bronze.jsnader.arkhamweakness.locaions.Location;
import com.medal.bronze.jsnader.arkhamweakness.locaions.LocationBuilder;
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
    private ArrayList<Location>  mLocations = new ArrayList<>();

    public ScenarioBuilder(){

    }

    public List<Scenario> buildScenarioList(){
        ArrayList<Scenario> scenarios = new ArrayList<>();

        addGeneralAllInclusive(scenarios);
        addUndimensionedWeakness(scenarios);
        addUndimensionedLocations(scenarios);
        addBlackStarsRise(scenarios);

        return scenarios;
    }

    public Scenario getScenario(ScenarioType pScenarioType){
        ArrayList<Scenario> scenarios = new ArrayList<>();

        switch (pScenarioType){
            case GENERAL:
                addGeneralAllInclusive(scenarios);
                break;
            case UNDIMENSIONED_AND_UNSEEN_WEAKNESS:
                addUndimensionedWeakness(scenarios);
                break;
            case UNDIMENSIONED_AND_UNSEEN_LOCATION:
                addUndimensionedLocations(scenarios);
                break;
            case BLACK_STARS_RISE:
                addBlackStarsRise(scenarios);
                break;
        }

        return scenarios.get(0);
    }

    private void addGeneralAllInclusive(ArrayList<Scenario> pScenarios){
        Scenario allInclusive = new Scenario(ScenarioType.GENERAL, "General Weakness", "All Inclusive", R.drawable.general_weakness);
        clear();
        mCardTraits.add(CardTrait.ALL);
        allInclusive.setTraits(new ArrayList<CardTrait>(mCardTraits));
        pScenarios.add(allInclusive);
    }

    private void addUndimensionedWeakness(ArrayList<Scenario> pScenarios){
        Scenario undimensionedWkns = new Scenario(ScenarioType.UNDIMENSIONED_AND_UNSEEN_WEAKNESS,"Undimensioned & Unseen - Weakness", "in the Dunwich Horror campaign", R.drawable.undimensioned_and_unseen);
        clear();
        mCardTraits.add(CardTrait.MADNESS);
        mCardTraits.add(CardTrait.INJURY);
        mCardTraits.add(CardTrait.PACT);
        undimensionedWkns.setTraits(new ArrayList<CardTrait>(mCardTraits));
        pScenarios.add(undimensionedWkns);
    }

    private void addUndimensionedLocations(ArrayList<Scenario> pScenarios){
        Scenario undimensionedLocs = new Scenario(ScenarioType.UNDIMENSIONED_AND_UNSEEN_LOCATION,"Undimensioned & Unseen - Location", "in the Dunwich Horror campaign", R.drawable.undimensioned_and_unseen);
        clear();
        mLocations = LocationBuilder.getInstance().getUnseenLocations();
        undimensionedLocs.setLocations(mLocations);
        pScenarios.add(undimensionedLocs);
    }

    private void addBlackStarsRise(ArrayList<Scenario> pScenarios){
        Scenario blackStarsRise = new Scenario(ScenarioType.BLACK_STARS_RISE,"Black Stars Rise", "in the Path to Carcosa campaign", R.drawable.black_stars_rise);
        clear();
        mCardTraits.add(CardTrait.MADNESS);
        mCardTraits.add(CardTrait.PACT);
        mCardTraits.add(CardTrait.CULTIST);
        mCardTraits.add(CardTrait.DETECTIVE);
        blackStarsRise.setTraits(new ArrayList<CardTrait>(mCardTraits));
        pScenarios.add(blackStarsRise);
    }

    private void clear(){
        mCardTraits.clear();
        mLocations.clear();
    }
}
