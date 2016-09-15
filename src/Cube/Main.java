package Cube;

public class Main {

    public static void main(String args[]){
        Cube cube = new Cube();
        cube.unorder();
        Searcher searcher = new Searcher(cube);
        System.out.println("Cubik unordered");
        System.out.println(cube);
        System.out.println("Cubik ordered");
        Cube done = searcher.BFS();
        if(done != null) {
            System.out.println("Created nodes: " + searcher.expandedNodes);
            System.out.println("Moves done: ");
            System.out.println(done.getMoves());
            System.out.println("Cubik:");
            System.out.println(done);
        }
        else
            System.out.println("Didn´t found a solution :'v");
    }
}
