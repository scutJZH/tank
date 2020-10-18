package com.jzh.tank.collider;

import com.jzh.tank.GameModel;
import com.jzh.tank.entity.domain.BaseTank;
import com.jzh.tank.entity.domain.GameObject;

public class TankTankCollider implements Collider {
    @Override
    public Boolean collide(GameModel gm, GameObject o1, GameObject o2) {
        if (o1 instanceof BaseTank && o2 instanceof BaseTank) {
            BaseTank t1 = (BaseTank)o1;
            BaseTank t2 = (BaseTank)o2;
            if (t1.collide(t2)) {
                t1.setLiving(false);
                t2.setLiving(false);
                gm.remove(t1);
                gm.remove(t2);
                gm.addElement(gm.getFactory().createExplode(t1.getX() + t1.getWidth() / 2, t1.getY() + t1.getHeight() / 2));
                gm.addElement(gm.getFactory().createExplode(t2.getX() + t2.getWidth() / 2, t2.getY() + t2.getHeight() / 2));
                return false;
            }
        }
        return true;
    }
}
