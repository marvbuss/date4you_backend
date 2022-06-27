package com.tutego.date4you.web.controller;

import com.tutego.date4you.core.entities.Unicorn;
import com.tutego.date4you.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/photos")
public class PhotoRestController {

    private final PhotoService ps;

    @Autowired
    PhotoRestController(PhotoService ps) {
        this.ps = ps;
    }

    @GetMapping(path = "photo", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@AuthenticationPrincipal Unicorn unicorn, @RequestParam String name) throws IOException {
        Optional<byte[]> picture = ps.download(name);
        return picture.orElse(null);
    }

}


