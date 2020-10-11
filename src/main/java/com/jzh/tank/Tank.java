package com.jzh.tank;

import lombok.Data;
import lombok.Setter;
import sun.audio.AudioPlayer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

@Setter
@Data
public class Tank {
    private int x;
    private int y;
    private DirEnum dir;
    private boolean moving = false;
    private TankFrame tf;
    private static final int SPEED = 2;
    private int width;
    private int height;
    private boolean living = true;
    private Group group;

    public Tank(Integer x, Integer y, DirEnum dir, Group group, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public Tank(Integer x, Integer y, DirEnum dir, Boolean moving, Group group, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
        this.moving = moving;
    }

    public void paint(Graphics g) {
        if (Group.ENEMY.equals(group)) {
            enemyPaint(g);
        } else if (Group.SELF.equals(group)) {
            myTankPaint(g);
        }
        move();
    }

    private void enemyPaint(Graphics g) {
        switch (dir) {
            case UP:
                g.drawImage(ResourceMgr.tankUpImage, x, y, null);
                width = ResourceMgr.tankUpImage.getWidth();
                height = ResourceMgr.tankUpImage.getHeight();
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankDownImage, x, y, null);
                width = ResourceMgr.tankDownImage.getWidth();
                height = ResourceMgr.tankDownImage.getHeight();
                break;
            case LEFT:
                g.drawImage(ResourceMgr.tankLeftImage, x, y, null);
                width = ResourceMgr.tankLeftImage.getWidth();
                height = ResourceMgr.tankLeftImage.getHeight();
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankRightImage, x, y, null);
                width = ResourceMgr.tankRightImage.getWidth();
                height = ResourceMgr.tankRightImage.getHeight();
                break;
            case LEFT_UP:
                g.drawImage(ResourceMgr.tankLeftUpImage, x, y, null);
                width = ResourceMgr.tankLeftUpImage.getWidth();
                height = ResourceMgr.tankLeftUpImage.getHeight();
                break;
            case RIGHT_UP:
                g.drawImage(ResourceMgr.tankRightUpImage, x, y, null);
                width = ResourceMgr.tankRightUpImage.getWidth();
                height = ResourceMgr.tankRightUpImage.getHeight();
                break;
            case LEFT_DOWN:
                g.drawImage(ResourceMgr.tankLeftDownImage, x, y, null);
                width = ResourceMgr.tankLeftDownImage.getWidth();
                height = ResourceMgr.tankLeftDownImage.getHeight();
                break;
            case RIGHT_DOWN:
                g.drawImage(ResourceMgr.tankRightDownImage, x, y, null);
                width = ResourceMgr.tankRightDownImage.getWidth();
                height = ResourceMgr.tankRightDownImage.getHeight();
                break;
        }
    }

    private void myTankPaint(Graphics g) {
        switch (dir) {
            case UP:
                g.drawImage(ResourceMgr.myTankUpImage, x, y, null);
                width = ResourceMgr.myTankUpImage.getWidth();
                height = ResourceMgr.myTankUpImage.getHeight();
                break;
            case DOWN:
                g.drawImage(ResourceMgr.myTankDownImage, x, y, null);
                width = ResourceMgr.myTankDownImage.getWidth();
                height = ResourceMgr.myTankDownImage.getHeight();
                break;
            case LEFT:
                g.drawImage(ResourceMgr.myTankLeftImage, x, y, null);
                width = ResourceMgr.myTankLeftImage.getWidth();
                height = ResourceMgr.myTankLeftImage.getHeight();
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.myTankRightImage, x, y, null);
                width = ResourceMgr.myTankRightImage.getWidth();
                height = ResourceMgr.myTankRightImage.getHeight();
                break;
            case LEFT_UP:
                g.drawImage(ResourceMgr.myTankLeftUpImage, x, y, null);
                width = ResourceMgr.myTankLeftUpImage.getWidth();
                height = ResourceMgr.myTankLeftUpImage.getHeight();
                break;
            case RIGHT_UP:
                g.drawImage(ResourceMgr.myTankRightUpImage, x, y, null);
                width = ResourceMgr.myTankRightUpImage.getWidth();
                height = ResourceMgr.myTankRightUpImage.getHeight();
                break;
            case LEFT_DOWN:
                g.drawImage(ResourceMgr.myTankLeftDownImage, x, y, null);
                width = ResourceMgr.myTankLeftDownImage.getWidth();
                height = ResourceMgr.myTankLeftDownImage.getHeight();
                break;
            case RIGHT_DOWN:
                g.drawImage(ResourceMgr.myTankRightDownImage, x, y, null);
                width = ResourceMgr.myTankRightDownImage.getWidth();
                height = ResourceMgr.myTankRightDownImage.getHeight();
                break;
        }
    }

    private void move() {
        if (!moving) {
            return;
        }
        // 发出声音
        try {
            AudioPlayer.player.start(new FileInputStream(new File(this.getClass().getResource("/").getPath() + "/audios/tank_move.wav")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case LEFT_UP:
                x -= SPEED;
                y -= SPEED;
                break;
            case RIGHT_UP:
                x += SPEED;
                y -= SPEED;
                break;
            case LEFT_DOWN:
                x -= SPEED;
                y += SPEED;
                break;
            case RIGHT_DOWN:
                x += SPEED;
                y += SPEED;
                break;
            default:
                break;
        }
        if (Group.ENEMY.equals(this.group)) {
            if (Math.random() > 0.99) {
                fire();
            }
            if (Math.random() > 0.95) {
                randomDir();
            }
        }
    }

    public void fire() {
        if (DirEnum.RIGHT.equals(dir) || DirEnum.UP.equals(dir) || DirEnum.LEFT.equals(dir) || DirEnum.DOWN.equals(dir)) {
            tf.getBulletList().add(new Bullet(this.dir, this));
            try {
                AudioPlayer.player.start(new FileInputStream(new File(this.getClass().getResource("/").getPath() + "/audios/tank_fire.wav")));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    private void randomDir() {
        this.dir = DirEnum.values()[(int)(Math.random() * DirEnum.values().length)];
    }
}
