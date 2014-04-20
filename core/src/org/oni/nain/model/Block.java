package org.oni.nain.model;

import org.oni.nain.model.enumeration.Biome;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Block {
    private int x;
    private int y;
    private int z;
    private Biome type;
    private Vector2 vector2;
    private Rectangle rectangle;


    public Block(int x, int y, int z, Biome type) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.type = type;
        this.vector2 = new Vector2(x, y);
        this.rectangle = new Rectangle(x, y, 1f, 1f);
    }

    public Block(int x, int y, int z) {
        this(x, y, z, null);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public Biome getType() {
        return type;
    }

    public void setType(Biome type) {
        this.type = type;
    }

    public Vector2 getVector2() {
        return vector2;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public String toString() {
        return "Block [x=" + x + ", y=" + y + ", z=" + z + ", type=" + type + "]";
    }
}
