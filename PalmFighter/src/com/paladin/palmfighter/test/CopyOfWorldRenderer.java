package com.paladin.palmfighter.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.paladin.palmfighter.utils.map.ParallaxBackground;
import com.paladin.palmfighter.utils.map.ParallaxLayer;

public class CopyOfWorldRenderer implements Disposable {

	private OrthographicCamera camera;
	private SpriteBatch batch;
	private WorldController worldController;

	TextureAtlas atlas = new TextureAtlas(
			Gdx.files.internal("maps/template/1/template1.atlas"));

	ParallaxBackground bg;
	ParallaxLayer[] parallaxLayers = new ParallaxLayer[4];

	public CopyOfWorldRenderer(WorldController worldController) {
		this.worldController = worldController;
//		init();
		initParallax();
	}

	private void init() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera(5, 5);
		camera.position.set(100, 100, 0);
		camera.update();
	}

	public void render() {
//		renderTestObjects();
		renderParallaxBg();
	}

	private void renderTestObjects() {
		worldController.cameraHelper.applyTo(camera);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for (Sprite sprite : this.worldController.testSprites) {
			sprite.draw(batch);
		}
		batch.end();
	}

	private void renderParallaxBg() {
		bg.render(Gdx.graphics.getDeltaTime());
		worldController.cameraHelper.applyTo(camera);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for (Sprite sprite : this.worldController.testSprites) {
			sprite.draw(batch);
		}
		batch.end();
	}

	private void initParallax() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera(5, 5);
		camera.position.set(100, 100, 0);
		camera.update();
		
		parallaxLayers[0] = new ParallaxLayer(atlas.findRegion("pic1"),
				new Vector2(2, 3), new Vector2(0, 335), new Vector2(0, 0));
		parallaxLayers[1] = new ParallaxLayer(atlas.findRegion("pic2"),
				new Vector2(2, 3), new Vector2(800, 335), new Vector2(0, 0));
		parallaxLayers[2] = new ParallaxLayer(atlas.findRegion("pic3"),
				new Vector2(3, 3), new Vector2(0, 800), new Vector2(0, 0));
		parallaxLayers[3] = new ParallaxLayer(atlas.findRegion("pic4"),
				new Vector2(3, 3), new Vector2(150, 800), new Vector2(0, 0));
//		parallaxLayers[4] = new ParallaxLayer(atlas.findRegion("pic5"),
//				new Vector2(4, 3), new Vector2(0, 185), new Vector2(0, 0));
//		parallaxLayers[5] = new ParallaxLayer(atlas.findRegion("pic6"),
//				new Vector2(5, 3), new Vector2(750, 185), new Vector2(0, 0));
//		parallaxLayers[6] = new ParallaxLayer(atlas.findRegion("pic7"),
//				new Vector2(6, 3), new Vector2(0, 119), new Vector2(0, 0));
//		parallaxLayers[7] = new ParallaxLayer(atlas.findRegion("pic8"),
//				new Vector2(7, 3), new Vector2(800, 119), new Vector2(0, 0));

		bg = new ParallaxBackground(parallaxLayers, 1600, 480, new Vector2(50,
				0));
		
		
	}

	public void resize(int width, int height) {
		camera.viewportWidth = (480 / height) * width;
		camera.update();
	}

	@Override
	public void dispose() {
//		batch.dispose();
	}

}
