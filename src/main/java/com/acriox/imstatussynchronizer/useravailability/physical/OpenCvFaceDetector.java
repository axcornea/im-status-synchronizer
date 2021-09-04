package com.acriox.imstatussynchronizer.useravailability.physical;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bytedeco.opencv.global.opencv_imgproc;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.RectVector;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;

@Component
@RequiredArgsConstructor
@Slf4j
public class OpenCvFaceDetector implements FaceDetector {

    @Value("${classifier.model-directory}")
    private final String modelDirectory;

    private List<CascadeClassifier> classifiers;

    @PostConstruct
    private void initialize() {
        classifiers = Arrays.stream(Path.of(modelDirectory).toFile().listFiles())
                .map(File::getAbsolutePath)
                .map(CascadeClassifier::new)
                .collect(Collectors.toList());
    }

    @Override
    public float isFaceOnPhoto(File sourceImageFile) {
        Mat image = loadImage(sourceImageFile);

        int triggeredClassifiersCount =
                classifiers.stream()
                        .mapToInt(classifier -> {
                            RectVector detectedObjects = new RectVector();
                            classifier.detectMultiScale(image, detectedObjects);
                            return detectedObjects.empty() ? 0 : 1;
                        })
                        .sum();

        return (float) triggeredClassifiersCount / (float) classifiers.size();
    }

    private Mat loadImage(File source) {
        Mat sourceImage = imread(source.getAbsolutePath());
        Mat grayImage = sourceImage.clone();
        opencv_imgproc.cvtColor(sourceImage, grayImage, opencv_imgproc.COLOR_BGR2GRAY);
        return grayImage;
    }
}
