package com.jzh.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame f = new TankFrame();
        for(int i = 0; i < 5; i++) {
            f.getEnemies().add(new Tank(i * 80, 400, DirEnum.UP, true, Group.ENEMY, f));
        }

        while (true) {
            Thread.sleep(50);
            f.repaint();
        }

    }
}