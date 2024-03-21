package qrcodeapi;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageCreator {
    private final int WIDTH = 250;
    private final int HEIGHT = 250;
    private final int ZERO = 0;

    public BufferedImage create250() {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        g.setColor(Color.white);
        g.fillRect(ZERO, ZERO, WIDTH, HEIGHT);

        g.dispose();
        return image;
    }
}
