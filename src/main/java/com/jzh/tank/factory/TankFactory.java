package com.jzh.tank.factory;

import com.jzh.tank.TankFrame;
import com.jzh.tank.entity.enumeration.DirEnum;

public abstract class TankFactory {
    public abstract Tank createTank(Integer x, Integer y, DirEnum dir, TankFrame tf);
}
