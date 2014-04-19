package org.oni.nain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.oni.nain.model.enumeration.TypeBlock;

public class World {

    private List<Block> blocks;

    public World() {
        blocks = new ArrayList<>();
        IntStream.range(-50, 50).forEach(
                x -> IntStream.range(-50, 50).forEach(
                        y -> blocks.add(new Block(x, y, 0, TypeBlock.AIR))));
    }

    public List<Block> getBlocks() {
        return blocks;
    }

}
