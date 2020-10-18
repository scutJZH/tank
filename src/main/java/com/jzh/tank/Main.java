package com.jzh.tank;

import com.jzh.tank.entity.enumeration.DirEnum;
import com.jzh.tank.entity.enumeration.TankFactoryNameEnum;
import com.jzh.tank.factory.TankFactory;
import com.jzh.tank.factory.TankFactoryProducer;
import com.jzh.tank.manager.ConfigMgr;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        TankFactory tankFactory = TankFactoryProducer.getTankFactory(TankFactoryNameEnum.IMAGE_TANK_FACTORY);
        int initEnemyNumber = Integer.parseInt((String) ConfigMgr.get("initEnemyNumber"));
        GameModel gameModel = new GameModel(tankFactory);
        for(int i = 0; i < initEnemyNumber; i++) {
            gameModel.addElement(tankFactory.createEnemyTank(i * 80, 400, DirEnum.UP, gameModel));
        }
        TankFrame f = new TankFrame(gameModel);

        while (true) {
            Thread.sleep(20);
            f.repaint();
        }

    }
}