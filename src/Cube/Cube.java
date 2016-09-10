package Cube;

public class Cube {

    int[][] front = new int[3][3];
    int[][] back = new int[3][3];
    int[][] top = new int[3][3];
    int[][] bottom = new int[3][3];
    int[][] left = new int[3][3];
    int[][] right = new int[3][3];

    public Cube() {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++) {
                front[i][j] = 1;
                back[i][j] = 2;
                top[i][j] = 3;
                bottom[i][j] = 4;
                left[i][j] = 5;
                right[i][j] = 6;
            }
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

    public boolean isOk() {
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                if(front[i][j] != CubeMover.frontOk[i][j])
                    return false;
                if(back[i][j] != CubeMover.backOk[i][j])
                    return false;
                if(top[i][j] != CubeMover.topOk[i][j])
                    return false;
                if(bottom[i][j] != CubeMover.bottomOk[i][j])
                    return false;
                if(left[i][j] != CubeMover.leftOk[i][j])
                    return false;
                if(right[i][j] != CubeMover.rightOk[i][j])
                    return false;
            }
        }
        return true;
    }
}
