package com.birelandef.utils;

import java.util.UUID;

/**
 * Created by sophie on 21/05/17.
 */
public final class IdGenerator {
    public static String generatorId() {
        return UUID.randomUUID().toString();
    }
}
