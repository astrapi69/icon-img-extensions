package io.github.astrapi69.img;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.awt.Graphics2D;
import java.io.File;
import javax.imageio.ImageIO;

public class BrightenImageExtensions {

    /**
     * Static method to brighten a PNG image.
     *
     * @param inputFile   The input image file
     * @param outputFile  The output file to save the brightened image
     * @param scaleFactor The factor to scale brightness (e.g., 1.2f = 20% brighter)
     * @throws Exception If an I/O or image processing error occurs
     */
    public static void brightenPngImage(File inputFile, File outputFile, float scaleFactor) throws Exception {
        // 1. Read image
        BufferedImage src = ImageIO.read(inputFile);

        // 2. Convert to compatible type if necessary
        BufferedImage img;
        int type = src.getType();
        if (type == BufferedImage.TYPE_BYTE_INDEXED || type == BufferedImage.TYPE_CUSTOM) {
            img = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = img.createGraphics();
            g.drawImage(src, 0, 0, null);
            g.dispose();
        } else {
            img = src;
        }

        // 3. Apply brightness adjustment
        float offset = 0f;
        RescaleOp op = new RescaleOp(scaleFactor, offset, null);
        BufferedImage brighterImg = op.filter(img, null);

        // 4. Write result to output file
        ImageIO.write(brighterImg, "png", outputFile);
    }
}