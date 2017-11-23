package com.leo.util.service;

import com.leo.util.constant.Protocol;
import com.leo.util.file.dowloader.FileDownloader;
import com.leo.util.file.dowloader.FtpFileDownloader;
import com.leo.util.file.dowloader.HttpFileDownloader;
import com.leo.util.file.dowloader.SftpFileDownloader;

import java.util.HashMap;
import java.util.Map;

import static com.leo.util.constant.Protocol.*;

public class FileDownloaderFactory {

    private static Map<Protocol, FileDownloader> downloaderMap;

    static {
        downloaderMap = new HashMap<Protocol, FileDownloader>();
        HttpFileDownloader httpFileDownloader = new HttpFileDownloader();
        downloaderMap.put(HTTP, httpFileDownloader);
        downloaderMap.put(HTTPS, httpFileDownloader);
        downloaderMap.put(FTP, new FtpFileDownloader());
        downloaderMap.put(SFTP, new SftpFileDownloader());
    }

    public static FileDownloader getDowloader(Protocol protocol) {
        FileDownloader fileDownloader = downloaderMap.get(protocol);
        if(fileDownloader == null) {
            throw new IllegalArgumentException("Unsupported protocol");
        }
        return fileDownloader;
    }
}
