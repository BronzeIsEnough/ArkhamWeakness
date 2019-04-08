package com.medal.bronze.jsnader.arkhamweakness.weaknesses;

import com.medal.bronze.jsnader.arkhamweakness.Card;
import com.medal.bronze.jsnader.arkhamweakness.CardType;
import com.medal.bronze.jsnader.arkhamweakness.support.CampaignAffinity;
import com.medal.bronze.jsnader.arkhamweakness.support.CardTrait;

import java.util.ArrayList;

/**
 * The main container class for representing a weakness on screen.  It will describe all the
 * elements that make up an Arkham Horror LCG weakness card.
 *
 * Created by Jeremiah on 3/24/2018.
 */
public class Weakness extends Card {
    private String                  mName;
    private CampaignAffinity        mSetAffinity;
    private int                     mNumAvailForSet; //1 or 2 typically
    private ArrayList<CardTrait>    mCardTraits;

    public Weakness(String pName, CampaignAffinity pSetAffinity, int pNumAvailable, int pDrawableResource){
        mCardType = CardType.WEAKNESS;
        mName = pName;
        mSetAffinity = pSetAffinity;
        mNumAvailForSet = pNumAvailable;
        mDrawableResource = pDrawableResource;
    }

    public void setCardTraits(ArrayList<CardTrait> pCardTraits){
        mCardTraits = new ArrayList<CardTrait>(pCardTraits);
    }

    public ArrayList<CardTrait> getCardTraits(){
        return mCardTraits;
    }

    public int getNumAvailable(){
        return mNumAvailForSet;
    }

    public int getDrawableResource(){return mDrawableResource;}
}
