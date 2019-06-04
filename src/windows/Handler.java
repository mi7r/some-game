package windows;

import framework.GameObject;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    public LinkedList<GameObject> gameObjects = new LinkedList<>();

    private GameObject tempObject;

    public void tick() {
        for (int i = 0; i < gameObjects.size(); i++) {
            tempObject = gameObjects.get(i);
            tempObject.tick(gameObjects);
        }
    }

    public void render(Graphics graphics) {
        for (int i = 0; i < gameObjects.size(); i++) {
            tempObject = gameObjects.get(i);
            tempObject.render(graphics);
        }
    }

    public void addObject(GameObject object) {
        this.gameObjects.add(object);
    }

    public void removeObject(GameObject object) {
        this.gameObjects.remove(object);
    }
}
