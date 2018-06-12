package toy.layout;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import toy.dom.Element;
import toy.dom.ImageElement;
import toy.dom.Node;
import toy.dom.Text;

public class Renderable {

    List<Renderable> RChildren = new ArrayList<Renderable>();
    int width;
	int height, x, y;
    Node domNode;
    static int current_pos = 0;
    
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
    
    public void setDimension(Element e) {
    	if(e instanceof ImageElement) {
    		this.width = Integer.parseInt(e.attribute.get("width"));
    		this.height = Integer.parseInt(e.attribute.get("height"));
    	}
    }
    

    public void layout() {
    	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    	final double max_width = screensize.getWidth();
        current_pos = 0;
    	List<ArrayList<Integer>> lines = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> length = new ArrayList<Integer>();
    	for(final Renderable child: this.RChildren) {
    		if(child instanceof RBlock) {
    			lines.add(length);
    			length = new ArrayList<Integer>();
    			current_pos = 0;
    		}
    		if(child.domNode instanceof ImageElement)
	    		if(current_pos + this.width < max_width) {
	    			length.add(this.width);
	    			current_pos += this.width;
	    		}
	    		else {
	    			lines.add(length);
	    			length = new ArrayList<Integer>();
	    			current_pos = 0;
	    		}
    		if(child.domNode instanceof Text) {
    			Text text = (Text) child.domNode;
    			for(Integer i:text.word_length) {
    				if(current_pos + i < max_width) {
    					length.add(i);
    					current_pos += i;
    				}
    				else {
    					lines.add(length);
    	    			length = new ArrayList<Integer>();
    	    			current_pos = 0;
    				}
    			}
    		}
    	}
    	for(List<Integer> line: lines) {
    		for(Integer len: line) {
    			System.out.println(len);
    		}
    	}
    }
}