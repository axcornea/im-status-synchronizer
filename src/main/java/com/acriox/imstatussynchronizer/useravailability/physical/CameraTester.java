package com.acriox.imstatussynchronizer.useravailability.physical;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Profile({"dev"})
@RequiredArgsConstructor
@Slf4j
public class CameraTester {

    private static final int ITERATION_INTERVAL_MS = 10 * 1000;

    private final Camera camera;

    @Scheduled(fixedRate = ITERATION_INTERVAL_MS)
    public void testCamera() {
        try {
            var photo = camera.takePhoto();
            log.info("Photo taken and saved to {}", photo.getAbsolutePath());
        } catch (IOException ex) {
            log.error("Error while capturing photo", ex);
        }
    }
}
