package com.acriox.imstatussynchronizer.useravailability.physical;

import java.io.File;

public interface FaceDetector {

    /**
     * Detect if there is a face on the given photo.
     *
     * Returned confidence will be in the range of [0; 1].
     *
     * @param photo Photo to be analyzed.
     * @return Confidence in the fact that there is a face on the photo.
     */
    float isFaceOnPhoto(File photo);
}
