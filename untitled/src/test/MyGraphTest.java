//package test.MyGraphTest;

import org.junit.Assert;
import org.junit.Test;


import java.io.File;
import java.io.IOException;

public class MyGraphTest {
    @Test
    public void featureOneTest() throws IOException {
        MyGraph myGraph = new MyGraph();
        myGraph.parseGraph("untitled/demo.dot");
        // Test parseGraph()

        Assert.assertEquals(
                "Number of nodes: 4\n" +
                        "Label of the nodes: [A1, B1, A2, B2]\n" +
                        "Number of edges: 4\n" +
                        "Nodes and edge directions: [(A1 -> B1)," +
                        " (A2 -> B2)," +
                        " (A1 -> A2)," +
                        " (B1 -> B2)]",
                myGraph.toString(Boolean.TRUE)
        );

        // Test outputGraph()
        myGraph.outputGraph("output.txt");
        File file = new File("output.txt");
        Assert.assertTrue(file.exists());
        file.delete();
    }

    @Test
    public void featureTwoTest() throws Exception {
        MyGraph myGraph = new MyGraph();
        myGraph.parseGraph("untitled/demo.dot");
        myGraph.addNode("A3");
        myGraph.addNode("A2");
        String[] nodesAdd = {"B2", "B3"};
        myGraph.addNodes(nodesAdd);
        Assert.assertEquals(
                "Number of nodes: 6\n" +
                        "Label of the nodes: [A1, B1, A2, B2, A3, B3]\n" +
                        "Number of edges: 4\n" +
                        "Nodes and edge directions: [(A1 -> B1)," +
                        " (A2 -> B2)," +
                        " (A1 -> A2)," +
                        " (B1 -> B2)]",
                myGraph.toString(Boolean.TRUE)
        );
        String[] nodesRemove = {"A3"};
        myGraph.removeNode("A1");
        myGraph.removeNodes(nodesRemove);
        Assert.assertEquals(
                "Number of nodes: 4\n" +
                        "Label of the nodes: [B1, A2, B2, B3]\n" +
                        "Number of edges: 2\n" +
                        "Nodes and edge directions: [" +
                        "(A2 -> B2)," +
                        " (B1 -> B2)]",
                myGraph.toString(Boolean.TRUE)
        );
    }


    @Test
    public void featureThreeTest() throws Exception {
        MyGraph myGraph = new MyGraph();
        myGraph.parseGraph("untitled/demo.dot");

        myGraph.addEdge("A1", "B2");
        Assert.assertEquals(
                "Number of nodes: 4\n" +
                        "Label of the nodes: [A1, B1, A2, B2]\n" +
                        "Number of edges: 5\n" +
                        "Nodes and edge directions: [(A1 -> B1)," +
                        " (A2 -> B2)," +
                        " (A1 -> A2)," +
                        " (B1 -> B2)," +
                        " (A1 -> B2)]",
                myGraph.toString(Boolean.TRUE)
        );
    }



    @Test
    public void featureFourTest() throws Exception {
        MyGraph myGraph = new MyGraph();
        myGraph.parseGraph("untitled/demo.dot");

        File dotfile = new File("output.dot");
        myGraph.outputDOTGraph("output.dot");
        Assert.assertTrue(dotfile.exists());
        dotfile.delete();

        // Test outputGraphics() for PNG format
        File pngfile = new File("output.png");
        myGraph.outputGraphics("output.png", "PNG");
        Assert.assertTrue(pngfile.exists());
        pngfile.delete();
    }
}