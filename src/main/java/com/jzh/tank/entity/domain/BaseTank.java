package com.jzh.tank.entity.domain;

import com.jzh.tank.TankFrame;
import com.jzh.tank.entity.enumeration.DirEnum;
import lombok.Data;

@Data
public abstract class BaseTank extends GameObject {
    protected DirEnum dir;
    protected Boolean moving;
    protected int preX;
    protected int preY;

    public abstract void fire();

    public abstract void move();

    protected abstract void initTankBounds();

    protected void bounderCheck() {
        if (x < 0) {
            x = 0;
        }
        if (x > TankFrame.GAME_WIDTH - width) {
            x = TankFrame.GAME_WIDTH - width;
        }
        if (y < height / 2) {
            y = height / 2;
        }
        if (y > TankFrame.GAME_HEIGHT - height) {
            y = TankFrame.GAME_HEIGHT - height;
        }
    }

    public void backToPreStep() {
        this.x = preX;
        this.y = preY;
    }
}
