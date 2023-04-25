import org.jgrapht.graph.DefaultEdge;

import java.util.*;
public class SearchStrategyDFS extends SearchStrategy{
    Stack<String> stack;

    public SearchStrategyDFS() {
        super();
        stack = new Stack<String>();
    }

    @Override
    protected void clearCache() {
        super.clearCache();
        stack.clear();
    }

    @Override
    protected boolean checkNodes() {
        return !stack.isEmpty();
    }

    @Override
    protected void putStartNode(String src){
        stack.push(src);
    }
    @Override
    protected String getCurrentNode() {
        return stack.pop();
    }

    @Override
    protected void fetchNextNodes(MyGraph myGraph, String currentNode) {
        for (DefaultEdge edge : myGraph.myGraph.edgesOf(currentNode)) {
            String neighbor = myGraph.myGraph.getEdgeTarget(edge);
            if(!visitedNodes.contains(neighbor) && !stack.contains(neighbor)) {
                stack.push(neighbor);
                previousNodes.put(neighbor, currentNode);
            }
        }
    }
}
