package Cube;

import java.util.HashSet;
import java.util.LinkedList;

public class Searcher {

    public Cube root;
    public int expandedNodes;

    public Searcher(Cube cube){
        root = cube;
    }

    public Cube BFS(){
        expandedNodes = 0;
        LinkedList<Cube> list = new LinkedList<>();
        HashSet<Cube> visited = new HashSet<>();
        list.add(root);
        visited.add(root);
        Cube tmp;
        while (!list.isEmpty()){
            expandedNodes++;
            Cube u = list.removeFirst();
            tmp = CubeMover.rotate1(u);
            if(tmp.isOk())
                return tmp;
            if(!visited.contains(tmp)) {
                list.add(tmp);
                visited.add(tmp);
            }

            tmp = CubeMover.rotate2(u);
            if(tmp.isOk())
                return tmp;
            if(!visited.contains(tmp)) {
                list.add(tmp);
                visited.add(tmp);
            }

            tmp = CubeMover.rotate3(u);
            if(tmp.isOk())
                return tmp;
            if(!visited.contains(tmp)) {
                list.add(tmp);
                visited.add(tmp);
            }

            tmp = CubeMover.rotate4(u);
            if(tmp.isOk())
                return tmp;
            if(!visited.contains(tmp)) {
                list.add(tmp);
                visited.add(tmp);
            }

            tmp = CubeMover.rotate5(u);
            if(tmp.isOk())
                return tmp;
            if(!visited.contains(tmp)) {
                list.add(tmp);
                visited.add(tmp);
            }

            tmp = CubeMover.rotate6(u);
            if(tmp.isOk())
                return tmp;
            if(!visited.contains(tmp)) {
                list.add(tmp);
                visited.add(tmp);
            }

            tmp = CubeMover.rotate7(u);
            if(tmp.isOk())
                return tmp;
            if(!visited.contains(tmp)) {
                list.add(tmp);
                visited.add(tmp);
            }

            tmp = CubeMover.rotate8(u);
            if(tmp.isOk())
                return tmp;
            if(!visited.contains(tmp)) {
                list.add(tmp);
                visited.add(tmp);
            }

            tmp = CubeMover.rotate9(u);
            if(tmp.isOk())
                return tmp;
            if(!visited.contains(tmp)) {
                list.add(tmp);
                visited.add(tmp);
            }

            tmp = CubeMover.rotate10(u);
            if(tmp.isOk())
                return tmp;
            if(!visited.contains(tmp)) {
                list.add(tmp);
                visited.add(tmp);
            }

            tmp = CubeMover.rotate11(u);
            if(tmp.isOk())
                return tmp;
            if(!visited.contains(tmp)) {
                list.add(tmp);
                visited.add(tmp);
            }

            tmp = CubeMover.rotate12(u);
            if(tmp.isOk())
                return tmp;
            if(!visited.contains(tmp)) {
                list.add(tmp);
                visited.add(tmp);
            }
        }
        return null;
    }
}
