package com.jzh.tank;

import lombok.Data;

import java.awt.*;

@Data
public class Bullet {
    public static final int SPEED = 5;
    private int width;
    private int height;
    private int x;
    private int y;
    private DirEnum dir;
    private boolean living = true;

    public Bullet(int x, int y, DirEnum dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        switch (dir) {
            case UP:
                width = ResourceMgr.bulletUpImage.getWidth();
                height = ResourceMgr.bulletUpImage.getHeight();
                g.drawImage(ResourceMgr.bulletUpImage, x - width / 2, y - height / 2, null);
                break;
            case DOWN:
                width = ResourceMgr.bulletDownImage.getWidth();
                height = ResourceMgr.bulletDownImage.getHeight();
                g.drawImage(ResourceMgr.bulletDownImage, x - width / 2, y - height / 2, null);
                break;
            case LEFT:
                width = ResourceMgr.bulletLeftImage.getWidth();
                height = ResourceMgr.bulletLeftImage.getHeight();
                g.drawImage(ResourceMgr.bulletLeftImage, x - width / 2, y - height / 2, null);
                break;
            case RIGHT:
                width = ResourceMgr.bulletRightImage.getWidth();
                height = ResourceMgr.bulletRightImage.getHeight();
                g.drawImage(ResourceMgr.bulletRightImage, x - width / 2, y - height / 2, null);
                break;
        }
        move();
    }

    private void move() {
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
        if (x < 0 || x > TankFrame.GAME_WIDTH || y < 0 || y > TankFrame.GAME_HEIGHT) {
            living = false;
        }
    }

    public void strike(Tank tank) {
        Rectangle bulletRectangle = new Rectangle(x, y, width, height);
        Rectangle tankRectangle = new Rectangle(tank.getX(), tank.getY(), tank.getWidth(), tank.getHeight());
        if (bulletRectangle.intersects(tankRectangle)) {
            tank.setLiving(false);
        }
    }
}
