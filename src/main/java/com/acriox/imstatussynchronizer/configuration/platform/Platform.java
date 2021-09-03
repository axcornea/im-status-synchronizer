package com.acriox.imstatussynchronizer.configuration.platform;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Platform {
    LINUX("Linux"),
    WINDOWS("Windows"),
    MAC_OS("Mac OS X");

    private final String friendlyName;
}
