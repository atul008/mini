package com.leo.util.test;

import com.leo.util.service.FileService;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

public class FileServiceTest {

    private static FileService fileService = new FileService();

    @Test
    public void test() throws MalformedURLException, URISyntaxException, UnsupportedEncodingException, ExecutionException {
        String[] urls = new String[]{ "http://che.org.il/wp-content/uploads/2016/12/pdf-sample.pdf", "ftp://speedtest.tele2.net/5MB.zip", "sftp://demo:password@test.rebex.net:22/" };
        fileService.dowloadFromUrls("/data/files", urls);
    }

}
