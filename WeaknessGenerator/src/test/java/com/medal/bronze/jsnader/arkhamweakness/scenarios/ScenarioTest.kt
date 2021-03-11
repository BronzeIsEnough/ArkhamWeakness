package com.medal.bronze.jsnader.arkhamweakness.scenarios

import com.medal.bronze.jsnader.arkhamweakness.locations.ConnectionSymbol
import com.medal.bronze.jsnader.arkhamweakness.locations.Location
import com.medal.bronze.jsnader.arkhamweakness.locations.LocationTrait
import com.medal.bronze.jsnader.arkhamweakness.support.CardTrait

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue

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
        assertTrue(mScenario.mTraits.isEmpty())
        mScenario.mTraits = TRAITS
        assertNotNull(mScenario.mTraits)
        assertEquals(TRAITS.size, mScenario.mTraits.size)
    }

    @Test
    fun checkLocationsForValidity() {
        assertTrue(mScenario.mLocations.isEmpty())
        mScenario.mLocations = LOCATIONS
        assertNotNull(mScenario.mLocations)
        assertEquals(LOCATIONS.size, mScenario.mLocations.size)
    }
}