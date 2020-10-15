package com.jzh.tank.factory;

import com.jzh.tank.entity.enumeration.TankFactoryNameEnum;

public class TankFactoryProducer {
    public static TankFactory getTankFactory(TankFactoryNameEnum tankFactoryName) {
        switch (tankFactoryName) {
            case IMAGE_TANK_FACTORY:
                return ImageTankFactory.getInstance();
            case RECT_TANK_FACTORY:
                return RectTankFactory.getInstance();
            default:
                return null;
        }
    }
}
