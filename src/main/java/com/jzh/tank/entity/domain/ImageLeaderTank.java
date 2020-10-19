package com.jzh.tank.entity.domain;

import com.jzh.tank.GameModel;
import com.jzh.tank.entity.enumeration.DirEnum;
import com.jzh.tank.manager.ResourceMgr;
import sun.audio.AudioPlayer;

import java.awt.*;

public class ImageLeaderTank extends BaseTank {
    private static int SPEED = 2;
    private GameModel gameModel;

    public ImageLeaderTank(Integer x, Integer y, DirEnum dir, GameModel gameModel) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.living = true;
        this.moving = false;
        this.gameModel = gameModel;
        initTankBounds();
        rectangle.setBounds(x, y, width, height);
        this.preX = x;
        this.preY = y;
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
        if (!living) {
            return;
        }
        AudioPlayer.player.start(ImageLeaderTank.class.getClassLoader().getResourceAsStream("audios/tank_fire.wav"));
        gameModel.addElement(gameModel.getFactory().createBullet(this.dir, this));
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
        if (!living || !moving) {
            return;
        }
        // 发出声音
        AudioPlayer.player.start(ImageLeaderTank.class.getClassLoader().getResourceAsStream("audios/tank_move.wav"));
        preX = x;
        preY = y;

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
        rectangle.setBounds(x, y, width, height);
    }
}
