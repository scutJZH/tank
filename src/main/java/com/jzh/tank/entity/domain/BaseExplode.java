package com.jzh.tank.entity.domain;

import lombok.Data;

import java.awt.*;

@Data
public abstract class BaseExplode {
    protected int x;
    protected int y;
    protected int counter = 0;
    protected boolean living = true;

    public BaseExplode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void paint(Graphics g);
}
