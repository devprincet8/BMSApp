package com.soarmorrow.bms.constants;

public enum AppUserStatus {

    FIRST_INSTALL(0),
    LOGGED_IN_MODE(1),
    LOGGED_OUT_MODE(2);

    private final int mType;

    AppUserStatus(int type) {
        mType = type;
    }

    public int getType() {
        return mType;
    }
}