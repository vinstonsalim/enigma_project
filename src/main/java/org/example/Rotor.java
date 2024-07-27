package org.example;

public class Rotor {

    private Character[] subLeft;
    private Character[] subRight;
    private String rotorName;
    private Character triggerRotationCharSubRight;

    public Character[] getSubLeft() {
        return subLeft;
    }

    public Character[] getSubRight() {
        return subRight;
    }

    public Rotor(String rotorName, Character[] subRight, Character[] subLeft,Character triggerRotationCharSubRight, Integer initState) {
        this.rotorName = rotorName;
        this.subLeft = subLeft;
        this.subRight = subRight;
        this.triggerRotationCharSubRight = triggerRotationCharSubRight;
        this.rotate(initState);
    }

    public String getRotorName()
    {
        return this.rotorName;
    }

    public void rotate(Integer rotations)
    {
        // Rotate the left side
        for (int i = 0; i < rotations; i++)
        {
            Character tempLeft = this.subLeft[0];
            Character tempRight = this.subRight[0];

            for (int j = 0; j < this.subLeft.length - 1; j++)
            {
                this.subLeft[j] = this.subLeft[j + 1];
                this.subRight[j] = this.subRight[j + 1];
            }

            this.subLeft[this.subLeft.length - 1] = tempLeft;
            this.subRight[this.subRight.length - 1] = tempRight;
        }
    }

    public Integer getNextLeftIndex(Integer startIndex) {
        return this.getNextIndex(startIndex, true);
    }

    public Integer getNextRightIndex(Integer startIndex) {
        return this.getNextIndex(startIndex, false);
    }

    public Integer getNextIndex(Integer startIndex, Boolean isToLeft) {
        char value = isToLeft ? this.subRight[startIndex] : this.subLeft[startIndex];
        Character[] sub = isToLeft ? this.subLeft : this.subRight;

        for (int i = 0; i < sub.length; i++) {
            if (sub[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public Boolean isTriggeringNext() {
        return this.subRight[0] == this.triggerRotationCharSubRight;
    }
}
