package com.leo.util.file.dowloader;

import java.io.File;
import java.net.URI;

public interface FileDownloader {

    public File download(URI uri, String fileName);
}
