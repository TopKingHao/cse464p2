import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert;
import java.io.IOException;

public class GraphSearchTest {
    @Test
    public void BFSTest() throws IOException {
        MyGraph myGraph = new MyGraph();
        myGraph.parseGraph("input2.dot");
        MyGraph.Path path = myGraph.graphSearchBFS("a", "g");
        Assert.assertEquals(path.toString(), "a -> e -> g");
        path = myGraph.graphSearchBFS("a", "h");
        Assert.assertEquals(path.toString(), "a -> e -> f -> h");
        path = myGraph.graphSearchBFS("c", "g");
        Assert.assertEquals(path.toString(), "c -> d -> a -> e -> g");
    }

    @Test
    public void DFSTest() throws IOException {
        MyGraph myGraph = new MyGraph();
        myGraph.parseGraph("input2.dot");
        MyGraph.Path path = myGraph.graphSearchDFS("a", "g");
        Assert.assertEquals(path.toString(), "a -> e -> g");
        path = myGraph.graphSearchDFS("a", "h");
        Assert.assertEquals(path.toString(), "a -> e -> f -> h");
        path = myGraph.graphSearchDFS("c", "g");
        Assert.assertEquals(path.toString(), "c -> d -> a -> e -> g");
    }
}
