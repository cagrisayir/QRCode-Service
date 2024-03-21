package qrcodeapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import qrcodeapi.service.QrCodeService;

import java.awt.image.BufferedImage;
import java.util.Map;

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
    public ResponseEntity<?> getImage(@RequestParam String contents,
                                      @RequestParam int size,
                                      @RequestParam String type) {

        Map<String, String> error = qrCodeService.errorHandler(contents, size, type);
        if (!error.isEmpty())
            return ResponseEntity.badRequest().body(error);

        MediaType imageType = qrCodeService.getMediaType(type);

        BufferedImage bufferedImage = qrCodeService.createImage(contents, size);
        return ResponseEntity.ok().contentType(imageType).body(bufferedImage);
    }
}
