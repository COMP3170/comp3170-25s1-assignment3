package comp3170.ass3;

import comp3170.InputManager;
import comp3170.SceneObject;
import comp3170.ass3.sceneobjects.Boat;
import comp3170.ass3.sceneobjects.HeightMap;

public class Scene extends SceneObject {

	public Scene() {
		Boat boat = new Boat();
		boat.setParent(this);
		
		HeightMap map = new HeightMap();
		map.setParent(this);
	}
	
	public void update(float deltaTime, InputManager input) {

	}
	
}
