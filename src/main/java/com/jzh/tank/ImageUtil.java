package com.jzh.tank;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageUtil {

    public static BufferedImage rotateImage(BufferedImage image, int degree) {
        int width = image.getWidth();
        int height = image.getHeight();
        int type = image.getColorModel().getTransparency();

        BufferedImage newImage = new BufferedImage(width, height, type);
        Graphics2D graph = newImage.createGraphics();
        graph.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);;
        graph.rotate(Math.toRadians(degree), width / 2d, height / 2d);
        graph.drawImage(image, 0, 0, null);
        graph.dispose();
        return newImage;
    }

}
