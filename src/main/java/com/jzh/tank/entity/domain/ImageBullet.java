package com.jzh.tank.entity.domain;

import com.jzh.tank.entity.enumeration.DirEnum;
import com.jzh.tank.manage.ResourceMgr;

import java.awt.*;

public class ImageBullet extends BaseBullet {

    public ImageBullet(DirEnum dir, BaseTank belongsTo) {
        super(dir, belongsTo);
        switch (dir) {
            case UP:
                width = ResourceMgr.bulletUpImage.getWidth();
                height = ResourceMgr.bulletUpImage.getHeight();
                this.x = belongsTo.getX() + belongsTo.getWidth() / 2 - width / 2;
                this.y = belongsTo.getY() - height;
                break;
            case DOWN:
                width = ResourceMgr.bulletDownImage.getWidth();
                height = ResourceMgr.bulletDownImage.getHeight();
                this.x = belongsTo.getX() + belongsTo.getWidth() / 2 - width / 2;
                this.y = belongsTo.getY() + belongsTo.getHeight();
                break;
            case LEFT:
                width = ResourceMgr.bulletLeftImage.getWidth();
                height = ResourceMgr.bulletLeftImage.getHeight();
                this.x = belongsTo.getX() - width;
                this.y = belongsTo.getY() + belongsTo.getHeight() / 2 - height / 2;
                break;
            case RIGHT:
                width = ResourceMgr.bulletRightImage.getWidth();
                height = ResourceMgr.bulletRightImage.getHeight();
                this.x = belongsTo.getX() + belongsTo.getWidth();
                this.y = belongsTo.getY() + belongsTo.getHeight() / 2 - height / 2;
                break;
        }
        bulletRectangle.setBounds(this.x, this.y, this.width, this.height);
    }

    @Override
    public void paint(Graphics g) {
        switch (dir) {
            case UP:
                width = ResourceMgr.bulletUpImage.getWidth();
                height = ResourceMgr.bulletUpImage.getHeight();
                g.drawImage(ResourceMgr.bulletUpImage, x, y, null);
                break;
            case DOWN:
                width = ResourceMgr.bulletDownImage.getWidth();
                height = ResourceMgr.bulletDownImage.getHeight();
                g.drawImage(ResourceMgr.bulletDownImage, x, y, null);
                break;
            case LEFT:
                width = ResourceMgr.bulletLeftImage.getWidth();
                height = ResourceMgr.bulletLeftImage.getHeight();
                g.drawImage(ResourceMgr.bulletLeftImage, x, y, null);
                break;
            case RIGHT:
                width = ResourceMgr.bulletRightImage.getWidth();
                height = ResourceMgr.bulletRightImage.getHeight();
                g.drawImage(ResourceMgr.bulletRightImage, x, y, null);
                break;
        }
        move();
    }

}
