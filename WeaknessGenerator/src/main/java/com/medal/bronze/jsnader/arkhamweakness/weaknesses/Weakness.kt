package com.medal.bronze.jsnader.arkhamweakness.weaknesses

import com.medal.bronze.jsnader.arkhamweakness.Card
import com.medal.bronze.jsnader.arkhamweakness.CardType
import com.medal.bronze.jsnader.arkhamweakness.support.CampaignAffinity
import com.medal.bronze.jsnader.arkhamweakness.support.CardTrait
import java.util.*

/**
 * The main container class for representing a weakness on screen.  It will describe all the
 * elements that make up an Arkham Horror LCG weakness card.
 *
 * Created by Jeremiah on 3/24/2018.
 */
class Weakness(pName: String?,
               pSetAffinity: CampaignAffinity?,
               pNumAvailable: Int,
               pDrawableResource: Int) : Card() {

    private val mName: String?
    private val mSetAffinity: CampaignAffinity?
    private val mNumAvailForSet //1 or 2 typically
            : Int
    private var mCardTraits: ArrayList<CardTrait?>? = null
    fun setCardTraits(pCardTraits: ArrayList<CardTrait?>?) {
        mCardTraits = pCardTraits?.let { ArrayList(it) }
    }

    fun getCardTraits(): ArrayList<CardTrait?>? {
        return mCardTraits
    }

    fun getNumAvailable(): Int {
        return mNumAvailForSet
    }

    override fun getDrawableResource(): Int {
        return mDrawableResource
    }

    init {
        mCardType = CardType.WEAKNESS
        mName = pName
        mSetAffinity = pSetAffinity
        mNumAvailForSet = pNumAvailable
        mDrawableResource = pDrawableResource
    }
}