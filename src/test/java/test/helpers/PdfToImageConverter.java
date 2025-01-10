package test.helpers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PdfToImageConverter {

    public static void convertPdfToImages(String pdfPath, String outputDir) throws IOException {
        // Ensure the output directory exists
        File dir = new File(outputDir);
        if (!dir.exists()) {
            dir.mkdirs();  // Create the directory if it does not exist
        }

        PDDocument document = PDDocument.load(new File(pdfPath));
        PDFRenderer pdfRenderer = new PDFRenderer(document);

        // Iterate over each page of the PDF and save as an image
        for (int page = 0; page < document.getNumberOfPages(); page++) {
            BufferedImage image = pdfRenderer.renderImageWithDPI(page, 300); // 300 DPI for high resolution
            File outputImage = new File(outputDir + "/page_" + (page + 1) + ".png");

            // Make sure the image can be written to the specified path
            if (!outputImage.exists()) {
                outputImage.createNewFile();
            }

            ImageIO.write(image, "PNG", outputImage);  // Write image to file
        }

        document.close();
    }
}
