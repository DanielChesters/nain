package org.oni.nain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.oni.nain.model.enumeration.TypeBlock;

public class World {

    private static final int MAX_Y = 50;
    private static final int MAX_X = 50;
    private List<Block> blocks;

    public World() {
        blocks = new ArrayList<>();
        IntStream.range(-MAX_X, MAX_X).forEach(
                x -> IntStream.range(-MAX_Y, MAX_Y).forEach(
                        y -> blocks.add(new Block(x, y, 0, TypeBlock.AIR))));
    }

    public List<Block> getBlocks() {
        return blocks;
    }

}
