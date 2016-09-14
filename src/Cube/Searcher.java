package Cube;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Searcher {

    public Cube root;
    public int expandedNodes;
    private LinkedList<Cube> list;
    private HashSet<Cube> visited;
    private PriorityQueue<Cube> q;
    private Cube tmp;

    public Searcher(Cube cube){
        root = cube;
    }

    public Cube theAStar(){
        q = new PriorityQueue<>();
        q.add(root);
        expandedNodes = 0;
        while (!q.isEmpty()){
            tmp = q.poll();;
            tmp = expandNodes2(tmp);
            if(tmp != null)
                return tmp;
        }
        return null;
    }

    public Cube iterativeDFS(int limit){
        for(int i = 1; i <= limit; i++){
            tmp = limitedDFS(i);
            if(tmp != null)
                return tmp;
        }
        return null;
    }

    public Cube DFS(){
        expandedNodes = 0;
        list = new LinkedList<>();
        visited = new HashSet<>();
        list.add(root);
        visited.add(root);
        while (!list.isEmpty()){
            Cube u = list.removeLast();
            tmp = expandNodes(u);
            if(tmp != null)
                return tmp;
        }
        return null;
    }

    public Cube limitedDFS(int limit){
        expandedNodes = 0;
        list = new LinkedList<>();
        visited = new HashSet<>();
        list.add(root);
        visited.add(root);
        while (!list.isEmpty()){
            Cube u = list.removeLast();
            if(u.getMoves().size() < limit)
                tmp = expandNodes(u);
            else
                tmp = null;
            if(tmp != null)
                return tmp;
        }
        return null;
    }

    public Cube BFS(){
        expandedNodes = 0;
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

    private Cube expandNodes(Cube u){
        tmp = CubeMover.rotate1(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            expandedNodes++;
        }

        tmp = CubeMover.rotate2(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            expandedNodes++;
        }

        tmp = CubeMover.rotate3(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            expandedNodes++;
        }

        tmp = CubeMover.rotate4(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            expandedNodes++;
        }

        tmp = CubeMover.rotate5(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            expandedNodes++;
        }

        tmp = CubeMover.rotate6(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            expandedNodes++;
        }

        tmp = CubeMover.rotate7(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            expandedNodes++;
        }

        tmp = CubeMover.rotate8(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            expandedNodes++;
        }

        tmp = CubeMover.rotate9(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            expandedNodes++;
        }

        tmp = CubeMover.rotate10(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            expandedNodes++;
        }

        tmp = CubeMover.rotate11(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            expandedNodes++;
        }

        tmp = CubeMover.rotate12(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            expandedNodes++;
        }

        tmp = CubeMover.rotate13(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            expandedNodes++;
        }

        tmp = CubeMover.rotate14(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            expandedNodes++;
        }

        tmp = CubeMover.rotate15(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            expandedNodes++;
        }

        tmp = CubeMover.rotate16(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            expandedNodes++;
        }

        tmp = CubeMover.rotate17(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            expandedNodes++;
        }

        tmp = CubeMover.rotate18(u);
        if(tmp.isOk())
            return tmp;
        if(!visited.contains(tmp)) {
            list.add(tmp);
            visited.add(tmp);
            expandedNodes++;
        }

        return null;
    }

    private Cube expandNodes2(Cube u){
        tmp = CubeMover.rotate1(u);
        if(tmp.isOk())
            return tmp;
        q.add(tmp);

        tmp = CubeMover.rotate2(u);
        if(tmp.isOk())
            return tmp;
        q.add(tmp);

        tmp = CubeMover.rotate3(u);
        if(tmp.isOk())
            return tmp;
        q.add(tmp);

        tmp = CubeMover.rotate4(u);
        if(tmp.isOk())
            return tmp;
        q.add(tmp);

        tmp = CubeMover.rotate5(u);
        if(tmp.isOk())
            return tmp;
        q.add(tmp);

        tmp = CubeMover.rotate6(u);
        if(tmp.isOk())
            return tmp;
        q.add(tmp);

        tmp = CubeMover.rotate7(u);
        if(tmp.isOk())
            return tmp;
        q.add(tmp);

        tmp = CubeMover.rotate8(u);
        if(tmp.isOk())
            return tmp;
        q.add(tmp);

        tmp = CubeMover.rotate9(u);
        if(tmp.isOk())
            return tmp;
        q.add(tmp);

        tmp = CubeMover.rotate10(u);
        if(tmp.isOk())
            return tmp;
        q.add(tmp);

        tmp = CubeMover.rotate11(u);
        if(tmp.isOk())
            return tmp;
        q.add(tmp);

        tmp = CubeMover.rotate12(u);
        if(tmp.isOk())
            return tmp;
        q.add(tmp);

        tmp = CubeMover.rotate13(u);
        if(tmp.isOk())
            return tmp;
        q.add(tmp);

        tmp = CubeMover.rotate14(u);
        if(tmp.isOk())
            return tmp;
        q.add(tmp);

        tmp = CubeMover.rotate15(u);
        if(tmp.isOk())
            return tmp;
        q.add(tmp);

        tmp = CubeMover.rotate16(u);
        if(tmp.isOk())
            return tmp;
        q.add(tmp);

        tmp = CubeMover.rotate17(u);
        if(tmp.isOk())
            return tmp;
        q.add(tmp);

        tmp = CubeMover.rotate18(u);
        if(tmp.isOk())
            return tmp;
        q.add(tmp);

        return null;
    }
}
