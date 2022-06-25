package com.tutego.date4you.service;

import com.tutego.date4you.domain.Photo;
import com.tutego.date4you.domain.FileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import java.io.UncheckedIOException;
import java.util.Optional;
import java.util.UUID;

@Service
@Validated
public class PhotoService {
    private final FileSystem fs;

    ;

    @Autowired
    public PhotoService(FileSystem fs) {
        this.fs = fs;

    }

    public Optional<byte[]> download(String imageName) {
        try {
            return Optional.of(fs.load(imageName + ".jpg"));
        } catch (UncheckedIOException e) {
            return Optional.empty();
        }
    }

    public Optional<byte[]> download(@Valid Photo photo) {
        return download(photo.name);
    }

    public String upload(byte[] imageBytes) {
        String imageName = UUID.randomUUID().toString();

        // First: store original image
        fs.store(imageName + ".jpg", imageBytes);

        return imageName;
    }
}
