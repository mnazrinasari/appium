package test.utils;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileDownloader {

    // Method to download a file from a URL
    public static void downloadFile(String fileURL, String destinationFilePath) throws IOException {
        // Create a URL object from the file URL
        URL url = new URL(fileURL);

        // Open a connection to the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET"); // Setting request method to GET for downloading

        // Get the input stream from the connection
        try (InputStream inputStream = connection.getInputStream();
             FileOutputStream outputStream = new FileOutputStream(destinationFilePath)) {

            byte[] buffer = new byte[4096];  // Buffer to read data in chunks
            int bytesRead;

            // Read the file in chunks and write it to the destination file
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }

        System.out.println("File downloaded to: " + destinationFilePath);
    }
}
