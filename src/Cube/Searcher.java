package Cube;


import java.util.LinkedList;

public class Searcher {

    public Cube root;

    public Searcher(Cube cube){
        root = cube;
    }

    public int BFS(){
        LinkedList<Cube> list = new LinkedList<>();
        list.add(root);
        Cube tmp;
        int i = 0;
        while (!list.isEmpty()){
            i++;
            Cube u = list.removeFirst();
            tmp = CubeMover.rotate1(u);
            if(tmp.isOk())
                return i;
            list.add(tmp);
            tmp = CubeMover.rotate2(u);
            if(tmp.isOk())
                return i;
            list.add(tmp);
            tmp = CubeMover.rotate3(u);
            if(tmp.isOk())
                return i;
            list.add(tmp);
            tmp = CubeMover.rotate4(u);
            if(tmp.isOk())
                return i;
            list.add(tmp);
            tmp = CubeMover.rotate5(u);
            if(tmp.isOk())
                return i;
            list.add(tmp);
            tmp = CubeMover.rotate6(u);
            if(tmp.isOk())
                return i;
            list.add(tmp);
        }
        return -1;
    }
}
