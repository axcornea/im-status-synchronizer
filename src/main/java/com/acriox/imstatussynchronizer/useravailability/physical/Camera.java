package com.acriox.imstatussynchronizer.useravailability.physical;

import java.io.File;
import java.io.IOException;

public interface Camera {
    File takePhoto() throws IOException;
}
