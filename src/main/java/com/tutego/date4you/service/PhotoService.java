package com.tutego.date4you.service;

import com.tutego.date4you.domain.Photo;
import com.tutego.date4you.domain.Thumbnail;
import com.tutego.date4you.repository.FileSystem;
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
    private final Thumbnail thumbnail;
    ;

    @Autowired
    public PhotoService(FileSystem fs, Thumbnail thumbnail) {
        this.fs = fs;
        this.thumbnail = thumbnail;
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

        // Second: store thumbnail
        byte[] thumbnailBytes = thumbnail.thumbnail(imageBytes);
        fs.store(imageName + "-thumb.jpg", thumbnailBytes);

        return imageName;
    }
}
