package Cube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

//000 -> white      010 -> green    100 -> yellow
//001 -> orange     011 -> red      101 -> blue

//Front -> green    Top -> white    Black -> blue
//Right -> red      Left -> orange  Bottom -> yellow

//front -> 0        back -> 27      top -> 54
//bottom -> 81      left -> 108     right -> 135

public class Cube implements Comparable<Cube>{

    BitSet bits;
    private int front = 0, back = 27, top = 54, bottom = 81, left = 108, right = 135;
    public static BitSet okCube = new BitSet(162);

    private ArrayList<Integer> moves;

//    public int heuristic(){
//        int j, i, r = moves.size();
//        for(int k = 0; k < 9; k++){
//            j = k%3;
//            i = k/3;
//            if(front[i][j] != front[1][1])
//                r++;
//            if(back[i][j] != back[1][1])
//                r++;
//            if(left[i][j] != left[1][1])
//                r++;
//            if(right[i][j] != right[1][1])
//                r++;
//            if(bottom[i][j] != bottom[1][1])
//                r++;
//            if(top[i][j] != top[1][1])
//                r++;
//        }
//        return r/10;
//    }
//
//    @Override
//    public int compareTo(Cube o) {
//        return (-(o.heuristic() - heuristic()));
//    }

    @Override
    public int compareTo(Cube o) {
        return 0;
    }

    public Cube() {
        bits = new BitSet(162);
        BitSet white = new BitSet(3), blue = new BitSet(3), yellow = new BitSet(3),
            orange = new BitSet(3), green = new BitSet(3), red = new BitSet(3);

        orange.set(2);
        green.set(1);
        red.set(1); red.set(2);
        yellow.set(0);
        blue.set(0); blue.set(2);

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++) {
                for(int n = 0;  n < 3; n++) {
                    bits.set(9 * i + 3 * j + front + n, green.get(n));
                    okCube.set(9 * i + 3 * j + front + n, green.get(n));
                }

                for(int n = 0;  n < 3; n++) {
                    bits.set(9 * i + 3 * j + back + n, blue.get(n));
                    okCube.set(9 * i + 3 * j + back + n, blue.get(n));
                }

                for(int n = 0;  n < 3; n++) {
                    bits.set(9 * i + 3 * j + top + n, white.get(n));
                    okCube.set(9 * i + 3 * j + top + n, white.get(n));
                }

                for(int n = 0;  n < 3; n++) {
                    bits.set(9 * i + 3 * j + bottom + n, yellow.get(n));
                    okCube.set(9 * i + 3 * j + bottom + n, yellow.get(n));
                }

                for(int n = 0;  n < 3; n++) {
                    bits.set(9 * i + 3 * j + left + n, orange.get(n));
                    okCube.set(9 * i + 3 * j + left + n, orange.get(n));
                }

                for(int n = 0;  n < 3; n++) {
                    bits.set(9 * i + 3 * j + right + n, red.get(n));
                    okCube.set(9 * i + 3 * j + right + n, red.get(n));
                }
            }
        }
        moves = new ArrayList<>();
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
//        int j, i, I, J, K, aux1, aux2;
//        BitSet tmp1, tmp2;
//        for(int k = 0; k < 8; k++){
//            j = k%3;
//            i = k/3;
//            K = k+1;
//            I = K%3;
//            J = K/3;
//
//            aux1 = 9*i+3*j+front;
//            aux2 = 9*I+3*J+front;
//            tmp1 = bits.get(aux1, aux1+3);
//            tmp2 = bits.get(aux2, aux2+3);
//            if(!tmp1.equals(tmp2))
//                return false;
//
//            aux1 = 9*i+3*j+back;
//            aux2 = 9*I+3*J+back;
//            tmp1 = bits.get(aux1, aux1+3);
//            tmp2 = bits.get(aux2, aux2+3);
//            if(!tmp1.equals(tmp2))
//                return false;
//
//            aux1 = 9*i+3*j+left;
//            aux2 = 9*I+3*J+left;
//            tmp1 = bits.get(aux1, aux1+3);
//            tmp2 = bits.get(aux2, aux2+3);
//            if(!tmp1.equals(tmp2))
//                return false;
//
//            aux1 = 9*i+3*j+right;
//            aux2 = 9*I+3*J+right;
//            tmp1 = bits.get(aux1, aux1+3);
//            tmp2 = bits.get(aux2, aux2+3);
//            if(!tmp1.equals(tmp2))
//                return false;
//
//            aux1 = 9*i+3*j+bottom;
//            aux2 = 9*I+3*J+bottom;
//            tmp1 = bits.get(aux1, aux1+3);
//            tmp2 = bits.get(aux2, aux2+3);
//            if(!tmp1.equals(tmp2))
//                return false;
//
//            aux1 = 9*i+3*j+top;
//            aux2 = 9*I+3*J+top;
//            tmp1 = bits.get(aux1, aux1+3);
//            tmp2 = bits.get(aux2, aux2+3);
//            if(!tmp1.equals(tmp2))
//                return false;
//        }
//        return true;
    }

    public void rotateFaceRight(int w){
        BitSet tmp;
        int k, l = 0, tmp2;
        for(int i = 0; i < 3; i++){
            k = 0;
            for(int j = 2; j >= 0; j--){
                tmp2 = (j*9+i*3)+w;
                tmp = bits.get(tmp2, tmp2+3);
                tmp2 = (l*9+k*3)+w;
                for(int n = 0; n < 3; n++)
                    bits.set(tmp2+n, tmp.get(i));
                k++;
            }
            l++;
        }
    }

