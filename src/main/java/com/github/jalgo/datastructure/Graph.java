package com.github.jalgo.datastructure;

import java.util.Collection;

public interface Graph<V extends Graph.Vertex, E extends Graph.Edge> { // todo

    int numberOfNodes();

    int numberOfEdges();

    void addNode(V newVertice);

    void removeNode(V nodeToRemove);

    void addEdge(Edge newEdge);

    boolean removeEdge(Edge edgeToRemove);

    interface Edge {

        Vertex getSource();

        Vertex getDestination();

        default int cost() {
            return 1;
        }

    }

    interface Vertex {

        int getId();

        Collection<Edge> neighborEdges();

    }

}
