package com.jzh.tank.entity.domain;

import java.awt.*;

public class Wall extends GameObject {

    public Wall(Integer x, Integer y, Integer width, Integer height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.living = true;
        this.rectangle = new Rectangle(x, y , width, height);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.GRAY);
        g.fillRect(x, y, width, height);
        g.setColor(c);
    }
}
