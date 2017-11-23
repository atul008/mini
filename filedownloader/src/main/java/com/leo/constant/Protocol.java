package com.leo.constant;

import org.apache.commons.lang3.StringUtils;

public enum Protocol {

    HTTP("http"), HTTPS("https"), FTP("ftp"), SFTP("sftp"), UNKNOWN("unknown");

    private String name;

    Protocol(String name) {
        this.name = name;
    }

    public static Protocol getByName(String name) {
        for(Protocol protocol : values()) {
            if(StringUtils.equalsIgnoreCase(name, protocol.name)) {
                return protocol;
            }
        }
        return UNKNOWN;
    }
}
