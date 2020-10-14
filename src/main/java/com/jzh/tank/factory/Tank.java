package com.jzh.tank.factory;

import com.jzh.tank.TankFrame;
import com.jzh.tank.entity.enumeration.DirEnum;
import lombok.Data;

import java.awt.*;

@Data
public abstract class Tank {
    protected int x;
    protected int y;
    protected DirEnum dir;
    protected boolean moving = false;
    protected TankFrame tf;
    protected int SPEED = 2;
    protected int width;
    protected int height;
    protected boolean living = true;
    protected Rectangle tankRectangle = new Rectangle();

    public abstract void paint(Graphics g);

    public abstract void fire();

    public abstract void move();

    public Tank(Integer x, Integer y, DirEnum dir, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        initTankBounds();
        tankRectangle.setBounds(x, y, width, height);
    }

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

    protected void randomDir() {
        this.dir = DirEnum.values()[(int)(Math.random() * DirEnum.values().length)];
    }

}
