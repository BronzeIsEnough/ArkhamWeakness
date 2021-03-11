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
package com.medal.bronze.jsnader.arkhamweakness.scenarios

import com.medal.bronze.jsnader.arkhamweakness.locations.Location
import com.medal.bronze.jsnader.arkhamweakness.support.CardTrait
import java.util.*
import kotlin.collections.ArrayList

/**
 * Represents a specific scenario within the Arkham Horror LCG universe that a weakness could be
 * selected from.
 *
 * Created by Jeremiah on 3/24/2018.
 */
class Scenario(val mScenarioType: ScenarioType,
               val mScenarioTitle: String,
               val mCampaignTitle: String,
               val mImageResource: Int,
               var mTraits : ArrayList<CardTrait> = ArrayList(),
               var mLocations : ArrayList<Location> = ArrayList()) {
}