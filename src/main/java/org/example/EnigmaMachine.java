package org.example;

//TODO: Thinking about how you can swap the motors easily
public class EnigmaMachine implements UtilEnigma {
    private Rotor rightRotor;
    private Rotor middleRotor;
    private Rotor leftRotor;
    private Reflector reflector;
    private Character[] configurations;

    public EnigmaMachine(Character[] configurations)
    {
        this.initAll(configurations);
    }

    private void initAll(Character[] configurations)
    {

        this.rightRotor = new Rotor(
                "Right",
                new Character[]{'B', 'D', 'F', 'H', 'J', 'L', 'C', 'P', 'R', 'T', 'X', 'V', 'Z', 'N', 'Y', 'E', 'I', 'W', 'G', 'A', 'K', 'M', 'U', 'S', 'Q', 'O'},
                new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'},
                'M',
                translateToNumber(configurations[2])
        );


        this.middleRotor = new Rotor(
                "Middle",
                new Character[]{'A', 'J', 'D', 'K', 'S', 'I', 'R', 'U', 'X', 'B', 'L', 'H', 'W', 'T', 'M', 'C', 'Q', 'G', 'Z', 'N', 'P', 'Y', 'F', 'V', 'O', 'E'},
                new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'},
                'S',
                translateToNumber(configurations[1])
        );


        this.leftRotor = new Rotor(
                "Left",
                new Character[]{'E', 'K', 'M', 'F', 'L', 'G', 'D', 'Q', 'V', 'Z', 'N', 'T', 'O', 'W', 'Y', 'H', 'X', 'U', 'S', 'P', 'A', 'I', 'B', 'R', 'C', 'J'},
                new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'},
                'X',
                translateToNumber(configurations[0])
        );

        this.reflector = new Reflector();
    }

    public char encrypt(Character character)
    {
        Boolean isTriggeringNext = this.rightRotor.isTriggeringNext();

        // Rotate the right rotor
        this.rightRotor.rotate(1);
        Integer nextIndex = this.rightRotor.getNextLeftIndex(translateToNumber(character));
//        System.out.println("Right rotor: " + this.rightRotor.getSubLeft()[nextIndex]);

        if (isTriggeringNext)
        {
            this.middleRotor.rotate(1);
        }
        nextIndex = this.middleRotor.getNextLeftIndex(nextIndex);
//        System.out.println("Encrypted character: " + this.middleRotor.getSubLeft()[nextIndex]);

        nextIndex = this.leftRotor.getNextLeftIndex(nextIndex);
//        System.out.println("Left rotor: " + this.leftRotor.getSubLeft()[nextIndex]);

        nextIndex = this.reflector.getNextIndex(nextIndex);
//        System.out.println("Reflector: " + this.reflector.getReflector()[nextIndex]);

        nextIndex = this.leftRotor.getNextRightIndex(nextIndex);
//        System.out.println("Left rotor: " + this.leftRotor.getSubRight()[nextIndex]);

        nextIndex = this.middleRotor.getNextRightIndex(nextIndex);
//        System.out.println("Encrypted character: " + this.middleRotor.getSubRight()[nextIndex]);

        nextIndex = this.rightRotor.getNextRightIndex(nextIndex);

        return mapIndexToChar(nextIndex);
    }


}
