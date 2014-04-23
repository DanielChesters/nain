package org.oni.nain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class World {

    private List<Block> blocks;

    public World() {
        this.blocks = Collections.synchronizedList(new ArrayList<>());
    }

    public World(List<Block> blocks) {
        this.blocks = blocks;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

}
