import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert;
import java.io.IOException;

public class GraphSearchTest {
    @Test
    public void BFSTest() throws IOException {
        MyGraph myGraph = new MyGraph();
        myGraph.parseGraph("input2.dot");
        GraphSearchBFS graphSearchSolution = new GraphSearchBFS(myGraph);
        MyGraph.Path path = graphSearchSolution.graphSearch("a", "g");
        Assert.assertTrue(myGraph.pathExist(path));
        path = graphSearchSolution.graphSearch("a", "h");
        Assert.assertTrue(myGraph.pathExist(path));
        path = graphSearchSolution.graphSearch("c", "g");
        Assert.assertTrue(myGraph.pathExist(path));
    }

    @Test
    public void DFSTest() throws IOException {
        MyGraph myGraph = new MyGraph();
        myGraph.parseGraph("input2.dot");
        GraphSearchDFS graphSearchSolution = new GraphSearchDFS(myGraph);
        MyGraph.Path path = graphSearchSolution.graphSearch("a", "g");
        Assert.assertTrue(myGraph.pathExist(path));
        path = graphSearchSolution.graphSearch("a", "h");
        Assert.assertTrue(myGraph.pathExist(path));
        path = graphSearchSolution.graphSearch("c", "g");
        Assert.assertTrue(myGraph.pathExist(path));
    }

    @Test
    public void BFSStrategyTest() throws IOException {
        MyGraph myGraph = new MyGraph();
        myGraph.parseGraph("input2.dot");
        GraphSearchStrategy graphSearchSolution = new GraphSearchStrategy(new SearchStrategyBFS());
        MyGraph.Path path = graphSearchSolution.graphSearch(myGraph, "a", "g");
        Assert.assertTrue(myGraph.pathExist(path));
        path = graphSearchSolution.graphSearch(myGraph, "a", "h");
        Assert.assertTrue(myGraph.pathExist(path));
        path = graphSearchSolution.graphSearch(myGraph, "c", "g");
        Assert.assertTrue(myGraph.pathExist(path));
    }

    @Test
    public void DFSStrategyTest() throws IOException {
        MyGraph myGraph = new MyGraph();
        myGraph.parseGraph("input2.dot");
        GraphSearchStrategy graphSearchSolution = new GraphSearchStrategy(new SearchStrategyDFS());
        MyGraph.Path path = graphSearchSolution.graphSearch(myGraph, "a", "g");
        Assert.assertTrue(myGraph.pathExist(path));
        path = graphSearchSolution.graphSearch(myGraph, "a", "h");
        Assert.assertTrue(myGraph.pathExist(path));
        path = graphSearchSolution.graphSearch(myGraph, "c", "g");
        Assert.assertTrue(myGraph.pathExist(path));
    }
}
