/**
 * Copyright 2018-2021 Jeremiah Snader
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.medal.bronze.jsnader.arkhamweakness.locations

import com.medal.bronze.jsnader.arkhamweakness.R
import java.util.*
import kotlin.collections.ArrayList

/**
 * A class that is meant to build a list of locations that would define what should be included
 * within the ScenarioAdapter class.
 *
 * @author Jeremiah Snader
 */
class LocationBuilder private constructor() {

    fun getUnseenLocations(): ArrayList<Location?>? {
        val locs = ArrayList<Location?>()
        val locationTraits = ArrayList(Arrays.asList(LocationTrait.DUNWICH))
        locs.add(
                Location("Blasted Heath",
                        R.drawable.unseen_blasted_heath,
                        locationTraits,
                        ConnectionType.SQUARE,
                        ArrayList(Arrays.asList(
                                ConnectionType.CIRCLE,
                                ConnectionType.HOURGLASS))))
        locs.add(
                Location(
                        "Cold Spring Glen",
                        R.drawable.unseen_cold_spring_glen,
                        locationTraits,
                        ConnectionType.TRIANGLE,
                        ArrayList(Arrays.asList(
                                ConnectionType.CIRCLE,
                                ConnectionType.DIAMOND,
                                ConnectionType.PLUS_SIGN))))
        locs.add(
                Location("Devil's Hopyard",
                        R.drawable.unseen_devils_hop_yard,
                        locationTraits,
                        ConnectionType.HOURGLASS,
                        ArrayList(Arrays.asList(
                                ConnectionType.SQUARE,
                                ConnectionType.PLUS_SIGN))))
        locs.add(
                Location("Dunwich Village",
                        R.drawable.unseen_dunwich_village,
                        locationTraits,
                        ConnectionType.CIRCLE,
                        ArrayList(Arrays.asList(
                                ConnectionType.TRIANGLE,
                                ConnectionType.SQUARE,
                                ConnectionType.DIAMOND))))
        locs.add(
                Location("Ten Acre Meadow",
                        R.drawable.unseen_ten_acre_meadow,
                        locationTraits,
                        ConnectionType.TRIANGLE,
                        ArrayList(Arrays.asList(
                                ConnectionType.CIRCLE,
                                ConnectionType.TRIANGLE,
                                ConnectionType.PLUS_SIGN))))
        locs.add(
                Location("Whateley Ruins",
                        R.drawable.unseen_whateley_ruins,
                        locationTraits,
                        ConnectionType.PLUS_SIGN,
                        ArrayList(Arrays.asList(
                                ConnectionType.TRIANGLE,
                                ConnectionType.DIAMOND,
                                ConnectionType.HOURGLASS))))
        return locs
    }

    fun getForgottenAgeLocations(): ArrayList<Location?>? {
        val locs = ArrayList<Location?>()
        val locationTraits = ArrayList(Arrays.asList(LocationTrait.FORGOTTEN_AGE))
        locs.add(Location(
                "Steps of Yoth",
                R.drawable.location_steps_of_yoth,
                locationTraits,
                ConnectionType.EQUAL_SIGN,
                ArrayList(Arrays.asList(
                        ConnectionType.HOURGLASS,
                        ConnectionType.SQUARE,
                        ConnectionType.TRIANGLE,
                        ConnectionType.DIAMOND,
                        ConnectionType.HEART))))
        locs.add(Location(
                "City of the Serpents",
                R.drawable.location_city_of_the_serpents,
                locationTraits,
                ConnectionType.DIAMOND,
                ArrayList(Arrays.asList(
                        ConnectionType.EQUAL_SIGN,
                        ConnectionType.FLAME,
                        ConnectionType.TRIANGLE,
                        ConnectionType.TETRIS_T,
                        ConnectionType.SQUARE))))
        locs.add(Location("Hall of Heresy",
                R.drawable.location_hall_of_heresy,
                locationTraits,
                ConnectionType.TRIANGLE,
                ArrayList(Arrays.asList(
                        ConnectionType.EQUAL_SIGN,
                        ConnectionType.DIAMOND,
                        ConnectionType.CIRCLE,
                        ConnectionType.SQUARE,
                        ConnectionType.TETRIS_T))))
        locs.add(Location(
                "Crumbling Precipice",
                R.drawable.location_crumbling_precipice,
                locationTraits,
                ConnectionType.HOURGLASS,
                ArrayList(Arrays.asList(
                        ConnectionType.EQUAL_SIGN,
                        ConnectionType.TILDA,
                        ConnectionType.HEART,
                        ConnectionType.TETRIS_T,
                        ConnectionType.FLAME))))
        locs.add(Location("Caverns of Yoth",
                R.drawable.location_caverns_of_yoth,
                locationTraits,
                ConnectionType.FLAME,
                ArrayList(Arrays.asList(
                        ConnectionType.CIRCLE,
                        ConnectionType.HOURGLASS,
                        ConnectionType.HEART,
                        ConnectionType.DIAMOND,
                        ConnectionType.TILDA))))
        locs.add(Location("Forked Path",
                R.drawable.location_forked_path,
                locationTraits,
                ConnectionType.TETRIS_T,
                ArrayList(Arrays.asList(
                        ConnectionType.CIRCLE,
                        ConnectionType.DIAMOND,
                        ConnectionType.HOURGLASS,
                        ConnectionType.SQUARE,
                        ConnectionType.TRIANGLE))))
        locs.add(Location(
                "Bridge over N'kai",
                R.drawable.location_bridge_over_nkai,
                locationTraits,
                ConnectionType.HEART,
                ArrayList(Arrays.asList(
                        ConnectionType.EQUAL_SIGN,
                        ConnectionType.CIRCLE,
                        ConnectionType.FLAME,
                        ConnectionType.HOURGLASS,
                        ConnectionType.TILDA))))
        locs.add(Location("Broken Passage",
                R.drawable.location_broken_passage,
                locationTraits,
                ConnectionType.TILDA,
                ArrayList(Arrays.asList(
                        ConnectionType.CIRCLE,
                        ConnectionType.FLAME,
                        ConnectionType.HOURGLASS,
                        ConnectionType.SQUARE,
                        ConnectionType.HEART))))
        locs.add(Location("Abandoned Site",
                R.drawable.location_abandoned_site,
                locationTraits,
                ConnectionType.SQUARE,
                ArrayList(Arrays.asList(
                        ConnectionType.EQUAL_SIGN,
                        ConnectionType.DIAMOND,
                        ConnectionType.TRIANGLE,
                        ConnectionType.TETRIS_T,
                        ConnectionType.TILDA))))
        locs.add(Location("Bright Canyon",
                R.drawable.location_bright_canyon,
                locationTraits,
                ConnectionType.CIRCLE,
                ArrayList(Arrays.asList(
                        ConnectionType.FLAME,
                        ConnectionType.TILDA,
                        ConnectionType.TETRIS_T,
                        ConnectionType.HEART,
                        ConnectionType.TRIANGLE))))
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