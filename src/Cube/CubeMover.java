package Cube;

public class CubeMover {

    static private byte b;

    static Cube rotate1(Cube cube){
        Cube tmp = new  Cube(cube);
        tmp.rotate1();
        b = 0b1;
        tmp.addMove(b);
        return  tmp;
    }
    static Cube rotate2(Cube cube){
        Cube tmp = new  Cube(cube);
        tmp.rotate2();
        b = 0b10;
        tmp.addMove(b);
        return  tmp;
    }
    static Cube rotate3(Cube cube){
        Cube tmp = new  Cube(cube);
        tmp.rotate3();
        b = 0b11;
        tmp.addMove(b);
        return  tmp;
    }
    static Cube rotate4(Cube cube){
        Cube tmp = new  Cube(cube);
        tmp.rotate4();
        b = 0b100;
        tmp.addMove(b);
        return  tmp;
    }
    static Cube rotate5(Cube cube){
        Cube tmp = new  Cube(cube);
        tmp.rotate5();
        b = 0b0101;
        tmp.addMove(b);
        return  tmp;
    }
    static Cube rotate6(Cube cube){
        Cube tmp = new  Cube(cube);
        tmp.rotate6();
        b = 0b110;
        tmp.addMove(b);
        return  tmp;
    }

    static Cube rotate7(Cube cube){
        Cube tmp = new Cube(cube);
        tmp.rotate1P();
        byte b = 0b111;
        tmp.addMove(b);
        return tmp;
    }

    static Cube rotate8(Cube cube){
        Cube tmp = new Cube(cube);
        tmp.rotate2P();
        b = 0b1000;
        tmp.addMove(b);
        return tmp;
    }

    static Cube rotate9(Cube cube){
        Cube tmp = new Cube(cube);
        tmp.rotate3P();
        b = 0b1001;
        tmp.addMove(b);
        return tmp;
    }

    static Cube rotate10(Cube cube){
        Cube tmp = new Cube(cube);
        tmp.rotate4P();
        b = 0b1010;
        tmp.addMove(b);
        return tmp;
    }

    static Cube rotate11(Cube cube){
        Cube tmp = new Cube(cube);
        tmp.rotate5P();
        b = 0b1011;
        tmp.addMove(b);
        return tmp;
    }

    static Cube rotate12(Cube cube){
        Cube tmp = new Cube(cube);
        tmp.rotate6P();
        b = 0b1100;
        tmp.addMove(b);
        return tmp;
    }
}
