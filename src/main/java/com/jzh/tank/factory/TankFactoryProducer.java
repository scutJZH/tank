package com.jzh.tank.factory;

import com.jzh.tank.entity.enumeration.TankFactoryNameEnum;

public class TankFactoryProducer {
    public static TankFactory getTankFactory(TankFactoryNameEnum tankFactoryName) {
        switch (tankFactoryName) {
            case ENEMY_TANK_FACTORY:
                return EnemyTankFactory.getInstance();
            case LEADER_TANK_FACTORY:
                return LeaderTankFactory.getInstance();
            default:
                return null;
        }
    }
}
