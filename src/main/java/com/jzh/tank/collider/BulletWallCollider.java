package com.jzh.tank.collider;

import com.jzh.tank.GameModel;
import com.jzh.tank.entity.domain.BaseBullet;
import com.jzh.tank.entity.domain.GameObject;
import com.jzh.tank.entity.domain.Wall;

public class BulletWallCollider implements Collider {
    @Override
    public Boolean collide(GameModel gm, GameObject o1, GameObject o2) {
        if (o1 instanceof BaseBullet && o2 instanceof Wall) {
            BaseBullet b = (BaseBullet)o1;
            Wall w = (Wall)o2;
            if (b.getRectangle().intersects(w.getRectangle())) {
                b.setLiving(false);
                return false;
            }
        } else if (o1 instanceof Wall && o2 instanceof BaseBullet) {
            collide(gm, o2, o1);
        }
        return true;
    }
}
