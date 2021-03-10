package com.medal.bronze.jsnader.arkhamweakness.scenarios

import com.medal.bronze.jsnader.arkhamweakness.locations.ConnectionSymbol
import com.medal.bronze.jsnader.arkhamweakness.locations.Location
import com.medal.bronze.jsnader.arkhamweakness.locations.LocationTrait
import com.medal.bronze.jsnader.arkhamweakness.support.CardTrait

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull

import org.junit.Before
import org.junit.Test

internal class ScenarioTest {
    val TRAITS = arrayListOf(CardTrait.MADNESS, CardTrait.PACT)
    val LOCATIONS = arrayListOf(Location(
        "locName",
        0,
        arrayListOf(LocationTrait.DUNWICH),
        ConnectionSymbol.SQUARE,
        arrayListOf(ConnectionSymbol.HOURGLASS, ConnectionSymbol.DIAMOND)))

    val mScenario : Scenario = Scenario(
        ScenarioType.BLACK_STARS_RISE,
        "TestScenarioTitle",
        "TestCampaignTitle",
        0)

    @Before
    fun setup() {

    }

    @Test
    fun checkTraitsForValidity() {
        assertNull(mScenario.getTraits())
        mScenario.setTraits(TRAITS)
        assertNotNull(mScenario.getTraits())
        assertEquals(TRAITS.size, mScenario.getTraits()!!.size)
    }

    @Test
    fun checkLocationsForValidity() {
        assertNull(mScenario.getLocations())
        mScenario.setLocations(LOCATIONS)
        assertNotNull(mScenario.getLocations())
        assertEquals(LOCATIONS.size, mScenario.getLocations()!!.size)
    }
}