package com.leo.util.test;

import com.leo.util.file.dowloader.HttpFileDownloader;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class HttpDownloaderTest {

    private static HttpFileDownloader httpFileDownloader = new HttpFileDownloader();

    @Test
    public void test() throws URISyntaxException {
        String url = "http://che.org.il/wp-content/uploads/2016/12/pdf-sample.pdf";
        String fileName = "testFile";
        File downloadedFile = httpFileDownloader.download(new URI(url), fileName);
        Assert.assertNotNull(downloadedFile);
    }
}
