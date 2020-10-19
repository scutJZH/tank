package com.jzh.tank.collider;

import com.jzh.tank.GameModel;
import com.jzh.tank.entity.domain.GameObject;

import java.util.LinkedList;
import java.util.List;

public class ColliderChain implements Collider {

    private List<Collider> colliderList;

    public static ColliderChain getInstance() {
        return Inner.COLLIER_CHAIN;
    }

    private ColliderChain() {
        colliderList = new LinkedList<>();
        colliderList.add(new TankBulletCollider());
        colliderList.add(new TankTankCollider());
        colliderList.add(new TankWallCollider());
        colliderList.add(new BulletWallCollider());
    }

    @Override
    public Boolean collide(GameModel gm, GameObject o1, GameObject o2) {
        for (Collider collider : colliderList) {
            if (!collider.collide(gm, o1, o2)) {
                return false;
            }
        }
        return true;
    }

    private static class Inner {
        private static final ColliderChain COLLIER_CHAIN = new ColliderChain();
    }
}
