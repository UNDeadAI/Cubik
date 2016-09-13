package Cube;

import java.util.ArrayList;
import java.util.Arrays;

public class Cube {
    int[][] front = new int[3][3];
    int[][] back = new int[3][3];
    int[][] top = new int[3][3];
    int[][] bottom = new int[3][3];
    int[][] left = new int[3][3];
    int[][] right = new int[3][3];
    private ArrayList<Integer> moves;
    private int disorderNumber = 1;

    public Cube() {

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++) {
                front[i][j] = 1;
                back[i][j] = 2;
                top[i][j] = 3;
                bottom[i][j] = 4;
                left[i][j] = 5;
                right[i][j] = 6;
            }
        }
        moves = new ArrayList<>();
    }

    public Cube(Cube cube) {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++) {
                front[i][j] = cube.front[i][j];
                back[i][j] = cube.back[i][j];
                top[i][j] = cube.top[i][j];
                bottom[i][j] = cube.bottom[i][j];
                left[i][j] = cube.left[i][j];
                right[i][j] = cube.right[i][j];
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
            if(front[i][j] != front[I][J])
                return false;
            if(back[i][j] != back[I][J])
                return false;
            if(left[i][j] != left[I][J])
                return false;
            if(right[i][j] != right[I][J])
                return false;
            if(bottom[i][j] != bottom[I][J])
                return false;
            if(top[i][j] != top[I][J])
                return false;
        }
        return true;
    }


    public void rotateFaceRight(int[][] M){
        int [][] aux = new int[M.length][];
        int k = 0, l = 0;
        for(int i = 0; i < M.length; i++)
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

    public void rotateFaceLeft(int[][] M){
        int [][] aux = new int[M.length][];
        int k = 0, l = 0;
        for(int i = 0; i < M.length; i++)
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
            int aux1 = top[i][0];
            int aux2 = back[i][0];
            int aux3 = bottom[i][0];
            top[i][0] = front[i][0];
            back[i][0] = aux1;
            bottom[i][0] = aux2;
            front[i][0] = aux3;
        }
        rotateFaceLeft(left);
    }

    public void rotate2(){
        for(int i = 0; i < 3; i++){
            int aux1 = top[i][2];
            int aux2 = back[i][2];
            int aux3 = bottom[i][2];
            top[i][2] = front[i][2];
            back[i][2] = aux1;
            bottom[i][2] = aux2;
            front[i][2] = aux3;
        }
        rotateFaceRight(right);
    }

    public void rotate3(){
        int lf[] = new int[3];
        int bt[] = new int[3];
        for(int i = 0; i < 3; i++){
            lf[i] = left[i][2];
            bt[i] = bottom[0][i];
        }
        for(int i = 0; i < 3; i++){
            int aux1 = top[2][i];
            int aux2 = right[i][0];
            int aux3 = bt[i];
            top[2][i] = lf[Math.abs(i-2)];
            right[i][0] = aux1;
            bottom[0][Math.abs(i-2)] = aux2;
            left[i][2] = aux3;
        }

        rotateFaceRight(front);
    }

    public void rotate4(){
        int lf[] = new int[3];
        int bt[] = new int[3];
        for(int i = 0; i < 3; i++){
            lf[i] = left[i][0];
            bt[i] = bottom[2][i];
        }
        for(int i = 0; i < 3; i++){
            int aux1 = top[0][i];
            int aux2 = right[i][2];
            int aux3 = bt[i];
            top[0][i] = lf[Math.abs(i-2)];
            right[i][2] = aux1;
            bottom[2][Math.abs(i-2)] = aux2;
            left[i][0] = aux3;
        }
        rotateFaceLeft(back);
    }

    public void rotate5(){
        for(int i = 0; i < 3; i++){
            int aux1 = front[0][i];
            int aux2 = right[0][i];
            int aux3 = back[2][Math.abs(i-2)];
            front[0][i] = left[0][i];
            right[0][i] = aux1;
            back[2][Math.abs(i-2)] = aux2;
            left[0][i] = aux3;
        }
        rotateFaceLeft(top);
    }

    public void rotate6(){
        for(int i = 0; i < 3; i++){
            int aux1 = front[2][i];
            int aux2 = right[2][i];
            int aux3 = back[0][Math.abs(i-2)];
            front[2][i] = left[2][i];
            right[2][i] = aux1;
            back[0][Math.abs(i-2)] = aux2;
            left[2][i] = aux3;
        }
        rotateFaceRight(bottom);
    }

    public void rotate1P(){
        for(int i = 0; i < 3; i++){
            int aux1 = top[i][0];
            int aux2 = front[i][0];
            int aux3 = bottom[i][0];
            top[i][0] = back[i][0];
            front[i][0] = aux1;
            bottom[i][0]= aux2;
            back[i][0]= aux3;
        }
        rotateFaceRight(left);
    }

    public void rotate2P(){
        for(int i = 0; i < 3; i++){
            int aux1 = top[i][2];
            int aux2 = front[i][2];
            int aux3 = bottom[i][2];
            top[i][2] = back[i][2];
            front[i][2] = aux1;
            bottom[i][2]= aux2;
            back[i][2]= aux3;
        }
        rotateFaceLeft(right);
    }

    public void rotate3P(){
        int rf[] = new int[3];
        int bt[] = new int[3];
        for(int i = 0; i < 3; i++){
            rf[i] = top[2][i];
            bt[i] = bottom[0][i];
        }
        for(int i = 0; i < 3; i++){
            int aux1 = right[i][0];
            int aux2 = left[i][2];
            //int aux3 = rf[i];
            left[i][2] = rf[Math.abs(i-2)];
            bottom[0][i] = aux2;
            right[i][0] = bt[Math.abs(i-2)];
            top[2][i] = aux1;
        }
        rotateFaceLeft(front);
    }

    public void rotate4P(){
        int rf[] = new int[3];
        int bt[] = new int[3];
        for(int i = 0; i < 3; i++){
            rf[i] = top[0][i];
            bt[i] = bottom[2][i];
        }
        for(int i = 0; i < 3; i++){
            int aux1 = right[i][2];
            int aux2 = left[i][0];
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
            int aux1 = front[0][i];
            int aux2 = left[0][i];
            int aux3 = back[2][Math.abs(i-2)];
            front[0][i] = right[0][i];
            left[0][i] = aux1;
            back[2][Math.abs(i-2)] = aux2;
            right[0][i] = aux3;
        }
        rotateFaceRight(top);
    }

    public void rotate6P(){
        for(int i = 0; i < 3; i++){
            int aux1 = front[2][i];
            int aux2 = left[2][i];
            int aux3 = back[0][Math.abs(i-2)];
            front[2][i] = right[2][i];
            left[2][i] = aux1;
            back[0][Math.abs(i-2)] = aux2;
            right[2][i] = aux3;
        }
        rotateFaceLeft(bottom);
    }

    public void unorder(){
        int r;
        ArrayList<Integer> rotations = new ArrayList<>(disorderNumber);
        System.out.println("Unordering");
        for(int i = 0; i < disorderNumber; i++) {
            r = (int) (Math.random() * 12);
            //r = 9;
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

    public void addMove(int move){
        moves.add(move);
    }

    public ArrayList<Integer> getMoves(){
        return moves;
    }

    public static void main(String[] args) {
        Cube cubyto = new Cube();
        System.out.println(cubyto);
        cubyto.unorder();
        System.out.println(cubyto);
    }
}
