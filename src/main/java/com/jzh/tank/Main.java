package com.jzh.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame f = new TankFrame();
        while (true) {
            Thread.sleep(20);
            f.repaint();
        }

    }
}