//    public void rotateFaceRight(BitSet[][] M){
//        BitSet[][] aux = new BitSet[3][];
//        int k, l = 0;
//        for(int i = 0; i < 3; i++)
//            aux[i] = M[i].clone();
//        for(int i = 0; i < 3; i++){
//            k = 0;
//            for(int j = 2; j >= 0; j--){
//                M[l][k] = aux[j][i];
//                k++;
//            }
//            l++;
//        }
//    }

    public void rotateFaceLeft(int w){
        BitSet tmp;
        int k, l = 0, tmp2;
        for(int i = 2; i >= 0; i--){
            k = 0;
            for(int j = 0; j < 3; j++){
                tmp2 = (j*9+i*3)+w;
                tmp = bits.get(tmp2, tmp2+3);
                tmp2 = (l*9+k*3)+w;
                for(int n = 0; n < 3; n++)
                    bits.set(tmp2+n, tmp.get(n));
                k++;
            }
            l++;
        }
    }

//    public void rotateFaceLeft(BitSet[][] M){
//        BitSet [][] aux = new BitSet[3][];
//        int k, l = 0;
//        for(int i = 0; i < 3; i++)
//            aux[i] = M[i].clone();
//        for(int i = 2; i >= 0; i--){
//            k = 0;
//            for(int j = 0; j < 3; j++){
//                M[l][k] = aux[j][i];
//                k++;
//            }
//            l++;
//        }
//    }

    public void rotate1(){
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = top[i][0];
            tmp = (i*9)+top;
            aux1 = bits.get(tmp, tmp+3);

            //BitSet aux2 = back[i][0];
            tmp = (i*9)+back;
            aux2 = bits.get(tmp, tmp+3);

            //BitSet aux3 = bottom[i][0];
            tmp = (i*9)+bottom;
            aux3 = bits.get(tmp, tmp+3);

            tmp = (i*9)+front;
            aux4 = bits.get(tmp, tmp+3);

            //top[i][0] = front[i][0];
            for(int n = 0; n < 3; n++)
                bits.set((i*9)+top+n, aux4.get(n));

            //back[i][0] = aux1;
            for(int n = 0; n < 3; n++)
                bits.set((i*9)+back+n, aux1.get(n));

            //bottom[i][0] = aux2;
            for(int n = 0; n < 3; n++)
                bits.set((i*9)+bottom+n, aux2.get(n));

            //front[i][0] = aux3;
            for(int n = 0; n < 3; n++)
                bits.set((i*9)+front+n, aux3.get(n));
        }
        rotateFaceLeft(left);
    }

    public void rotate1P(){
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = top[i][0];
            tmp = (i*9)+top;
            aux1 = bits.get(tmp, tmp+3);

            //BitSet aux2 = front[i][0];
            tmp = (i*9)+front;
            aux2 = bits.get(tmp, tmp+3);

            //BitSet aux3 = bottom[i][0];
            tmp = (i*9)+bottom;
            aux3 = bits.get(tmp, tmp+3);

            tmp = (i*9)+back;
            aux4 = bits.get(tmp, tmp+3);

            //top[i][0] = back[i][0];
            for(int n = 0; n < 3; n++)
                bits.set((i*9)+top+n, aux4.get(n));

            //front[i][0] = aux1;
            for(int n = 0; n < 3; n++)
                bits.set((i*9)+front+n, aux1.get(n));

            //bottom[i][0]= aux2;
            for(int n = 0; n < 3; n++)
                bits.set((i*9)+bottom+n, aux2.get(n));

            //back[i][0]= aux3;
            for(int n = 0; n < 3; n++)
                bits.set((i*9)+back+n, aux3.get(n));
        }
        rotateFaceRight(left);
    }

