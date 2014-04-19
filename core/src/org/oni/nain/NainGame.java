package org.oni.nain;

import org.oni.nain.model.World;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
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
        cam = new OrthographicCamera(NainConstants.MAX_SIZE, NainConstants.MAX_SIZE);
        cam.position.set(NainConstants.MAX_SIZE/2, NainConstants.MAX_SIZE/2, 0);
        cam.update();
        renderer = new ShapeRenderer();
        world = new World();
        LOG.debug(world.getBlocks().toString());
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.setProjectionMatrix(cam.combined);
        renderer.begin(ShapeType.Filled);
        world.getBlocks().stream().forEach(b -> {
            switch (b.getType()) {
                case DIRT:
                    renderer.setColor(Color.ORANGE);
                    break;
                case WATER:
                    renderer.setColor(Color.BLUE);
                    break;
                case AIR:
                    renderer.setColor(Color.BLACK);
                    break;
                default:
                    LOG.error("Block type unknown : " + b);
                    break;
            }
            Rectangle rectangle = b.getRectangle();
            renderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        });
        renderer.end();
    }
}
