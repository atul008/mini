package com.leo.util;

import com.leo.util.service.FileService;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class Main {

    private static FileService fileService = new FileService();

    public static void main(String[] locationAndUrls) throws MalformedURLException, URISyntaxException, UnsupportedEncodingException, ExecutionException {
        // String[] urls = new String[]{ "http://che.org.il/wp-content/uploads/2016/12/pdf-sample.pdf", "ftp://speedtest.tele2.net/5MB.zip", "sftp://user@india123.systems.in:9090/some/path" };
        if(locationAndUrls.length < 2) {
            throw new IllegalArgumentException("Please provide storage location and atleast one url");
        }
        String storageLocation = locationAndUrls[0];
        String[] urls = Arrays.copyOfRange(locationAndUrls, 1, locationAndUrls.length);
        fileService.dowloadFromUrls(storageLocation, urls);
    }
}
