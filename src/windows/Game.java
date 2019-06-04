package windows;


import framework.ObjectId;
import objects.TestObject;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = -3212233448875075669L;

    private boolean running = false;

    private Thread thread;

    Handler handler;

    Random random = new Random();

    private void init() {
        handler = new Handler();

        for (int i = 0; i < 50; i++) {

            handler.addObject(new TestObject(random.nextInt(1280), random.nextInt(720), ObjectId.Test));
        }
    }

    public synchronized void start() {
        if (running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();


    }

    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames + " TICKS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    private void tick() {
        handler.tick();

    }

    private void render() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics graphics = bufferStrategy.getDrawGraphics();
        ////////////////////////////////////////////////////
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, getWidth(), getHeight());

        handler.render(graphics);

        //DRAW HERE
        ////////////////////////////////////////////////////
        graphics.dispose();
        bufferStrategy.show();

    }


    public static void main(String[] args) {
        new Window(800, 600, "platfor1", new Game()) {


        };
    }
}
