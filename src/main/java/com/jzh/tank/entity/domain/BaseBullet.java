package com.jzh.tank.entity.domain;

import com.jzh.tank.TankFrame;
import com.jzh.tank.entity.enumeration.DirEnum;
import lombok.Data;

import java.awt.*;

@Data
public abstract class BaseBullet {
    protected int SPEED = 5;
    protected int width;
    protected int height;
    protected int x;
    protected int y;
    protected DirEnum dir;
    protected boolean living = true;
    protected Rectangle bulletRectangle = new Rectangle();
    protected BaseTank belongsTo;

    public BaseBullet(DirEnum dir, BaseTank belongsTo) {
        this.dir = dir;
        this.belongsTo = belongsTo;
    }

    public abstract void paint(Graphics g);

    public void move() {
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

    public boolean strike(BaseTank tank) {
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
