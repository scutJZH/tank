package com.jzh.tank.entity.domain;

import com.jzh.tank.TankFrame;
import com.jzh.tank.entity.enumeration.DirEnum;
import com.jzh.tank.manage.ResourceMgr;
import sun.audio.AudioPlayer;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageLeaderBaseTank extends BaseTank {
    public ImageLeaderBaseTank(Integer x, Integer y, DirEnum dir, TankFrame tf) {
        super(x, y, dir, tf);
    }

    @Override
    public void paint(Graphics g) {
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
                width = ResourceMgr.myTankUpImage.getWidth();
                height = ResourceMgr.myTankUpImage.getHeight();
                break;
            case DOWN:
                width = ResourceMgr.myTankDownImage.getWidth();
                height = ResourceMgr.myTankDownImage.getHeight();
                break;
            case LEFT:
                width = ResourceMgr.myTankLeftImage.getWidth();
                height = ResourceMgr.myTankLeftImage.getHeight();
                break;
            case RIGHT:
                width = ResourceMgr.myTankRightImage.getWidth();
                height = ResourceMgr.myTankRightImage.getHeight();
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

        bounderCheck();
        tankRectangle.setBounds(x, y, width, height);
    }
}
