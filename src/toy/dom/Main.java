package toy.dom;

import java.util.HashMap;
import java.util.Map;
import toy.layout.Renderable;

public class Main {
    public static void main(String[] args) {
        HTMLDocument html = new HTMLDocument("HTMLDocument", "html");
        HTMLBodyElement body = new HTMLBodyElement("HTMLBodyElement", "body");
        html.setChildren(body);
        Map<String, String> attr = new HashMap<String, String>();
        attr.put("display", "inline");
        Element div = new Element("element", "div");
        div.CSSProperties(attr);
        Map<String, String> attr2 = new HashMap<String, String>();
        attr2.put("display", "block");
        Element div2 = new Element("element", "div2");
        div2.CSSProperties(attr2);
        ImageElement img = new ImageElement("ImageElement","img");
        body.setChildren(div);        
        body.setChildren(div2);
        Map<String,String> attr3 = new HashMap<String,String>();
        attr3.put("width", "30");
        attr3.put("height", "40");
        img.CSSProperties(attr3);
        div2.setChildren(img);
        Text text = new Text("Hello world");
        div.setChildren(text);
        Renderable renderable = html.createRenderTree();
        System.out.println("DOM Tree:");
        html.dumpTree(1);
        System.out.println();
        System.out.println("Render Tree:");
        renderable.dumpTree(1);
    }
}