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
 * Created by Jeremiah on 2/23/2021.
 */
class CardBuilder(private val mScenarioType: ScenarioType?) {
    private val mFullWeaknessList: ArrayList<Weakness?>? = ArrayList()
    private val mCardList: ArrayList<Card?>? = ArrayList()
    fun getCardList(): ArrayList<Card?>? {
        return mCardList
    }

    private fun buildGeneralWeaknessList() {
        for (weakness in this.mFullWeaknessList!!) {
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

    private fun buildDepthsOfYothWeaknessList() {
        val traits = ScenarioBuilder().getScenario(ScenarioType.DEPTHS_OF_YOTH)?.getTraits()
        updateListWithTraits(traits)
    }

    private fun updateListWithTraits(pScenarioTraits: ArrayList<CardTrait?>?) {
        for (weakness in this.mFullWeaknessList!!) {
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

    private fun setupFullWeaknessList() {

        //TODO: Read the strings, numbers and resource ids from the resource arrays instead of being
        //      hardcoded here.

        // Night of the Zealot Campaign
        val amnWeakness = Weakness("Amnesia", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 2, R.drawable.weakness_amnesia)
        assignCardTraits(amnWeakness, ArrayList(Arrays.asList(CardTrait.MADNESS)))
        mFullWeaknessList?.add(amnWeakness)
        val hauWeakness = Weakness("Haunted", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_haunted)
        assignCardTraits(hauWeakness, ArrayList(Arrays.asList(CardTrait.CURSE)))
        mFullWeaknessList?.add(hauWeakness)
        val hypWeakness = Weakness("Hypochondria", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_hypochondria)
        assignCardTraits(hypWeakness, ArrayList(Arrays.asList(CardTrait.MADNESS)))
        mFullWeaknessList?.add(hypWeakness)
        val mobWeakness = Weakness("Mob Enforcer", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_mob_enforcer)
        assignCardTraits(mobWeakness, ArrayList(Arrays.asList(CardTrait.HUMANOID, CardTrait.CRIMINAL)))
        mFullWeaknessList?.add(mobWeakness)
        val parWeakness = Weakness("Paranoia", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 2, R.drawable.weakness_paranoia)
        assignCardTraits(parWeakness, ArrayList(Arrays.asList(CardTrait.MADNESS)))
        mFullWeaknessList?.add(parWeakness)
        val psyWeakness = Weakness("Psychosis", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_psychosis)
        assignCardTraits(psyWeakness, ArrayList(Arrays.asList(CardTrait.MADNESS)))
        mFullWeaknessList?.add(psyWeakness)
        val silWeakness = Weakness("Silver Twilight Acolyte", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_silver_twilight_acolyte)
        assignCardTraits(silWeakness, ArrayList(Arrays.asList(CardTrait.HUMANOID, CardTrait.CULTIST, CardTrait.SILVER_TWILIGHT)))
        mFullWeaknessList?.add(silWeakness)
        val stbWeakness = Weakness("Stubborn Detective", CampaignAffinity.NIGHT_OF_THE_ZEALOT, 1, R.drawable.weakness_stubbor_detective)
        assignCardTraits(stbWeakness, ArrayList(Arrays.asList(CardTrait.HUMANOID, CardTrait.DETECTIVE)))
        mFullWeaknessList?.add(stbWeakness)
        // Dunwich Legacy Campaign
        val chrWeakness = Weakness("Chronophobia", CampaignAffinity.DUNWICH_LEGACY, 2, R.drawable.weakness_chronophobia)
        assignCardTraits(chrWeakness, ArrayList(Arrays.asList(CardTrait.MADNESS)))
        mFullWeaknessList?.add(chrWeakness)
        val indWeakness = Weakness("Indebted", CampaignAffinity.DUNWICH_LEGACY, 2, R.drawable.weakness_indebted)
        assignCardTraits(indWeakness, ArrayList(Arrays.asList(CardTrait.FLAW)))
        mFullWeaknessList?.add(indWeakness)
        val intWeakness = Weakness("Internal Injury", CampaignAffinity.DUNWICH_LEGACY, 2, R.drawable.weakness_internal_injury)
        assignCardTraits(intWeakness, ArrayList(Arrays.asList(CardTrait.INJURY)))
        mFullWeaknessList?.add(intWeakness)
        // Return to Dunwich Legacy Campaign
        val thrDaGtsWeakness = Weakness("Through the Gates", CampaignAffinity.RETURN_TO_DUNWICH_LEGACY, 2, R.drawable.weakness_through_the_gates)
        assignCardTraits(thrDaGtsWeakness, ArrayList(Arrays.asList(CardTrait.PACT, CardTrait.MYSTERY)))
        mFullWeaknessList?.add(thrDaGtsWeakness)
        // Path to Carcosa Campaign
        val drwSignWeakeness = Weakness("Drawing the Sign", CampaignAffinity.PATH_TO_CARCOSA, 1, R.drawable.weakness_drawing_the_sign)
        assignCardTraits(drwSignWeakeness, ArrayList(Arrays.asList(CardTrait.MADNESS, CardTrait.PACT)))
        mFullWeaknessList?.add(drwSignWeakeness)
        val thgWeakness = Weakness("The Thing That Follows", CampaignAffinity.PATH_TO_CARCOSA, 1, R.drawable.weakness_the_thing_that_follows)
        assignCardTraits(thgWeakness, ArrayList(Arrays.asList(CardTrait.MONSTER, CardTrait.CURSE)))
        mFullWeaknessList?.add(thgWeakness)
        val ovrWeakness = Weakness("Overzealous", CampaignAffinity.PATH_TO_CARCOSA, 2, R.drawable.weakness_overzealous)
        assignCardTraits(ovrWeakness, ArrayList(Arrays.asList(CardTrait.FLAW)))
        mFullWeaknessList?.add(ovrWeakness)
        // Return to Path to Carcosa Campaign
        val unspBldWeakness = Weakness("Unspeakable Oath (Bloodthirst)", CampaignAffinity.RETURN_TO_PATH_TO_CARCOSA, 1, R.drawable.weakness_unspeakable_oath_bloodthirst)
        assignCardTraits(unspBldWeakness, ArrayList(Arrays.asList(CardTrait.MADNESS, CardTrait.PACT)))
        mFullWeaknessList?.add(unspBldWeakness)
        val unspCwrdWeakness = Weakness("Unspeakable Oath (Cowardice)", CampaignAffinity.RETURN_TO_PATH_TO_CARCOSA, 1, R.drawable.weakness_unspeakable_oath_cowardice)
        assignCardTraits(unspCwrdWeakness, ArrayList(Arrays.asList(CardTrait.MADNESS, CardTrait.PACT)))
        mFullWeaknessList?.add(unspCwrdWeakness)
        val unspCurWeakness = Weakness("Unspeakable Oath (Curiosity)", CampaignAffinity.RETURN_TO_PATH_TO_CARCOSA, 1, R.drawable.weakness_unspeakable_oath_curiosity)
        assignCardTraits(unspCurWeakness, ArrayList(Arrays.asList(CardTrait.MADNESS, CardTrait.PACT)))
        mFullWeaknessList?.add(unspCurWeakness)
        // Forgotten Age Campaign
        val drkPctWeakness = Weakness("Dark Pact", CampaignAffinity.THE_FORGOTTEN_AGE, 1, R.drawable.weakness_dark_pact)
        assignCardTraits(drkPctWeakness, ArrayList(Arrays.asList(CardTrait.PACT)))
        mFullWeaknessList?.add(drkPctWeakness)
        val dmdPctWeakness = Weakness("Doomed", CampaignAffinity.THE_FORGOTTEN_AGE, 1, R.drawable.weakness_doomed)
        assignCardTraits(dmdPctWeakness, ArrayList(Arrays.asList(CardTrait.CURSE)))
        mFullWeaknessList?.add(dmdPctWeakness)
        // Return to Forgotten Age Campaign
        val dendTrnsWeakness = Weakness("Dendromorphosis: \"Natural\" Transformation", CampaignAffinity.RETURN_TO_FORGOTTEN_AGE, 1, R.drawable.weakness_dendromorphosis)
        assignCardTraits(dendTrnsWeakness, ArrayList(Arrays.asList(CardTrait.CURSE, CardTrait.FLORA)))
        mFullWeaknessList?.add(dendTrnsWeakness)
        val offerWeakness = Weakness("Offer You Cannot Refuse", CampaignAffinity.RETURN_TO_FORGOTTEN_AGE, 1, R.drawable.weakness_offer_you_cant_refuse)
        assignCardTraits(offerWeakness, ArrayList(Arrays.asList(CardTrait.PACT)))
        mFullWeaknessList?.add(offerWeakness)
        // Circle Undone Campaign
        val thrtnVisWeakness = Weakness("The 13th Vision", CampaignAffinity.CIRCLE_UNDONE, 2, R.drawable.weakness_thirteenth_vision)
        assignCardTraits(thrtnVisWeakness, ArrayList(Arrays.asList(CardTrait.OMEN)))
        mFullWeaknessList?.add(thrtnVisWeakness)
        val twrXviWeakenss = Weakness("The Tower - XVI: Circumstances Beyond Your Control", CampaignAffinity.CIRCLE_UNDONE, 2, R.drawable.weakness_the_tower)
        assignCardTraits(twrXviWeakenss, ArrayList(Arrays.asList(CardTrait.OMEN, CardTrait.TAROT)))
        mFullWeaknessList?.add(twrXviWeakenss)
        // Dream Eaters Campaign
        val klptoWeakness = Weakness("Kleptomania", CampaignAffinity.DREAM_EATERS, 1, R.drawable.weakness_kleptomania)
        assignCardTraits(klptoWeakness, ArrayList(Arrays.asList(CardTrait.MADNESS, CardTrait.TALENT)))
        mFullWeaknessList?.add(klptoWeakness)
        val nrcWeakness = Weakness("Narcolepsy", CampaignAffinity.DREAM_EATERS, 1, R.drawable.weakness_narcolepsy)
        assignCardTraits(nrcWeakness, ArrayList(Arrays.asList(CardTrait.MADNESS)))
        mFullWeaknessList?.add(nrcWeakness)
        val slfCntWeakness = Weakness("Self-Centered", CampaignAffinity.DREAM_EATERS, 1, R.drawable.weakness_self_centered)
        assignCardTraits(slfCntWeakness, ArrayList(Arrays.asList(CardTrait.FLAW)))
        mFullWeaknessList?.add(slfCntWeakness)
        val ywnWeakness = Weakness("Your Worst Nightmare", CampaignAffinity.DREAM_EATERS, 1, R.drawable.weakness_your_worst_nightmare)
        assignCardTraits(ywnWeakness, ArrayList(Arrays.asList(CardTrait.MONSTER)))
        mFullWeaknessList?.add(ywnWeakness)
        // Innsmouth Conspiracy Campaign
        val accFlwWeakness = Weakness("Accursed Follower", CampaignAffinity.INNSMOUTH_CONSPIRACY, 1, R.drawable.weakness_accursed_follower)
        assignCardTraits(accFlwWeakness, ArrayList(Arrays.asList(CardTrait.HUMANOID, CardTrait.CULTIST, CardTrait.CURSE)))
        mFullWeaknessList?.add(accFlwWeakness)
        val drdCrsWeakness = Weakness("Dread Curse", CampaignAffinity.INNSMOUTH_CONSPIRACY, 1, R.drawable.weakness_dread_curse)
        assignCardTraits(drdCrsWeakness, ArrayList(Arrays.asList(CardTrait.CURSE)))
        mFullWeaknessList?.add(drdCrsWeakness)
        val dyRcknWeakness = Weakness("Day of Reckoning", CampaignAffinity.INNSMOUTH_CONSPIRACY, 1, R.drawable.weakness_day_of_reckoning)
        assignCardTraits(dyRcknWeakness,  ArrayList(Arrays.asList(CardTrait.ENDTIMES)))
        mFullWeaknessList?.add(dyRcknWeakness)
    }

    @Synchronized
    private fun assignCardTraits(pWeakness: Weakness?, pCardTraits: ArrayList<CardTrait?>?) {
        for (trait in pCardTraits?.let { ArrayList(it) }!!) {
            pCardTraits.add(trait)
        }
        pWeakness?.setCardTraits(pCardTraits)
        pCardTraits.clear()
    }

    init {
        setupFullWeaknessList()
        when (mScenarioType) {
            ScenarioType.GENERAL -> buildGeneralWeaknessList()
            ScenarioType.UNDIMENSIONED_AND_UNSEEN_WEAKNESS -> buildUndimensionedWeaknessList()
            ScenarioType.UNDIMENSIONED_AND_UNSEEN_LOCATION -> buildUndimensionedLocationList()
            ScenarioType.BLACK_STARS_RISE -> buildBlackStarsRiseWeaknessList()
            ScenarioType.DEPTHS_OF_YOTH -> buildDepthsOfYothWeaknessList()
        }
    }
}