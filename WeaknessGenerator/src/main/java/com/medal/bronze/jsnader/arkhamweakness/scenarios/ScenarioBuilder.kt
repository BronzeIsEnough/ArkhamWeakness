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
package com.medal.bronze.jsnader.arkhamweakness.scenarios

import com.medal.bronze.jsnader.arkhamweakness.R
import com.medal.bronze.jsnader.arkhamweakness.locations.Location
import com.medal.bronze.jsnader.arkhamweakness.locations.LocationBuilder
import com.medal.bronze.jsnader.arkhamweakness.support.CardTrait
import java.util.*

/**
 * A class that is meant to build a list of scenarios that would define what should be included
 * within the ScenarioAdapter class.
 *
 * Created by Jeremiah on 2/24/2021.
 */
class ScenarioBuilder {
    private var mCardTraits: ArrayList<CardTrait> = ArrayList()
    private var mLocations: ArrayList<Location> = ArrayList()

    fun buildScenarioList(): MutableList<Scenario> {
        val scenarios = ArrayList<Scenario>()
        addGeneralAllInclusive(scenarios)
        addUndimensionedWeakness(scenarios)
        addUndimensionedLocations(scenarios)
        addBlackStarsRise(scenarios)
        addPallidMask(scenarios)
        addDepthsOfYothWeakness(scenarios)
        addDepthsOfYothLocations(scenarios)
        return scenarios
    }

    fun getScenario(pScenarioType: ScenarioType): Scenario {
        val scenarios = ArrayList<Scenario>()
        when (pScenarioType) {
            ScenarioType.GENERAL -> addGeneralAllInclusive(scenarios)
            ScenarioType.UNDIMENSIONED_AND_UNSEEN_WEAKNESS -> addUndimensionedWeakness(scenarios)
            ScenarioType.UNDIMENSIONED_AND_UNSEEN_LOCATION -> addUndimensionedLocations(scenarios)
            ScenarioType.BLACK_STARS_RISE -> addBlackStarsRise(scenarios)
            ScenarioType.THE_PALLID_MASK -> addPallidMask(scenarios)
            ScenarioType.DEPTHS_OF_YOTH_WEAKNESS -> addDepthsOfYothWeakness(scenarios)
            ScenarioType.DEPTHS_OF_YOTH_LOCATION -> addDepthsOfYothLocations(scenarios)
        }
        return scenarios[0]
    }

    private fun addGeneralAllInclusive(pScenarios: ArrayList<Scenario>) {
        val allInclusive =
                Scenario(ScenarioType.GENERAL,
                        "General Weakness",
                        "All Inclusive",
                        R.drawable.general_weakness)
        clear()
        mCardTraits.add(CardTrait.ALL)
        allInclusive.mTraits = mCardTraits.let { ArrayList(it) }
        pScenarios.add(allInclusive)
    }

    private fun addUndimensionedWeakness(pScenarios: ArrayList<Scenario>) {
        val undimensionedWkns =
                Scenario(ScenarioType.UNDIMENSIONED_AND_UNSEEN_WEAKNESS,
                        "Undimensioned & Unseen - Weakness",
                        "in the Dunwich Horror campaign",
                        R.drawable.undimensioned_and_unseen)
        clear()
        mCardTraits.add(CardTrait.MADNESS)
        mCardTraits.add(CardTrait.INJURY)
        mCardTraits.add(CardTrait.PACT)
        undimensionedWkns.mTraits = mCardTraits.let { ArrayList(it) }
        pScenarios.add(undimensionedWkns)
    }

    private fun addUndimensionedLocations(pScenarios: ArrayList<Scenario>) {
        val undimensionedLocs =
                Scenario(ScenarioType.UNDIMENSIONED_AND_UNSEEN_LOCATION,
                        "Undimensioned & Unseen - Location Movement",
                        "in the Dunwich Horror campaign",
                        R.drawable.undimensioned_and_unseen)
        clear()
        mLocations = LocationBuilder.getUnseenLocations()
        undimensionedLocs.mLocations = mLocations
        pScenarios.add(undimensionedLocs)
    }

    private fun addBlackStarsRise(pScenarios: ArrayList<Scenario>) {
        val blackStarsRise =
                Scenario(ScenarioType.BLACK_STARS_RISE,
                        "Black Stars Rise",
                        "in the Path to Carcosa campaign",
                        R.drawable.black_stars_rise)
        clear()
        mCardTraits.add(CardTrait.MADNESS)
        mCardTraits.add(CardTrait.PACT)
        mCardTraits.add(CardTrait.CULTIST)
        mCardTraits.add(CardTrait.DETECTIVE)
        blackStarsRise.mTraits = mCardTraits.let { ArrayList(it) }
        pScenarios.add(blackStarsRise)
    }

    private fun addPallidMask(pScenarios: ArrayList<Scenario>) {
        val pallidMask =
                Scenario(ScenarioType.THE_PALLID_MASK,
                "The Pallid Mask",
                "in the Path to Carcosa campaign",
                R.drawable.black_stars_rise)
        clear()
        mCardTraits.add(CardTrait.MADNESS)
        mCardTraits.add(CardTrait.PACT)
        pallidMask.mTraits = mCardTraits.let {ArrayList(it)}
        pScenarios.add(pallidMask)
    }

    private fun addDepthsOfYothWeakness(pScenarios: ArrayList<Scenario>) {
        val depthsOfYoth =
                Scenario(ScenarioType.DEPTHS_OF_YOTH_WEAKNESS,
                        "Depths of Yoth - Failure Weakness",
                        "in the Forgotten Age campaign",
                        R.drawable.forgotten_age)
        clear()
        mCardTraits.add(CardTrait.INJURY)
        depthsOfYoth.mTraits = mCardTraits.let { ArrayList(it) }
        pScenarios.add(depthsOfYoth)
    }

    private fun addDepthsOfYothLocations(pScenarios: ArrayList<Scenario>) {
        val depthsLoc =
                Scenario(ScenarioType.DEPTHS_OF_YOTH_LOCATION,
                        "Depths of Yoth - Location Placement",
                        "in the Forgotten Age campaign",
                        R.drawable.forgotten_age)
        clear()
        mLocations = LocationBuilder.getForgottenAgeLocations()
        depthsLoc.mLocations = mLocations
        pScenarios.add(depthsLoc)
    }

    private fun clear() {
        mCardTraits.clear()
        mLocations.clear()
    }
}