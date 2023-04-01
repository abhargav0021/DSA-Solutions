
//Intuition:
//1) Build the board array by using the snakes array and ladders array
//2) use the board array to create an adjecency list or a graph
//3) use bfs to find the min path

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakesNLadders {
    //create boards array function
    static int[] createBoardArray(int[][] ladders,int[][] snakes, int numberOfCells){
        int[] board = new int[numberOfCells+1];
        //for ladders you go up on the board
        for(int[] lad: ladders){
            board[lad[0]] = lad[1]-lad[0];
        }
        //for snakes you go down
        for(int[] snk: snakes){
            board[snk[0]] = snk[1]-snk[0];
        }
        return board;
    }
    //create a graph
    static ArrayList<ArrayList<Integer>> createGraph(int[] board, int numberOfCells){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(numberOfCells+1);
        ArrayList<Integer> temp;
        adjList.add(new ArrayList<>());
        for(int i=1; i< numberOfCells+1;i++){
            temp = new ArrayList<>();
            if(board[i] == 0) {
                //try all the possiblites of reaching to a cell on the board by using a die
                for (int dice = 1; dice <= 6; dice++) {
                    int cell = i + dice;
                    if(cell<=numberOfCells)
                        temp.add(cell + board[cell]);
                }
            }
            adjList.add(temp);
        }
        return adjList;
    }
    //breadth first search
    static int minDiceThrowBFS(ArrayList<ArrayList<Integer>> graph , int numberOfCells){
        int[] dist = new int[numberOfCells+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1]=0;
        while(!q.isEmpty()){
            int front = q.poll();
            ArrayList<Integer> temp = graph.get(front);
            //System.out.println(temp);
            for(int i=0;i<temp.size();i++){
                if(dist[temp.get(i)] == Integer.MAX_VALUE){
                    dist[temp.get(i)] = dist[front]+1;
                    q.add(temp.get(i));
                }
            }
        }
        return dist[numberOfCells];
    }

    static void modify(Integer i){
        i=i+1;
    }
    public static void main(String[] args) {
//        int[][] ladders = {{3,7},{6,15},{8,12},{14,16}};
//        int[][] snakes = {{10,3},{13,6},{18,11}};
//        int numberOfCells = 20;
//        int[] board = createBoardArray(ladders,snakes,numberOfCells);
//        System.out.println(Arrays.toString(board));
//        ArrayList<ArrayList<Integer>> graph = createGraph(board,numberOfCells);
//        System.out.println(graph);
//        System.out.println(minDiceThrowBFS(graph,numberOfCells));
        Integer i = Integer.valueOf(12);
        System.out.println(i+" ");
        modify(i);
        System.out.println(i);
    }
}
