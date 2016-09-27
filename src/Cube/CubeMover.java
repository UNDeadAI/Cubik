package Cube;

import java.util.ArrayList;
import java.util.BitSet;

//000 -> white      010 -> green    100 -> yellow
//001 -> orange     011 -> red      101 -> blue

//Front -> green    Top -> white    Black -> blue
//Right -> red      Left -> orange  Bottom -> yellow

//front -> 0        back -> 27      top -> 54
//bottom -> 81      left -> 108     right -> 135

public class CubeMover {

    static private byte b;
    public static int front = 0, back = 27, top = 54, bottom = 81, left = 108, right = 135;
    static int disorderNumber = 4;

    public static void createCube(Cube cube){
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
                    cube.bits.set(9 * i + 3 * j + CubeMover.front + n, green.get(n));
                    Cube.okCube.set(9 * i + 3 * j + CubeMover.front + n, green.get(n));
                }

                for(int n = 0;  n < 3; n++) {
                    cube.bits.set(9 * i + 3 * j + CubeMover.back + n, blue.get(n));
                    Cube.okCube.set(9 * i + 3 * j + CubeMover.back + n, blue.get(n));
                }

                for(int n = 0;  n < 3; n++) {
                    cube.bits.set(9 * i + 3 * j + CubeMover.top + n, white.get(n));
                    Cube.okCube.set(9 * i + 3 * j + CubeMover.top + n, white.get(n));
                }

                for(int n = 0;  n < 3; n++) {
                    cube.bits.set(9 * i + 3 * j + CubeMover.bottom + n, yellow.get(n));
                    Cube.okCube.set(9 * i + 3 * j + CubeMover.bottom + n, yellow.get(n));
                }

                for(int n = 0;  n < 3; n++) {
                    cube.bits.set(9 * i + 3 * j + CubeMover.left + n, orange.get(n));
                    Cube.okCube.set(9 * i + 3 * j + CubeMover.left + n, orange.get(n));
                }

