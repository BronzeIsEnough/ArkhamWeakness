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
class Location(mName : String,
               mDrawableResource : Int,
               val mLocationTraits : ArrayList<LocationTrait> = ArrayList(),
               val mLocSymbol : ConnectionSymbol,
               val mLocConnections : ArrayList<ConnectionSymbol> = ArrayList())
    : Card(mName, CardType.LOCATION, mDrawableResource) {

}