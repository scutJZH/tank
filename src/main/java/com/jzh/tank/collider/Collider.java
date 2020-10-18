package com.jzh.tank.collider;

import com.jzh.tank.GameModel;
import com.jzh.tank.entity.domain.GameObject;

public interface Collider {
    Boolean collide(GameModel gm, GameObject o1, GameObject o2);
}