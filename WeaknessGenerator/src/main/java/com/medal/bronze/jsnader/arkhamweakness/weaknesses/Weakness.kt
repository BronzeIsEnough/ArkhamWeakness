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
class Weakness(mName: String,
               val mSetAffinity: CampaignAffinity,
               val mNumAvailable: Int,
               mDrawableResource: Int,
               var mCardTraits: ArrayList<CardTrait> = ArrayList())
    : Card(mName, CardType.WEAKNESS, mDrawableResource) {

}