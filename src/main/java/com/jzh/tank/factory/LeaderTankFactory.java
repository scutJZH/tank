package com.jzh.tank.factory;

import com.jzh.tank.TankFrame;
import com.jzh.tank.entity.domain.LeaderTank;
import com.jzh.tank.entity.enumeration.DirEnum;

public class LeaderTankFactory extends TankFactory {

    private LeaderTankFactory() {}

    public static LeaderTankFactory getInstance() {
        return LeaderTankFactory.InnerClass.enemyTankFactory;
    }
    private static class InnerClass {
        public static final LeaderTankFactory enemyTankFactory = new LeaderTankFactory();
    }

    @Override
    public Tank createTank(Integer x, Integer y, DirEnum dir, TankFrame tf) {
        return new LeaderTank(x, y, dir, tf);
    }
}
