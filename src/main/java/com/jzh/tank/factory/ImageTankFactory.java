package com.jzh.tank.factory;

import com.jzh.tank.TankFrame;
import com.jzh.tank.entity.domain.*;
import com.jzh.tank.entity.enumeration.DirEnum;

public class ImageTankFactory extends TankFactory {

    private ImageTankFactory() {}

    public static TankFactory getInstance() {
        return ImageTankFactory.InnerClass.gameV1TankFactory;
    }

    private static class InnerClass {
        public static final TankFactory gameV1TankFactory = new ImageTankFactory();
    }

    @Override
    public BaseTank createLeaderTank(Integer x, Integer y, DirEnum dir, TankFrame tf) {
        return new ImageLeaderBaseTank(x, y, dir, tf);
    }

    @Override
    public BaseTank createEnemyTank(Integer x, Integer y, DirEnum dir, TankFrame tf) {
        return new ImageEnemyBaseTank(x, y, dir, tf);
    }

    @Override
    public BaseBullet createBullet(DirEnum dir, BaseTank belongsTo) {
        return new ImageBullet(dir, belongsTo);
    }

    @Override
    public BaseExplode createExplode(Integer x, Integer y) {
        return new ImageExplode(x, y);
    }
}
