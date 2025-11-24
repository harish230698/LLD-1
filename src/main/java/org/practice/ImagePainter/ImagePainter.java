package org.practice.ImagePainter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.*;

public class ImagePainter {
    static ExecutorService executor;
    private final int[][] image;

    //Todo: Initialise the Image and create an executor with fixed thread pool size = 4
    public ImagePainter(int[][] image) {
        this.image=image;
        executor = Executors.newFixedThreadPool(4);
    }

    public void paintImage(int color) throws InterruptedException {
        int rows = image.length;
        int cols = image[0].length;
        int halfRows = rows / 2;
        int halfCols = cols / 2;

        // A sample quadrant call will look like this, here we are using the lambda function to pass a runnable!
        Future<?> q1 = executor.submit(() -> paintQuadrant(0, halfRows, 0, halfCols, color)); // Top-left quadrant
        // TODO: Submit remaining 3 tasks to paint each quadrant of the image
        Future<?> q2 = executor.submit(()-> paintQuadrant(0, halfRows, halfCols, cols, 2*color));

        Future<?> q3 = executor.submit(()-> paintQuadrant(halfRows, rows, 0, halfCols, 3*color));

        Future<?> q4 = executor.submit(()-> paintQuadrant(halfRows, rows,halfCols,cols, 4*color));

        try{
            // Todo: Wait for the tasks to finish by calling the .get() method of future objects
            q1.get();
            q2.get();
            q3.get();
            q4.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //Todo: Shutdown the executor once all tasks have been done
        executor.shutdown();
    }

    private void paintQuadrant(int startRow, int endRow, int startCol, int endCol, int color) {
        //Todo: Iterate over the quadrant to fill it with given color

        for(int i=startRow;i<endRow;i++){
            for(int j=startCol;j<endCol;j++){
                image[i][j] = color;
            }
        }
    }

    public int[][] getImage() {
        return image;
    }

    public static void main(String[] args) throws InterruptedException {
        int[][] image = new int[4][4]; // Example 4x4 image
        ImagePainter painter = new ImagePainter(image);
        painter.paintImage(1);

        int[][] paintedImage = painter.getImage();
        // Print the painted image (for demonstration purposes)
        for (int[] row : paintedImage) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}








