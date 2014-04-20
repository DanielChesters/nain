package org.oni.nain.model.enumeration;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;

public enum TypeBlock {
    DIRT(Color.ORANGE),
    WATER(Color.BLUE),
    AIR(Color.BLACK);

    private static final Random RND = new Random();

    private Color color;

    private TypeBlock(Color color) {
        this.color = color;
    }

    public static TypeBlock getRandom() {
        return values()[RND.nextInt(values().length)];
    }

    public Color getColor() {
        return color;
    }

}
