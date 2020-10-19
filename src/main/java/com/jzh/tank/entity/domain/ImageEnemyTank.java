package com.jzh.tank.entity.domain;

import com.jzh.tank.GameModel;
import com.jzh.tank.entity.enumeration.DirEnum;
import com.jzh.tank.manager.ResourceMgr;
import sun.audio.AudioPlayer;

import java.awt.*;

public class ImageEnemyTank extends BaseTank {
    private GameModel gameModel;
    private static int SPEED = 2;

    public ImageEnemyTank(Integer x, Integer y, DirEnum dir, GameModel gameModel) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.gameModel = gameModel;
        this.living = true;
        this.moving = false;
        initTankBounds();
        this.rectangle.setBounds(x, y, width, height);
        this.moving = true;
        this.preX = x;
        this.preY = y;
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
        if (!living) {
            return;
        }
        gameModel.addElement(gameModel.getFactory().createBullet(this.dir, this));
        AudioPlayer.player.start(ImageEnemyTank.class.getClassLoader().getResourceAsStream("audios/tank_fire.wav"));
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
        if (!living || !moving) {
            return;
        }
        // 发出声音
//        AudioPlayer.player.start(ImageEnemyTank.class.getClassLoader().getResourceAsStream("audios/tank_move.wav"));
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

        if (Math.random() > 0.95) {
            randomDir();
        }
        if (Math.random() > 0.99) {
            fire();
        }
        bounderCheck();
        rectangle.setBounds(x, y, width, height);
    }

    private void randomDir() {
        this.dir = DirEnum.values()[(int)(Math.random() * DirEnum.values().length)];
    }
}
