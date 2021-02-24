package com.medal.bronze.jsnader.arkhamweakness.checkstyle;

/**
 * A class that is meant to check against various checkstyle formats that we want to enforce.  The
 * call here are not necessarily covering all cases, but it helps if this is used to guide our
 * checkstyle formatting so that we have a good starting point for another project that we might
 * be working on in the future.
 */
public final class CheckStyleFormat {
    /** Another name that is not exposed but can only work in this order "below" public. */
    private static final String CHECK_PRIV_NAME = "";
    /** An exposed name that other classes can use. */
    public static final String CHECK_NAME = "";

    // Since not used by another class a check tells us that we should have this as a private
    // constructor.
    private CheckStyleFormat() {

    }
}
