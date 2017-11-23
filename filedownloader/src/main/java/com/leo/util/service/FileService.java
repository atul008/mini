package com.leo.util.service;

import com.leo.constant.Protocol;

import java.net.URI;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileService {

    private static final String          storageLocation = "/data/files";
    private static       ExecutorService executor        = Executors.newFixedThreadPool(100);

    public void dowloadFromUrls(String[] urls) throws ExecutionException {
        if(urls == null || urls.length == 0) {
            throw new IllegalArgumentException("Please provide atleast one url");
        }
        for(String urlStr : urls) {
            try {
                URI uri = new URI(urlStr);
                final Protocol protocol = Protocol.getByName(uri.getScheme());
                if(protocol != Protocol.UNKNOWN) {
                    String fileName = storageLocation + "/" + FileNameUtil.uriToFileName(uri);
                    executor.submit(() -> FileDownloaderFactory.getDowloader(protocol).download(uri, fileName));
                    System.out.println("Download started for : URL : " + urlStr);
                }
            }
            catch (Exception ex) {
                System.out.println("Unable to download from url : " + urlStr);
                ex.printStackTrace();
            }
        }

    }
}
