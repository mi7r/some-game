package source.game;

import java.awt.*;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = -3212233448875075669L;

    private boolean running = false;

    private Thread thread;

    public synchronized void start() {
        if (running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();


    }

    @Override
    public void run() {

        System.out.println("Thread is running");

    }


    public static void main(String[] args) {
        new Window(800, 600, "platfor1", new Game()) {


        };
    }
}