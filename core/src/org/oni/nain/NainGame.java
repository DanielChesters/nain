package org.oni.nain;

import java.util.List;

import org.oni.nain.generator.Generator;
import org.oni.nain.model.Block;
import org.oni.nain.model.World;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Logger;

public class NainGame extends ApplicationAdapter {
    private World world;
    private OrthographicCamera cam;
    private ShapeRenderer renderer;
    private static final Logger LOG = new Logger(NainGame.class.getSimpleName(), Logger.DEBUG);

    @Override
    public void create () {
        cam = new OrthographicCamera(Constants.MAX_SIZE, Constants.MAX_SIZE);
        cam.position.set(Constants.MAX_SIZE/2, Constants.MAX_SIZE/2, 0);
        cam.update();
        renderer = new ShapeRenderer();
        List<Block> blocks = Generator.INSTANCE.generateBlocks(Constants.MAX_SIZE);
        world = new World(blocks);
        LOG.debug(world.getBlocks().toString());
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.setProjectionMatrix(cam.combined);
        renderer.begin(ShapeType.Filled);
        world.getBlocks().stream().forEach(b -> {
            renderer.setColor(b.getBiome().getColor());
            Rectangle rectangle = b.getRectangle();
            renderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        });
        renderer.end();
    }
}
