package com.jzh.tank.entity.domain;

import com.jzh.tank.entity.enumeration.DirEnum;

import java.awt.*;

public class RectBullet extends BaseBullet {
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;

    public RectBullet(DirEnum dir, BaseTank belongsTo) {
        this.dir = dir;
        this.belongsTo = belongsTo;
        this.living = true;
        this.width = WIDTH;
        this.height = HEIGHT;
        switch (dir) {
            case UP:
                this.x = belongsTo.getX() + belongsTo.getWidth() / 2 - width / 2;
                this.y = belongsTo.getY() - height;
                break;
            case DOWN:
                this.x = belongsTo.getX() + belongsTo.getWidth() / 2 - width / 2;
                this.y = belongsTo.getY() + belongsTo.getHeight();
                break;
            case LEFT:
                this.x = belongsTo.getX() - width;
                this.y = belongsTo.getY() + belongsTo.getHeight() / 2 - height / 2;
                break;
            case RIGHT:
                this.x = belongsTo.getX() + belongsTo.getWidth();
                this.y = belongsTo.getY() + belongsTo.getHeight() / 2 - height / 2;
                break;
        }
        rectangle.setBounds(this.x, this.y, width, height);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
        g.setColor(c);
        move();
    }
}
