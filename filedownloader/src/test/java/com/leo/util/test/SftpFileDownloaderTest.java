package com.leo.util.test;

import com.leo.util.file.dowloader.SftpFileDownloader;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class SftpFileDownloaderTest {

    private static SftpFileDownloader sftpFileDownloader = new SftpFileDownloader();

    @Test
    public void test() throws URISyntaxException {
        String url = "sftp://demo:password@test.rebex.net:22/";
        String fileName = "/data/files/testFile";
        File downloadedFile = sftpFileDownloader.download(new URI(url), fileName);
        Assert.assertNotNull(downloadedFile);
    }
}
