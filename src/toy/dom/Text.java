package toy.dom;

import java.awt.List;

public class Text extends Node {
  String value;
  List words;
  
  Text(String s) {
    nodeType = "text";
    tag = "text";
    value = s;
  }
  
  void createList() {
	  for(String w: value.split(" ")) {
		  words.add(w);
	  }
  }
}
