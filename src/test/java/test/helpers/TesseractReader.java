package test.helpers;

import net.sourceforge.tess4j.Tesseract;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class TesseractReader {

    public static String extractTextFromImage(String imagePath) {
        Tesseract tesseract = new Tesseract();

        // Optional: Set the path to the Tesseract data folder (where tessdata is located)
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata"); // Replace with your actual path

        // Optional: Set the language if necessary (e.g., 'eng' for English)
        tesseract.setLanguage("eng");

        try {
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile); // Read image using ImageIO
            return tesseract.doOCR(image); // Perform OCR on the image
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
