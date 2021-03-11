package com.medal.bronze.jsnader.arkhamweakness.locations

import com.medal.bronze.jsnader.arkhamweakness.R

import junit.framework.TestCase.assertEquals

import org.junit.Before
import org.junit.Test

internal class LocationTest {

    val EXP_SYMBOL = ConnectionSymbol.SQUARE
    val EXP_CONNECTIONS = arrayListOf(ConnectionSymbol.CIRCLE, ConnectionSymbol.HOURGLASS)

    lateinit var loc : Location

    @Before
    fun setup() {
        loc = Location(
            "Blasted Heath",
            R.drawable.unseen_blasted_heath,
            arrayListOf(LocationTrait.DUNWICH),
            EXP_SYMBOL,
            EXP_CONNECTIONS
        )
    }

    @Test
    fun locationSymbolExistsAfterCreation() {
        assertEquals(EXP_SYMBOL, loc.mLocSymbol)
    }

    @Test
    fun locationConnectionsExistAfterCreation() {
        assertEquals(EXP_CONNECTIONS, loc.mLocConnections)
    }
}