//    public void rotate2(){
//        for(int i = 0; i < 3; i++){
//            BitSet aux1 = top[i][2];
//            BitSet aux2 = back[i][2];
//            BitSet aux3 = bottom[i][2];
//            top[i][2] = front[i][2];
//            back[i][2] = aux1;
//            bottom[i][2] = aux2;
//            front[i][2] = aux3;
//        }
//        rotateFaceRight(right);
//    }
//
//    public void rotate3(){
//        BitSet lf[] = new BitSet[3];
//        BitSet bt[] = new BitSet[3];
//        for(int i = 0; i < 3; i++){
//            lf[i] = left[i][2];
//            bt[i] = bottom[0][i];
//        }
//        for(int i = 0; i < 3; i++){
//            BitSet aux1 = top[2][i];
//            BitSet aux2 = right[i][0];
//            BitSet aux3 = bt[i];
//            top[2][i] = lf[Math.abs(i-2)];
//            right[i][0] = aux1;
//            bottom[0][Math.abs(i-2)] = aux2;
//            left[i][2] = aux3;
//        }
//
//        rotateFaceRight(front);
//    }
//
//    public void rotate4(){
//        BitSet lf[] = new BitSet[3];
//        BitSet bt[] = new BitSet[3];
//        for(int i = 0; i < 3; i++){
//            lf[i] = left[i][0];
//            bt[i] = bottom[2][i];
//        }
//        for(int i = 0; i < 3; i++){
//            BitSet aux1 = top[0][i];
//            BitSet aux2 = right[i][2];
//            BitSet aux3 = bt[i];
//            top[0][i] = lf[Math.abs(i-2)];
//            right[i][2] = aux1;
//            bottom[2][Math.abs(i-2)] = aux2;
//            left[i][0] = aux3;
//        }
//        rotateFaceLeft(back);
//    }
//
//    public void rotate5(){
//        for(int i = 0; i < 3; i++){
//            BitSet aux1 = front[0][i];
//            BitSet aux2 = right[0][i];
//            BitSet aux3 = back[2][Math.abs(i-2)];
//            front[0][i] = left[0][i];
//            right[0][i] = aux1;
//            back[2][Math.abs(i-2)] = aux2;
//            left[0][i] = aux3;
//        }
//        rotateFaceLeft(top);
//    }
//
//    public void rotate6(){
//        for(int i = 0; i < 3; i++){
//            BitSet aux1 = front[2][i];
//            BitSet aux2 = right[2][i];
//            BitSet aux3 = back[0][Math.abs(i-2)];
//            front[2][i] = left[2][i];
//            right[2][i] = aux1;
//            back[0][Math.abs(i-2)] = aux2;
//            left[2][i] = aux3;
//        }
//        rotateFaceRight(bottom);
//    }