                for(int n = 0;  n < 3; n++) {
                    cube.bits.set(9 * i + 3 * j + CubeMover.right + n, red.get(n));
                    Cube.okCube.set(9 * i + 3 * j + CubeMover.right + n, red.get(n));
                }
            }
        }
    }

    public static void unorder(Cube cube){
       int r;
        ArrayList<Integer> rotations = new ArrayList<>(disorderNumber);
        System.out.println("Unordering");
        for(int i = 0; i < disorderNumber; i++) {
            r = (int) (Math.random() * 12);
            r++;
            rotations.add(r);
            switch (r) {
                case 1:
                    rotateCube1(cube);
                    break;
                case 2:
                    rotateCube2(cube);
                    break;
                case 3:
                    rotateCube3(cube);
                    break;
                case 4:
                    rotateCube4(cube);
                    break;
                case 5:
                    rotateCube5(cube);
                    break;
                case 6:
                    rotateCube6(cube);
                    break;
                case 7:
                    rotate1P(cube);
                    break;
                case 8:
                    rotate2P(cube);
                    break;
                case 9:
                    rotate3P(cube);
                    break;
                case 10:
                    rotate4P(cube);
                    break;
                case 11:
                    rotate5P(cube);
                    break;
                case 12:
                    rotate6P(cube);
                    break;
            }
        }
        System.out.println(rotations);
    }

    static Cube rotate1(Cube cube){
        Cube tmp = new  Cube(cube);
        rotateCube1(tmp);
        b = 0b1;
        tmp.addMove(b);
        return  tmp;
    }
    static Cube rotate2(Cube cube){
        Cube tmp = new  Cube(cube);
        rotateCube2(tmp);
        b = 0b10;
        tmp.addMove(b);
        return  tmp;
    }
    static Cube rotate3(Cube cube){
        Cube tmp = new  Cube(cube);
        rotateCube3(tmp);
        b = 0b11;
        tmp.addMove(b);
        return  tmp;
    }
    static Cube rotate4(Cube cube){
        Cube tmp = new  Cube(cube);
        rotateCube4(tmp);
        b = 0b100;
        tmp.addMove(b);
        return  tmp;
    }
    static Cube rotate5(Cube cube){
        Cube tmp = new  Cube(cube);
        rotateCube5(tmp);
        b = 0b0101;
        tmp.addMove(b);
        return  tmp;
    }
    static Cube rotate6(Cube cube){
        Cube tmp = new  Cube(cube);
        rotateCube6(tmp);
        b = 0b110;
        tmp.addMove(b);
        return  tmp;
    }

    static Cube rotate7(Cube cube){
        Cube tmp = new Cube(cube);
        rotate1P(tmp);
        byte b = 0b111;
        tmp.addMove(b);
        return tmp;
    }

    static Cube rotate8(Cube cube){
        Cube tmp = new Cube(cube);
        rotate2P(tmp);
        b = 0b1000;
        tmp.addMove(b);
        return tmp;
    }

    static Cube rotate9(Cube cube){
        Cube tmp = new Cube(cube);
        rotate3P(tmp);
        b = 0b1001;
        tmp.addMove(b);
        return tmp;
    }

    static Cube rotate10(Cube cube){
        Cube tmp = new Cube(cube);
        rotate4P(tmp);
        b = 0b1010;
        tmp.addMove(b);
        return tmp;
    }

    static Cube rotate11(Cube cube){
        Cube tmp = new Cube(cube);
        rotate5P(tmp);
        b = 0b1011;
        tmp.addMove(b);
        return tmp;
    }

    static Cube rotate12(Cube cube){
        Cube tmp = new Cube(cube);
        rotate6P(tmp);
        b = 0b1100;
        tmp.addMove(b);
        return tmp;
    }

    public static void rotateFaceRight(int w, Cube cube){
        BitSet tmp, tmp3;
        tmp3 = cube.bits.get(w, w+27);
        int k, l = 0, tmp2;
        for(int i = 0; i < 3; i++){
            k = 0;
            for(int j = 2; j >= 0; j--){
                tmp2 = (j*9+i*3);
                tmp = tmp3.get(tmp2, tmp2+3);
                tmp2 = (l*9+k*3)+w;
                for(int n = 0; n < 3; n++)
                    cube.bits.set(tmp2+n, tmp.get(n));
                k++;
            }
            l++;
        }
    }

    public static void rotateFaceLeft(int w, Cube cube){
        BitSet tmp, tmp3;
        tmp3 = cube.bits.get(w, w+27);
        int k, l = 0, tmp2;
        for(int i = 2; i >= 0; i--){
            k = 0;
            for(int j = 0; j < 3; j++){
                tmp2 = (j*9+i*3);
                tmp = tmp3.get(tmp2, tmp2+3);
                tmp2 = (l*9+k*3)+w;
                for(int n = 0; n < 3; n++)
                    cube.bits.set(tmp2+n, tmp.get(n));
                k++;
            }
            l++;
        }
    }

    public static void rotateCube1(Cube cube){
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = top[i][0];
            tmp = (i*9)+top;
            aux1 = cube.bits.get(tmp, tmp+3);

            //BitSet aux2 = back[i][0];
            tmp = (i*9)+back;
            aux2 = cube.bits.get(tmp, tmp+3);

            //BitSet aux3 = bottom[i][0];
            tmp = (i*9)+bottom;
            aux3 = cube.bits.get(tmp, tmp+3);

            tmp = (i*9)+front;
            aux4 = cube.bits.get(tmp, tmp+3);

            //top[i][0] = front[i][0];
            for(int n = 0; n < 3; n++)
                cube.bits.set((i*9)+top+n, aux4.get(n));

            //back[i][0] = aux1;
            for(int n = 0; n < 3; n++)
                cube.bits.set((i*9)+back+n, aux1.get(n));

            //bottom[i][0] = aux2;
            for(int n = 0; n < 3; n++)
                cube.bits.set((i*9)+bottom+n, aux2.get(n));

            //front[i][0] = aux3;
            for(int n = 0; n < 3; n++)
                cube.bits.set((i*9)+front+n, aux3.get(n));
        }
        rotateFaceLeft(left, cube);
    }

    public static void rotate1P(Cube cube){
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = top[i][0];
            tmp = (i*9)+top;
            aux1 = cube.bits.get(tmp, tmp+3);

            //BitSet aux2 = front[i][0];
            tmp = (i*9)+front;
            aux2 = cube.bits.get(tmp, tmp+3);

            //BitSet aux3 = bottom[i][0];
            tmp = (i*9)+bottom;
            aux3 = cube.bits.get(tmp, tmp+3);

            tmp = (i*9)+back;
            aux4 = cube.bits.get(tmp, tmp+3);

            //top[i][0] = back[i][0];
            for(int n = 0; n < 3; n++)
                cube.bits.set((i*9)+top+n, aux4.get(n));

            //front[i][0] = aux1;
            for(int n = 0; n < 3; n++)
                cube.bits.set((i*9)+front+n, aux1.get(n));

            //bottom[i][0]= aux2;
            for(int n = 0; n < 3; n++)
                cube.bits.set((i*9)+bottom+n, aux2.get(n));

            //back[i][0]= aux3;
            for(int n = 0; n < 3; n++)
                cube.bits.set((i*9)+back+n, aux3.get(n));
        }
        rotateFaceRight(left, cube);
    }

    public static void rotateCube2(Cube cube){
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = top[i][2];
            tmp = (i*9)+6+top;
            aux1 = cube.bits.get(tmp, tmp+3);

            //BitSet aux2 = back[i][2];
            tmp = (i*9)+6+back;
            aux2 = cube.bits.get(tmp, tmp+3);

            //BitSet aux3 = bottom[i][2];
            tmp = (i*9)+6+bottom;
            aux3 = cube.bits.get(tmp, tmp+3);

            tmp = (i*9)+6+front;
            aux4 = cube.bits.get(tmp, tmp+3);

            //top[i][2] = front[i][2];
            for(int n = 0; n < 3; n++)
                cube.bits.set((i*9)+6+top+n, aux4.get(n));

            //back[i][2] = aux1;
            for(int n = 0; n < 3; n++)
                cube.bits.set((i*9)+6+back+n, aux1.get(n));

            //bottom[i][2] = aux2;
            for(int n = 0; n < 3; n++)
                cube.bits.set((i*9)+6+bottom+n, aux2.get(n));

            //front[i][2] = aux3;
            for(int n = 0; n < 3; n++)
                cube.bits.set((i*9)+6+front+n, aux3.get(n));
        }
        rotateFaceRight(right, cube);
    }

    public static void rotateCube3(Cube cube){
        BitSet lf[] = new BitSet[3];
        BitSet bt[] = new BitSet[3];
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //lf[i] = left[i][2];
            tmp = (i*9)+6+left;
            lf[i] = cube.bits.get(tmp, tmp+3);

            //bt[i] = bottom[0][i];
            tmp = (i*3)+bottom;
            bt[i] = cube.bits.get(tmp, tmp+3);
        }
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = top[2][i];
            tmp = (18+i*3)+top;
            aux1 = cube.bits.get(tmp, tmp+3);

            //BitSet aux2 = right[i][0];
            tmp = (i*9)+right;
            aux2 = cube.bits.get(tmp, tmp+3);

            aux3 = bt[i];

            //top[2][i] = lf[Math.abs(i-2)];
            aux4 = lf[Math.abs(i-2)];
            for(int n = 0; n < 3; n++)
                cube.bits.set(2*9+i*3+top+n, aux4.get(n));

            //right[i][0] = aux1;
            for(int n = 0; n < 3; n++)
                cube.bits.set(i*9+right+n, aux1.get(n));

            //bottom[0][Math.abs(i-2)] = aux2;
            tmp = Math.abs(i-2);
            for(int n = 0; n < 3; n++)
                cube.bits.set(tmp*3+bottom+n, aux2.get(n));

            //left[i][2] = aux3;
            for(int n = 0; n < 3; n++)
                cube.bits.set(i*9+6+left+n, aux3.get(n));
        }
        rotateFaceRight(front, cube);
    }

    public static void rotate3P(Cube cube){
        BitSet rf[] = new BitSet[3];
        BitSet bt[] = new BitSet[3];
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //rf[i] = top[2][i];
            tmp = 18+i*3+top;
            rf[i] = cube.bits.get(tmp, tmp+3);

            //bt[i] = bottom[0][i];
            tmp = i*3+bottom;
            bt[i] = cube.bits.get(tmp, tmp+3);
        }
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = right[i][0];
            tmp = i*9+right;
            aux1 = cube.bits.get(tmp, tmp+3);

            //BitSet aux2 = left[i][2];
            tmp = i*9+6+left;
            aux2 = cube.bits.get(tmp, tmp+3);

            //left[i][2] = rf[Math.abs(i-2)];
            aux3 = rf[Math.abs(i-2)];
            for(int n = 0; n < 3; n++)
                cube.bits.set(i*9+6+left+n, aux3.get(n));

            //bottom[0][i] = aux2;
            for(int n = 0; n < 3; n++)
                cube.bits.set(i*3+bottom+n, aux2.get(n));

            //right[i][0] = bt[Math.abs(i-2)];
            aux4 = bt[Math.abs(i-2)];
            for(int n = 0; n < 3; n++)
                cube.bits.set(i*9+right+n, aux4.get(n));

            //top[2][i] = aux1;
            for(int n = 0; n < 3; n++)
                cube.bits.set(18+i*3+top+n, aux1.get(n));
        }
        rotateFaceLeft(front, cube);
    }

    public static void rotateCube4(Cube cube){
        BitSet lf[] = new BitSet[3];
        BitSet bt[] = new BitSet[3];
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //lf[i] = left[i][0];
            tmp = (i*9)+left;
            lf[i] = cube.bits.get(tmp, tmp+3);

            //bt[i] = bottom[2][i];
            tmp = 18+i*3+bottom;
            bt[i] = cube.bits.get(tmp, tmp+3);
        }
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = top[0][i];
            tmp = (i*3)+top;
            aux1 = cube.bits.get(tmp, tmp+3);

            //BitSet aux2 = right[i][2];
            tmp = i*9+6+right;
            aux2 = cube.bits.get(tmp, tmp+3);

            //BitSet aux3 = bt[i];
            aux3 = bt[i];

            //top[0][i] = lf[Math.abs(i-2)];
            aux4 = lf[Math.abs(i-2)];
            for(int n = 0; n < 3; n++)
                cube.bits.set(i*3+top+n, aux4.get(n));

            //right[i][2] = aux1;
            for(int n = 0; n < 3; n++)
                cube.bits.set(i*9+6+right+n, aux1.get(n));

            //bottom[2][Math.abs(i-2)] = aux2;
            tmp = Math.abs(i-2);
            for(int n = 0; n < 3; n++)
                cube.bits.set(18+tmp*3+bottom+n, aux2.get(n));

            //left[i][0] = aux3;
            for(int n = 0; n < 3; n++)
                cube.bits.set(i*9+left+n, aux3.get(n));
        }
        rotateFaceLeft(back, cube);
    }

    public static void rotate4P(Cube cube){
        BitSet rf[] = new BitSet[3];
        BitSet bt[] = new BitSet[3];
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //rf[i] = top[0][i];
            tmp = i*3+top;
            rf[i] = cube.bits.get(tmp, tmp+3);

            //bt[i] = bottom[2][i];
            tmp = 18+i*3+bottom;
            bt[i] = cube.bits.get(tmp, tmp+3);
        }
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = right[i][2];
            tmp = i*9+6+right;
            aux1 = cube.bits.get(tmp, tmp+3);

            //BitSet aux2 = left[i][0];
            tmp = i*9+left;
            aux2 = cube.bits.get(tmp, tmp+3);

            //left[i][0] = rf[Math.abs(i-2)];
            aux3 = rf[Math.abs(i-2)];
            for(int n = 0; n < 3; n++)
                cube.bits.set(i*9+left+n, aux3.get(n));

            //bottom[2][i] = aux2;
            for(int n = 0; n < 3; n++)
                cube.bits.set(18+i*3+bottom+n, aux2.get(n));

            //right[i][2] = bt[Math.abs(i-2)];
            aux4 = bt[Math.abs(i-2)];
            for(int n = 0; n < 3; n++)
                cube.bits.set(9*i+6+right+n, aux4.get(n));

            //top[0][i] = aux1;
            for(int n = 0; n < 3; n++)
                cube.bits.set(i*3+top+n, aux1.get(n));

        }
        rotateFaceRight(back, cube);
    }

    public static void rotateCube5(Cube cube){
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = front[0][i];
            tmp = (i*3)+front;
            aux1 = cube.bits.get(tmp, tmp+3);

            //BitSet aux2 = right[0][i];
            tmp = (i*3)+right;
            aux2 = cube.bits.get(tmp, tmp+3);

            //BitSet aux3 = back[2][Math.abs(i-2)];
            tmp = Math.abs(i-2);
            tmp = 18+tmp*3+back;
            aux3 = cube.bits.get(tmp, tmp+3);

            tmp = (i*3)+left;
            aux4 = cube.bits.get(tmp, tmp+3);

            //front[0][i] = left[0][i];
            for(int n = 0; n < 3; n++)
                cube.bits.set(i*3+front+n, aux4.get(n));

            //right[0][i] = aux1;
            for(int n = 0; n < 3; n++)
                cube.bits.set(i*3+right+n, aux1.get(n));

            //back[2][Math.abs(i-2)] = aux2;
            tmp = Math.abs(i-2);
            for(int n = 0; n < 3; n++)
                cube.bits.set(18+tmp*3+back+n, aux2.get(n));

            //left[0][i] = aux3;
            for(int n = 0; n < 3; n++)
                cube.bits.set(i*3+left+n, aux3.get(n));
        }
        rotateFaceLeft(top, cube);
    }

    public static void rotateCube6(Cube cube){
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = front[2][i];
            tmp = 18+i*3+front;
            aux1 = cube.bits.get(tmp, tmp+3);

            //BitSet aux2 = right[2][i];
            tmp = 18+i*3+right;
            aux2 = cube.bits.get(tmp, tmp+3);

            //BitSet aux3 = back[0][Math.abs(i-2)];
            tmp = Math.abs(i-2);
            tmp = tmp*3+back;
            aux3 = cube.bits.get(tmp, tmp+3);

            tmp = 18+i*3+left;
            aux4 = cube.bits.get(tmp, tmp+3);

            //front[2][i] = left[2][i];
            for(int n = 0; n < 3; n++)
                cube.bits.set(18+i*3+front+n, aux4.get(n));

            //right[2][i] = aux1;
            for(int n = 0; n < 3; n++)
                cube.bits.set(18+i*3+right+n, aux1.get(n));

            //back[0][Math.abs(i-2)] = aux2;
            tmp = Math.abs(i-2);
            for(int n = 0; n < 3; n++)
                cube.bits.set(tmp*3+back+n, aux2.get(n));

            //left[2][i] = aux3;
            for(int n = 0; n < 3; n++)
                cube.bits.set(18+i*3+left+n, aux3.get(n));
        }
        rotateFaceRight(bottom, cube);
    }

    public static void rotate2P(Cube cube){
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = top[i][2];
            tmp = i*9+6+top;
            aux1 = cube.bits.get(tmp, tmp+3);

            //BitSet aux2 = front[i][2];
            tmp = i*9+6+front;
            aux2 = cube.bits.get(tmp, tmp+3);

            //BitSet aux3 = bottom[i][2];
            tmp = i*9+6+bottom;
            aux3 = cube.bits.get(tmp, tmp+3);

            tmp = i*9+6+back;
            aux4 = cube.bits.get(tmp, tmp+3);

            //top[i][2] = back[i][2];
            for(int n = 0; n < 3; n++)
                cube.bits.set(i*9+6+top+n, aux4.get(n));

            //front[i][2] = aux1;
            for(int n = 0; n < 3; n++)
                cube.bits.set(i*9+6+front+n, aux1.get(n));

            //bottom[i][2]= aux2;
            for(int n = 0; n < 3; n++)
                cube.bits.set(i*9+6+bottom+n, aux2.get(n));

            //back[i][2]= aux3;
            for(int n = 0; n < 3; n++)
                cube.bits.set(i*9+6+back+n, aux3.get(n));

        }
        rotateFaceLeft(right, cube);
    }

    public static void rotate5P(Cube cube){
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = front[0][i];
            tmp = i*3+front;
            aux1 = cube.bits.get(tmp, tmp+3);

            //BitSet aux2 = left[0][i];
            tmp = i*3+left;
            aux2 = cube.bits.get(tmp, tmp+3);

            //BitSet aux3 = back[2][Math.abs(i-2)];
            tmp = Math.abs(i-2);
            tmp = 18+tmp*3+back;
            aux3 = cube.bits.get(tmp, tmp+3);

            tmp = i*3+right;
            aux4 = cube.bits.get(tmp, tmp+3);

            //front[0][i] = right[0][i];
            for(int n = 0; n < 3; n++)
                cube.bits.set(i*3+front+n, aux4.get(n));

            //left[0][i] = aux1;
            for(int n = 0; n < 3; n++)
                cube.bits.set(i*3+left+n, aux1.get(n));

            //back[2][Math.abs(i-2)] = aux2;
            tmp = Math.abs(i-2);
            for(int n = 0; n < 3; n++)
                cube.bits.set(18+tmp*3+back+n, aux2.get(n));

            //right[0][i] = aux3;
            for(int n = 0; n < 3; n++)
                cube.bits.set(i*3+right+n, aux3.get(n));
        }
        rotateFaceRight(top, cube);
    }

    public static void rotate6P(Cube cube){
        int tmp;
        BitSet aux1, aux2, aux3, aux4;
        for(int i = 0; i < 3; i++){
            //BitSet aux1 = front[2][i];
            tmp = 18+i*3+front;
            aux1 = cube.bits.get(tmp, tmp+3);

            //BitSet aux2 = left[2][i];
            tmp = 18+i*3+left;
            aux2 = cube.bits.get(tmp, tmp+3);

            //BitSet aux3 = back[0][Math.abs(i-2)];
            tmp = Math.abs(i-2);
            tmp = tmp*3+back;
            aux3 = cube.bits.get(tmp, tmp+3);

            tmp = 18+i*3+right;
            aux4 = cube.bits.get(tmp, tmp+3);

            //front[2][i] = right[2][i];
            for(int n = 0; n < 3; n++)
                cube.bits.set(18+i*3+front+n, aux4.get(n));

            //left[2][i] = aux1;
            for(int n = 0; n < 3; n++)
                cube.bits.set(18+i*3+left+n, aux1.get(n));

            //back[0][Math.abs(i-2)] = aux2;
            tmp = Math.abs(i-2);
            for(int n = 0; n < 3; n++)
                cube.bits.set(tmp*3+back+n, aux2.get(n));

            //right[2][i] = aux3;
            for(int n = 0; n < 3; n++)
                cube.bits.set(18+i*3+right+n, aux3.get(n));

        }
        rotateFaceLeft(bottom, cube);
    }

    public static int heuristic(Cube cube){
        int j, i, tmp, r = cube.getMoves().size();
        BitSet a = cube.bits.get(12+front, 15+front), b = cube.bits.get(12+back, 15+back),
                c = cube.bits.get(12+left, 15+left), d = cube.bits.get(12+right, 15+right), e = cube.bits.get(12+bottom, 15+bottom),
                f = cube.bits.get(12+top, 15+top);

        for(int k = 0; k < 9; k++){
            j = k%3;
            i = k/3;
            tmp = 9*i+3*j;
            if(!cube.bits.get(tmp+front,tmp+3+front).equals(a))
                r++;
            if(!cube.bits.get(tmp+back,tmp+3+back).equals(b))
                r++;
            if(!cube.bits.get(tmp+left,tmp+3+left).equals(c))
                r++;
            if(!cube.bits.get(tmp+right,tmp+3+right).equals(d))
                r++;
            if(!cube.bits.get(tmp+bottom,tmp+3+bottom).equals(e))
                r++;
            if(!cube.bits.get(tmp+top,tmp+3+top).equals(f))
                r++;
        }
        return r/12;
    }
}
