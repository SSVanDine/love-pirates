package com.pirates.game;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
class MyUtils {
	private static ShapeRenderer debugRenderer = new ShapeRenderer();
	static int imageCount = 0;
	static void visuliseArray(double[][] a, boolean b) {
		Pixmap toSave = new Pixmap(a.length, a.length, Pixmap.Format.RGB565);
		if (!b){
			for (int i = 0; i<(a.length); i++) {
				for (int j = 0; j<(a.length); j++) {
					Color c = new Color();
					double r = a[i][j];
					if (r<.75) {
						r = 0;
					}
					c.set((float) r, (float) a[i][j]/2, (float) a[i][j]/3,1f);
					toSave.drawPixel(i,j,Color.rgba8888(c));
				}
			}
		} else {
			for (int i = 0; i<(a.length); i++) {
				for (int j = 0; j<(a.length); j++) {
					Color c = new Color();
					double r = a[i][j];
					c.set((float) r, (float) a[i][j]/2, (float) a[i][j]/3,1f);
					toSave.drawPixel(i,j,Color.rgba8888(c));
				}
			}
		}
		String filename = "heightmap"+imageCount+".png";
		FileHandle handle = Gdx.files.local(filename);
		imageCount++;
		PixmapIO.writePNG(handle,toSave);
		toSave.dispose();
	}
	public static void DrawDebugLine(Vector2 start,
			Vector2 end) {
	    Gdx.gl.glLineWidth(1);
	    debugRenderer.setProjectionMatrix(LovePirates.camera.combined);
	    debugRenderer.begin(ShapeRenderer.ShapeType.Line);
	    debugRenderer.setColor(Color.WHITE);
	    debugRenderer.line(start, end);
	    debugRenderer.end();
	    Gdx.gl.glLineWidth(1);
	}
}