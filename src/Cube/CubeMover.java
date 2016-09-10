package Cube;


public class CubeMover {

    static int[][] frontOk = new int[3][3];
    static int[][] backOk = new int[3][3];
    static int[][] topOk = new int[3][3];
    static int[][] bottomOk = new int[3][3];
    static int[][] leftOk = new int[3][3];
    static int[][] rightOk = new int[3][3];

    public CubeMover(){
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++) {
                frontOk[i][j] = 1;
                backOk[i][j] = 2;
                topOk[i][j] = 3;
                bottomOk[i][j] = 4;
                leftOk[i][j] = 5;
                rightOk[i][j] = 6;
            }
    }

    static Cube rotate1(Cube cube){
        return new Cube(cube);
    }
    static Cube rotate2(Cube cube){
        return new Cube(cube);
    }
    static Cube rotate3(Cube cube){
        return new Cube(cube);
    }
    static Cube rotate4(Cube cube){
        return new Cube(cube);
    }
    static Cube rotate5(Cube cube){
        return new Cube(cube);
    }
    static Cube rotate6(Cube cube){
        return new Cube(cube);
    }
}
