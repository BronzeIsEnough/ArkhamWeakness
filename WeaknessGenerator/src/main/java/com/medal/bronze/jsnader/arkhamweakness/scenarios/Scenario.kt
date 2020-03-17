package com.medal.bronze.jsnader.arkhamweakness.scenarios

import com.medal.bronze.jsnader.arkhamweakness.locations.Location
import com.medal.bronze.jsnader.arkhamweakness.support.CardTrait
import java.util.*

/**
 * Represents a specific scenario within the Arkham Horror LCG universe that a weakness could be
 * selected from.
 *
 * Created by Jeremiah on 3/24/2018.
 */
class Scenario(private val mScenarioType: ScenarioType?, private val mScenarioTitle: String?, private val mCampaignTitle: String?, private val mImageResource: Int) {
    private var mTraits: ArrayList<CardTrait?>? = null
    private var mLocations: ArrayList<Location?>? = null

    fun getScenarioTitle(): String? {
        return mScenarioTitle
    }

    fun getCampaignTitle(): String? {
        return mCampaignTitle
    }

    fun getImageResource(): Int {
        return mImageResource
    }

    fun getScenarioType(): ScenarioType? {
        return mScenarioType
    }

    fun setTraits(pTraits: ArrayList<CardTrait?>?) {
        mTraits = pTraits
    }

    fun getTraits(): ArrayList<CardTrait?>? {
        return mTraits
    }

    fun setLocations(pLocations: ArrayList<Location?>?) {
        mLocations = pLocations
    }

    fun getLocations(): ArrayList<Location?>? {
        return mLocations
    }

}