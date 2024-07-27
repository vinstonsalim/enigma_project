package org.example;

public class Reflector implements UtilEnigma {
    private final Character[] reflector;

    public Reflector() {
        this.reflector = this.initReflector();
    }

    public Character[] initReflector()
    {
        return new Character[] {
                'A',
                'B',
                'C',
                'D',
                'E',
                'F',
                'G',
                'D',
                'I',
                'J',
                'K',
                'G',
                'M',
                'K',
                'M',
                'I',
                'E',
                'B',
                'F',
                'T',
                'C',
                'V',
                'V',
                'J',
                'A',
                'T',
        };
    }

    public Character[] getReflector() {
        return reflector;
    }

    public Integer getNextIndex(Integer startIndex) {
        char key = this.reflector[startIndex];

        for (int i = 0; i < this.reflector.length; i++) {
            if (this.reflector[i] == key  && i != startIndex) {
                return i;
            }
        }

        return -1;
    }
}
