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

public class NainGame extends ApplicationAdapter {
    private World world;
    private OrthographicCamera cam;
    private ShapeRenderer renderer;

    @Override
    public void create () {
        cam = new OrthographicCamera(3, 3);
        cam.position.set(1.5f, 1.5f, 0);
        cam.update();
        renderer = new ShapeRenderer();
        world = new World();
        System.out.println(world.getBlocks());
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
                    break;
            }
            Rectangle rectangle = b.getRectangle();
            renderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        });
        renderer.end();
    }
}
