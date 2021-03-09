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

import androidx.room.TypeConverters

/**
 * Represents the traits associated with a card in the Arkham Horror game.  These are typically
 * referenced by individuals and used to filter whether or not it should be considered for
 * inclusion in the weakness selection process.
 *
 * Created by Jeremiah on 2/23/2021.
 */
@TypeConverters(CardConverters::class)
enum class CardTrait(val jsonName : String){
    ALL("all"),
    CRIMINAL("criminal"),
    CULTIST("cultist"),
    CURSE("curse"),
    DETECTIVE("detective"),
    ENDTIMES("end_times"),
    FLAW("flaw"),
    FLORA("flora"),
    HUMANOID("humanoid"),
    INJURY("injury"),
    MADNESS("madness"),
    MONSTER("monster"),
    MYSTERY("mystery"),
    OMEN("opoen"),
    PACT("pact"),
    SILVER_TWILIGHT("silver_twilight"),
    TALENT("talent"),
    TAROT("tarot")
}