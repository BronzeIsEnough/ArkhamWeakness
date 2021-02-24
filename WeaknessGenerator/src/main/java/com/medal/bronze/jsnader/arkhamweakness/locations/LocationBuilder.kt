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

    fun getForgottenAgeLocations(): ArrayList<Location?>? {
        val locations = ArrayList<Location?>()
        val locationTraits = ArrayList(Arrays.asList(LocationTrait.FORGOTTEN_AGE))
        locations.add(Location("Steps of Yoth", R.drawable.location_steps_of_yoth, locationTraits))
        locations.add(Location("City of the Serpents", R.drawable.location_city_of_the_serpents, locationTraits))
        locations.add(Location("Hall of Heresy", R.drawable.location_hall_of_heresy, locationTraits))
        locations.add(Location("Crumbling Precipice", R.drawable.location_crumbling_precipice, locationTraits))
        locations.add(Location("Caverns of Yoth", R.drawable.location_caverns_of_yoth, locationTraits))
        locations.add(Location("Forked Path", R.drawable.location_forked_path, locationTraits))
        locations.add(Location("Bridge over N'kai", R.drawable.location_bridge_over_nkai, locationTraits))
        locations.add(Location("Broken Passage", R.drawable.location_broken_passage, locationTraits))
        locations.add(Location("Abandoned Site", R.drawable.location_abandoned_site, locationTraits))
        locations.add(Location("Bright Canyon", R.drawable.location_bright_canyon, locationTraits))
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