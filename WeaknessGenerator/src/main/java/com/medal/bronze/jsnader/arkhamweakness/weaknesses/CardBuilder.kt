package com.medal.bronze.jsnader.arkhamweakness.weaknesses

import com.medal.bronze.jsnader.arkhamweakness.Card
import com.medal.bronze.jsnader.arkhamweakness.R
import com.medal.bronze.jsnader.arkhamweakness.scenarios.ScenarioBuilder
import com.medal.bronze.jsnader.arkhamweakness.scenarios.ScenarioType
import com.medal.bronze.jsnader.arkhamweakness.support.CampaignAffinity
import com.medal.bronze.jsnader.arkhamweakness.support.CardTrait
import java.util.*

/**
 * A class that is meant to build a list of weaknesses that would define what should be included
 * within the ScenarioAdapter class.
 *
 * Created by Jeremiah on 3/24/2018.
 */
class CardBuilder(private val mScenarioType: ScenarioType?) {
    private val mFullWeaknessList: ArrayList<Weakness?>? = ArrayList()
    private val mCardList: ArrayList<Card?>? = ArrayList()
    fun getCardList(): ArrayList<Card?>? {
        return mCardList
    }

    private fun buildGeneralWeaknessList() {
        for (weakness in this!!.mFullWeaknessList!!) {
            for (index in 0 until weakness?.getNumAvailable()!!) {
                mCardList?.add(weakness)
            }
        }
    }

    private fun buildUndimensionedWeaknessList() {
        val traits = ScenarioBuilder().getScenario(ScenarioType.UNDIMENSIONED_AND_UNSEEN_WEAKNESS)?.getTraits()
        updateListWithTraits(traits)
    }

    private fun buildUndimensionedLocationList() {
        val locationList = ScenarioBuilder().getScenario(ScenarioType.UNDIMENSIONED_AND_UNSEEN_LOCATION)?.getLocations()
        for (location in locationList!!) {
            mCardList?.add(location)
        }
    }

    private fun buildBlackStarsRiseWeaknessList() {
        val traits = ScenarioBuilder().getScenario(ScenarioType.BLACK_STARS_RISE)?.getTraits()
        updateListWithTraits(traits)
    }

    private fun updateListWithTraits(pScenarioTraits: ArrayList<CardTrait?>?) {
        for (weakness in this!!.mFullWeaknessList!!) {
            for (trait in pScenarioTraits!!) { //Step through each possible trait that the weakness could have.
                if (weakness?.getCardTraits()?.contains(trait)!!) {
                    for (index in 0 until weakness.getNumAvailable()) { //If there are more than one card, add it multiple times.
                        mCardList?.add(weakness)
                    }
                    break //If one trait is found in the search, then proceed to the next weakness;
                }
            }
        }
    }

