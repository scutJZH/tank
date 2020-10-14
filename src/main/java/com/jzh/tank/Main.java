package com.jzh.tank;

import com.jzh.tank.entity.enumeration.DirEnum;
import com.jzh.tank.entity.enumeration.TankFactoryNameEnum;
import com.jzh.tank.factory.TankFactory;
import com.jzh.tank.factory.TankFactoryProducer;
import com.jzh.tank.manage.ConfigMgr;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        TankFactory tankFactory = TankFactoryProducer.getTankFactory(TankFactoryNameEnum.ENEMY_TANK_FACTORY);
        int initEnemyNumber = Integer.parseInt((String) ConfigMgr.get("initEnemyNumber"));

        TankFrame f = new TankFrame();
        for(int i = 0; i < initEnemyNumber; i++) {
            f.getEnemies().add(tankFactory.createTank(i * 80, 400, DirEnum.UP, f));
        }

        while (true) {
            Thread.sleep(20);
            f.repaint();
        }

    }
}