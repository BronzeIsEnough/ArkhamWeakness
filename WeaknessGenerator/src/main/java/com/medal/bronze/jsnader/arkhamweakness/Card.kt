package com.medal.bronze.jsnader.arkhamweakness

open class Card {
    var mCardType: CardType? = null
    var mDrawableResource = 0
    open fun getDrawableResource(): Int {
        return mDrawableResource
    }
}