//    public void rotate2P(){
//        for(int i = 0; i < 3; i++){
//            BitSet aux1 = top[i][2];
//            BitSet aux2 = front[i][2];
//            BitSet aux3 = bottom[i][2];
//            top[i][2] = back[i][2];
//            front[i][2] = aux1;
//            bottom[i][2]= aux2;
//            back[i][2]= aux3;
//        }
//        rotateFaceLeft(right);
//    }
//
//    public void rotate3P(){
//        BitSet rf[] = new BitSet[3];
//        BitSet bt[] = new BitSet[3];
//        for(int i = 0; i < 3; i++){
//            rf[i] = top[2][i];
//            bt[i] = bottom[0][i];
//        }
//        for(int i = 0; i < 3; i++){
//            BitSet aux1 = right[i][0];
//            BitSet aux2 = left[i][2];
//            //int aux3 = rf[i];
//            left[i][2] = rf[Math.abs(i-2)];
//            bottom[0][i] = aux2;
//            right[i][0] = bt[Math.abs(i-2)];
//            top[2][i] = aux1;
//        }
//        rotateFaceLeft(front);
//    }
//
//    public void rotate4P(){
//        BitSet rf[] = new BitSet[3];
//        BitSet bt[] = new BitSet[3];
//        for(int i = 0; i < 3; i++){
//            rf[i] = top[0][i];
//            bt[i] = bottom[2][i];
//        }
//        for(int i = 0; i < 3; i++){
//            BitSet aux1 = right[i][2];
//            BitSet aux2 = left[i][0];
//            //int aux3 = rf[i];
//            left[i][0] = rf[Math.abs(i-2)];
//            bottom[2][i] = aux2;
//            right[i][2] = bt[Math.abs(i-2)];
//            top[0][i] = aux1;
//        }
//        rotateFaceRight(back);
//    }
//
//    public void rotate5P(){
//        for(int i = 0; i < 3; i++){
//            BitSet aux1 = front[0][i];
//            BitSet aux2 = left[0][i];
//            BitSet aux3 = back[2][Math.abs(i-2)];
//            front[0][i] = right[0][i];
//            left[0][i] = aux1;
//            back[2][Math.abs(i-2)] = aux2;
//            right[0][i] = aux3;
//        }
//        rotateFaceRight(top);
//    }
//
//    public void rotate6P(){
//        for(int i = 0; i < 3; i++){
//            BitSet aux1 = front[2][i];
//            BitSet aux2 = left[2][i];
//            BitSet aux3 = back[0][Math.abs(i-2)];
//            front[2][i] = right[2][i];
//            left[2][i] = aux1;
//            back[0][Math.abs(i-2)] = aux2;
//            right[2][i] = aux3;
//        }
//        rotateFaceLeft(bottom);
//    }

    public void unorder(){
        int disorderNumber = 1, r;
        ArrayList<Integer> rotations = new ArrayList<>(disorderNumber);
        System.out.println("Unordering");
        for(int i = 0; i < disorderNumber; i++) {
            r = (int) (Math.random() * 1);
            rotations.add(r+1);
            switch (r) {
                case 0:
                    rotate1();
                    break;
//                case 1:
//                    rotate2();
//                    break;
//                case 2:
//                    rotate3();
//                    break;
//                case 3:
//                    rotate4();
//                    break;
//                case 4:
//                    rotate5();
//                    break;
//                case 5:
//                    rotate6();
//                    break;
                case 6:
                    rotate1P();
                    break;
//                case 7:
//                    rotate2P();
//                    break;
//                case 8:
//                    rotate3P();
//                    break;
//                case 9:
//                    rotate4P();
//                    break;
//                case 10:
//                    rotate5P();
//                    break;
//                case 11:
//                    rotate6P();
//                    break;
            }
        }
        System.out.println(rotations);
    }

    @Override
    public String toString(){
        //StringBuilder theString = new StringBuilder();

//        String waka;
//        theString.append("Top: [");
//        for(int i = 0; i < 3; i++)
//            for (int j = 0; j < 3; j++) {
//                theString.append(top[i][j]);
//                waka = (i == 2 && j == 2)?"] \n":",";
//                theString.append(waka);
//            }
//        //theString.append("] \n");
//        theString.append("Front: [");
//        for(int i = 0; i < 3; i++)
//            for (int j = 0; j < 3; j++) {
//                theString.append(front[i][j]);
//                waka = (i == 2 && j == 2)?"] \n":",";
//                theString.append(waka);
//            }
//
//        //theString.append("] \n");
//
//        theString.append("Bottom: [");
//        for(int i = 0; i < 3; i++)
//            for (int j = 0; j < 3; j++) {
//                theString.append(bottom[i][j]);
//                waka = (i == 2 && j == 2)?"] \n":",";
//                theString.append(waka);
//            }
//
//        theString.append("Back: [");
//        for(int i = 2; i >= 0; i--)
//            for (int j = 2; j >= 0; j--)
//            {
//                theString.append(back[i][j]);
//                waka = (i == 0 && j == 0)?"] \n":",";
//                theString.append(waka);
//            }
//
//        theString.append("Left: [");
//        for(int i = 0; i < 3; i++)
//            for (int j = 0; j < 3; j++) {
//                theString.append(left[i][j]);
//                waka = (i == 2 && j == 2)?"] \n":",";
//                theString.append(waka);
//            }
//
//        theString.append("Right: [");
//        for(int i = 0; i < 3; i++)
//            for (int j = 0; j < 3; j++) {
//                theString.append(right[i][j]);
//                waka = (i == 2 && j == 2)?"] \n":",";
//                theString.append(waka);
//            }

        return bits.toString();
    }

    public void addMove(int move){
        moves.add(move);
    }

    public ArrayList<Integer> getMoves(){
        return moves;
    }
}
