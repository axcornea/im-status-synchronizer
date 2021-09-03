package com.acriox.imstatussynchronizer.useravailability.physical;

import com.github.sarxos.webcam.Webcam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public abstract class UniversalCameraBase implements Camera {

    @Value("${camera.image-storage-directory}")
    private String imageStorageDirectory;

    @Value("${camera.image-format}")
    private String imageFormat;

    protected Webcam webcam;

    protected void initialize() {
        setupImageStorageDirectory();
        setupCamera();
    }

    private void setupImageStorageDirectory() {
        Path.of(imageStorageDirectory).toFile().mkdirs();
    }

    protected abstract void setupCamera();

    protected File createFileForImage() throws IOException {
        var file = Path.of(imageStorageDirectory, generateImageFilename()).toFile();
        file.createNewFile();
        return file;
    }

    private String generateImageFilename() {
        return LocalDateTime.now().toString().replace(":", "-") + "." + imageFormat;
    }
}
