package test.helpers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PdfReader {

    // Method to extract text from a PDF
    public static String extractTextFromPdf(String pdfFilePath) throws IOException {
        // Load the PDF document
        PDDocument document = PDDocument.load(new File(pdfFilePath));

        // Log the document structure (number of pages)
        System.out.println("Number of pages in the PDF: " + document.getNumberOfPages());

        // Customize PDFTextStripper settings (optional)
        PDFTextStripper stripper = new PDFTextStripper();
        stripper.setStartPage(1); // Start from the first page
        stripper.setEndPage(document.getNumberOfPages()); // Extract text from all pages

        // Extract text from the document
        String text = stripper.getText(document);
        document.close(); // Close the document

        // Return the extracted text after trimming leading/trailing whitespaces
        return text.trim();
    }
}
