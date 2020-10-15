package com.jzh.tank;

import com.jzh.tank.entity.domain.*;
import com.jzh.tank.entity.enumeration.DirEnum;
import com.jzh.tank.factory.TankFactory;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TankFrame extends Frame {
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    private List<BaseBullet> bulletList;
    private List<BaseTank> enemies;
    private List<BaseExplode> explodes;
    private TankFactory tankFactory;
    private BaseTank myTank;

    public TankFrame(TankFactory tankFactory) {
        setVisible(true);
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new MyKeyListener());
        this.bulletList = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.explodes  = new ArrayList<>();
        this.tankFactory = tankFactory;
        this.myTank = tankFactory.createLeaderTank(200, 200, DirEnum.RIGHT, this);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹数量：" + bulletList.size(), 100, 100);
        g.drawString("敌人数量：" + enemies.size(), 100, 300);
        g.setColor(c);
        myTank.paint(g);

        Iterator<BaseBullet> bulletIterator = bulletList.iterator();
        while (bulletIterator.hasNext()) {
            BaseBullet bullet = bulletIterator.next();
            if (bullet.isLiving()) {
                bullet.paint(g);
            } else {
                bulletIterator.remove();
            }
        }

        Iterator<BaseTank> tankIterator = enemies.iterator();
        while (tankIterator.hasNext()) {
            BaseTank enemy = tankIterator.next();
            if (enemy.isLiving()) {
                enemy.paint(g);
            } else {
                tankIterator.remove();
            }
        }

        for (BaseBullet bullet : bulletList) {
            for (BaseTank tank : enemies) {
                if (bullet.strike(tank)) {
                    explodes.add(tankFactory.createExplode(tank.getX() + tank.getWidth() / 2, tank.getY() + tank.getHeight() / 2));
                }
            }
        }

        Iterator<BaseExplode> explodeIterator = explodes.listIterator();
        while (explodeIterator.hasNext()) {
            BaseExplode explode = explodeIterator.next();
            if (explode.isLiving()) {
                explode.paint(g);
            } else {
                explodeIterator.remove();
            }

        }
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH,GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    private class MyKeyListener extends KeyAdapter {

        private boolean bL = false;
        private boolean bR = false;
        private boolean bU = false;
        private boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                default:
                    break;
            }
            setTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            setTankDir();
        }

        private void setTankDir() {
            if (!(bL || bR || bU || bD)) {
                myTank.setMoving(false);
                return;
            }
            myTank.setMoving(true);
            if (bR) {
                myTank.setDir(DirEnum.RIGHT);
            } else if (bL) {
                myTank.setDir(DirEnum.LEFT);
            } else if (bU) {
                myTank.setDir(DirEnum.UP);
            } else if (bD) {
                myTank.setDir(DirEnum.DOWN);
            }
        }
    }

    public List<BaseBullet> getBulletList() {
        return this.bulletList;
    }

    public List<BaseTank> getEnemies() {
        return this.enemies;
    }

    public TankFactory getTankFactory() {
        return tankFactory;
    }
}
