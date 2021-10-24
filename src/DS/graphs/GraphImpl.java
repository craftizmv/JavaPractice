package DS.graphs;

import java.util.*;

/*
 * Graph components -: Vertex, Edge
 * Count connection in a graph -: Using the adjacency matrix, adjacency list
 *
 * NOTE -: Below example uses adjacency list to represent
 * the map.
 *
 */
public class GraphImpl {

    static class Edge {

    }

    /**
     * A representation of Graph
     * Supported operation in a graph -:
     * 1. Creation
     * 2. Updation
     * 3. Searching
     */
    static class Graph {

        /**
         * Vertex class.
         */
        class Vertex {
            String label;

            Vertex(String label) {
                this.label = label;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj)
                    return true;

                if (obj == null)
                    return false;

                if (getClass() != obj.getClass())
                    return false;

                Vertex other = (Vertex) obj;

                if (!getOuterType().equals(other.getOuterType()))
                    return false;

                if (label == null) {

                    if (other.label != null)
                        return false;

                } else if (!label.equals(other.label))
                    return false;
                return true;
            }

            private Graph getOuterType() {
                return Graph.this;
            }

            @Override
            public int hashCode() {
                return Objects.hashCode(label);
            }
        }


        /**
         * Mapping of vertex to list of other vertices
         */
        private Map<Vertex, List<Vertex>> adjVertices;

        Graph() {
            this.adjVertices = new HashMap<>();
        }

        /**
         * Add the vertex
         *
         * @param label
         */
        void addVertex(String label) {
            adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
        }

        /**
         * Remove the vertex and its connections
         *
         * @param label
         */
        void removeVertex(String label) {
            Vertex v = new Vertex(label);

            //Removing the connection stored in the arraylist
            adjVertices.values().stream().forEach(e -> e.remove(v));

            //TODO-MV - Check if below works by just using the same v.
            //Remove from the keys
            adjVertices.remove(new Vertex(label));
        }

        /**
         * Add the edge
         *
         * @param label1
         * @param label2
         */
        void addEdge(String label1, String label2) {
            Vertex v1 = new Vertex(label1);
            Vertex v2 = new Vertex(label2);

            //Adding connection from v1->v2 and vice-versa
            adjVertices.get(v1).add(v2);
            adjVertices.get(v2).add(v1);
        }

        /**
         * Removes the edge
         */
        void removeEdge(String label1, String label2) {
            //Create the vertex first
            Vertex v1 = new Vertex(label1);
            Vertex v2 = new Vertex(label2);

            List<Vertex> list1 = adjVertices.get(v1);
            if (list1 != null) {
                list1.remove(v1);
            }

            List<Vertex> list2 = adjVertices.get(v2);
            if (list2 != null) {
                list2.remove(v2);
            }
        }

        /**
         * Returns the adjacent vertices of a particular
         * vertex.
         *
         * @param label
         * @return
         */
        List<Vertex> getAdjVertices(String label) {
            return adjVertices.get(new Vertex(label));
        }


        /**
         * Traverses the graph.
         *
         * @param graph - Passed in graph
         * @param root  - Start node
         * @return
         */
        Set<String> depthFirstTraversal(Graph graph, String root) {
            Set<String> visited = new LinkedHashSet<>();
            Stack<String> stack = new Stack<>();

            //1. Push the root element to the stack
            stack.push(root);

            //2. Loop and mark element as visited
            while (!stack.isEmpty()) {
                String vertex = stack.pop();
                if (!visited.contains(vertex)) {
                    visited.add(vertex);

                    //3. Pushing all the adjacent to the graph element
                    for (Vertex v : graph.getAdjVertices(vertex)) {
                        stack.push(v.label);
                    }
                }
            }
            return visited;
        }


        /**
         * Performs the breath first search on the graph.
         *
         * @param graph - Passed in graph variable
         * @param root  - Start node of the graph.
         * @return
         */
        Set<String> breadthFirstTraversal(Graph graph, String root) {
            Set<String> visited = new LinkedHashSet<>();
            Queue<String> queue = new LinkedList<>();
            queue.add(root);
            visited.add(root);

            while (!queue.isEmpty()) {
                String vertex = queue.poll();
                for (Vertex v : getAdjVertices(vertex)) {
                    if (!visited.contains(v.label)) {
                        visited.add(v.label);
                        queue.add(v.label);
                    }
                }
            }
            return visited;
        }
    }


    /************************** HELPER METHODS *****************************/

    /**
     * Creates a sample Graph.
     *
     * @return
     */
    private Graph createGraph() {
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        return graph;
    }

    public static void main(String[] args) {
        //1. create the graph
        GraphImpl graphImpl = new GraphImpl();
        Graph graph = graphImpl.createGraph();

        //2. Execute DFS on the graph
        Set<String> dfsResult = graph.breadthFirstTraversal(graph, "Mark");
        for (String s : dfsResult) {
            System.out.println(" Result of bfs " + s);
        }
    }

}
