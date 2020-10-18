package com.jzh.tank.collider;

import com.jzh.tank.GameModel;
import com.jzh.tank.entity.domain.BaseBullet;
import com.jzh.tank.entity.domain.BaseTank;
import com.jzh.tank.entity.domain.GameObject;

public class TankBulletCollider implements Collider {

    @Override
    public Boolean collide(GameModel gm, GameObject o1, GameObject o2) {
        if (o1 instanceof BaseBullet && o2 instanceof BaseTank) {
            BaseBullet bullet = (BaseBullet)o1;
            BaseTank tank = (BaseTank)o2;
            if (bullet.collid(tank)) {
                tank.setLiving(false);
                bullet.setLiving(false);
                gm.addElement(gm.getFactory().createExplode(tank.getX() + tank.getWidth() / 2, tank.getY() + tank.getHeight() / 2));
                return false;
            }
        } else if (o1 instanceof BaseTank && o2 instanceof BaseBullet) {
            return collide(gm, o2, o1);
        }
        return true;
    }
}
