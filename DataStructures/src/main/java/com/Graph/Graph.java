package com.Graph;

/**
 * Created by Manoj.Mohanan Nair on 6/18/2017.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class Neighbor {
    public int vertexNum;
    public Neighbor next;

    public Neighbor(int vnum, Neighbor nbr) {
        this.vertexNum = vnum;
        next = nbr;
    }
}

class Vertex {
    String name;
    Neighbor adjList;

    Vertex(String name, Neighbor neighbors) {
        this.name = name;
        this.adjList = neighbors;
    }
}

public class Graph {

    Vertex[] adjLists;

    public Graph(String file) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("friendship.txt"));
        String graphType = sc.next();
        boolean undirected = true;
        if (graphType.equals("directed")) {
            undirected = false;
        }

        adjLists = new Vertex[sc.nextInt()];

        // read vertices
        for (int v = 0; v < adjLists.length; v++) {
            adjLists[v] = new Vertex(sc.next(), null);
        }

        // read edges
        while (sc.hasNext()) {

            // read vertex names and translate to vertex numbers
            String nextval = sc.next();
            System.out.println(nextval);
            int v1 = indexForName(nextval);
            nextval = sc.next();
            System.out.println(nextval);
            int v2 = indexForName(nextval);

            // add v2 to front of v1's adjacency list and
            // add v1 to front of v2's adjacency list
            adjLists[v1].adjList = new Neighbor(v2, adjLists[v1].adjList);
            System.out.println(adjLists[v1].adjList.vertexNum);
            if (undirected) {
                adjLists[v2].adjList = new Neighbor(v1, adjLists[v2].adjList);
                System.out.println(adjLists[v2].adjList.vertexNum);
            }
        }
    }

    int indexForName(String name) {
        for (int v = 0; v < adjLists.length; v++) {
            if (adjLists[v].name.equals(name)) {
                return v;
            }
        }
        return -1;
    }

    public void print() {
        System.out.println();
        for (int v = 0; v < adjLists.length; v++) {
            System.out.print(adjLists[v].name);
            for (Neighbor nbr = adjLists[v].adjList; nbr != null; nbr = nbr.next) {
                System.out.print(" --> " + adjLists[nbr.vertexNum].name);
            }
            System.out.println("\n");
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args)
            throws IOException {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter graph input file name: ");
        String file = "friendship.txt";
        Graph graph = new Graph(file);
        graph.print();

    }

}
