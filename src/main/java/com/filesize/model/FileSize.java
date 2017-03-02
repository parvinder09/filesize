package com.filesize.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by parvinder.kumar on 3/1/2017.
 */
public class FileSize {

    private long filesize;

    public long getFilesize() {
        return filesize;
    }

    public void setFilesize(long filesize) {
        this.filesize = filesize;
    }
}
