import org.jgrapht.graph.*;
import org.jgrapht.nio.dot.DOTImporter;
import org.jgrapht.nio.dot.DOTExporter;
import org.jgrapht.ext.JGraphXAdapter;
import java.io.File;
import java.io.*;
import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;
import org.jgrapht.Graph;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.List;

public class MyGraph {
    Graph <String, DefaultEdge> myGraph;

    public void parseGraph(String filepath) {
        File f = new File(filepath);
        myGraph = new SimpleDirectedGraph<>(DefaultEdge.class);
        DOTImporter<String, DefaultEdge> importer = new DOTImporter<>();
        importer.setVertexFactory(id->id);
        importer.importGraph(myGraph, f);

    }

    public String toString(Boolean ifPrint) {
         String s= "Number of nodes: " + myGraph.vertexSet().size() + "\n" +
                "Label of the nodes: " + myGraph.vertexSet() + "\n" +
                "Number of edges: " + myGraph.edgeSet().size() + "\n" +
                "Nodes and edge directions: " + (myGraph.edgeSet().toString()).replace(":", "->");
         if (ifPrint) {
             System.out.println(s);
         }
         return s;
    }

    public void outputGraph(String filepath) {
        try {
            OutputStream f = new FileOutputStream(filepath);
            OutputStreamWriter writer = new OutputStreamWriter(f, StandardCharsets.UTF_8);
            writer.append(this.toString(Boolean.FALSE));
            writer.close();
            f.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addNode(String label) {
        myGraph.addVertex(label);
    }

    public void removeNode(String label) {
        myGraph.removeVertex(label);
    }

    public void addNodes(String[] label) {
        for(String node:label) {
            this.addNode(node);
        }
    }

    public void removeNodes(String[] label) {
        for(String node:label) {
            this.removeNode(node);
        }
    }

    public void addEdge(String srcLabel, String dstLabel) {
        this.myGraph.addEdge(srcLabel, dstLabel);
    }

    public void  removeEdge(String srcLabel, String dstLabel) {
        this.myGraph.removeEdge(srcLabel, dstLabel);
    }

    public void outputDOTGraph(String path) {
        DOTExporter exporter = new DOTExporter<>();
        File f = new File(path);
        exporter.exportGraph(this.myGraph, f);
    }

    public void outputGraphics(String path, String format) {
        JGraphXAdapter mxGraph = new JGraphXAdapter(this.myGraph);
        mxIGraphLayout layout = new mxCircleLayout(mxGraph);
        layout.execute(mxGraph.getDefaultParent());
        BufferedImage image = mxCellRenderer.createBufferedImage(mxGraph, null, 1, Color.WHITE, true, null);
        try {
            ImageIO.write(image, format, new File(path));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static class Path {
        private List<String> nodes;

        public Path() {
            nodes = new LinkedList<>();
        }

        public void addNode(String node) {
            nodes.add(node);
        }

        public List<String> getNodes() {
            return nodes;
        }

        public String toString() {
            return String.join(" -> ", nodes);
        }
    }

    public boolean pathExist(Path path){
        List<String> node_list = path.getNodes();
        for(int i = 0; i < node_list.size()-1; i++) {
            String node = node_list.get(i);
            String next_node = node_list.get(i+1);
            if(!myGraph.containsVertex(node))
                return false;
            if(!myGraph.containsEdge(node, next_node))
                return false;
        }
        return true;
    }
}
