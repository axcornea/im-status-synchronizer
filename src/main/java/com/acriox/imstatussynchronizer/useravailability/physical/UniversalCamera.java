package com.acriox.imstatussynchronizer.useravailability.physical;

import com.github.sarxos.webcam.Webcam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

@Component
@ConditionalOnProperty(name = "flags.camera-always-on", havingValue = "false")
@RequiredArgsConstructor
@Slf4j
public class UniversalCamera extends UniversalCameraBase {

    @PostConstruct
    public void initialize() {
        super.initialize();
    }

    protected void setupCamera() {
        webcam = Webcam.getDefault();
    }

    @Override
    public File takePhoto() throws IOException {
        webcam.open();

        var photo = createFileForImage();
        ImageIO.write(webcam.getImage(), getImageFormat(), photo);

        webcam.close();
        return photo;
    }
}
