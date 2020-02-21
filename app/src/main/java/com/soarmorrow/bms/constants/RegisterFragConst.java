package com.soarmorrow.bms.constants;

public enum RegisterFragConst {
    COMPANY(0),
    USER(1),
    THANKYOU(2);
    private final int mType;

    RegisterFragConst(int type) {
        mType = type;
    }

    public int getType() {
        return mType;
    }
}