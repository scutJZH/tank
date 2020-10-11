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
    Rectangle bulletRectangle = new Rectangle();
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
        bulletRectangle.setBounds(this.x, this.y, this.width, this.height);
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
        }
        if (x < -width || x > TankFrame.GAME_WIDTH || y < -height || y > TankFrame.GAME_HEIGHT) {
            living = false;
        }
        bulletRectangle.setBounds(this.x, this.y, this.width, this.height);
    }

    public boolean strike(Tank tank) {
        if (belongsTo.equals(tank)) {
            return false;
        }
        if (bulletRectangle.intersects(tank.getTankRectangle())) {
            tank.setLiving(false);
            this.living = false;
            return true;
        }
        return false;
    }
}
