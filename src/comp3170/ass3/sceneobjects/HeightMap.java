package comp3170.ass3.sceneobjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import comp3170.SceneObject;

public class HeightMap extends SceneObject {

	private static final File HEIGHT_MAP = new File("src/comp3170/ass3/maps/islands.png");
	private int width;
	private int depth;
	private float[][] heights;


	public HeightMap() {
		// load the vertex heights from the image

		loadHeights(HEIGHT_MAP);

		// TODO: Turn this data into a height map mesh
		
	}

	/**
	 * Load the height data. This sets the values of the fields:
	 *
	 *    (width, depth) are set to the (x,y) image size, 
	 *    which should equal the number of vertices in each direction
	 *    
	 *    heights[i][j] is set to the value of the pixel at coordinates (i,j).
	 *    This is a float between 0 and 1, corresponding to the minimum and maximum height values. 
	 * 
	 * @param imageFile
	 */
	
	private void loadHeights(File imageFile) {
		BufferedImage mapImage;
		try {
			mapImage = ImageIO.read(imageFile);

			width = mapImage.getWidth();
			depth = mapImage.getHeight();

			heights = new float[width][depth];
			int n = 0;

			for (int x = 0; x < width; x++) {
				for (int z = 0; z < depth; z++) {
					int rgb = mapImage.getRGB(x, z);
					int r = (rgb & 0xff0000) >> 16;
					int g = (rgb & 0xff00) >> 8;
					int b = rgb & 0xff;

					// scale to [0...1]
					heights[x][z] = (r + g + b) / 255f / 3;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
