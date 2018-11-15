package com.codecool.util;

import java.util.UUID;

public abstract class Util {

    protected String createId() {
        return UUID.randomUUID().toString();
    }

    protected abstract boolean checkIfIdIsUnique(String id);

    public String getNewId() {
        String idToCheck = createId();
        if (checkIfIdIsUnique(idToCheck)) {
            return idToCheck;
        } else {
            getNewId();
        }
        return null;
    }
}
