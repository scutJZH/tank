package com.jzh.tank.entity.domain;

import com.jzh.tank.manage.ResourceMgr;
import lombok.Data;
import sun.audio.AudioPlayer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
        if (counter == 0) {
            try {
                AudioPlayer.player.start(new FileInputStream(new File(this.getClass().getResource("/").getPath() + "/audios/explode.wav")));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (counter < ResourceMgr.explodeImages.size()) {
            BufferedImage image = ResourceMgr.explodeImages.get(counter++);
            g.drawImage(image, x - image.getWidth() / 2, y - image.getHeight() / 2, null);
        } else {
            living = false;
        }
    }
}
