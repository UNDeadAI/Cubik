package Cube;


import java.util.BitSet;

public class AuxMain {

    public static void main(String args[]){
        BitSet white = new BitSet(3), blue = new BitSet(3), yellow = new BitSet(3),
                orange = new BitSet(3), green = new BitSet(3), red = new BitSet(3);

        orange.set(2);
        green.set(1);
        red.set(1); red.set(2);
        yellow.set(0);
        blue.set(0); blue.set(2);
        System.out.println("White: " + white);
        System.out.println("Blue: " + blue);
        System.out.println("Yellow: " + yellow);
        System.out.println("Orange: " + orange);
        System.out.println("Green: " + green);
        System.out.println("Red: " + red);
    }
}
