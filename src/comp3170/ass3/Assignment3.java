package comp3170.ass3;



import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_LEQUAL;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glClearDepth;
import static org.lwjgl.opengl.GL11.glDepthFunc;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glPointSize;
import static org.lwjgl.opengl.GL32.GL_PROGRAM_POINT_SIZE;

import java.io.File;

import comp3170.IWindowListener;
import comp3170.InputManager;
import comp3170.OpenGLException;
import comp3170.ShaderLibrary;
import comp3170.TextureLibrary;
import comp3170.Window;

public class Assignment3 implements IWindowListener {

	public static Assignment3 theWindow;
	private static final File SHADER_DIR = new File("src/comp3170/ass3/shaders");
	private static final File TEXTURE_DIR = new File("src/comp3170/ass3/textures");

	private Window window;
	private int screenWidth = 800;
	private int screenHeight = 800;
	private Scene scene;

	private InputManager input;
	private long oldTime;


	public Assignment3() throws OpenGLException {
		window = new Window("Assignment3", screenWidth, screenHeight, this);
		window.run();		
	}


	@Override
	public void init() {
		glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

		new ShaderLibrary(SHADER_DIR);
		new TextureLibrary(TEXTURE_DIR);
		scene = new Scene();
		
		// initialise oldTime
		input = new InputManager(window);
		oldTime = System.currentTimeMillis();
	}

	private void update() {
		long time = System.currentTimeMillis();
		float deltaTime = (time - oldTime) / 1000f;
		oldTime = time;
		
		// update the scene
		scene.update(deltaTime, input);
		// clear the input at the end of each update
		input.clear();
	}

	@Override
	public void draw() {		
		update();
		
		glClear(GL_COLOR_BUFFER_BIT);		
		scene.draw();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void close() {
	}

	public static void main(String[] args) throws OpenGLException {
		new Assignment3();
	}
}
