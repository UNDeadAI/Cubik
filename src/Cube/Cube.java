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

    private void rotateMatrix(int[][] M){
        int[][] tmp = M;
        M[0][0] = tmp[0][2];
        M[0][1] = tmp[1][2];
        M[0][2] = tmp[2][2];
        M[1][0] = tmp[0][1];
        M[1][2] = tmp[2][1];
        M[2][0] = tmp[0][0];
        M[2][1] = tmp[1][0];
        M[2][2] = tmp[2][0];
    }

    private void rotate1(){

    }
}
