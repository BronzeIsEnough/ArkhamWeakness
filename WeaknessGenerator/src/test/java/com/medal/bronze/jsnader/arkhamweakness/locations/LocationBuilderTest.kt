package com.medal.bronze.jsnader.arkhamweakness.locations

import junit.framework.TestCase.assertEquals
import org.junit.Test

internal class LocationBuilderTest {
    val NUM_UNFORSEEN = 6
    val NUM_FORGOTTEN = 10

    @Test
    fun unforseenHasCorrectNumberOfLocations() {
        assertEquals(NUM_UNFORSEEN, LocationBuilder.getUnseenLocations().size)
    }

    @Test
    fun forgottenHasCorrectNumberOfLocations() {
        assertEquals(NUM_FORGOTTEN, LocationBuilder.getForgottenAgeLocations().size)
    }
}