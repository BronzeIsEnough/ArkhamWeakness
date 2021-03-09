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
 * Describes where the card originated from which will allow for further filtering during the
 * selection process.  Determining what set of cards that something belongs to will help identify
 * whether or not it should be available for certain filters.
 *
 * Created by Jeremiah on 2/23/2021.
 */
@TypeConverters(CardConverters::class)
enum class CampaignAffinity(val jsonName : String) {
    NIGHT_OF_THE_ZEALOT("night_of_the_zealot"),
    DUNWICH_LEGACY("dunwich_legacy"),
    RETURN_TO_DUNWICH_LEGACY("return_to_dunwich_legacy"),
    PATH_TO_CARCOSA("path_to_carcosa"),
    RETURN_TO_PATH_TO_CARCOSA("return_to_path_to_carcosa"),
    THE_FORGOTTEN_AGE("the_forgotten_age"),
    RETURN_TO_FORGOTTEN_AGE("return_to_forgotten_age"),
    CIRCLE_UNDONE("circle_undone"),
    DREAM_EATERS("dream_eaters"),
    INNSMOUTH_CONSPIRACY("innsmouth_conspiracy")
}
