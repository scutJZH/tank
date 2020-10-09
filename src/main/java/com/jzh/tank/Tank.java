package com.jzh.tank;

import lombok.Data;
import lombok.Setter;

import java.awt.*;

@Setter
@Data
public class Tank {
    private int x;
    private int y;
    private DirEnum dir;
    private boolean moving = false;
    private TankFrame tf;
    private static final int SPEED = 5;


    public Tank(Integer x, Integer y, DirEnum dir, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 50, 50);
        g.setColor(c);
        if (!moving) {
            return;
        }
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
            case LEFT_UP:
                x -= SPEED;
                y -= SPEED;
                break;
            case RIGHT_UP:
                x += SPEED;
                y -= SPEED;
                break;
            case LEFT_DOWN:
                x -= SPEED;
                y += SPEED;
                break;
            case RIGHT_DOWN:
                x += SPEED;
                y += SPEED;
                break;
            default:
                break;
        }
    }

    public void fire() {
        tf.getBulletList().add(new Bullet(this.x, this.y, this.dir));
    }
}
