package com.medal.bronze.jsnader.arkhamweakness.locaions;

import com.medal.bronze.jsnader.arkhamweakness.Card;
import com.medal.bronze.jsnader.arkhamweakness.CardType;

import java.util.ArrayList;

public class Location extends Card {
    public String                   mName;
    public ArrayList<LocationTrait> mLocationTraits;

    public Location(String pName, int pDrawableResource, ArrayList<LocationTrait> pLocationTraits){
        mCardType = CardType.LOCATION;
        mName = pName;
        mDrawableResource = pDrawableResource;
        mLocationTraits = pLocationTraits;
    }
}
