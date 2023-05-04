package implementations;

import interfaces.AbstractTree;

import java.util.*;
import java.util.stream.Collectors;

public class Tree<E> implements AbstractTree<E> {
    private E key; //самият елемент
    private Tree<E> parent; //насока към Parent Node
    private List<Tree<E>> children; //пазим всички деца в такава колекция

    public Tree(E key) {
        this.key = key;
        this.children = new ArrayList<>();
    }

    @Override
    public void setParent(Tree<E> parent) {
        this.parent = parent;
    }

    @Override
    public void addChild(Tree<E> child) {
        this.children.add(child);
    }

    @Override
    public Tree<E> getParent() {
        return this.parent;
    }

    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public String getAsString() {
        StringBuilder sb = new StringBuilder();

        traverseTreeWithRecurrence(sb, 0, this);
        return sb.toString().trim();
    }

    @Override
    public List<E> getLeafKeys() {

        return traverseWithBFS()
                .stream()
                .filter(tree -> tree.children.isEmpty()) //няма наследници ==> Leaf
                .map(Tree::getKey)
                .collect(Collectors.toList());
        // връщаме списък с всички Leaf
    }

    @Override
    public List<E> getMiddleKeys() {
        return this.traverseWithBFS()
                .stream()
                .filter(tree -> tree.parent != null && !tree.children.isEmpty())
                .map(Tree::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public Tree<E> getDeepestLeftmostNode() {
        List<Tree<E>> trees = this.traverseWithBFS();

        int maxPath = 0;
        Tree<E> deepestLeftmostNode = null;

        for (Tree<E> tree : trees) {
            if (tree.isLeaf()) {
                int currentPath = getMaxPathCount(tree);
                if (currentPath > maxPath) {
                    maxPath = currentPath;
                    deepestLeftmostNode = tree;
                }
            }
        }
        return deepestLeftmostNode;
    }

    private int getMaxPathCount(Tree<E> tree) {
        int counter = 0;
        Tree<E> current = tree;
        while (current.parent != null) {
            counter++;
            current = current.parent;
        }
        return counter;
    }


    private boolean isLeaf() {
        return this.parent != null && this.children.isEmpty();
    }

    @Override
    public List<E> getLongestPath() {
        return null;
    }

    @Override
    public List<List<E>> pathsWithGivenSum(int sum) {
        return null;
    }

    @Override
    public List<Tree<E>> subTreesWithGivenSum(int sum) {
        return null;
    }

    private void traverseTreeWithRecurrence(StringBuilder sb, int indent, Tree<E> tree) {

        sb
                .append(this.getPadding(indent)) // ще даде колко space-а да има (0, 1, 2 и т.н.)
                .append(tree.getKey()) //стойността на ключа
                .append(System.lineSeparator());

        for (Tree<E> child : tree.children) {
            traverseTreeWithRecurrence(sb, indent + 2, child);
        } //това е и дъното на рекурсията, тк ако няма children, ще спре цикъла

    }

    private String getPadding(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private List<Tree<E>> traverseWithBFS() {
        Deque<Tree<E>> queue = new ArrayDeque<>();

        queue.offer(this);

        List<Tree<E>> allNodes = new ArrayList<>();


        while (!queue.isEmpty()) {
            Tree<E> tree = queue.poll();
            allNodes.add(tree);
            for (Tree<E> child : tree.children) {
                queue.offer(child);
            }
        }
        return allNodes;
    }
}



