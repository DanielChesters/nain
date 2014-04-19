package org.oni.nain.model;

import org.oni.nain.model.enumeration.TypeBlock;

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

    @Override
    public String toString() {
        return "Block [x=" + x + ", y=" + y + ", z=" + z + ", type=" + type + "]";
    }
}
