package org.example;

public interface UtilEnigma {

    public default int translateToNumber(Character c) {
        return (int) c - 65;
    }

    public default char mapIndexToChar(Integer index) {
        return (char) (index + 65);
    }
}
