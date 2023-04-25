import org.jgrapht.graph.DefaultEdge;

import java.util.*;

public class GraphSearchRandom extends GraphSearch{
    ArrayList<String> list;
    public GraphSearchRandom(MyGraph myGraph) {
        super(myGraph);
        list = new ArrayList<String>();
    }

    @Override
    protected void clearCache() {
        super.clearCache();
        list.clear();
    }

    @Override
    protected boolean checkNodes() {
        return !list.isEmpty();
    }

    @Override
    protected void putStartNode(String src){
        list.add(src);
    }
    @Override
    protected String getCurrentNode() {
        Collections.shuffle(list);

        // Get a random element from the shuffled list
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());
        String randomNode = list.get(randomIndex);
        list.remove(randomIndex);
        System.out.println("visiting path: "+getPath(randomNode, previousNodes).toString());
        return randomNode;
    }

    @Override
    protected void fetchNextNodes(String currentNode) {
        for (DefaultEdge edge : myGraph.myGraph.edgesOf(currentNode)) {
            String neighbor = myGraph.myGraph.getEdgeTarget(edge);
            if(!visitedNodes.contains(neighbor) && !list.contains(neighbor)) {
                list.add(neighbor);
                previousNodes.put(neighbor, currentNode);
            }
        }
    }
}
