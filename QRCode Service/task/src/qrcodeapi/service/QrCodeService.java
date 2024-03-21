package qrcodeapi.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class QrCodeService {
    public BufferedImage createImage(int size) {
        final int ZERO = 0;
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        g.setColor(Color.white);
        g.fillRect(ZERO, ZERO, size, size);

        g.dispose();
        return image;
    }

    public Map<String, String> errorHandler(int size, String type) {
        Map<String, String> error = new HashMap<>();
        String[] possibleTypes = {"png", "jpeg", "gif"};
        if (size > 350 || size < 150) {
            error.put("error", "Image size must be between 150 and 350 pixels");
            return error;
        }

        if (Arrays.stream(possibleTypes).noneMatch(type::equals))
            error.put("error", "Only png, jpeg and gif image types are supported");
        return error;
    }

    public MediaType getMediaType(String type) {
        switch (type) {
            case "png" -> {
                return MediaType.IMAGE_PNG;
            }
            case "jpeg" -> {
                return MediaType.IMAGE_JPEG;
            }
            case "gif" -> {
                return MediaType.IMAGE_GIF;
            }
            default -> {
                return null;
            }
        }
    }
}
