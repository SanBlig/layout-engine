package toy.dom;

import java.util.ArrayList;
import java.util.List;

public class Node {
  List<Node> children = new ArrayList<Node>();
  String nodeType;
  String tag;
  
  
  void dumpTree(int level) {
    for(Node child: children) {
      System.out.println(String.format("%-"+level+"s", " ") + child);
      child.dumpTree(level+2);
    } 
  }
  
  void setChildren(Node n) {
    this.children.add(n);
  }
}
