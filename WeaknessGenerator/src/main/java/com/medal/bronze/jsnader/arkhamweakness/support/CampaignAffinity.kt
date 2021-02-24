package com.medal.bronze.jsnader.arkhamweakness.support

/**
 * Describes where the card originated from which will allow for further filtering during the
 * selection process.  Determining what set of cards that something belongs to will help identify
 * whether or not it should be available for certain filters.
 *
 * Created by Jeremiah on 2/23/2021.
 */
enum class CampaignAffinity {
    NIGHT_OF_THE_ZEALOT,
    DUNWICH_LEGACY,
    RETURN_TO_DUNWICH_LEGACY,
    PATH_TO_CARCOSA,
    RETURN_TO_PATH_TO_CARCOSA,
    THE_FORGOTTEN_AGE,
    RETURN_TO_FORGOTTEN_AGE,
    CIRCLE_UNDONE,
    DREAM_EATERS,
    INNSMOUTH_CONSPIRACY
}