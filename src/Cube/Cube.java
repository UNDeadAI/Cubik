package Cube;

import java.util.ArrayList;
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
                    bits.set(tmp2+n, tmp.get(n));
                k++;
            }
            l++;
        }
    }

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

    public void rotate2(){
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = top[i][2];
            tmp = (i*9)+6+top;
            aux1 = bits.get(tmp, tmp+3);

            //BitSet aux2 = back[i][2];
            tmp = (i*9)+6+back;
            aux2 = bits.get(tmp, tmp+3);

            //BitSet aux3 = bottom[i][2];
            tmp = (i*9)+6+bottom;
            aux3 = bits.get(tmp, tmp+3);

            tmp = (i*9)+6+front;
            aux4 = bits.get(tmp, tmp+3);

            //top[i][2] = front[i][2];
            for(int n = 0; n < 3; n++)
                bits.set((i*9)+6+top+n, aux4.get(n));

            //back[i][2] = aux1;
            for(int n = 0; n < 3; n++)
                bits.set((i*9)+6+back+n, aux1.get(n));

            //bottom[i][2] = aux2;
            for(int n = 0; n < 3; n++)
                bits.set((i*9)+6+bottom+n, aux2.get(n));

            //front[i][2] = aux3;
            for(int n = 0; n < 3; n++)
                bits.set((i*9)+6+front+n, aux3.get(n));
        }
        rotateFaceRight(right);
    }

    public void rotate3(){
        BitSet lf[] = new BitSet[3];
        BitSet bt[] = new BitSet[3];
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //lf[i] = left[i][2];
            tmp = (i*9)+6+left;
            lf[i] = bits.get(tmp, tmp+3);

            //bt[i] = bottom[0][i];
            tmp = (i*3)+bottom;
            bt[i] = bits.get(tmp, tmp+3);
        }
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = top[2][i];
            tmp = (18+i*3)+top;
            aux1 = bits.get(tmp, tmp+3);

            //BitSet aux2 = right[i][0];
            tmp = (i*9)+right;
            aux2 = bits.get(tmp, tmp+3);

            aux3 = bt[i];

            //top[2][i] = lf[Math.abs(i-2)];
            aux4 = lf[Math.abs(i-2)];
            for(int n = 0; n < 3; n++)
                bits.set(2*9+i*3+top+n, aux4.get(n));

            //right[i][0] = aux1;
            for(int n = 0; n < 3; n++)
                bits.set(i*9+right+n, aux1.get(n));

            //bottom[0][Math.abs(i-2)] = aux2;
            tmp = Math.abs(i-2);
            for(int n = 0; n < 3; n++)
                bits.set(tmp*3+bottom+n, aux2.get(n));

            //left[i][2] = aux3;
            for(int n = 0; n < 3; n++)
                bits.set(i*9+6+left+n, aux3.get(n));
        }
        rotateFaceRight(front);
    }

    public void rotate3P(){
        BitSet rf[] = new BitSet[3];
        BitSet bt[] = new BitSet[3];
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //rf[i] = top[2][i];
            tmp = 18+i*3+top;
            rf[i] = bits.get(tmp, tmp+3);

            //bt[i] = bottom[0][i];
            tmp = i*3+bottom;
            bt[i] = bits.get(tmp, tmp+3);
        }
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = right[i][0];
            tmp = i*9+right;
            aux1 = bits.get(tmp, tmp+3);

            //BitSet aux2 = left[i][2];
            tmp = i*9+6+left;
            aux2 = bits.get(tmp, tmp+3);

            //left[i][2] = rf[Math.abs(i-2)];
            aux3 = rf[Math.abs(i-2)];
            for(int n = 0; n < 3; n++)
                bits.set(i*9+6+left+n, aux3.get(n));

            //bottom[0][i] = aux2;
            for(int n = 0; n < 3; n++)
                bits.set(i*3+bottom+n, aux2.get(n));

            //right[i][0] = bt[Math.abs(i-2)];
            aux4 = bt[Math.abs(i-2)];
            for(int n = 0; n < 3; n++)
                bits.set(i*9+right+n, aux4.get(n));

            //top[2][i] = aux1;
            for(int n = 0; n < 3; n++)
                bits.set(18+i*3+top+n, aux1.get(n));
        }
        rotateFaceLeft(front);
    }

    public void rotate4(){
        BitSet lf[] = new BitSet[3];
        BitSet bt[] = new BitSet[3];
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //lf[i] = left[i][0];
            tmp = (i*9)+left;
            lf[i] = bits.get(tmp, tmp+3);

            //bt[i] = bottom[2][i];
            tmp = 18+i*3+bottom;
            bt[i] = bits.get(tmp, tmp+3);
        }
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = top[0][i];
            tmp = (i*3)+top;
            aux1 = bits.get(tmp, tmp+3);

            //BitSet aux2 = right[i][2];
            tmp = i*9+6+right;
            aux2 = bits.get(tmp, tmp+3);

            //BitSet aux3 = bt[i];
            aux3 = bt[i];

            //top[0][i] = lf[Math.abs(i-2)];
            aux4 = lf[Math.abs(i-2)];
            for(int n = 0; n < 3; n++)
                bits.set(i*3+top+n, aux4.get(n));

            //right[i][2] = aux1;
            for(int n = 0; n < 3; n++)
                bits.set(i*9+6+right+n, aux1.get(n));

            //bottom[2][Math.abs(i-2)] = aux2;
            tmp = Math.abs(i-2);
            for(int n = 0; n < 3; n++)
                bits.set(18+tmp*3+bottom+n, aux2.get(n));

            //left[i][0] = aux3;
            for(int n = 0; n < 3; n++)
                bits.set(i*9+left+n, aux3.get(n));
        }
        rotateFaceLeft(back);
    }

    public void rotate4P(){
        BitSet rf[] = new BitSet[3];
        BitSet bt[] = new BitSet[3];
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //rf[i] = top[0][i];
            tmp = i*3+top;
            rf[i] = bits.get(tmp, tmp+3);

            //bt[i] = bottom[2][i];
            tmp = 18+i*3+bottom;
            bt[i] = bits.get(tmp, tmp+3);
        }
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = right[i][2];
            tmp = i*9+6+right;
            aux1 = bits.get(tmp, tmp+3);

            //BitSet aux2 = left[i][0];
            tmp = i*9+left;
            aux2 = bits.get(tmp, tmp+3);

            //left[i][0] = rf[Math.abs(i-2)];
            aux3 = rf[Math.abs(i-2)];
            for(int n = 0; n < 3; n++)
                bits.set(i*9+left+n, aux3.get(n));

            //bottom[2][i] = aux2;
            for(int n = 0; n < 3; n++)
                bits.set(18+i*3+bottom+n, aux2.get(n));

            //right[i][2] = bt[Math.abs(i-2)];
            aux4 = bt[Math.abs(i-2)];
            for(int n = 0; n < 3; n++)
                bits.set(9*i+6+right+n, aux4.get(n));

            //top[0][i] = aux1;
            for(int n = 0; n < 3; n++)
                bits.set(i*3+top+n, aux1.get(n));

        }
        rotateFaceRight(back);
    }

    public void rotate5(){
        int tmp, tmp2;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = front[0][i];
            tmp = (i*3)+front;
            aux1 = bits.get(tmp, tmp+3);

            //BitSet aux2 = right[0][i];
            tmp = (i*3)+right;
            aux2 = bits.get(tmp, tmp+3);

            //BitSet aux3 = back[2][Math.abs(i-2)];
            tmp2 = Math.abs(i-2);
            tmp = 18+tmp2*3+back;
            aux3 = bits.get(tmp, tmp+3);

            tmp = (i*3)+left;
            aux4 = bits.get(tmp, tmp+3);

            //front[0][i] = left[0][i];
            for(int n = 0; n < 3; n++)
                bits.set(i*3+front+n, aux4.get(n));

            //right[0][i] = aux1;
            for(int n = 0; n < 3; n++)
                bits.set(i*3+right+n, aux1.get(n));

            //back[2][Math.abs(i-2)] = aux2;
            tmp = Math.abs(i-2);
            for(int n = 0; n < 3; n++)
                bits.set(18+tmp*3+back+n, aux2.get(n));

            //left[0][i] = aux3;
            for(int n = 0; n < 3; n++)
                bits.set(i*3+left+n, aux3.get(n));
        }
        rotateFaceLeft(top);
    }

    public void rotate6(){
        int tmp, tmp2;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = front[2][i];
            tmp = 18+i*3+front;
            aux1 = bits.get(tmp, tmp+3);

            //BitSet aux2 = right[2][i];
            tmp = 18+i*3+right;
            aux2 = bits.get(tmp, tmp+3);

            //BitSet aux3 = back[0][Math.abs(i-2)];
            tmp2 = Math.abs(i-2);
            tmp = (tmp2*3)+back;
            aux3 = bits.get(tmp, tmp+3);

            tmp = 18+i*3+left;
            aux4 = bits.get(tmp, tmp+3);

            //front[2][i] = left[2][i];
            for(int n = 0; n < 3; n++)
                bits.set(18+i*3+front+n, aux4.get(n));

            //right[2][i] = aux1;
            for(int n = 0; n < 3; n++)
                bits.set(18+i*3+right+n, aux1.get(n));

            //back[0][Math.abs(i-2)] = aux2;
            tmp = Math.abs(i-2);
            for(int n = 0; n < 3; n++)
                bits.set(tmp*3+back+n, aux2.get(n));

            //left[2][i] = aux3;
            for(int n = 0; n < 3; n++)
                bits.set(18+i*3+left+n, aux3.get(n));
        }
        rotateFaceRight(bottom);
    }

    public void rotate2P(){
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = top[i][2];
            tmp = i*9+6+top;
            aux1 = bits.get(tmp, tmp+3);

            //BitSet aux2 = front[i][2];
            tmp = i*9+6+front;
            aux2 = bits.get(tmp, tmp+3);

            //BitSet aux3 = bottom[i][2];
            tmp = i*9+6+bottom;
            aux3 = bits.get(tmp, tmp+3);

            tmp = i*9+6+back;
            aux4 = bits.get(tmp, tmp+3);

            //top[i][2] = back[i][2];
            for(int n = 0; n < 3; n++)
                bits.set(i*9+6+top+n, aux4.get(n));

            //front[i][2] = aux1;
            for(int n = 0; n < 3; n++)
                bits.set(i*9+6+front+n, aux1.get(n));

            //bottom[i][2]= aux2;
            for(int n = 0; n < 3; n++)
                bits.set(i*9+6+bottom+n, aux2.get(n));

            //back[i][2]= aux3;
            for(int n = 0; n < 3; n++)
                bits.set(i*9+6+back+n, aux3.get(n));

        }
        rotateFaceLeft(right);
    }

    public void rotate5P(){
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = front[0][i];
            tmp = i*3+front;
            aux1 = bits.get(tmp, tmp+3);

            //BitSet aux2 = left[0][i];
            tmp = i*3+left;
            aux2 = bits.get(tmp, tmp+3);

            //BitSet aux3 = back[2][Math.abs(i-2)];
            tmp = Math.abs(i-2);
            tmp = 18+tmp*3+back;
            aux3 = bits.get(tmp, tmp+3);

            tmp = i*3+right;
            aux4 = bits.get(tmp, tmp+3);

            //front[0][i] = right[0][i];
            for(int n = 0; n < 3; n++)
                bits.set(i*3+front+n, aux4.get(n));

            //left[0][i] = aux1;
            for(int n = 0; n < 3; n++)
                bits.set(i*3+left+n, aux1.get(n));

            //back[2][Math.abs(i-2)] = aux2;
            tmp = Math.abs(i-2);
            for(int n = 0; n < 3; n++)
                bits.set(18+tmp*3+back+n, aux2.get(n));

            //right[0][i] = aux3;
            for(int n = 0; n < 3; n++)
                bits.set(i*3+right+n, aux3.get(n));
        }
        rotateFaceRight(top);
    }

    public void rotate6P(){
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = front[2][i];
            tmp = 18+i*3+front;
            aux1 = bits.get(tmp, tmp+3);

            //BitSet aux2 = left[2][i];
            tmp = 18+i*3+left;
            aux2 = bits.get(tmp, tmp+3);

            //BitSet aux3 = back[0][Math.abs(i-2)];
            tmp = Math.abs(i-2);
            tmp = tmp*3+back;
            aux3 = bits.get(tmp, tmp+3);

            tmp = 18+i*3+right;
            aux4 = bits.get(tmp, tmp+3);

            //front[2][i] = right[2][i];
            for(int n = 0; n < 3; n++)
                bits.set(18+i*3+front+n, aux4.get(n));

            //left[2][i] = aux1;
            for(int n = 0; n < 3; n++)
                bits.set(18+i*3+left+n, aux1.get(n));

            //back[0][Math.abs(i-2)] = aux2;
            tmp = Math.abs(i-2);
            for(int n = 0; n < 3; n++)
                bits.set(tmp*3+back+n, aux2.get(n));

            //right[2][i] = aux3;
            for(int n = 0; n < 3; n++)
                bits.set(18+i*3+right+n, aux3.get(n));

        }
        rotateFaceLeft(bottom);
    }

    public void unorder(){
        int disorderNumber = 14, r;
        ArrayList<Integer> rotations = new ArrayList<>(disorderNumber);
        System.out.println("Unordering");
        for(int i = 0; i < disorderNumber; i++) {
            r = (int) (Math.random() * 12);
            r++;
            rotations.add(r);
            switch (r) {
                case 1:
                    rotate1();
                    break;
                case 2:
                    rotate2();
                    break;
                case 3:
                    rotate3();
                    break;
                case 4:
                    rotate4();
                    break;
                case 5:
                    rotate5();
                    break;
                case 6:
                    rotate6();
                    break;
                case 7:
                    rotate1P();
                    break;
                case 8:
                    rotate2P();
                    break;
                case 9:
                    rotate3P();
                    break;
                case 10:
                    rotate4P();
                    break;
                case 11:
                    rotate5P();
                    break;
                case 12:
                    rotate6P();
                    break;
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
