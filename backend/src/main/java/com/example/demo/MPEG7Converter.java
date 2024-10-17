package com.example.demo;
import nu.pattern.OpenCV;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
public class MPEG7Converter {
    public static float[] convert(){
        OpenCV.loadShared();
        Mat greyImage = new Mat();
        Mat image = Imgcodecs.imread("image.jpg");
        Imgproc.cvtColor(image, greyImage, Imgproc.COLOR_BGR2GRAY);

        int numBlocks = 4;
        int blockSizeX = greyImage.width() / numBlocks;
        int blockSizeY = greyImage.height() / numBlocks;

        Mat verticalKernel = new Mat(3, 3, CvType.CV_32F);
        verticalKernel.put(0, 0, -1, 0, 1, -2, 0, 2, -1, 0, 1);

        Mat horizontalKernel = new Mat(3, 3, CvType.CV_32F);
        horizontalKernel.put(0, 0, 1, 2, 1, 0, 0, 0, -1, -2, -1);

        Mat diagonal45Kernel = new Mat(3, 3, CvType.CV_32F);
        diagonal45Kernel.put(0, 0, 2, 1, 0, 1, 0, -1, 0, -1, -2);

        Mat diagonal135Kernel = new Mat(3, 3, CvType.CV_32F);
        diagonal135Kernel.put(0, 0, 0, 1, 2, -1, 0, 1, -2, -1, 0);

        Mat nonDirectionalKernel = new Mat(3, 3, CvType.CV_32F);
        nonDirectionalKernel.put(0, 0, 1, 1, 1, 1, -8, 1, 1, 1, 1);


        float[] edgeHistogram = new float[numBlocks * numBlocks * 5];


        for (int i = 0; i < numBlocks; i++) {
            for (int j = 0; j < numBlocks; j++) {
                int x = j * blockSizeX;
                int y = i * blockSizeY;
                Mat block = greyImage.submat(y, y + blockSizeY, x, x + blockSizeX);
                float[] edgeStrengths = new float[5];
                edgeStrengths[0] = applyKernel(block, verticalKernel);
                edgeStrengths[1] = applyKernel(block, horizontalKernel);
                edgeStrengths[2] = applyKernel(block, diagonal45Kernel);
                edgeStrengths[3] = applyKernel(block, diagonal135Kernel);
                edgeStrengths[4] = applyKernel(block, nonDirectionalKernel);
                float sum = 0;
                for (float strength : edgeStrengths) {
                    sum += strength;
                }
                if (sum > 0) {
                    for (int k = 0; k < 5; k++) {
                        edgeHistogram[i * numBlocks * 5 + j * 5 + k] = edgeStrengths[k] / sum;
                    }
                }
            }
        }

        return edgeHistogram;



    }
    private static float applyKernel(Mat block, Mat kernel) {
        Mat edgeResponse = new Mat();
        Imgproc.filter2D(block, edgeResponse, -1, kernel);
        return (float) Core.sumElems(edgeResponse).val[0];
    }
}
