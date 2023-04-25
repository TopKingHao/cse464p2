import org.jgrapht.graph.DefaultEdge;

import java.util.*;

abstract class GraphSearch
{
    protected abstract String getCurrentNode();
    protected abstract void fetchNextNodes(String currentNode);
    protected abstract void putStartNode(String src);
    protected abstract boolean checkNodes();

    MyGraph myGraph;
    Map<String, String> previousNodes;
    Set<String> visitedNodes;

    public GraphSearch(MyGraph myGraph)
    {
        this.myGraph = myGraph;
        previousNodes = new HashMap<String, String>();
        visitedNodes = new HashSet<String>();
    }

    public MyGraph.Path graphSearch(String src, String dst) {
        if (judgeSearchProblem(src, dst)) return null;
        clearCache();

        putStartNode(src);
        while (checkNodes()) {
            String currentNode = getCurrentNode();

            if (currentNode.equals(dst)) {
                return getPath(dst, previousNodes);
            }

            updateVisitedNode(currentNode);
            fetchNextNodes(currentNode);

        }
        return null;
    }

    protected void clearCache()
    {
        previousNodes.clear();
        visitedNodes.clear();
    }
    protected boolean judgeSearchProblem(String src, String dst) {
        if (src == null || dst == null || !myGraph.myGraph.containsVertex(src) || !myGraph.myGraph.containsVertex(dst)) {
            return true;
        }
        return false;
    }

    protected void updateVisitedNode(String currentNode) {
        visitedNodes.add(currentNode);
        return;
    }
    protected static MyGraph.Path getPath(String dst, Map<String, String> previousNodes) {
        MyGraph.Path path = new MyGraph.Path();
        String pathNode = dst;
        while (pathNode != null) {
            path.addNode(pathNode);
            pathNode = previousNodes.get(pathNode);
        }
        Collections.reverse(path.getNodes());
        return path;
    }
}