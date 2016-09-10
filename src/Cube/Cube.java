package Cube;

/**
 * Created by Alvaro on 01/09/2016.
 */
public class Cube {
    int[][] front = new int[3][3];
    int[][] back = new int[3][3];
    int[][] top = new int[3][3];
    int[][] bottom = new int[3][3];
    int[][] left = new int[3][3];
    int[][] right = new int[3][3];

    public Cube()
    {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++)
            {
                front[i][j] = 1;
                back[i][j] = 2;
                top[i][j] = 3;
                bottom[i][j] = 4;
                left[i][j] = 5;
                right[i][j] = 6;
            }
        }
    }

    private void rotateFace(int[][] M){
        int [][] aux = new int[M.length][];
        int k = 0, l = 0;
        for(int i = 0; i < M.length; i++)
            aux[i] = M[i].clone();
        for(int i = 0; i < 3; i++){
            for(int j = 2; j >= 0; j--){
                M[l][k] = aux[j][i];
                k++;
            }
            l++;
        }
    }

    private void rotate1(){
        for(int i = 0; i < 3; i++){
            int aux1 = top[i][0];
            int aux2 = back[i][0];
            int aux3 = bottom[i][0];
            top[i][0] = front[i][0];
            back[i][0] = aux1;
            bottom[i][0] = aux2;
            front[i][0] = aux3;
        }
    }

    private void rotate2(){
        for(int i = 0; i < 3; i++){
            int aux1 = top[i][2];
            int aux2 = back[i][2];
            int aux3 = bottom[i][2];
            top[i][2] = front[i][2];
            back[i][2] = aux1;
            bottom[i][2] = aux2;
            front[i][2] = aux3;
        }
    }

    private void rotate3(){
        for(int i = 0; i < 3; i++){
            int aux1 = top[i][0];
            int aux2 = right[i][0];
            int aux3 = bottom[i][0];
            top[i][0] = left[i][0];
            right[i][0] = aux1;
            bottom[i][0] = aux2;
            left[i][0] = aux3;
        }
    }

    private void rotate4(){
        for(int i = 0; i < 3; i++){
            int aux1 = top[i][2];
            int aux2 = right[i][2];
            int aux3 = bottom[i][2];
            top[i][0] = left[i][2];
            right[i][2] = aux1;
            bottom[i][2] = aux2;
            left[i][2] = aux3;
        }
    }

    private void rotate5(){
        for(int i = 0; i < 3; i++){
            int aux1 = front[i][0];
            int aux2 = right[i][0];
            int aux3 = back[i][0];
            front[i][0] = left[i][0];
            right[i][0] = aux1;
            back[i][0] = aux2;
            left[i][0] = aux3;
        }
    }

    private void rotate6(){
        for(int i = 0; i < 3; i++){
            int aux1 = front[i][2];
            int aux2 = right[i][2];
            int aux3 = back[i][2];
            front[i][0] = left[i][2];
            right[i][2] = aux1;
            back[i][2] = aux2;
            left[i][2] = aux3;
        }
    }

    private void unorder(){
        int r;
        for(int i = 0; i < 15; i++) {
            r = (int) (Math.random() * 6);
            switch (r)
            {
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
            }

        }

    }


    public static void main(String[] args) {
        Cube cubyto = new Cube();
        cubyto.unorder();

    }
}
