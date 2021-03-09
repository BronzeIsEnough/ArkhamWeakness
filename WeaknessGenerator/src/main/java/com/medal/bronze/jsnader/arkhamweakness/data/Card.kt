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
package com.medal.bronze.jsnader.arkhamweakness.data

import androidx.room.Entity
import androidx.room.PrimaryKey

import com.medal.bronze.jsnader.arkhamweakness.support.CampaignAffinity
import com.medal.bronze.jsnader.arkhamweakness.support.CardTrait
import com.medal.bronze.jsnader.arkhamweakness.support.EnemyKeywords
import com.medal.bronze.jsnader.arkhamweakness.support.MythosCardType

/**
 * This will be a table that represents the cards that we will be referencing when we want to get
 * information specifically from what is available.  The information in each column can be seen
 * within the class below.  The [CardDao] will expose the methods for retrieving information on
 * the data in the table.
 */
@Entity(tableName = "card_table")
data class Card (
    @PrimaryKey(autoGenerate = true)
    val name : String,
    val isBasicWeakness : Boolean,
    val numAvailable : Int,
    val image : Int,
    val affinity : CampaignAffinity,
    val mythosCardType : MythosCardType,
    val traits : ArrayList<CardTrait>,
    val keywords : ArrayList<EnemyKeywords>,
    val flavorText : String,
    val illustrator : String,
    val fightVal : Int,
    val healthVal : Int,
    val evadeVal : Int,
    val damage : Int,
    val horror : Int
)