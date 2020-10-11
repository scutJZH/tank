package com.jzh.tank;

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
    public static BufferedImage tankLeftDownImage;
    public static BufferedImage tankLeftUpImage;
    public static BufferedImage tankRightDownImage;
    public static BufferedImage tankRightUpImage;

    public static BufferedImage bulletLeftImage;
    public static BufferedImage bulletRightImage;
    public static BufferedImage bulletUpImage;
    public static BufferedImage bulletDownImage;

    public static List<BufferedImage> explodeImages;

    static {
        try {
            tankUpImage = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankLeftImage = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankRightImage = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankDownImage = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            tankLeftDownImage = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankLD.gif"));
            tankLeftUpImage = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankLU.gif"));
            tankRightDownImage = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankRD.gif"));
            tankRightUpImage = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankRU.gif"));

            bulletUpImage = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletLeftImage = ImageUtil.rotateImage(bulletUpImage, -90);
            bulletRightImage = ImageUtil.rotateImage(bulletUpImage, 90);
            bulletDownImage = ImageUtil.rotateImage(bulletUpImage, 180);

            explodeImages = new ArrayList<>();
            for (int i = 1; i <= 16; i++) {
                explodeImages.add(ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + i + ".gif")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
