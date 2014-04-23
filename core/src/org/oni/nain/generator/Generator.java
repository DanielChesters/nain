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
     * @param size
     * @return
     */
    public List<Block> generateBlocks(int size) {
        List<Block> blocks = Collections.synchronizedList(new ArrayList<>());
        IntStream.rangeClosed(0, size).forEach(
                x -> IntStream.rangeClosed(0, size).forEach(
                        y -> blocks.add(new Block(x, y))));


        Function<Block, List<Block>> blocksBordeningFunc =
                b -> blocks
                        .stream().parallel()
                        .filter(b1 -> blockInCorner(b, b1)
                                || blockUpDown(b, b1)
                                || blockLeftRight(b, b1)).collect(Collectors.toList());
        Map<Block, List<Block>> blocksBordeningMap =
                blocks.stream().parallel().collect(Collectors.toMap(Function.identity(), blocksBordeningFunc));

        blocksBordeningMap
                .entrySet()
                .stream().parallel()
                .filter(e -> e.getKey().getBiome() == null)
                .forEach(
                        e -> {
                            e.getKey().setBiome(Biome.getRandom());
                            e.getValue().stream().filter(b -> b.getBiome() == null)
                                    .filter(b -> new Random().nextBoolean())
                                    .forEach(b -> b.setBiome(e.getKey().getBiome()));
                        });
        return blocks;
    }

    /**
     * @param blockCenter
     * @param b
     * @return
     */
    private boolean blockLeftRight(Block blockCenter, Block b) {
        return Math.abs(blockCenter.getX() - b.getX()) == 1 && Math.abs(blockCenter.getY()
                - b.getY()) == 0;
    }

    /**
     * @param blockCenter
     * @param b
     * @return
     */
    private boolean blockUpDown(Block blockCenter, Block b) {
        return Math.abs(blockCenter.getX() - b.getX()) == 0 && Math.abs(blockCenter.getY()
                - b.getY()) == 1;
    }

    /**
     * @param blockCenter
     * @param b
     * @return
     */
    private boolean blockInCorner(Block blockCenter, Block b) {
        return Math.abs(blockCenter.getX() - b.getX()) == 1 && Math.abs(blockCenter.getY()
                - b.getY()) == 1;
    }
}
