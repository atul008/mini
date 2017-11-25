package com.leo.util.test;

import com.leo.util.file.dowloader.FtpFileDownloader;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class FtpDownloaderTest {

    private static FtpFileDownloader ftpFileDownloader = new FtpFileDownloader();

    @Test
    public void test() throws URISyntaxException {
        String url = "ftp://speedtest.tele2.net/5MB.zip";
        String fileName = "testFile";
        File downloadedFile = ftpFileDownloader.download(new URI(url), fileName);
        Assert.assertNotNull(downloadedFile);
    }
}
