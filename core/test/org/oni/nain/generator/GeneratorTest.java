package org.oni.nain.generator;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.oni.nain.model.Block;
import org.oni.nain.model.enumeration.Biome;

@RunWith(JUnit4.class)
public class GeneratorTest {

    private List<Block> blocks;

    @Before
    public void setup() {
        blocks = Generator.INSTANCE.generateBlocks(10);
    }

    @Test
    public void generateBlockIsNotEmptyTest() {
        Assert.assertNotNull(blocks);
        Assert.assertFalse(blocks.isEmpty());
    }

    @Test
    public void generateBlockSize() {
        Assert.assertEquals(100, blocks.size());
    }

    @Test
    public void generateBlockHaveWater() {
        Assert.assertTrue(blocks.parallelStream().anyMatch(b -> b.getBiome() == Biome.WATER));
    }

    @Test
    public void generateBlockHaveAir() {
        Assert.assertTrue(blocks.parallelStream().anyMatch(b -> b.getBiome() == Biome.AIR));
    }

    @Test
    public void generateBlockHaveDirt() {
        Assert.assertTrue(blocks.parallelStream().anyMatch(b -> b.getBiome() == Biome.DIRT));
    }

}
