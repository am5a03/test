package com.paladin.palmfighter.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Disposable;
import com.paladin.palmfighter.utils.PFConstants;

public class Assets implements Disposable, AssetErrorListener {
	private static Assets assets = null;
	private AssetManager assetManager;
	
	public static final String TAG = Assets.class.getName();
	
	public AssetConfirmBtn assetConfirmBtn;
	public AssetCancelBtn assetCancelBtn;
	public TemplateGuy templateGuy;
	
//	public Fonts fonts;
	
	public static Assets getInstance(){
		if(assets == null){
			assets = new Assets();
		}
		return assets;
	}
	
	public void init(){
		this.assetManager = new AssetManager();
		this.assetManager.setErrorListener(this);
		this.assetManager.load(PFConstants.TextureObj.TEMPLATE_ATLAS, TextureAtlas.class);
		this.assetManager.finishLoading();
		
		TextureAtlas atlas = this.assetManager.get(PFConstants.TextureObj.TEMPLATE_ATLAS);
		
		for(Texture t : atlas.getTextures()){
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}
		
		this.assetConfirmBtn = new AssetConfirmBtn(atlas);
		this.assetCancelBtn = new AssetCancelBtn(atlas);
		this.templateGuy = new TemplateGuy(atlas);
//		this.fonts = new Fonts();
	}
	
	@Override
	public void error(AssetDescriptor asset, Throwable throwable) {
		Gdx.app.error(TAG, "Couldn't load asset " + asset.fileName, (Exception)throwable );
	}

	@Override
	public void dispose() {
		this.assetManager.dispose();
//		this.fonts.smallFont.dispose();
//		this.fonts.normalFont.dispose();
//		this.fonts.largeFont.dispose();
	}

	public class AssetConfirmBtn{
		public final AtlasRegion btnConfirm;
		public AssetConfirmBtn(TextureAtlas atlas){
			btnConfirm = atlas.findRegion("greenBtn");
		}
	}
	
	public class AssetCancelBtn{
		public final AtlasRegion btnCancel;
		public AssetCancelBtn(TextureAtlas atlas){
			btnCancel = atlas.findRegion("redBtn");
		}
	}
	
	public class TemplateGuy{
		public final AtlasRegion templateGuy;
		public TemplateGuy(TextureAtlas atlas){
			templateGuy = atlas.findRegion("face");
		}
		
	}
	
//	public class Fonts{
//		public final BitmapFont smallFont;
//		public final BitmapFont normalFont;
//		public final BitmapFont largeFont;
//		
//		public Fonts(){
//			this.smallFont = new BitmapFont(Gdx.files.internal(PFConstants.ScreenSkin.FONT), true);
//			this.normalFont = new BitmapFont(Gdx.files.internal(PFConstants.ScreenSkin.FONT), true);
//			this.largeFont = new BitmapFont(Gdx.files.internal(PFConstants.ScreenSkin.FONT), true);
//			
//			this.smallFont.setScale(0.8f);
//			this.normalFont.setScale(1.0f);
//			this.largeFont.setScale(1.75f);
//			
//			this.smallFont.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
//			this.normalFont.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
//			this.largeFont.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
//		}
//		
//		
//	}
}


