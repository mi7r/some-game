package objects;

import framework.GameObject;
import framework.ObjectId;

import java.awt.*;
import java.util.LinkedList;

public class TestObject extends GameObject {

    public TestObject(float x, float y, ObjectId test) {
        super(x, y);
    }

    @Override
    public void tick(LinkedList<GameObject> objects) {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect((int)x,(int)y,32,32);

    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public float getVelX() {
        return velX;
    }

    @Override
    public float getVelY() {
        return velY;
    }

    @Override
    public void setVelX(float velX) {
        this.velX = velX;
    }

    @Override
    public void setVelY(float velY) {
        this.velY = velY;
    }

    @Override
    public ObjectId getId() {
        return id;
    }
}
