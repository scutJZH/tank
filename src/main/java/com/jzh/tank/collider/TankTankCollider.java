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
            if (t1.getRectangle().intersects(t2.getRectangle())) {
                t1.backToPreStep();
                t2.backToPreStep();
            }
        }
        return true;
    }
}
