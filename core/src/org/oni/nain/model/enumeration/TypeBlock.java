package org.oni.nain.model.enumeration;

import java.util.Random;

public enum TypeBlock {
    DIRT, WATER, AIR;
    private static final Random RND = new Random();

    public static TypeBlock getRandom() {
        return values()[RND.nextInt(values().length)];
    }

}
