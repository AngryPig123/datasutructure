package org.example.datastructuresandalgorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<String>());
            return true;
        } else {
            return false;
        }
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex2).add(vertex1);
            adjList.get(vertex1).add(vertex2);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeVertex(String vertex) {
        ArrayList<String> temp = adjList.get(vertex);
        if (temp != null) {
            for (String str : temp) {
                ArrayList<String> remove = adjList.get(str);
                remove.remove(vertex);
            }
            adjList.remove(vertex);
            return true;
        } else {
            return false;
        }
    }

}
