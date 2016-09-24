package Cube;

import java.util.ArrayList;
import java.util.BitSet;

public class Cube implements Comparable<Cube>{

    BitSet bits;
    public static BitSet okCube = new BitSet(162);
    private ArrayList<Byte> moves;

    @Override
    public int compareTo(Cube o) {
        return (-(CubeMover.heuristic(o) - CubeMover.heuristic(this)));
    }

    public Cube() {
        bits = new BitSet(162);
        moves = new ArrayList<>();
        CubeMover.createCube(this);
    }

    public Cube(Cube cube) {
        bits = (BitSet)cube.bits.clone();
        moves = new ArrayList<>(cube.getMoves());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cube cube = (Cube) o;

        return bits.equals(cube.bits);
    }

    @Override
    public int hashCode() {
        return bits.hashCode();
    }

    public boolean isOk() {
        return bits.equals(okCube);
    }

    @Override
    public String toString(){
        return bits.toString();
    }

    public void addMove(Byte move){
        moves.add(move);
    }

    public ArrayList<Byte> getMoves(){
        return moves;
    }
}
