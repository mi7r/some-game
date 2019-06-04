package framework;

import java.awt.*;
import java.util.LinkedList;

public abstract class GameObject {

    protected float x, y;
    protected ObjectId id;
    protected float velX = 0, velY = 0;

    public GameObject(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public abstract void tick(LinkedList<GameObject> objects);
    public abstract void render(Graphics graphics);

    public abstract float getX();
    public abstract float getY();
    public abstract void setX(float x);
    public abstract void setY(float y);

    public abstract float getVelX();
    public abstract float getVelY();
    public abstract void setVelX(float velX);
    public abstract void setVelY(float velY);

    public abstract ObjectId getId();
}
