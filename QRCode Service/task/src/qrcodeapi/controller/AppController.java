package qrcodeapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/api/health")
    public ResponseEntity<HttpStatus> health() {
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/api/qrcode")
    public ResponseEntity<HttpStatus> qrcode() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(HttpStatus.NOT_IMPLEMENTED);
    }
}
