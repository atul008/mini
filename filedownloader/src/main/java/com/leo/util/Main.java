package com.leo.util;

import com.leo.util.service.FileService;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

public class Main {

    private static FileService fileService = new FileService();

    public static void main(String[] urlsi) throws MalformedURLException, URISyntaxException, UnsupportedEncodingException, ExecutionException {
        String[] urls = new String[]{ "http://che.org.il/wp-content/uploads/2016/12/pdf-sample.pdf", "ftp://speedtest.tele2.net/5MB.zip", "sftp://user@india123.systems.in:9090/some/path" };
        fileService.dowloadFromUrls(urls);
    }
}
