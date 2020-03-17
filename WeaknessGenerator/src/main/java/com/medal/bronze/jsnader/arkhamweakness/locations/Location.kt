package com.medal.bronze.jsnader.arkhamweakness.locations

import com.medal.bronze.jsnader.arkhamweakness.Card
import com.medal.bronze.jsnader.arkhamweakness.CardType
import java.util.*

class Location(pName: String?, pDrawableResource: Int, pLocationTraits: ArrayList<LocationTrait?>?) : Card() {
    var mName: String?
    var mLocationTraits: ArrayList<LocationTrait?>?

    init {
        mCardType = CardType.LOCATION
        mName = pName
        mDrawableResource = pDrawableResource
        mLocationTraits = pLocationTraits
    }
}