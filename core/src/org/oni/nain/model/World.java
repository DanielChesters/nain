package org.oni.nain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.oni.nain.NainConstants;
import org.oni.nain.model.enumeration.TypeBlock;

public class World {

    private static final int MAX_Y = NainConstants.MAX_SIZE - 1;
    private static final int MAX_X = NainConstants.MAX_SIZE - 1;
    private List<Block> blocks;

    public World() {
        blocks = Collections.synchronizedList(new ArrayList<>());
        IntStream.rangeClosed(0, MAX_X).forEach(
                x -> IntStream.rangeClosed(0, MAX_Y).forEach(
                        y -> blocks.add(new Block(x, y, 0))));


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
                .filter(e -> e.getKey().getType() == null)
                .forEach(
                        e -> {
                            e.getKey().setType(TypeBlock.getRandom());
                            e.getValue().stream().filter(b -> b.getType() == null)
                                    .filter(b -> new Random().nextBoolean())
                                    .forEach(b -> b.setType(e.getKey().getType()));
                        });
    }

    private boolean blockLeftRight(Block blockCenter, Block b) {
        return Math.abs(blockCenter.getX() - b.getX()) == 1 && Math.abs(blockCenter.getY()
                - b.getY()) == 0;
    }

    private boolean blockUpDown(Block blockCenter, Block b) {
        return Math.abs(blockCenter.getX() - b.getX()) == 0 && Math.abs(blockCenter.getY()
                - b.getY()) == 1;
    }

    private boolean blockInCorner(Block blockCenter, Block b) {
        return Math.abs(blockCenter.getX() - b.getX()) == 1 && Math.abs(blockCenter.getY()
                - b.getY()) == 1;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

}
