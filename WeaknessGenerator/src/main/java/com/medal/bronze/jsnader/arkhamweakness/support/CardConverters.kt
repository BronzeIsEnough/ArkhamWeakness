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
package com.medal.bronze.jsnader.arkhamweakness.support

import androidx.room.TypeConverter
import java.util.*

class CardConverters {
    /**
     * It's purpose is to convert a json string name to an enumeration and vice versa that we will
     * work with as we store things in a Room database for internal usage related to [CampaignAffinity]
     */
    @TypeConverter
    fun affinityToJsonName(affinity: CampaignAffinity) : String {
        return affinity.name
    }
    @TypeConverter
    fun jsonNameToAffinity(jsonName: String) : CampaignAffinity? {
        return CampaignAffinity.values().find { it.name.equals(jsonName) }
    }
    /**
     * It's purpose is to convert a json string name to an enumeration and vice versa that we will
     * work with as we store things in a Room database for internal usage related to [CardTrait]
     */
    @TypeConverter
    fun cardTraitToJsonName(traits : ArrayList<CardTrait>) : String {
        var jsonString = ""
        for(keyword in traits) {
            jsonString += keyword.name
        }
        return jsonString;
    }
    @TypeConverter
    fun jsonNameToCardTrait(jsonValues : String) : ArrayList<CardTrait>? {
        val dbValues = jsonValues.split("\\s,\\s*")
        var keywords = arrayListOf<CardTrait>()

        for (string in dbValues) {
            keywords.add(CardTrait.valueOf(string))
        }
        return keywords
    }
    /**
     * It's purpose is to convert a json string name to an enumeration and vice versa that we will
     * work with as we store things in a Room database for internal usage related to [EnemyKeyword]
     */
    @TypeConverter
    fun enemyKeywordsToJsonName(enemyKeywords : ArrayList<EnemyKeyword>) : String {
        var jsonString = ""
        for(keyword in enemyKeywords) {
            jsonString += keyword.name
        }
        return jsonString;
    }
    @TypeConverter
    fun jsonNameToEnemyKeyword(jsonValues : String) : ArrayList<EnemyKeyword>? {
        val dbValues = jsonValues.split("\\s,\\s*")
        var keywords = arrayListOf<EnemyKeyword>()

        for (string in dbValues) {
            keywords.add(EnemyKeyword.valueOf(string))
        }
        return keywords
    }
    /**
     * It's purpose is to convert a json string name to an enumeration and vice versa that we will
     * work with as we store things in a Room database for internal usage related to [MythosCardType]
     */
    @TypeConverter
    fun mythosTypeToJsonName(mythosType: MythosCardType) : String {
        return mythosType.name
    }
    @TypeConverter
    fun jsonNameToMythosType(jsonName: String) : MythosCardType? {
        return MythosCardType.values().find { it.name.equals(jsonName) }
    }
}