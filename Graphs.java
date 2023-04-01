import java.util.LinkedList;

public class Graphs {
    //create adjecency list using linked list
    static void createGraphLL(int x, int y, LinkedList<Integer>[] arrLL) {
        arrLL[x].add(y);
        arrLL[y].add(x);
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 3}, {3, 2}, {3, 4}, {2, 4}, {1, 2}};
        LinkedList<Integer>[] arrLL = new LinkedList[5];
        for (int i = 0; i < 5; i++) {
            arrLL[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            //System.out.println(edge[0]);
            createGraphLL(edge[0], edge[1], arrLL);
        }
        for (int i = 0; i < 5; i++)
            System.out.println(arrLL[i]);
    }
}