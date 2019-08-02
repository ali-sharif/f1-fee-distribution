package org.aion.f1;

public class Address {
    public static final int LENGTH = 32;
    private final byte[] raw = new byte[32];
    private static final char[] hexArray = "0123456789abcdef".toCharArray();

    public Address(byte[] raw) throws IllegalArgumentException {
        if (raw == null) {
            throw new NullPointerException();
        } else if (raw.length != 32) {
            throw new IllegalArgumentException();
        } else {
            System.arraycopy(raw, 0, this.raw, 0, 32);
        }
    }

    public byte[] toByteArray() {
        byte[] copy = new byte[32];
        System.arraycopy(this.raw, 0, copy, 0, 32);
        return copy;
    }

    public int hashCode() {
        int code = 0;
        byte[] var2 = this.raw;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            byte elt = var2[var4];
            code += elt;
        }

        return code;
    }

    public boolean equals(Object obj) {
        boolean isEqual = this == obj;
        if (!isEqual && obj instanceof Address) {
            Address other = (Address)obj;
            isEqual = true;

            for(int i = 0; isEqual && i < 32; ++i) {
                isEqual = this.raw[i] == other.raw[i];
            }
        }

        return isEqual;
    }

    public String toString() {
        return toHexStringForAPI(this.raw);
    }

    private static String toHexStringForAPI(byte[] bytes) {
        int length = bytes.length;
        char[] hexChars = new char[length * 2];

        for(int i = 0; i < length; ++i) {
            int v = bytes[i] & 255;
            hexChars[i * 2] = hexArray[v >>> 4];
            hexChars[i * 2 + 1] = hexArray[v & 15];
        }

        return new String(hexChars);
    }
}