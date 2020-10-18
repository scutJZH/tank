package com.jzh.tank.entity.domain;

import com.jzh.tank.manager.ResourceMgr;
import sun.audio.AudioPlayer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageExplode extends BaseExplode {
    private int counter;

    public ImageExplode(int x, int y) {
        this.x = x;
        this.y = y;
        this.living = true;
        this.counter = 0;
    }

    @Override
    public void paint(Graphics g) {
        if (counter == 0) {
            AudioPlayer.player.start(ImageExplode.class.getClassLoader().getResourceAsStream("audios/explode.wav"));
        }
        if (counter < ResourceMgr.explodeImages.size()) {
            BufferedImage image = ResourceMgr.explodeImages.get(counter++);
            g.drawImage(image, x - image.getWidth() / 2, y - image.getHeight() / 2, null);
        } else {
            living = false;
        }
    }
}
