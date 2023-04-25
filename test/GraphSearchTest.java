import org.junit.Assert;
import org.junit.Test;
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

    @Test
    public void RandomTest() throws IOException {
        System.out.println("random testing");
        MyGraph myGraph = new MyGraph();
        myGraph.parseGraph("input2.dot");
        GraphSearchRandom graphSearchSolution = new GraphSearchRandom(myGraph);
        for(int i = 0; i < 5; i++) {
            System.out.println("Test "+ i);
            MyGraph.Path path = graphSearchSolution.graphSearch("a", "c");
            System.out.println("Path: " + path.toString());
            Assert.assertTrue(myGraph.pathExist(path));
        }
    }

    @Test
    public void RandomStrategyTest() throws IOException {
        System.out.println("random testing");
        MyGraph myGraph = new MyGraph();
        myGraph.parseGraph("input2.dot");
        GraphSearchStrategy graphSearchSolution = new GraphSearchStrategy(new SearchStrategyRandom());
        for(int i = 0; i < 5; i++) {
            System.out.println("Test "+ i);
            MyGraph.Path path = graphSearchSolution.graphSearch(myGraph, "a", "c");
            System.out.println("Path: " + path.toString());
            Assert.assertTrue(myGraph.pathExist(path));
        }
    }
}
