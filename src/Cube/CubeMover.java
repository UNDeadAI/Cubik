package Cube;

public class CubeMover {

    static Cube rotate1(Cube cube){
        Cube tmp = new  Cube(cube);
        tmp.rotate1();
        tmp.addMove(1);
        return  tmp;
    }
    static Cube rotate2(Cube cube){
        Cube tmp = new  Cube(cube);
        tmp.rotate2();
        tmp.addMove(2);
        return  tmp;
    }
    static Cube rotate3(Cube cube){
        Cube tmp = new  Cube(cube);
        tmp.rotate3();
        tmp.addMove(3);
        return  tmp;
    }
    static Cube rotate4(Cube cube){
        Cube tmp = new  Cube(cube);
        tmp.rotate4();
        tmp.addMove(4);
        return  tmp;
    }
    static Cube rotate5(Cube cube){
        Cube tmp = new  Cube(cube);
        tmp.rotate5();
        tmp.addMove(5);
        return  tmp;
    }
    static Cube rotate6(Cube cube){
        Cube tmp = new  Cube(cube);
        tmp.rotate6();
        tmp.addMove(6);
        return  tmp;
    }
}
