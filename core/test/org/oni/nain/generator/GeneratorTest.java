package org.oni.nain.generator;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.oni.nain.model.Block;
import org.oni.nain.model.enumeration.Biome;

@RunWith(JUnit4.class)
public class GeneratorTest {
    @Test
    public void generateBlockTest() {
        List<Block> blocks = Generator.INSTANCE.generateBlocks(10);
        Assert.assertNotNull(blocks);
        Assert.assertFalse(blocks.isEmpty());
        Assert.assertEquals(100, blocks.size());
        Assert.assertTrue(blocks.stream().anyMatch(b -> b.getBiome() == Biome.AIR));
        Assert.assertTrue(blocks.stream().anyMatch(b -> b.getBiome() == Biome.WATER));
        Assert.assertTrue(blocks.stream().anyMatch(b -> b.getBiome() == Biome.DIRT));
    }

}
