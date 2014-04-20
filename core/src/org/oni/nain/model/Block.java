package org.oni.nain.model;

import java.util.HashSet;
import java.util.Set;

import org.oni.nain.model.enumeration.Biome;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Block {
    private int x;
    private int y;
    private Biome biome;
    private Vector2 center;
    private Set<Vector2> corners;
    private Rectangle rectangle;


    public Block(int x, int y, Biome biome) {
        this.x = x;
        this.y = y;
        this.biome = biome;
        this.center = new Vector2(x + 0.5f, y + 0.5f);
        this.corners = new HashSet<>();
        this.corners.add(new Vector2(x, y));
        this.corners.add(new Vector2(x + 1, y));
        this.corners.add(new Vector2(x, y + 1));
        this.corners.add(new Vector2(x + 1, y + 1));

        this.rectangle = new Rectangle(x, y, 1f, 1f);
    }

    public Block(int x, int y) {
        this(x, y, null);
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

    public Biome getBiome() {
        return biome;
    }

    public void setBiome(Biome biome) {
        this.biome = biome;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Vector2 getCenter() {
        return center;
    }

    public Set<Vector2> getCorners() {
        return corners;
    }

    @Override
    public String toString() {
        return "Block [x=" + x + ", y=" + y + ", biome=" + biome + "]";
    }
}
