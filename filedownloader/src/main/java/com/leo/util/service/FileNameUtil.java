package com.leo.util.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class FileNameUtil {

    public static String urlToFileName(String url) throws URISyntaxException, UnsupportedEncodingException {
        return uriToFileName(new URI(url));
    }

    public static String uriToFileName(URI uri) throws UnsupportedEncodingException {
        return URLEncoder.encode(uri.getPath(), "UTF-8");
    }

    public static String getUrlFromFileName(String fileName) throws UnsupportedEncodingException {
        return URLDecoder.decode(fileName, "UTF-8");
    }
}
