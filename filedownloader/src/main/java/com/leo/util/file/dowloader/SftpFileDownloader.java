package com.leo.util.file.dowloader;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;

public class SftpFileDownloader implements FileDownloader {

    @Override
    public File download(URI uri, String fileName) {
        try {
            FileSystemOptions fsOptions = new FileSystemOptions();
            SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(fsOptions, "no");
            FileSystemManager fsManager = VFS.getManager();
            FileObject fo = fsManager.resolveFile(uri.getPath(), fsOptions);
            BufferedInputStream bis = new BufferedInputStream(fo.getContent().getInputStream());
            File tempFile = new File("/tmp/" + fileName);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(tempFile));
            int readCount;
            byte[] buffer = new byte[1024];
            while((readCount = bis.read(buffer)) > 0) {
                bos.write(buffer, 0, readCount);
            }
            File file = new File(fileName);
            tempFile.renameTo(file);
            System.out.println("Download complete , URL : " + uri + " ,FileName : " + file.getAbsolutePath());
            return file;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
}

