package com.jzh.tank.factory;

import com.jzh.tank.TankFrame;
import com.jzh.tank.entity.domain.BaseBullet;
import com.jzh.tank.entity.domain.BaseExplode;
import com.jzh.tank.entity.domain.BaseTank;
import com.jzh.tank.entity.enumeration.DirEnum;

public abstract class TankFactory {
    public abstract BaseTank createLeaderTank(Integer x, Integer y, DirEnum dir, TankFrame tf);

    public abstract BaseTank createEnemyTank(Integer x, Integer y, DirEnum dir, TankFrame tf);

    public abstract BaseBullet createBullet(DirEnum dir, BaseTank belongsTo);

    public abstract BaseExplode createExplode(Integer x, Integer y);
}
