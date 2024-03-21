package qrcodeapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import qrcodeapi.service.QrCodeService;

import java.awt.image.BufferedImage;

@RestController
public class AppController {

    private final QrCodeService qrCodeService;

    public AppController(QrCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @GetMapping("/api/health")
    public ResponseEntity<HttpStatus> health() {
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/api/qrcode")
    public ResponseEntity<BufferedImage> getImage() {
        BufferedImage bufferedImage = qrCodeService.create250();
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(bufferedImage);
    }
}
