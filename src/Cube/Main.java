package Cube;

public class Main {

    public static void main(String args[]){
        CubeMover mover = new CubeMover();
        Cube cube = new Cube();
        cube.unorder();
        Searcher searcher = new Searcher(cube);
        System.out.println(searcher.BFS());
    }
}
