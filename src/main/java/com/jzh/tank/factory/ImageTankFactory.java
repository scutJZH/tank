package com.jzh.tank.factory;

import com.jzh.tank.GameModel;
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
    public BaseTank createLeaderTank(Integer x, Integer y, DirEnum dir, GameModel gm) {
        return new ImageLeaderTank(x, y, dir, gm);
    }

    @Override
    public BaseTank createEnemyTank(Integer x, Integer y, DirEnum dir, GameModel gm) {
        return new ImageEnemyTank(x, y, dir, gm);
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
