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
        val locs = ArrayList<Location?>()
        val locationTraits = ArrayList(Arrays.asList(LocationTrait.DUNWICH))
        locs.add(
                Location("Blasted Heath", R.drawable.unseen_blasted_heath, locationTraits))
        locs.add(
                Location("Cold Spring Glen", R.drawable.unseen_cold_spring_glen, locationTraits))
        locs.add(
                Location("Devil's Hopyard", R.drawable.unseen_devils_hop_yard, locationTraits))
        locs.add(
                Location("Dunwich Village", R.drawable.unseen_dunwich_village, locationTraits))
        locs.add(
                Location("Ten Acre Meadow", R.drawable.unseen_ten_acre_meadow, locationTraits))
        locs.add(
                Location("Whateley Ruins", R.drawable.unseen_whateley_ruins, locationTraits))
        return locs
    }

    fun getForgottenAgeLocations(): ArrayList<Location?>? {
        val locs = ArrayList<Location?>()
        val locationTraits = ArrayList(Arrays.asList(LocationTrait.FORGOTTEN_AGE))
        locs.add(Location("Steps of Yoth", R.drawable.location_steps_of_yoth, locationTraits))
        locs.add(Location(
                "City of the Serpents", R.drawable.location_city_of_the_serpents, locationTraits))
        locs.add(Location("Hall of Heresy", R.drawable.location_hall_of_heresy, locationTraits))
        locs.add(Location(
                "Crumbling Precipice", R.drawable.location_crumbling_precipice, locationTraits))
        locs.add(Location("Caverns of Yoth", R.drawable.location_caverns_of_yoth, locationTraits))
        locs.add(Location("Forked Path", R.drawable.location_forked_path, locationTraits))
        locs.add(Location(
                "Bridge over N'kai", R.drawable.location_bridge_over_nkai, locationTraits))
        locs.add(Location("Broken Passage", R.drawable.location_broken_passage, locationTraits))
        locs.add(Location("Abandoned Site", R.drawable.location_abandoned_site, locationTraits))
        locs.add(Location("Bright Canyon", R.drawable.location_bright_canyon, locationTraits))
        return locs
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