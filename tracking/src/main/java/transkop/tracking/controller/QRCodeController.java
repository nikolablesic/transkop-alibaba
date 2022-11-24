package transkop.tracking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import transkop.tracking.controller.dto.ProductRequest;
import transkop.tracking.controller.dto.ProductResponse;
import transkop.tracking.controller.dto.mapper.ProductMapper;
import transkop.tracking.model.Product;
import transkop.tracking.utils.generators.QRCodeGenerator;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api/qr-code")
public class QRCodeController {

    @GetMapping("{id}")
    public ResponseEntity<byte[]> generate(@PathVariable String id) throws IOException {
        byte[] response = QRCodeGenerator.generateImageQRCode(id,400,400);
        return ResponseEntity.ok(response);
    }
}
