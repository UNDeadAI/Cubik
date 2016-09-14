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

    static Cube rotate7(Cube cube){
        Cube tmp = new Cube(cube);
        tmp.rotate1P();
        tmp.addMove(7);
        return tmp;
    }

    static Cube rotate8(Cube cube){
        Cube tmp = new Cube(cube);
        tmp.rotate2P();
        tmp.addMove(8);
        return tmp;
    }

    static Cube rotate9(Cube cube){
        Cube tmp = new Cube(cube);
        tmp.rotate3P();
        tmp.addMove(9);
        return tmp;
    }

    static Cube rotate10(Cube cube){
        Cube tmp = new Cube(cube);
        tmp.rotate4P();
        tmp.addMove(10);
        return tmp;
    }

    static Cube rotate11(Cube cube){
        Cube tmp = new Cube(cube);
        tmp.rotate5P();
        tmp.addMove(11);
        return tmp;
    }

    static Cube rotate12(Cube cube){
        Cube tmp = new Cube(cube);
        tmp.rotate6P();
        tmp.addMove(12);
        return tmp;
    }

    static Cube rotate13(Cube cube){
        Cube tmp = new Cube(cube);
        tmp.rotateC1();
        tmp.addMove(13);
        return tmp;
    }

    static Cube rotate14(Cube cube){
        Cube tmp = new Cube(cube);
        tmp.rotateC2();
        tmp.addMove(14);
        return tmp;
    }

    static Cube rotate15(Cube cube){
        Cube tmp = new Cube(cube);
        tmp.rotateC3();
        tmp.addMove(15);
        return tmp;
    }

    static Cube rotate16(Cube cube){
        Cube tmp = new Cube(cube);
        tmp.rotateC1P();
        tmp.addMove(16);
        return tmp;
    }

    static Cube rotate17(Cube cube){
        Cube tmp = new Cube(cube);
        tmp.rotateC2P();
        tmp.addMove(17);
        return tmp;
    }

    static Cube rotate18(Cube cube){
        Cube tmp = new Cube(cube);
        tmp.rotateC3P();
        tmp.addMove(18);
        return tmp;
    }
}
