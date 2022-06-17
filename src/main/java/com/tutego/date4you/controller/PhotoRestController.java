package com.tutego.date4you.controller;

import com.tutego.date4you.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
public class PhotoRestController {

    private final PhotoService ps;

    @Autowired
    PhotoRestController(PhotoService ps) {
        this.ps = ps;
    }

    @GetMapping(path = "/api/v1/photo/random", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] randomPhoto() throws IOException {
        Optional<byte[]> picture = ps.download("unicorn001");
        return picture.orElse(null);
    }

//    public byte[] randomPhoto() throws IOException {
//        Resource resource = new UrlResource(
//                "https://getwallpapers.com/wallpaper/full/1/1/7/264012.jpg"
//        );
//        InputStream inputStream = resource.getInputStream();
//        return StreamUtils.copyToByteArray( inputStream );
//    }
}
