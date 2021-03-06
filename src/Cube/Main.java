package Cube;

public class Main {
    
    public static void main(String args[]){
        Cube cube = new Cube();
        CubeMover.unorder(cube);
        Searcher searcher = new Searcher(cube);
        System.out.println("Cubik unordered");
        System.out.println(cube);
        System.out.println("Cubik ordered");
        //Cube done = searcher.bidirectionalSearch();
        //Cube done = searcher.iterativeDFS(14);
        Cube done = searcher.theAStar();
        //Cube done = searcher.BFS();
        if(done != null) {
            System.out.println("Nodes created: " + searcher.nodesCreated);
            System.out.println("Moves done: ");
            System.out.println(done.getMoves());
            System.out.println("Cubik:");
            System.out.println(done);
        }
        else
            System.out.println("Didn´t find a solution :'v");
    }
}

