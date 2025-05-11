package comp3170.ass3.sceneobjects;

import java.io.FileNotFoundException;

import comp3170.GLBuffers;
import comp3170.SceneObject;
import comp3170.ass3.models.MeshData;
import comp3170.ass3.models.MeshData.Mesh;

public class Boat extends SceneObject {

	private static final String OBJ_FILE = "src/comp3170/ass3/models/boat.obj";
	
	private int vertexBuffer;
	private int indexBuffer;
	
	public Boat()
	{
		// Load the boat OBJ file
		
		MeshData data = null;
		
		try {
			data = new MeshData(OBJ_FILE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 

		// Access the vertex and index buffers for the 'boat' submesh:
		
		Mesh mesh = data.getMesh("boat");
		vertexBuffer = GLBuffers.createBuffer(mesh.vertices);
		indexBuffer = GLBuffers.createIndexBuffer(mesh.indices);		
	}

	// COMPLETE THIS CLASS


}
