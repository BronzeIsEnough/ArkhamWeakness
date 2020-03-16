package com.medal.bronze.jsnader.arkhamweakness.locations;

import com.medal.bronze.jsnader.arkhamweakness.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A class that is meant to build a list of locations that would define what should be included
 * within the ScenarioAdapter class.
 *
 * Created by Jeremiah on 3/24/2018.
 */
public class LocationBuilder {
    private static LocationBuilder mInstance;

    private LocationBuilder(){

    }

    public static LocationBuilder getInstance(){
        if(mInstance == null){
            mInstance = new LocationBuilder();
        }
        return mInstance;
    }

    public ArrayList<Location> getUnseenLocations(){
        ArrayList<Location> locations = new ArrayList<>();
        ArrayList<LocationTrait> locationTraits = new ArrayList<>(Arrays.asList(LocationTrait.DUNWICH));
        locations.add(new Location("Blasted Heath", R.drawable.unseen_blasted_heath, locationTraits));
        locations.add(new Location("Cold Spring Glen", R.drawable.unseen_cold_spring_glen, locationTraits));
        locations.add(new Location("Devil's Hopyard", R.drawable.unseen_devils_hop_yard, locationTraits));
        locations.add(new Location("Dunwich Village", R.drawable.unseen_dunwich_village, locationTraits));
        locations.add(new Location("Ten Acre Meadow", R.drawable.unseen_ten_acre_meadow, locationTraits));
        locations.add(new Location("Whateley Ruins", R.drawable.unseen_whateley_ruins, locationTraits));
        return locations;
    }
}
