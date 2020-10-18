package com.jzh.tank;

import com.jzh.tank.collider.Collider;
import com.jzh.tank.collider.ColliderChain;
import com.jzh.tank.entity.domain.BaseTank;
import com.jzh.tank.entity.domain.GameObject;
import com.jzh.tank.entity.enumeration.DirEnum;
import com.jzh.tank.factory.TankFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private BaseTank myTank;
    private List<GameObject> gameObjects;
    private TankFactory factory;
    private Collider collider;


    public GameModel(TankFactory factory) {
        this.gameObjects = new ArrayList<>();
        this.myTank = factory.createLeaderTank(200, 200, DirEnum.RIGHT, this);
        this.factory = factory;
        this.collider = ColliderChain.getInstance();
    }

    public void paint(Graphics g) {
        myTank.paint(g);

        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject gameObject = gameObjects.get(i);
            if (gameObject.isLiving()) {
                gameObject.paint(g);
            } else {
                gameObjects.remove(gameObject);
            }
        }

        for (int i = 0; i < gameObjects.size() - 1; i++) {
            for (int j = i + 1; j < gameObjects.size(); j++) {
                collider.collide(this, gameObjects.get(i), gameObjects.get(j));
            }
        }
    }

    public void addElement(GameObject o) {
        this.gameObjects.add(o);
    }

    public void remove(GameObject o) {
        this.gameObjects.remove(o);
    }

    public TankFactory getFactory() {
        return factory;
    }

    public BaseTank getMyTank() {
        return myTank;
    }
}
