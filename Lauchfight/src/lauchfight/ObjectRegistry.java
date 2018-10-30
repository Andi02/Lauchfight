package lauchfight;

import java.util.ArrayList;
import java.util.List;

public class ObjectRegistry {
	private List<Object> objects = new ArrayList<Object>();
	private List<Object> objectReturn = new ArrayList<Object>();

	public List<Object> getNewObjects() {
		objectReturn = objects;
		return objectReturn;
	}

	public void setNewObjects(Object objectFromFactory) {
		this.objects.add(objectFromFactory);
	}

}
