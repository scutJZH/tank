package com.jzh.tank.entity.domain;

import com.jzh.tank.TankFrame;
import com.jzh.tank.entity.enumeration.DirEnum;

public abstract class BaseBullet extends GameObject {
    protected int SPEED = 5;
    protected DirEnum dir;
    protected BaseTank belongsTo;

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
        rectangle.setBounds(this.x, this.y, this.width, this.height);
    }

    public boolean collid(BaseTank tank) {
        if (belongsTo.equals(tank)) {
            return false;
        }
        return rectangle.intersects(tank.getRectangle());
    }
}
