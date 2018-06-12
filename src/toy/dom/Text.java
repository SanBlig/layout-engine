package toy.dom;

import java.util.ArrayList;
import java.util.List;

public class Text extends Node {
  String value;
  List<String> words = new ArrayList<String>();
  public List<Integer> word_length = new ArrayList<Integer>();
  
  Text(String s) {
    nodeType = "text";
    tag = "text";
    value = s;
  }
  
  void createList() {
	  for(String w: value.split(" ")) {
		  words.add(w);
		  word_length.add(w.length());
	  }
  }
}
