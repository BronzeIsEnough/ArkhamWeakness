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
 * Created by Jeremiah on 3/24/2018.
 */
class ScenarioBuilder {
    private var mCardTraits: ArrayList<CardTrait?>? = ArrayList()
    private var mLocations: ArrayList<Location?>? = ArrayList()

    fun buildScenarioList(): MutableList<Scenario?>? {
        val scenarios = ArrayList<Scenario?>()
        addGeneralAllInclusive(scenarios)
        addUndimensionedWeakness(scenarios)
        addUndimensionedLocations(scenarios)
        addBlackStarsRise(scenarios)
        return scenarios
    }

    fun getScenario(pScenarioType: ScenarioType?): Scenario? {
        val scenarios = ArrayList<Scenario?>()
        when (pScenarioType) {
            ScenarioType.GENERAL -> addGeneralAllInclusive(scenarios)
            ScenarioType.UNDIMENSIONED_AND_UNSEEN_WEAKNESS -> addUndimensionedWeakness(scenarios)
            ScenarioType.UNDIMENSIONED_AND_UNSEEN_LOCATION -> addUndimensionedLocations(scenarios)
            ScenarioType.BLACK_STARS_RISE -> addBlackStarsRise(scenarios)
        }
        return scenarios[0]
    }

    private fun addGeneralAllInclusive(pScenarios: ArrayList<Scenario?>?) {
        val allInclusive : Scenario = Scenario(ScenarioType.GENERAL, "General Weakness", "All Inclusive", R.drawable.general_weakness)
        clear()
        mCardTraits?.add(CardTrait.ALL)
        allInclusive.setTraits(ArrayList(mCardTraits))
        pScenarios?.add(allInclusive)
    }

    private fun addUndimensionedWeakness(pScenarios: ArrayList<Scenario?>?) {
        val undimensionedWkns = Scenario(ScenarioType.UNDIMENSIONED_AND_UNSEEN_WEAKNESS, "Undimensioned & Unseen - Weakness", "in the Dunwich Horror campaign", R.drawable.undimensioned_and_unseen)
        clear()
        mCardTraits?.add(CardTrait.MADNESS)
        mCardTraits?.add(CardTrait.INJURY)
        mCardTraits?.add(CardTrait.PACT)
        undimensionedWkns.setTraits(ArrayList(mCardTraits))
        pScenarios?.add(undimensionedWkns)
    }

    private fun addUndimensionedLocations(pScenarios: ArrayList<Scenario?>?) {
        val undimensionedLocs = Scenario(ScenarioType.UNDIMENSIONED_AND_UNSEEN_LOCATION, "Undimensioned & Unseen - Location", "in the Dunwich Horror campaign", R.drawable.undimensioned_and_unseen)
        clear()
        mLocations = LocationBuilder.Companion.getInstance()?.getUnseenLocations()
        undimensionedLocs.setLocations(mLocations)
        pScenarios?.add(undimensionedLocs)
    }

    private fun addBlackStarsRise(pScenarios: ArrayList<Scenario?>?) {
        val blackStarsRise = Scenario(ScenarioType.BLACK_STARS_RISE, "Black Stars Rise", "in the Path to Carcosa campaign", R.drawable.black_stars_rise)
        clear()
        mCardTraits?.add(CardTrait.MADNESS)
        mCardTraits?.add(CardTrait.PACT)
        mCardTraits?.add(CardTrait.CULTIST)
        mCardTraits?.add(CardTrait.DETECTIVE)
        blackStarsRise.setTraits(ArrayList(mCardTraits))
        pScenarios?.add(blackStarsRise)
    }

    private fun clear() {
        mCardTraits?.clear()
        mLocations?.clear()
    }
}