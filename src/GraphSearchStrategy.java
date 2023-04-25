import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

public class GraphSearchStrategy
{
    MyGraph myGraph;
    SearchStrategy searchStrategy;
    GraphSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public MyGraph.Path graphSearch(MyGraph myGraph, String src, String dst) {
        return searchStrategy.execute(myGraph, src, dst);
    }
}