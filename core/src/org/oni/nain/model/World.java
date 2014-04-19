package org.oni.nain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
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
                        y -> blocks.add(new Block(x, y, 0, null))));


        Function<Block, List<Block>> blocksBordeningFunc =
                b -> blocks
                        .stream()
                        .filter(b1 -> (Math.abs(b.getX() - b1.getX()) == 1 && Math.abs(b.getY()
                                - b1.getY()) == 1)
                                || (Math.abs(b.getX() - b1.getX()) == 0 && Math.abs(b.getY()
                                        - b1.getY()) == 1)
                                || (Math.abs(b.getX() - b1.getX()) == 1 && Math.abs(b.getY()
                                        - b1.getY()) == 0)).collect(Collectors.toList());
        Map<Block, List<Block>> blocksBordeningMap =
                blocks.stream().collect(Collectors.toMap(Function.identity(), blocksBordeningFunc));

        blocksBordeningMap
                .entrySet()
                .stream()
                .filter(e -> e.getKey().getType() == null)
                .forEach(
                        e -> {
                            e.getKey().setType(TypeBlock.getRandom());
                            e.getValue().stream().filter(b -> b.getType() == null)
                                    .filter(b -> new Random().nextBoolean())
                                    .forEach(b -> b.setType(e.getKey().getType()));
                        });
    }

    public List<Block> getBlocks() {
        return blocks;
    }

}
