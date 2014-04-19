package org.oni.nain.model;

import org.oni.nain.model.enumeration.TypeBlock;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Block {
    private int x;
    private int y;
    private int z;
    private TypeBlock type;

    public Block(int x, int y, int z, TypeBlock type) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.type = type;
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

    public TypeBlock getType() {
        return type;
    }

    public void setType(TypeBlock type) {
        this.type = type;
    }

    public Vector2 getVector2() {
        return new Vector2(x, y);
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, 1f, 1f);
    }

    @Override
    public String toString() {
        return "Block [x=" + x + ", y=" + y + ", z=" + z + ", type=" + type + "]";
    }
}
