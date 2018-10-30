package lauchfight;

import java.util.List;

public class ObjectRegistry {
	private List<Object> objects;
	private List<Object> objectReturn;

	public List<Object> getNewObjects() {
		objectReturn = objects;
		objects.clear();
		return objectReturn;
	}

	public void setNewObjects(Object objectFromFactory) {
		this.objects.add(objectFromFactory);
	}

}
