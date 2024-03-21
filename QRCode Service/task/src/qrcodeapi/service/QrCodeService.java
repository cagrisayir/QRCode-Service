package qrcodeapi.service;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;

@Service
public class QrCodeService {
    public BufferedImage create250() {
        final int WIDTH = 250;
        final int HEIGHT = 250;
        final int ZERO = 0;
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        g.setColor(Color.white);
        g.fillRect(ZERO, ZERO, WIDTH, HEIGHT);

        g.dispose();
        return image;
    }
}
