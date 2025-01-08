import test.helpers.PdfReader;
import test.utils.FileDownloader;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.File;

public class PdfTest {

    private static final String FILE_URL = "https://drive.google.com/uc?export=download&id=1XE3Uh9Yl8kG4S5tEqnR_6m0jZf5omyrW"; // Google Drive link
    private static final String LOCAL_FILE_PATH = "C:/Users/Administrator/IdeaProjects/appium/testdata/downloaded_filek.pdf"; // Local path to save

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
    }

    @After
    public void tearDown() {
        // No driver to quit, no clean-up required
    }

    @Test
    public void testPdfTextExtractionAndAssertion() throws Exception {
        // Extract text from the downloaded PDF using Apache PDFBox
        String pdfText = PdfReader.extractTextFromPdf(LOCAL_FILE_PATH);

        // Log the extracted text for debugging purposes
        System.out.println("Extracted text from PDF: " + pdfText);
//
//        // Example assertion for testing
//        org.junit.Assert.assertTrue("Text should contain 'Total'", pdfText.contains("Total"));
    }

//    @Test
//    public void anotherPdfTest() throws Exception {
//        // Extract text from the downloaded PDF again for a different test
//        String pdfText = PdfReader.extractTextFromPdf(LOCAL_FILE_PATH);
//
//        // Log the extracted text for debugging purposes
//        System.out.println("Extracted text from PDF: " + pdfText);
//
//        // Example assertion for testing
//       org.junit.Assert.assertTrue("Text should contain 'Total'", pdfText.contains("Total"));
//    }
}
