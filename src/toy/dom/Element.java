package toy.dom;


import java.util.HashMap;
import java.util.Map;
import toy.layout.RBlock;
import toy.layout.RInline;
import toy.layout.RText;
import toy.layout.Renderable;

public class Element extends Node {

  Map<String, String> attribute = new HashMap<String, String>();

  Element(final String type, final String name) {
    nodeType = type;
    tag = name;
  }

  void CSSProperties(Map<String, String> attr) {
    attribute = attr;
  }

  Renderable createRenderTree() {
    Renderable self = (this.attribute.get("display") != "inline") ? new RBlock(this) : new RInline(this); 
    for (final Node child : this.children) {
      if (child instanceof Element) {
        final Element elementChild = (Element) child;  
        self.addChild(elementChild.createRenderTree());
      } else if (child instanceof Text) {
        //final Text textChild = (Text) child;
        self.addChild(new RText(child));
      }
    }
    return self;
  }
}