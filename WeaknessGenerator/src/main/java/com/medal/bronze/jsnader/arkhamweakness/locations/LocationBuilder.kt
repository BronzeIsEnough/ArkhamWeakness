package com.medal.bronze.jsnader.arkhamweakness.locations

import com.medal.bronze.jsnader.arkhamweakness.R
import java.util.*

/**
 * A class that is meant to build a list of locations that would define what should be included
 * within the ScenarioAdapter class.
 *
 * Created by Jeremiah on 3/24/2018.
 */
class LocationBuilder private constructor() {
    fun getUnseenLocations(): ArrayList<Location?>? {
        val locations = ArrayList<Location?>()
        val locationTraits = ArrayList(Arrays.asList(LocationTrait.DUNWICH))
        locations.add(Location("Blasted Heath", R.drawable.unseen_blasted_heath, locationTraits))
        locations.add(Location("Cold Spring Glen", R.drawable.unseen_cold_spring_glen, locationTraits))
        locations.add(Location("Devil's Hopyard", R.drawable.unseen_devils_hop_yard, locationTraits))
        locations.add(Location("Dunwich Village", R.drawable.unseen_dunwich_village, locationTraits))
        locations.add(Location("Ten Acre Meadow", R.drawable.unseen_ten_acre_meadow, locationTraits))
        locations.add(Location("Whateley Ruins", R.drawable.unseen_whateley_ruins, locationTraits))
        return locations
    }

    companion object {
        private var mInstance: LocationBuilder? = null
        fun getInstance(): LocationBuilder? {
            if (mInstance == null) {
                mInstance = LocationBuilder()
            }
            return mInstance
        }
    }
}