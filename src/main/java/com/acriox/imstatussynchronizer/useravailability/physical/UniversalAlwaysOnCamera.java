package com.acriox.imstatussynchronizer.useravailability.physical;

import com.github.sarxos.webcam.Webcam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

@Component
@ConditionalOnProperty(name = "flags.camera-always-on", havingValue = "true")
@RequiredArgsConstructor
@Slf4j
public class UniversalAlwaysOnCamera extends UniversalCameraBase {

    @PostConstruct
    public void initialize() {
        super.initialize();
    }

    protected void setupCamera() {
        webcam = Webcam.getDefault();

        // TODO Make it configurable through the configuration properties
        var hdViewSize = new Dimension(1280, 720);
        webcam.setCustomViewSizes(new Dimension[] { hdViewSize });
        webcam.setViewSize(hdViewSize);

        webcam.open(true);
    }

    @Override
    public File takePhoto() throws IOException {
        var photo = createFileForImage();
        ImageIO.write(webcam.getImage(), getImageFormat(), photo);
        return photo;
    }
}
