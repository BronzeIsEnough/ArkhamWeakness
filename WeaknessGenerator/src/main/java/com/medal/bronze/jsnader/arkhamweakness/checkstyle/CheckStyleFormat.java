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
package com.medal.bronze.jsnader.arkhamweakness.checkstyle;

import android.util.Log;
import java.util.Random;

/**
 * A class that is meant to check against various checkstyle formats that we want to enforce.  The
 * call here are not necessarily covering all cases, but it helps if this is used to guide our
 * checkstyle formatting so that we have a good starting point for another project that we might
 * be working on in the future.
 */
public final class CheckStyleFormat {
    // TODO: Add additional check and enforce them.
    // TODO: Make sure that the gradlew works from checkstyle/pmd/findbugs
    /** An exposed name that other classes can use. */
    public static final String CHECK_PUB_NAME = "";
    /** Another name that is not exposed but can only work in this order "below" public. */
    private static final String CHECK_PRIV_NAME = "";
    /** A magic number solution for checks. */
    private static final int MAGIC_NUMBER = 7;
    /** Private members need to private, but can be exposed via a getter as needed. */
    private final String mCheckPrivName;
    /** Protected members need to be private, but can be exposed via protected getters. */
    private String mCheckProtName;

    // Since not used by another class a check tells us that we should have this as a private
    // constructor.
    private CheckStyleFormat() {
        mCheckPrivName = "Default name";
        initialChecks();
    }

    public String getCheckPrivName() {
        return mCheckPrivName;
    }

    protected String getCheckProtName() {
        return mCheckProtName;
    }

    protected void setCheckProtName(String pCheckName) {
        mCheckProtName = pCheckName;
    }

    private void initialChecks() {
        magicNumberWithForLoopFormatChecks();
        lineTooLongCheck();
        operatorCheck();
    }

    private void magicNumberWithForLoopFormatChecks() {
        final int var = MAGIC_NUMBER;
        for (int index = 0; index < var; index++) {
            Log.d("checkstyle", "MagicNumber " + var + " = " + index);
        }
    }

    private void lineTooLongCheck() {
        final String messageTooLong =
                "If we extend beyond the 100 character be throwing an exception";
    }

    private void operatorCheck() {
        final int rand = new Random(MAGIC_NUMBER).nextInt();
        if (MAGIC_NUMBER == rand
                && rand > 1) {
            Log.d("checkstyle", "Operators on the correct lines");
        }
    }
}
