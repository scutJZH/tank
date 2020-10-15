package com.jzh.tank.entity.domain;

import com.jzh.tank.TankFrame;
import com.jzh.tank.entity.enumeration.DirEnum;
import com.jzh.tank.manage.ResourceMgr;
import sun.audio.AudioPlayer;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageEnemyBaseTank extends BaseTank {
    public ImageEnemyBaseTank(Integer x, Integer y, DirEnum dir, TankFrame tf) {
        super(x, y, dir, tf);
        this.moving = true;
    }

    @Override
    public void paint(Graphics g) {
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
        }
        move();
    }

    @Override
    public void fire() {
        tf.getBulletList().add(tf.getTankFactory().createBullet(this.dir, this));
        try {
            AudioPlayer.player.start(new FileInputStream(new File(this.getClass().getResource("/").getPath() + "/audios/tank_fire.wav")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initTankBounds() {
        switch (dir) {
            case UP:
                width = ResourceMgr.tankUpImage.getWidth();
                height = ResourceMgr.tankUpImage.getHeight();
                break;
            case DOWN:
                width = ResourceMgr.tankDownImage.getWidth();
                height = ResourceMgr.tankDownImage.getHeight();
                break;
            case LEFT:
                width = ResourceMgr.tankLeftImage.getWidth();
                height = ResourceMgr.tankLeftImage.getHeight();
                break;
            case RIGHT:
                width = ResourceMgr.tankRightImage.getWidth();
                height = ResourceMgr.tankRightImage.getHeight();
                break;
        }
    }

    @Override
    public void move() {
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
            default:
                break;
        }

        if (Math.random() > 0.95) {
            randomDir();
        }
        if (Math.random() > 0.99) {
            fire();
        }
        bounderCheck();
        tankRectangle.setBounds(x, y, width, height);
    }
}
