package Cube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

//000 -> white      010 -> green    100 -> yellow
//001 -> orange     011 -> red      101 -> blue

//Front -> green    Top -> white    back -> blue
//Right -> red      Left -> orange  Bottom -> yellow

public class Cube implements Comparable<Cube>{

    BitSet bits = new BitSet(27);

    BitSet[][] front = new BitSet[3][3];
    BitSet[][] back = new BitSet[3][3];
    BitSet[][] top = new BitSet[3][3];
    BitSet[][] bottom = new BitSet[3][3];
    BitSet[][] left = new BitSet[3][3];
    BitSet[][] right = new BitSet[3][3];
    private ArrayList<Integer> moves;

    public int heuristic(){
        int j, i, r = moves.size();
        for(int k = 0; k < 9; k++){
            j = k%3;
            i = k/3;
            if(front[i][j] != front[1][1])
                r++;
            if(back[i][j] != back[1][1])
                r++;
            if(left[i][j] != left[1][1])
                r++;
            if(right[i][j] != right[1][1])
                r++;
            if(bottom[i][j] != bottom[1][1])
                r++;
            if(top[i][j] != top[1][1])
                r++;
        }
        return r/10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cube cube = (Cube) o;

        if (!Arrays.deepEquals(front, cube.front)) return false;
        if (!Arrays.deepEquals(back, cube.back)) return false;
        if (!Arrays.deepEquals(top, cube.top)) return false;
        if (!Arrays.deepEquals(bottom, cube.bottom)) return false;
        if (!Arrays.deepEquals(left, cube.left)) return false;
        return Arrays.deepEquals(right, cube.right);

    }

    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(front);
        result = 31 * result + Arrays.deepHashCode(back);
        result = 31 * result + Arrays.deepHashCode(top);
        result = 31 * result + Arrays.deepHashCode(bottom);
        result = 31 * result + Arrays.deepHashCode(left);
        result = 31 * result + Arrays.deepHashCode(right);
        return result;
    }

    @Override
    public int compareTo(Cube o) {
        return (-(o.heuristic() - heuristic()));
    }

    public Cube() {
        BitSet white = new BitSet(3), blue = new BitSet(3), yellow = new BitSet(3),
            orange = new BitSet(3), green = new BitSet(3), red = new BitSet(3);

        orange.set(2);
        green.set(1);
        red.set(1); red.set(2);
        yellow.set(0);
        blue.set(0); blue.set(2);

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++) {
                front[i][j] = green;
                back[i][j] = blue;
                top[i][j] = white;
                bottom[i][j] = yellow;
                left[i][j] = orange;
                right[i][j] = red;
            }
        }
        moves = new ArrayList<>();
    }

    public Cube(Cube cube) {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++) {
                front[i][j] = (BitSet)cube.front[i][j].clone();
                back[i][j] = (BitSet)cube.back[i][j].clone();
                top[i][j] = (BitSet)cube.top[i][j].clone();
                bottom[i][j] = (BitSet)cube.bottom[i][j].clone();
                left[i][j] = (BitSet)cube.left[i][j].clone();
                right[i][j] = (BitSet)cube.right[i][j].clone();
            }
        moves = new ArrayList<>(cube.getMoves());
    }

    public boolean isOk() {
        int j, i, I, J, K;
        for(int k = 0; k < 8; k++){
            j = k%3;
            i = k/3;
            K = k+1;
            I = K%3;
            J = K/3;
            if(!front[i][j].equals(front[I][J]))
                return false;
            if(!back[i][j].equals(back[I][J]))
                return false;
            if(!left[i][j].equals(left[I][J]))
                return false;
            if(!right[i][j].equals(right[I][J]))
                return false;
            if(!bottom[i][j].equals(bottom[I][J]))
                return false;
            if(!top[i][j].equals(top[I][J]))
                return false;
        }
        return true;
    }


    public void rotateFaceRight(BitSet[][] M){
        BitSet[][] aux = new BitSet[3][];
        int k, l = 0;
        for(int i = 0; i < 3; i++)
            aux[i] = M[i].clone();
        for(int i = 0; i < 3; i++){
            k = 0;
            for(int j = 2; j >= 0; j--){
                M[l][k] = aux[j][i];
                k++;
            }
            l++;
        }
    }

    public void rotateFaceLeft(BitSet[][] M){
        BitSet [][] aux = new BitSet[3][];
        int k, l = 0;
        for(int i = 0; i < 3; i++)
            aux[i] = M[i].clone();
        for(int i = 2; i >= 0; i--){
            k = 0;
            for(int j = 0; j < 3; j++){
                M[l][k] = aux[j][i];
                k++;
            }
            l++;
        }
    }

    public void rotate1(){
        for(int i = 0; i < 3; i++){
            BitSet aux1 = top[i][0];
            BitSet aux2 = back[i][0];
            BitSet aux3 = bottom[i][0];
            top[i][0] = front[i][0];
            back[i][0] = aux1;
            bottom[i][0] = aux2;
            front[i][0] = aux3;
        }
        rotateFaceLeft(left);
    }

    public void rotate2(){
        for(int i = 0; i < 3; i++){
            BitSet aux1 = top[i][2];
            BitSet aux2 = back[i][2];
            BitSet aux3 = bottom[i][2];
            top[i][2] = front[i][2];
            back[i][2] = aux1;
            bottom[i][2] = aux2;
            front[i][2] = aux3;
        }
        rotateFaceRight(right);
    }

    public void rotate3(){
        BitSet lf[] = new BitSet[3];
        BitSet bt[] = new BitSet[3];
        for(int i = 0; i < 3; i++){
            lf[i] = left[i][2];
            bt[i] = bottom[0][i];
        }
        for(int i = 0; i < 3; i++){
            BitSet aux1 = top[2][i];
            BitSet aux2 = right[i][0];
            BitSet aux3 = bt[i];
            top[2][i] = lf[Math.abs(i-2)];
            right[i][0] = aux1;
            bottom[0][Math.abs(i-2)] = aux2;
            left[i][2] = aux3;
        }

        rotateFaceRight(front);
    }

    public void rotate4(){
        BitSet lf[] = new BitSet[3];
        BitSet bt[] = new BitSet[3];
        for(int i = 0; i < 3; i++){
            lf[i] = left[i][0];
            bt[i] = bottom[2][i];
        }
        for(int i = 0; i < 3; i++){
            BitSet aux1 = top[0][i];
            BitSet aux2 = right[i][2];
            BitSet aux3 = bt[i];
            top[0][i] = lf[Math.abs(i-2)];
            right[i][2] = aux1;
            bottom[2][Math.abs(i-2)] = aux2;
            left[i][0] = aux3;
        }
        rotateFaceLeft(back);
    }

    public void rotate5(){
        for(int i = 0; i < 3; i++){
            BitSet aux1 = front[0][i];
            BitSet aux2 = right[0][i];
            BitSet aux3 = back[2][Math.abs(i-2)];
            front[0][i] = left[0][i];
            right[0][i] = aux1;
            back[2][Math.abs(i-2)] = aux2;
            left[0][i] = aux3;
        }
        rotateFaceLeft(top);
    }

    public void rotate6(){
        for(int i = 0; i < 3; i++){
            BitSet aux1 = front[2][i];
            BitSet aux2 = right[2][i];
            BitSet aux3 = back[0][Math.abs(i-2)];
            front[2][i] = left[2][i];
            right[2][i] = aux1;
            back[0][Math.abs(i-2)] = aux2;
            left[2][i] = aux3;
        }
        rotateFaceRight(bottom);
    }

    public void rotate1P(){
        for(int i = 0; i < 3; i++){
            BitSet aux1 = top[i][0];
            BitSet aux2 = front[i][0];
            BitSet aux3 = bottom[i][0];
            top[i][0] = back[i][0];
            front[i][0] = aux1;
            bottom[i][0]= aux2;
            back[i][0]= aux3;
        }
        rotateFaceRight(left);
    }

    public void rotate2P(){
        for(int i = 0; i < 3; i++){
            BitSet aux1 = top[i][2];
            BitSet aux2 = front[i][2];
            BitSet aux3 = bottom[i][2];
            top[i][2] = back[i][2];
            front[i][2] = aux1;
            bottom[i][2]= aux2;
            back[i][2]= aux3;
        }
        rotateFaceLeft(right);
    }

    public void rotate3P(){
        BitSet rf[] = new BitSet[3];
        BitSet bt[] = new BitSet[3];
        for(int i = 0; i < 3; i++){
            rf[i] = top[2][i];
            bt[i] = bottom[0][i];
        }
        for(int i = 0; i < 3; i++){
            BitSet aux1 = right[i][0];
            BitSet aux2 = left[i][2];
            //int aux3 = rf[i];
            left[i][2] = rf[Math.abs(i-2)];
            bottom[0][i] = aux2;
            right[i][0] = bt[Math.abs(i-2)];
            top[2][i] = aux1;
        }
        rotateFaceLeft(front);
    }

    public void rotate4P(){
        BitSet rf[] = new BitSet[3];
        BitSet bt[] = new BitSet[3];
        for(int i = 0; i < 3; i++){
            rf[i] = top[0][i];
            bt[i] = bottom[2][i];
        }
        for(int i = 0; i < 3; i++){
            BitSet aux1 = right[i][2];
            BitSet aux2 = left[i][0];
            //int aux3 = rf[i];
            left[i][0] = rf[Math.abs(i-2)];
            bottom[2][i] = aux2;
            right[i][2] = bt[Math.abs(i-2)];
            top[0][i] = aux1;
        }
        rotateFaceRight(back);
    }

    public void rotate5P(){
        for(int i = 0; i < 3; i++){
            BitSet aux1 = front[0][i];
            BitSet aux2 = left[0][i];
            BitSet aux3 = back[2][Math.abs(i-2)];
            front[0][i] = right[0][i];
            left[0][i] = aux1;
            back[2][Math.abs(i-2)] = aux2;
            right[0][i] = aux3;
        }
        rotateFaceRight(top);
    }

    public void rotate6P(){
        for(int i = 0; i < 3; i++){
            BitSet aux1 = front[2][i];
            BitSet aux2 = left[2][i];
            BitSet aux3 = back[0][Math.abs(i-2)];
            front[2][i] = right[2][i];
            left[2][i] = aux1;
            back[0][Math.abs(i-2)] = aux2;
            right[2][i] = aux3;
        }
        rotateFaceLeft(bottom);
    }

    public void unorder(){
        int disorderNumber = 6, r;
        ArrayList<Integer> rotations = new ArrayList<>(disorderNumber);
        System.out.println("Unordering");
        for(int i = 0; i < disorderNumber; i++) {
            r = (int) (Math.random() * 12);
            rotations.add(r+1);
            switch (r) {
                case 0:
                    rotate1();
                    break;
                case 1:
                    rotate2();
                    break;
                case 2:
                    rotate3();
                    break;
                case 3:
                    rotate4();
                    break;
                case 4:
                    rotate5();
                    break;
                case 5:
                    rotate6();
                    break;
                case 6:
                    rotate1P();
                    break;
                case 7:
                    rotate2P();
                    break;
                case 8:
                    rotate3P();
                    break;
                case 9:
                    rotate4P();
                    break;
                case 10:
                    rotate5P();
                    break;
                case 11:
                    rotate6P();
                    break;
            }
        }
        System.out.println(rotations);
    }

    @Override
    public String toString(){
        StringBuilder theString = new StringBuilder();

        String waka;
        theString.append("Top: [");
        for(int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                theString.append(top[i][j]);
                waka = (i == 2 && j == 2)?"] \n":",";
                theString.append(waka);
            }
        //theString.append("] \n");
        theString.append("Front: [");
        for(int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                theString.append(front[i][j]);
                waka = (i == 2 && j == 2)?"] \n":",";
                theString.append(waka);
            }

        //theString.append("] \n");

        theString.append("Bottom: [");
        for(int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                theString.append(bottom[i][j]);
                waka = (i == 2 && j == 2)?"] \n":",";
                theString.append(waka);
            }

        //theString.append("] \n");

        theString.append("Back: [");
        for(int i = 2; i >= 0; i--)
            for (int j = 2; j >= 0; j--)
            {
                theString.append(back[i][j]);
                waka = (i == 0 && j == 0)?"] \n":",";
                theString.append(waka);
            }

        //theString.append("] \n");
        theString.append("Left: [");
        for(int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                theString.append(left[i][j]);
                waka = (i == 2 && j == 2)?"] \n":",";
                theString.append(waka);
            }

        //theString.append("] \n");
        theString.append("Right: [");
        for(int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                theString.append(right[i][j]);
                waka = (i == 2 && j == 2)?"] \n":",";
                theString.append(waka);
            }

        //theString.append("] \n");
        return theString.toString();
    }

    public void addMove(int move){
        moves.add(move);
    }

    public ArrayList<Integer> getMoves(){
        return moves;
    }
}
