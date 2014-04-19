package org.oni.nain.model;

import java.util.ArrayList;
import java.util.List;

public class World {

    private List<Block> blocks;

    public World() {
        blocks = new ArrayList<>();
    }

    public List<Block> getBlocks() {
        return blocks;
    }

}
