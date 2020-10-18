package com.jzh.tank.manager;

import com.jzh.tank.util.ImageUtils;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResourceMgr {

    public static BufferedImage tankLeftImage;
    public static BufferedImage tankRightImage;
    public static BufferedImage tankUpImage;
    public static BufferedImage tankDownImage;

    public static BufferedImage myTankLeftImage;
    public static BufferedImage myTankRightImage;
    public static BufferedImage myTankUpImage;
    public static BufferedImage myTankDownImage;

    public static BufferedImage bulletLeftImage;
    public static BufferedImage bulletRightImage;
    public static BufferedImage bulletUpImage;
    public static BufferedImage bulletDownImage;

    public static List<BufferedImage> explodeImages;

    static {
        try {
            tankUpImage = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankLeftImage = ImageUtils.rotateImage(tankUpImage, 270);
            tankRightImage = ImageUtils.rotateImage(tankUpImage, 90);
            tankDownImage = ImageUtils.rotateImage(tankUpImage, 180);

            myTankUpImage = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            myTankRightImage = ImageUtils.rotateImage(myTankUpImage, 90);
            myTankDownImage = ImageUtils.rotateImage(myTankUpImage, 180);
            myTankLeftImage = ImageUtils.rotateImage(myTankUpImage, 270);

            bulletUpImage = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletLeftImage = ImageUtils.rotateImage(bulletUpImage, -90);
            bulletRightImage = ImageUtils.rotateImage(bulletUpImage, 90);
            bulletDownImage = ImageUtils.rotateImage(bulletUpImage, 180);

            explodeImages = new ArrayList<>();
            for (int i = 1; i <= 16; i++) {
                explodeImages.add(ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + i + ".gif")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
