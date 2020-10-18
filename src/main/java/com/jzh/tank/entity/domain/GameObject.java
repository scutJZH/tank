package com.jzh.tank.entity.domain;

import lombok.Data;

import java.awt.*;

@Data
public abstract class GameObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean living;
    protected Rectangle rectangle = new Rectangle();

    public abstract void paint(Graphics g);
}
