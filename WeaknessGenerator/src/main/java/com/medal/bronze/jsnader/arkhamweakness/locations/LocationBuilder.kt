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
object LocationBuilder {
    fun getUnseenLocations(): ArrayList<Location> {
        val locs = ArrayList<Location>()
        val locationTraits = ArrayList(Arrays.asList(LocationTrait.DUNWICH))
        locs.add(
                Location("Blasted Heath",
                        R.drawable.unseen_blasted_heath,
                        locationTraits,
                        ConnectionSymbol.SQUARE,
                        ArrayList(Arrays.asList(
                                ConnectionSymbol.CIRCLE,
                                ConnectionSymbol.HOURGLASS))))
        locs.add(
                Location(
                        "Cold Spring Glen",
                        R.drawable.unseen_cold_spring_glen,
                        locationTraits,
                        ConnectionSymbol.TRIANGLE,
                        ArrayList(Arrays.asList(
                                ConnectionSymbol.CIRCLE,
                                ConnectionSymbol.DIAMOND,
                                ConnectionSymbol.PLUS_SIGN))))
        locs.add(
                Location("Devil's Hopyard",
                        R.drawable.unseen_devils_hop_yard,
                        locationTraits,
                        ConnectionSymbol.HOURGLASS,
                        ArrayList(Arrays.asList(
                                ConnectionSymbol.SQUARE,
                                ConnectionSymbol.PLUS_SIGN))))
        locs.add(
                Location("Dunwich Village",
                        R.drawable.unseen_dunwich_village,
                        locationTraits,
                        ConnectionSymbol.CIRCLE,
                        ArrayList(Arrays.asList(
                                ConnectionSymbol.TRIANGLE,
                                ConnectionSymbol.SQUARE,
                                ConnectionSymbol.DIAMOND))))
        locs.add(
                Location("Ten Acre Meadow",
                        R.drawable.unseen_ten_acre_meadow,
                        locationTraits,
                        ConnectionSymbol.TRIANGLE,
                        ArrayList(Arrays.asList(
                                ConnectionSymbol.CIRCLE,
                                ConnectionSymbol.TRIANGLE,
                                ConnectionSymbol.PLUS_SIGN))))
        locs.add(
                Location("Whateley Ruins",
                        R.drawable.unseen_whateley_ruins,
                        locationTraits,
                        ConnectionSymbol.PLUS_SIGN,
                        ArrayList(Arrays.asList(
                                ConnectionSymbol.TRIANGLE,
                                ConnectionSymbol.DIAMOND,
                                ConnectionSymbol.HOURGLASS))))
        return locs
    }

    fun getForgottenAgeLocations(): ArrayList<Location> {
        val locs = ArrayList<Location>()
        val locationTraits = ArrayList(Arrays.asList(LocationTrait.FORGOTTEN_AGE))
        locs.add(Location(
                "Steps of Yoth",
                R.drawable.location_steps_of_yoth,
                locationTraits,
                ConnectionSymbol.EQUAL_SIGN,
                ArrayList(Arrays.asList(
                        ConnectionSymbol.HOURGLASS,
                        ConnectionSymbol.SQUARE,
                        ConnectionSymbol.TRIANGLE,
                        ConnectionSymbol.DIAMOND,
                        ConnectionSymbol.HEART))))
        locs.add(Location(
                "City of the Serpents",
                R.drawable.location_city_of_the_serpents,
                locationTraits,
                ConnectionSymbol.DIAMOND,
                ArrayList(Arrays.asList(
                        ConnectionSymbol.EQUAL_SIGN,
                        ConnectionSymbol.FLAME,
                        ConnectionSymbol.TRIANGLE,
                        ConnectionSymbol.TETRIS_T,
                        ConnectionSymbol.SQUARE))))
        locs.add(Location("Hall of Heresy",
                R.drawable.location_hall_of_heresy,
                locationTraits,
                ConnectionSymbol.TRIANGLE,
                ArrayList(Arrays.asList(
                        ConnectionSymbol.EQUAL_SIGN,
                        ConnectionSymbol.DIAMOND,
                        ConnectionSymbol.CIRCLE,
                        ConnectionSymbol.SQUARE,
                        ConnectionSymbol.TETRIS_T))))
        locs.add(Location(
                "Crumbling Precipice",
                R.drawable.location_crumbling_precipice,
                locationTraits,
                ConnectionSymbol.HOURGLASS,
                ArrayList(Arrays.asList(
                        ConnectionSymbol.EQUAL_SIGN,
                        ConnectionSymbol.TILDA,
                        ConnectionSymbol.HEART,
                        ConnectionSymbol.TETRIS_T,
                        ConnectionSymbol.FLAME))))
        locs.add(Location("Caverns of Yoth",
                R.drawable.location_caverns_of_yoth,
                locationTraits,
                ConnectionSymbol.FLAME,
                ArrayList(Arrays.asList(
                        ConnectionSymbol.CIRCLE,
                        ConnectionSymbol.HOURGLASS,
                        ConnectionSymbol.HEART,
                        ConnectionSymbol.DIAMOND,
                        ConnectionSymbol.TILDA))))
        locs.add(Location("Forked Path",
                R.drawable.location_forked_path,
                locationTraits,
                ConnectionSymbol.TETRIS_T,
                ArrayList(Arrays.asList(
                        ConnectionSymbol.CIRCLE,
                        ConnectionSymbol.DIAMOND,
                        ConnectionSymbol.HOURGLASS,
                        ConnectionSymbol.SQUARE,
                        ConnectionSymbol.TRIANGLE))))
        locs.add(Location(
                "Bridge over N'kai",
                R.drawable.location_bridge_over_nkai,
                locationTraits,
                ConnectionSymbol.HEART,
                ArrayList(Arrays.asList(
                        ConnectionSymbol.EQUAL_SIGN,
                        ConnectionSymbol.CIRCLE,
                        ConnectionSymbol.FLAME,
                        ConnectionSymbol.HOURGLASS,
                        ConnectionSymbol.TILDA))))
        locs.add(Location("Broken Passage",
                R.drawable.location_broken_passage,
                locationTraits,
                ConnectionSymbol.TILDA,
                ArrayList(Arrays.asList(
                        ConnectionSymbol.CIRCLE,
                        ConnectionSymbol.FLAME,
                        ConnectionSymbol.HOURGLASS,
                        ConnectionSymbol.SQUARE,
                        ConnectionSymbol.HEART))))
        locs.add(Location("Abandoned Site",
                R.drawable.location_abandoned_site,
                locationTraits,
                ConnectionSymbol.SQUARE,
                ArrayList(Arrays.asList(
                        ConnectionSymbol.EQUAL_SIGN,
                        ConnectionSymbol.DIAMOND,
                        ConnectionSymbol.TRIANGLE,
                        ConnectionSymbol.TETRIS_T,
                        ConnectionSymbol.TILDA))))
        locs.add(Location("Bright Canyon",
                R.drawable.location_bright_canyon,
                locationTraits,
                ConnectionSymbol.CIRCLE,
                ArrayList(Arrays.asList(
                        ConnectionSymbol.FLAME,
                        ConnectionSymbol.TILDA,
                        ConnectionSymbol.TETRIS_T,
                        ConnectionSymbol.HEART,
                        ConnectionSymbol.TRIANGLE))))
        return locs
    }
}