package com.jzh.tank;

import lombok.Data;

import java.awt.*;
import java.awt.image.BufferedImage;

@Data
public class Explode {
    private int x;
    private int y;
    private int counter = 0;
    private boolean living = true;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {
        if (counter < ResourceMgr.explodeImages.size()) {
            g.drawImage(ResourceMgr.explodeImages.get(counter++), x, y, null);
        } else {
            living = false;
        }
    }
}
