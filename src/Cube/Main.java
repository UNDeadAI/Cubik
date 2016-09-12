package Cube;

public class Main {

    public static void main(String args[]){
        //CubeMover mover = new CubeMover();
        Cube cube = new Cube();
        cube.unorder();
        Searcher searcher = new Searcher(cube);
        System.out.println("Cubik unordered");
        System.out.println(cube);
        System.out.println("Cubik ordered");
        Cube done = searcher.BFS();
        System.out.println("Expanded nodes: " + searcher.expandedNodes);
        System.out.println("Moves done: ");
        System.out.println(done.getMoves());
        System.out.println("Cubik:");
        System.out.println(done);
    }
}
