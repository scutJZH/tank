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
    private Tank belongsTo;

    public Bullet(DirEnum dir, Tank belongsTo) {
        this.dir = dir;
        this.belongsTo = belongsTo;
        switch (dir) {
            case UP:
                width = ResourceMgr.bulletUpImage.getWidth();
                height = ResourceMgr.bulletUpImage.getHeight();
                this.x = belongsTo.getX() + belongsTo.getWidth() / 2 - width / 2;
                this.y = belongsTo.getY() - height;
                break;
            case DOWN:
                width = ResourceMgr.bulletDownImage.getWidth();
                height = ResourceMgr.bulletDownImage.getHeight();
                this.x = belongsTo.getX() + belongsTo.getWidth() / 2 - width / 2;
                this.y = belongsTo.getY() + belongsTo.getHeight();
                break;
            case LEFT:
                width = ResourceMgr.bulletLeftImage.getWidth();
                height = ResourceMgr.bulletLeftImage.getHeight();
                this.x = belongsTo.getX() - width;
                this.y = belongsTo.getY() + belongsTo.getHeight() / 2 - height / 2;
                break;
            case RIGHT:
                width = ResourceMgr.bulletRightImage.getWidth();
                height = ResourceMgr.bulletRightImage.getHeight();
                this.x = belongsTo.getX() + belongsTo.getWidth();
                this.y = belongsTo.getY() + belongsTo.getHeight() / 2 - height / 2;
                break;
        }
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        switch (dir) {
            case UP:
                width = ResourceMgr.bulletUpImage.getWidth();
                height = ResourceMgr.bulletUpImage.getHeight();
                g.drawImage(ResourceMgr.bulletUpImage, x, y, null);
                break;
            case DOWN:
                width = ResourceMgr.bulletDownImage.getWidth();
                height = ResourceMgr.bulletDownImage.getHeight();
                g.drawImage(ResourceMgr.bulletDownImage, x, y, null);
                break;
            case LEFT:
                width = ResourceMgr.bulletLeftImage.getWidth();
                height = ResourceMgr.bulletLeftImage.getHeight();
                g.drawImage(ResourceMgr.bulletLeftImage, x, y, null);
                break;
            case RIGHT:
                width = ResourceMgr.bulletRightImage.getWidth();
                height = ResourceMgr.bulletRightImage.getHeight();
                g.drawImage(ResourceMgr.bulletRightImage, x, y, null);
                break;
        }
        g.setColor(c);
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

    public boolean strike(Tank tank) {
        if (belongsTo.equals(tank)) {
            return false;
        }
        Rectangle bulletRectangle = new Rectangle(x, y, width, height);
        Rectangle tankRectangle = new Rectangle(tank.getX(), tank.getY(), tank.getWidth(), tank.getHeight());
        if (bulletRectangle.intersects(tankRectangle)) {
            tank.setLiving(false);
            this.living = false;
            return true;
        }
        return false;
    }
}
