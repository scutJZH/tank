package com.jzh.tank.factory;

import com.jzh.tank.TankFrame;
import com.jzh.tank.entity.domain.EnemyTank;
import com.jzh.tank.entity.enumeration.DirEnum;

public class EnemyTankFactory extends TankFactory {

    private EnemyTankFactory() {}

    public static EnemyTankFactory getInstance() {
        return InnerClass.enemyTankFactory;
    }

    private static class InnerClass {
        public static final EnemyTankFactory enemyTankFactory = new EnemyTankFactory();
    }

    @Override
    public Tank createTank(Integer x, Integer y, DirEnum dir, TankFrame tf) {
        return new EnemyTank(x, y, dir, tf);
    }
}
