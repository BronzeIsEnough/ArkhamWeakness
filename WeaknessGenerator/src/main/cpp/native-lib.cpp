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
#include "include/native-lib.h"

#include <string.h>

// Introduce simplistic calls into the JNI layer just to keep a grasp on some small things that can
// be done to test Kotlin and native development integration of libraries and methods that we would
// like do define for testing purposes.  They might not be useful or needed by the application
// itself.
extern "C" {

    jboolean Java_com_medal_bronze_jsnader_arkhamweakness_SelectionPage_checkAppPassphrase(
        JNIEnv * env,
        jobject obj,
        jstring pass) {

        const char *storedPass = "SimpleNativePassPhrase";
        const char *inputPass = env->GetStringUTFChars(pass, JNI_FALSE);

        int res = strncmp(inputPass, storedPass, strlen(storedPass));
        if (res == 0) {
            return JNI_TRUE;
        } else {
            return JNI_FALSE;
        }
    }

} // End Extern "C"
