package toy.dom;

public class Text extends Node {
  String value;
  
  Text(String s) {
    nodeType = "text";
    tag = "text";
    value = s;
  }

}
