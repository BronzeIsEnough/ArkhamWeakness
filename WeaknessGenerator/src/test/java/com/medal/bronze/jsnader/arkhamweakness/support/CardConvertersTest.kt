package com.medal.bronze.jsnader.arkhamweakness.support

import junit.framework.TestCase.assertEquals
import org.junit.Test

internal class CardConvertersTest {
    val mConverters = CardConverters()
    val EXP_CARD_TRAITS_JSON = "[\n" +
                                "\tPACT,\n" +
                                "\tMADNESS\n" +
                                "]"
    val EXP_ENEMY_TRAIT_JSON = "[\n" +
                               "\tALERT,\n" +
                               "\tHUNTER\n" +
                               "]"

    @Test
    fun campaignAffinityConversionAreAsExpected() {
        val affinity = CampaignAffinity.INNSMOUTH_CONSPIRACY;
        val affinName = mConverters.affinityToJsonName(affinity)
        assertEquals(affinity.name, affinName)
        assertEquals(affinity, mConverters.jsonNameToAffinity(affinName))
    }

    @Test
    fun cardTraitConversionsAreAsExpected() {
        val traitList = arrayListOf(CardTrait.PACT, CardTrait.MADNESS)
        val traitName = mConverters.cardTraitToJsonName(traitList)
        assertEquals(EXP_CARD_TRAITS_JSON, traitName)
        assertEquals(traitList, mConverters.jsonNameToCardTrait(traitName))
    }

    @Test
    fun enemyKeywordConversionAreAsExpected() {
        val keywordList = arrayListOf(EnemyKeyword.ALERT, EnemyKeyword.HUNTER)
        val keyName = mConverters.enemyKeywordsToJsonName(keywordList)
        assertEquals(EXP_ENEMY_TRAIT_JSON, keyName)
        assertEquals(keywordList, mConverters.jsonNameToEnemyKeyword(keyName))
    }

    @Test
    fun mythosTypeConversionsAreAsExpected() {
        val mythos = MythosCardType.TREACHERY
        val mythosName = mConverters.mythosTypeToJsonName(mythos)
        assertEquals(mythos.name, mythosName)
        assertEquals(mythos, mConverters.jsonNameToMythosType(mythosName))
    }
}