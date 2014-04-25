package org.oni.nain.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.oni.nain.model.Block;
import org.oni.nain.model.enumeration.Biome;

public enum Generator {
    INSTANCE;

    /**
     * Generate Block of map
     * @param size size of each axe of map
     * @return List of Block for the map
     */
    public List<Block> generateBlocks(int size) {
        List<Block> blocks = Collections.synchronizedList(new ArrayList<>());
        IntStream.rangeClosed(0, size - 1).forEach(
                x -> IntStream.rangeClosed(0, size - 1).forEach(
                        y -> blocks.add(new Block(x, y))));


        Function<Block, List<Block>> blocksBorderingFunc =
                b -> blocks
                        .parallelStream()
                        .filter(b1 -> blockInCorner(b, b1)
                                || blockUpDown(b, b1)
                                || blockLeftRight(b, b1)).collect(Collectors.toList());
        Map<Block, List<Block>> blocksBorderingMap =
                blocks.parallelStream().collect(Collectors.toMap(Function.identity(), blocksBorderingFunc));

        blocksBorderingMap
                .entrySet()
                .parallelStream()
                .filter(e -> e.getKey().getBiome() == null)
                .forEach(
                        e -> {
                            e.getKey().setBiome(Biome.getRandom());
                            e.getValue().parallelStream().filter(b -> b.getBiome() == null)
                                    .filter(b -> new Random().nextBoolean())
                                    .forEach(b -> b.setBiome(e.getKey().getBiome()));
                        });
        return blocks;
    }

    /**
     * Test if a block is on left or right of a other block
     * @param blockCenter block on center
     * @param b block to test
     * @return if b is on left or right of blockCenter
     */
    private boolean blockLeftRight(Block blockCenter, Block b) {
        return Math.abs(blockCenter.getX() - b.getX()) == 1 && Math.abs(blockCenter.getY()
                - b.getY()) == 0;
    }

    /**
     * Test if a block is on up or down of a other block
     * @param blockCenter block on center
     * @param b block to test
     * @return if b is on up or down of blockCenter
     */
    private boolean blockUpDown(Block blockCenter, Block b) {
        return Math.abs(blockCenter.getX() - b.getX()) == 0 && Math.abs(blockCenter.getY()
                - b.getY()) == 1;
    }

    /**
     * Test if a block is on corner of a other block
     * @param blockCenter block on center
     * @param b block to test
     * @return if b is on corners of blockCenter
     */
    private boolean blockInCorner(Block blockCenter, Block b) {
        return Math.abs(blockCenter.getX() - b.getX()) == 1 && Math.abs(blockCenter.getY()
                - b.getY()) == 1;
    }
}
