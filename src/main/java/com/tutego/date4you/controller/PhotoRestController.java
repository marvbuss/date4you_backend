package com.tutego.date4you.controller;

import com.tutego.date4you.domain.Unicorn;
import com.tutego.date4you.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
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
        System.out.println(name);
        Optional<byte[]> picture = ps.download(name);
        return picture.orElse(null);
    }


        @GetMapping( "/random" )
        public byte[] randomPhoto() throws IOException {
            Resource resource = new UrlResource(
                    "https://getwallpapers.com/wallpaper/full/1/1/7/264012.jpg"
            );
            InputStream inputStream = resource.getInputStream();
            return StreamUtils.copyToByteArray( inputStream );
        }
}


