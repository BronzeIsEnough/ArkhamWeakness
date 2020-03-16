package com.medal.bronze.jsnader.arkhamweakness.scenarios;

import com.medal.bronze.jsnader.arkhamweakness.support.CardTrait;
import com.medal.bronze.jsnader.arkhamweakness.locations.Location;

import java.util.ArrayList;

/**
 * Represents a specific scenario within the Arkham Horror LCG universe that a weakness could be
 * selected from.
 *
 * Created by Jeremiah on 3/24/2018.
 */
public class Scenario {
    private ScenarioType         mScenarioType;
    private String               mScenarioTitle;
    private String               mCampaignTitle;
    private int                  mImageResource;
    private ArrayList<CardTrait> mTraits;
    private ArrayList<Location>  mLocations;

    public Scenario(ScenarioType pScenarioType, String pScenarioTitle, String pCampaignTitle, int pImageResource){
        mScenarioType = pScenarioType;
        mScenarioTitle = pScenarioTitle;
        mCampaignTitle = pCampaignTitle;
        mImageResource = pImageResource;
    }

    public String getScenarioTitle(){return mScenarioTitle;}
    public String getCampaignTitle(){return mCampaignTitle;}
    public int getImageResource(){return mImageResource;}
    public ScenarioType getScenarioType(){return mScenarioType;}

    public void setTraits(ArrayList<CardTrait> pTraits){
        mTraits = pTraits;
    }
    public ArrayList<CardTrait> getTraits(){return mTraits;}
    public void setLocations(ArrayList<Location> pLocations) {mLocations = pLocations;}
    public ArrayList<Location>  getLocations(){return mLocations;}
}
