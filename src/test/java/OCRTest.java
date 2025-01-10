import test.helpers.PdfReader;
import test.helpers.PdfToImageConverter;
import test.helpers.TesseractReader;
import test.utils.FileDownloader;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class OCRTest {

    private static final String FILE_URL = "https://drive.google.com/uc?export=download&id=1XE3Uh9Yl8kG4S5tEqnR_6m0jZf5omyrW"; // Google Drive link
    private static final String LOCAL_FILE_PATH = "C:/Users/Administrator/IdeaProjects/appium/testdata/downloaded_file.pdf"; // Local path to save
    private static final String IMAGE_OUTPUT_DIR = "C:/Users/Administrator/IdeaProjects/appium/testdata/images"; // Directory for saving images

    @Before
    public void setUp() throws Exception {
        // Ensure the PDF file is downloaded before each test
        FileDownloader.downloadFile(FILE_URL, LOCAL_FILE_PATH);

        // Check if the downloaded file exists
        File file = new File(LOCAL_FILE_PATH);

        // Log to console if file is found
        if (!file.exists()) {
            throw new Exception("File not found at " + LOCAL_FILE_PATH);
        }

        // Convert the downloaded PDF to images
        PdfToImageConverter.convertPdfToImages(LOCAL_FILE_PATH, IMAGE_OUTPUT_DIR);
    }

    @After
    public void tearDown() {
        // Clean-up or any necessary teardown steps (not needed here)
    }

    @Test
    public void testPdfTextExtractionUsingTesseract() throws Exception {
        // Example: Process the first image page (you can loop through all the pages)
        String extractedText = TesseractReader.extractTextFromImage(IMAGE_OUTPUT_DIR + "/page_1.png");

        // Log the extracted text for debugging purposes
        System.out.println("Extracted text from PDF page 1: " + extractedText);

        // Example assertion (you can modify based on your expected text)
//        org.junit.Assert.assertTrue("Text should contain 'Total'", extractedText.contains("Total"));
    }
}