    private fun setupFullWeaknessList() { //Keep alphabetical for easy reference later.
        val cardTraits = ArrayList<CardTrait?>()
        val amnWeakness = Weakness("Amnesia", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 2, R.drawable.weakness_amnesia)
        assignCardTraits(amnWeakness, ArrayList(Arrays.asList(CardTrait.MADNESS)))
        val chrWeakness = Weakness("Chronophobia", CampaignAffinity.DUNWICH_LEGACY, 2, R.drawable.weakness_chronophobia)
        assignCardTraits(chrWeakness, ArrayList(Arrays.asList(CardTrait.MADNESS)))
        val drkPctWeakness = Weakness("Dark Pact", CampaignAffinity.THE_FORGOTTEN_AGE, 1, R.drawable.weakness_dark_pact)
        assignCardTraits(drkPctWeakness, ArrayList(Arrays.asList(CardTrait.PACT)))
        val dmdPctWeakness = Weakness("Doomed", CampaignAffinity.THE_FORGOTTEN_AGE, 1, R.drawable.weakness_doomed)
        assignCardTraits(dmdPctWeakness, ArrayList(Arrays.asList(CardTrait.CURSE)))
        val drwSignWeakeness = Weakness("Drawing the Sign", CampaignAffinity.PATH_TO_CARCOSA, 1, R.drawable.weakness_drawing_the_sign)
        assignCardTraits(drwSignWeakeness, ArrayList(Arrays.asList(CardTrait.MADNESS, CardTrait.PACT)))
        val hauWeakness = Weakness("Haunted", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_haunted)
        assignCardTraits(hauWeakness, ArrayList(Arrays.asList(CardTrait.CURSE)))
        val hypWeakness = Weakness("Hypochondria", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_hypochondria)
        assignCardTraits(hypWeakness, ArrayList(Arrays.asList(CardTrait.MADNESS)))
        val indWeakness = Weakness("Indebted", CampaignAffinity.DUNWICH_LEGACY, 2, R.drawable.weakness_indebted)
        assignCardTraits(indWeakness, ArrayList(Arrays.asList(CardTrait.FLAW)))
        val intWeakness = Weakness("Internal Injury", CampaignAffinity.DUNWICH_LEGACY, 2, R.drawable.weakness_internal_injury)
        assignCardTraits(intWeakness, ArrayList(Arrays.asList(CardTrait.INJURY)))
        val klptoWeakness = Weakness("Kleptomania", CampaignAffinity.DREAM_EATERS, 1, R.drawable.weakness_kleptomania)
        assignCardTraits(klptoWeakness, ArrayList(Arrays.asList(CardTrait.MADNESS, CardTrait.TALENT)))
        val mobWeakness = Weakness("Mob Enforcer", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_mob_enforcer)
        assignCardTraits(mobWeakness, ArrayList(Arrays.asList(CardTrait.HUMANOID, CardTrait.CRIMINAL)))
        val nrcWeakness = Weakness("Narcolepsy", CampaignAffinity.DREAM_EATERS, 1, R.drawable.weakness_narcolepsy)
        assignCardTraits(nrcWeakness, ArrayList(Arrays.asList(CardTrait.MADNESS)))
        val ovrWeakness = Weakness("Overzealous", CampaignAffinity.PATH_TO_CARCOSA, 2, R.drawable.weakness_overzealous)
        assignCardTraits(ovrWeakness, ArrayList(Arrays.asList(CardTrait.FLAW)))
        val parWeakness = Weakness("Paranoia", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 2, R.drawable.weakness_paranoia)
        assignCardTraits(parWeakness, ArrayList(Arrays.asList(CardTrait.MADNESS)))
        val psyWeakness = Weakness("Psychosis", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_psychosis)
        assignCardTraits(psyWeakness, ArrayList(Arrays.asList(CardTrait.MADNESS)))
        val slfCntWeakness = Weakness("Self-Centered", CampaignAffinity.DREAM_EATERS, 1, R.drawable.weakness_self_centered)
        assignCardTraits(slfCntWeakness, ArrayList(Arrays.asList(CardTrait.FLAW)))
        val silWeakness = Weakness("Silver Twilight Acolyte", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_silver_twilight_acolyte)
        assignCardTraits(silWeakness, ArrayList(Arrays.asList(CardTrait.HUMANOID, CardTrait.CULTIST, CardTrait.SILVER_TWILIGHT)))
        val stbWeakness = Weakness("Stubborn Detective", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_stubbor_detective)
        assignCardTraits(stbWeakness, ArrayList(Arrays.asList(CardTrait.HUMANOID, CardTrait.DETECTIVE)))
        val thrtnVisWeakness = Weakness("The 13th Vision", CampaignAffinity.CIRCLE_UNDONE, 2, R.drawable.weakness_thirteenth_vision)
        assignCardTraits(thrtnVisWeakness, ArrayList(Arrays.asList(CardTrait.OMEN)))
        val thgWeakness = Weakness("The Thing That Follows", CampaignAffinity.PATH_TO_CARCOSA, 1, R.drawable.weakness_the_thing_that_follows)
        assignCardTraits(thgWeakness, ArrayList(Arrays.asList(CardTrait.MONSTER, CardTrait.CURSE)))
        val twrXviWeakenss = Weakness("The Tower - XVI: Circumstances Beyond Your Control", CampaignAffinity.CIRCLE_UNDONE, 2, R.drawable.weakness_the_tower)
        assignCardTraits(twrXviWeakenss, ArrayList(Arrays.asList(CardTrait.OMEN, CardTrait.TAROT)))
        val thrDaGtsWeakness = Weakness("Through the Gates", CampaignAffinity.CIRCLE_UNDONE, 2, R.drawable.weakness_through_the_gates)
        assignCardTraits(thrDaGtsWeakness, ArrayList(Arrays.asList(CardTrait.PACT, CardTrait.MYSTERY)))
        val unspBldWeakness = Weakness("Unspeakable Oath (Bloodthirst)", CampaignAffinity.RETURN_TO_PATH_TO_CARCOSA, 1, R.drawable.weakness_unspeakable_oath_bloodthirst)
        assignCardTraits(unspBldWeakness, ArrayList(Arrays.asList(CardTrait.MADNESS, CardTrait.PACT)))
        val unspCwrdWeakness = Weakness("Unspeakable Oath (Cowardice)", CampaignAffinity.RETURN_TO_PATH_TO_CARCOSA, 1, R.drawable.weakness_unspeakable_oath_cowardice)
        assignCardTraits(unspCwrdWeakness, ArrayList(Arrays.asList(CardTrait.MADNESS, CardTrait.PACT)))
        val unspCurWeakness = Weakness("Unspeakable Oath (Curiosity)", CampaignAffinity.RETURN_TO_PATH_TO_CARCOSA, 1, R.drawable.weakness_unspeakable_oath_curiosity)
        assignCardTraits(unspCurWeakness, ArrayList(Arrays.asList(CardTrait.MADNESS, CardTrait.PACT)))
        val ywnWeakness = Weakness("Your Worst Nightmare", CampaignAffinity.DREAM_EATERS, 1, R.drawable.weakness_your_worst_nightmare)
        assignCardTraits(ywnWeakness, ArrayList(Arrays.asList(CardTrait.MONSTER)))
        mFullWeaknessList?.add(amnWeakness)
        mFullWeaknessList?.add(chrWeakness)
        mFullWeaknessList?.add(drwSignWeakeness)
        mFullWeaknessList?.add(drkPctWeakness)
        mFullWeaknessList?.add(dmdPctWeakness)
        mFullWeaknessList?.add(hauWeakness)
        mFullWeaknessList?.add(hypWeakness)
        mFullWeaknessList?.add(indWeakness)
        mFullWeaknessList?.add(intWeakness)
        mFullWeaknessList?.add(klptoWeakness)
        mFullWeaknessList?.add(mobWeakness)
        mFullWeaknessList?.add(nrcWeakness)
        mFullWeaknessList?.add(ovrWeakness)
        mFullWeaknessList?.add(parWeakness)
        mFullWeaknessList?.add(psyWeakness)
        mFullWeaknessList?.add(slfCntWeakness)
        mFullWeaknessList?.add(silWeakness)
        mFullWeaknessList?.add(stbWeakness)
        mFullWeaknessList?.add(thrtnVisWeakness)
        mFullWeaknessList?.add(thgWeakness)
        mFullWeaknessList?.add(twrXviWeakenss)
        mFullWeaknessList?.add(thrDaGtsWeakness)
        mFullWeaknessList?.add(unspBldWeakness)
        mFullWeaknessList?.add(unspCurWeakness)
        mFullWeaknessList?.add(unspCwrdWeakness)
        mFullWeaknessList?.add(ywnWeakness)
    }

    @Synchronized
    private fun assignCardTraits(pWeakness: Weakness?, pCardTraits: ArrayList<CardTrait?>?) {
        for (trait in pCardTraits?.let { ArrayList(it) }!!) {
            pCardTraits?.add(trait)
        }
        pWeakness?.setCardTraits(pCardTraits)
        pCardTraits?.clear()
    }

    init {
        setupFullWeaknessList()
        when (mScenarioType) {
            ScenarioType.GENERAL -> buildGeneralWeaknessList()
            ScenarioType.UNDIMENSIONED_AND_UNSEEN_WEAKNESS -> buildUndimensionedWeaknessList()
            ScenarioType.UNDIMENSIONED_AND_UNSEEN_LOCATION -> buildUndimensionedLocationList()
            ScenarioType.BLACK_STARS_RISE -> buildBlackStarsRiseWeaknessList()
        }
    }
}