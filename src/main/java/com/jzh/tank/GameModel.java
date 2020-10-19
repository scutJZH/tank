package com.jzh.tank;

import com.jzh.tank.collider.Collider;
import com.jzh.tank.collider.ColliderChain;
import com.jzh.tank.entity.domain.BaseTank;
import com.jzh.tank.entity.domain.GameObject;
import com.jzh.tank.entity.domain.Wall;
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
        addElement(new Wall(300, 300, 100, 50));
        addElement(new Wall(300, 700, 100, 50));
        addElement(new Wall(700, 500, 200, 500));
    }

    public void paint(Graphics g) {
        if (myTank.getLiving()) {
            myTank.paint(g);
        } else {
            Color c = g.getColor();
            g.setColor(Color.RED);
            g.drawString("游戏结束！！！", 550, 480);
            g.setColor(c);
        }


        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject gameObject = gameObjects.get(i);
            if (gameObject.getLiving()) {
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

        for (int i = 0; i < gameObjects.size(); i++) {
            collider.collide(this, myTank, gameObjects.get(i));
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
