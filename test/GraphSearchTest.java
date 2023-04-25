import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert;
import java.io.IOException;

public class GraphSearchTest {
    @Test
    public void BFSTest() throws IOException {
        MyGraph myGraph = new MyGraph();
        myGraph.parseGraph("input2.dot");
        MyGraph.Path path = myGraph.GraphSearch("a", "g");
        Assert.assertEquals(path.toString(), "a -> e -> g");
        path = myGraph.GraphSearch("a", "h");
        Assert.assertEquals(path.toString(), "a -> e -> f -> h");
        path = myGraph.GraphSearch("c", "g");
        Assert.assertEquals(path.toString(), "c -> d -> a -> e -> g");
    }

    @Test
    public void DFSTest() throws IOException {
        MyGraph myGraph = new MyGraph();
        myGraph.parseGraph("input2.dot");
        MyGraph.Path path = myGraph.GraphSearchDFS("a", "g");
        Assert.assertEquals(path.toString(), "a -> e -> g");
        path = myGraph.GraphSearchDFS("a", "h");
        Assert.assertEquals(path.toString(), "a -> e -> f -> h");
        path = myGraph.GraphSearchDFS("c", "g");
        Assert.assertEquals(path.toString(), "c -> d -> a -> e -> g");
    }
}
