import org.jgrapht.graph.DefaultEdge;

import java.util.*;

public class GraphSearchBFS extends GraphSearch{
    Queue<String> queue;

    public GraphSearchBFS(MyGraph myGraph) {
        super(myGraph);
        queue = new LinkedList<>();
    }

    @Override
    protected void clearCache() {
        super.clearCache();
        queue.clear();
    }

    @Override
    protected boolean checkNodes() {
        return !queue.isEmpty();
    }
    @Override
    protected void putStartNode(String src) {
        queue.add(src);
    }
    @Override
    protected String getCurrentNode() {
        return queue.poll();
    }
    @Override
    protected void fetchNextNodes(String currentNode) {
        for (DefaultEdge edge : myGraph.myGraph.edgesOf(currentNode)) {
            String neighbor = myGraph.myGraph.getEdgeTarget(edge);
            if (!visitedNodes.contains(neighbor) && !queue.contains(neighbor)) {
                previousNodes.put(neighbor, currentNode);
                queue.add(neighbor);
            }
        }
    }
}
