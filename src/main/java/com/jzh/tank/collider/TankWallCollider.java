package com.jzh.tank.collider;

import com.jzh.tank.GameModel;
import com.jzh.tank.entity.domain.BaseTank;
import com.jzh.tank.entity.domain.GameObject;
import com.jzh.tank.entity.domain.Wall;

public class TankWallCollider implements Collider {
    @Override
    public Boolean collide(GameModel gm, GameObject o1, GameObject o2) {
        if (o1 instanceof BaseTank && o2 instanceof Wall) {
            BaseTank t = (BaseTank)o1;
            Wall w = (Wall)o2;
            if (t.getRectangle().intersects(w.getRectangle())) {
                t.backToPreStep();
            }
        } else if (o1 instanceof Wall && o2 instanceof BaseTank) {
            collide(gm, o2, o1);
        }
        return true;
    }
}
