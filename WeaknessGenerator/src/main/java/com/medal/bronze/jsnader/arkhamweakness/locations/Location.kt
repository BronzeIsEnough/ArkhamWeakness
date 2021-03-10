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

import com.medal.bronze.jsnader.arkhamweakness.Card
import com.medal.bronze.jsnader.arkhamweakness.CardType
import kotlin.collections.ArrayList

/**
 * This is a class that is meant to represent physical locations in the game that are represented
 * as cards.  They have names, [LocationTrait]s and [ConnectionSymbol]s associated with them.  The
 * name is not always unique since there could be multiple copies of each.  This should be kept in
 * mind when using data associated with locations for filtering purposes.
 *
 * @author Jeremiah Snader
 */
class Location(pName: String,
               pDrawableResource: Int,
               pLocationTraits: ArrayList<LocationTrait>,
               pLocationValue: ConnectionSymbol,
               pLocationConnections: ArrayList<ConnectionSymbol>) : Card() {

    var mName: String
    var mLocationTraits: ArrayList<LocationTrait>
    val mLocSymbol: ConnectionSymbol
    var mConnections: ArrayList<ConnectionSymbol>

    init {
        mCardType = CardType.LOCATION
        mName = pName
        mDrawableResource = pDrawableResource
        mLocationTraits = pLocationTraits
        mLocSymbol = pLocationValue
        mConnections = pLocationConnections
    }

    /**
     * Returns a symbol that represents what location this card represents in the current
     * scenario.  Symbols determine what other connections are connected to it a location.
     */
    public fun getLocationSymbol() : ConnectionSymbol {
        return mLocSymbol;
    }

    /**
     * This defines the connectivity of the location to other [Location]s. If a location has
     * connectivity to another location, then their [ConnectionSymbol] will be in this list.
     */
    public fun getConnections() : ArrayList<ConnectionSymbol> {
        return mConnections
    }
}