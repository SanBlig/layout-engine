package toy.layout;

import java.util.ArrayList;
import java.util.List;

import toy.dom.Element;
import toy.dom.Node;
import toy.dom.Text;

public class Renderable {

    List<Renderable> RChildren = new ArrayList<Renderable>();
    int width, height, x, y;
    Node domNode;
    
    Renderable(Node n) {
      domNode = n;
    }
    
    public void addChild(Renderable r) {
        this.RChildren.add(r); 
    }
    
    public void addDomNode(Element e) {
      domNode = e;
    }
    
    public void addDomNode(Text t) {
      domNode = t;
    }
    
    

    public void dumpTree(int level) {
        for (Renderable RChild : RChildren) {
            System.out.println(String.format("%-"+level+"s", " ") + RChild+"---->"+RChild.domNode);
            RChild.dumpTree(level+2);
        }
    }

    void layout() {

    }
}