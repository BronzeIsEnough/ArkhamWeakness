package com.medal.bronze.jsnader.arkhamweakness.locaions;

import java.util.ArrayList;

public class Location {
    public String mName;
    public ArrayList<LocationTrait> mLocationTraits;

    public ArrayList<Location> getUnseenLocations(){
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location());
        return locations;
    }
}
