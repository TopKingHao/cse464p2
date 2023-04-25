import java.util.*;

public abstract class SearchStrategy {
    protected abstract String getCurrentNode();
    protected abstract void fetchNextNodes(MyGraph myGraph, String currentNode);
    protected abstract void putStartNode(String src);
    protected abstract boolean checkNodes();

    Map<String, String> previousNodes;
    Set<String> visitedNodes;

    public SearchStrategy()
    {
        previousNodes = new HashMap<String, String>();
        visitedNodes = new HashSet<String>();
    }

    public MyGraph.Path execute(MyGraph myGraph, String src, String dst) {
        if (judgeSearchProblem(myGraph, src, dst)) return null;
        clearCache();

        putStartNode(src);
        while (checkNodes()) {
            String currentNode = getCurrentNode();

            if (currentNode.equals(dst)) {
                return getPath(dst, previousNodes);
            }

            updateVisitedNode(currentNode);
            fetchNextNodes(myGraph, currentNode);

        }
        return null;
    }

    protected void clearCache()
    {
        previousNodes.clear();
        visitedNodes.clear();
    }
    protected boolean judgeSearchProblem(MyGraph myGraph, String src, String dst) {
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
