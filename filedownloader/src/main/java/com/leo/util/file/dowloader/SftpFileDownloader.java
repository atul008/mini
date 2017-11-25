package com.leo.util.file.dowloader;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.Selectors;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;

import java.io.File;
import java.net.URI;

public class SftpFileDownloader implements FileDownloader {

    @Override
    public File download(URI uri, String fileName) {
        StandardFileSystemManager manager = new StandardFileSystemManager();
        try {
            manager.init();
            FileObject localFile = manager.resolveFile(fileName);
            FileObject remoteFile = manager.resolveFile(uri.toString());
            localFile.copyFrom(remoteFile, Selectors.SELECT_SELF);
            File file = new File(fileName);
            // tempFile.renameTo(file);
            System.out.println("#### Download complete , URL : " + uri + " ,FileName : " + file.getAbsolutePath() + " ####");
            return file;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            manager.close();
        }
    }
}

