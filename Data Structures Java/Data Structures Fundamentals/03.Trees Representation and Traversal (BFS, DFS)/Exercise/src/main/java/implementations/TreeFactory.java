package implementations;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class TreeFactory {
    private Map<Integer, Tree<Integer>> nodesByKeys;

    public TreeFactory() {
        this.nodesByKeys = new LinkedHashMap<>();
    }

    public Tree<Integer> createTreeFromStrings(String[] input) {
        for (String params : input) {
            int[] keys = Arrays.stream(params.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int parentKey = keys[0];
            int childKey = keys[1];
            //приемаме входните данни и вадим Parent и Child

            this.addEdge(parentKey, childKey);

        }
        return this.getRoot();
    }

    private Tree<Integer> getRoot() {
        for (Tree<Integer> value : nodesByKeys.values()) {
            if (value.getParent() == null) {
                return value;
            }
        }
        return null;
    }

    public Tree<Integer> createNodeByKey(int key) {
        this.nodesByKeys.putIfAbsent(key, new Tree<>(key)); //добавяме Key(Parent Node) както и Child Node

        return this.nodesByKeys.get(key);
    }

    public void addEdge(int parent, int child) {
        Tree<Integer> parentByKey = this.createNodeByKey(parent); //създаваме Parent
        Tree<Integer> childByKey = this.createNodeByKey(child); //създаваме Child

        childByKey.setParent(parentByKey);
        parentByKey.addChild(childByKey);

    }
}



