package com.leo.util.file.dowloader;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URI;

public class FtpFileDownloader implements FileDownloader {

    @Override
    public File download(URI uri, String fileName) {
        try {
            File tempFile = new File("/tmp/" + fileName);
            FileUtils.copyURLToFile(uri.toURL(), tempFile);
            File file = new File(fileName);
            tempFile.renameTo(file);
            System.out.println("Download complete , URL : " + uri + " ,FileName : " + file.getAbsolutePath());
            return file;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
