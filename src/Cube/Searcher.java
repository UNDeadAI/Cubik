package Cube;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Searcher {

    public Cube root;
    public long nodesCreated;
    public int limit;
    private LinkedList<Cube> list;
    private HashSet<Cube> visited;
    private HashSet<Cube> frontier;
    private PriorityQueue<Cube> q;
    private Cube tmp;
    private Cube goal = new Cube();
    private HashSet<Cube> visited2;
    private LinkedList<Cube> list2;

    public Searcher(Cube cube){
        root = cube;
    }

    public Cube BFS(){
        nodesCreated = 0;
        if(root.isOk())
            return root;
        list = new LinkedList<>();
        visited = new HashSet<>();
        list.add(root);
        visited.add(root);
        while (!list.isEmpty()){
            Cube u = list.removeFirst();
            tmp = expandNodes(u);
            if(tmp != null)
                return tmp;
        }
        return null;
    }

    public Cube bidirectionalSearch(){
        nodesCreated = 0;
        if(root.isOk())
            return root;
        list = new LinkedList<>();
        visited = new HashSet<>();
        list.add(root);
        visited.add(root);
        while (!list.isEmpty()){
            Cube u = list.removeFirst();
            if(u.getMoves().size() == CubeMover.disorderNumber/2)
                break;
                tmp = expandNodes(u);
                if (tmp != null)
                    return tmp;
        }
        frontier = new HashSet<>(list);
        //for(Cube x:list)
            //frontier.add(x);
        //list2 = new LinkedList<>(list);
        //visited2 = new HashSet<>(visited);
        list = new LinkedList<>();
        //visited = new HashSet<>();
        list.add(goal);
        visited.add(goal);
        while(!list.isEmpty()){
            Cube u = list.removeFirst();
            for(Cube x:frontier){
                if(u.equals(x)){
                    for(Byte b : u.getMoves())
                        x.addMove(b);
                    return x;
                }
            }
            expandNodes2(u);
        }
        return null;
    }

    public Cube theAStar(){
        nodesCreated = 0;
        if(root.isOk())
            return root;
        q = new PriorityQueue<>();
        visited = new HashSet<>();
        q.add(root);
        while (!q.isEmpty()){
            tmp = q.poll();;
            tmp = expandNodes3(tmp);
            if(tmp != null)
                return tmp;
        }
        return null;
    }

    public Cube iterativeDFS(int limit2){
        nodesCreated = 0;
        visited = new HashSet<>();
        if(root.isOk())
            return root;
        for(int i = 1; i <= limit2; i++){
            limit = i;
            tmp = limitedDFS(root);
            if(tmp != null)
                return tmp;
        }
        return null;
    }

    public Cube limitedDFS(Cube u){
        if(u.getMoves().size() < limit) {
            tmp = CubeMover.rotate1(u);
            if (tmp.isOk())
                return tmp;
            nodesCreated++;
            tmp = limitedDFS(tmp);
            if(tmp != null)
                return tmp;

            tmp = CubeMover.rotate2(u);
            if (tmp.isOk())
                return tmp;
            nodesCreated++;
            tmp = limitedDFS(tmp);
            if(tmp != null)
                return tmp;

            tmp = CubeMover.rotate3(u);
            if (tmp.isOk())
                return tmp;
            nodesCreated++;
            tmp = limitedDFS(tmp);
            if(tmp != null)
                return tmp;

            tmp = CubeMover.rotate4(u);
            if (tmp.isOk())
                return tmp;
            nodesCreated++;
            tmp = limitedDFS(tmp);
            if(tmp != null)
                return tmp;

            tmp = CubeMover.rotate5(u);
            if (tmp.isOk())
                return tmp;
            nodesCreated++;
            tmp = limitedDFS(tmp);
            if(tmp != null)
                return tmp;

            tmp = CubeMover.rotate6(u);
            if (tmp.isOk())
                return tmp;
            nodesCreated++;
            tmp = limitedDFS(tmp);
            if(tmp != null)
                return tmp;

            tmp = CubeMover.rotate7(u);
            if (tmp.isOk())
                return tmp;
            nodesCreated++;
            tmp = limitedDFS(tmp);
            if(tmp != null)
                return tmp;

            tmp = CubeMover.rotate8(u);
            if (tmp.isOk())
                return tmp;
            nodesCreated++;
            tmp = limitedDFS(tmp);
            if(tmp != null)
                return tmp;

            tmp = CubeMover.rotate9(u);
            if (tmp.isOk())
                return tmp;
            nodesCreated++;
            tmp = limitedDFS(tmp);
            if(tmp != null)
                return tmp;

            tmp = CubeMover.rotate10(u);
            if (tmp.isOk())
                return tmp;
            nodesCreated++;
            tmp = limitedDFS(tmp);
            if(tmp != null)
                return tmp;

            tmp = CubeMover.rotate11(u);
            if (tmp.isOk())
                return tmp;
            nodesCreated++;
            tmp = limitedDFS(tmp);
            if(tmp != null)
                return tmp;

            tmp = CubeMover.rotate12(u);
            if (tmp.isOk())
                return tmp;
            nodesCreated++;
            tmp = limitedDFS(tmp);
            if(tmp != null)
                return tmp;
        }
        return null;
    }

    public Cube limitedDFS(){
        nodesCreated = 0;
        if(root.isOk())
            return root;
        list = new LinkedList<>();
        visited = new HashSet<>();
        list.add(root);
        visited.add(root);
        while (!list.isEmpty()){
            Cube u = list.removeLast();
            if(u.getMoves().size() < limit)
                tmp = expandNodes(u);
            if(tmp != null)
                return tmp;
        }
        return null;
    }

    private Cube expandNodes(Cube u){
        tmp = CubeMover.rotate1(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate2(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate3(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate4(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate5(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate6(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate7(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate8(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate9(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate10(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate11(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate12(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }
        return null;
    }

    private void expandNodes2(Cube u){
        tmp = CubeMover.rotate1(u);
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate2(u);

        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate3(u);

        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate4(u);

        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate5(u);

        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate6(u);

        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate7(u);

        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate8(u);

        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate9(u);

        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate10(u);

        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate11(u);

        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate12(u);

        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }
    }

    private Cube expandNodes3(Cube u){
        tmp = CubeMover.rotate1(u);
        if (tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            q.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate2(u);
        if (tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            q.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate3(u);
        if (tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            q.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate4(u);
        if (tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            q.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate5(u);
        if (tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            q.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate6(u);
        if (tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            q.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate7(u);
        if (tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            q.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate8(u);
        if (tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            q.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate9(u);
        if (tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            q.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate10(u);
        if (tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            q.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate11(u);
        if (tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            q.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }

        tmp = CubeMover.rotate12(u);
        if (tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            q.add(tmp);
            visited.add(tmp);
            nodesCreated++;
        }
        return null;
    }
}
