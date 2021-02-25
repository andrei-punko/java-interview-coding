package by.andd3dfx.tree.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Дано бинарное дерево с выделенным корнем, в каждой вершине которого записано по одной букве A-Z.
 * Две вершины считаются эквивалентными, если поддеревья этих вершин содержат одинаковое множество (т.е. без учета частот) букв.
 * Нужно найти две эквивалентные вершины с максимальным суммарным размеров поддеревьев.
 * <p>
 * public class Node {
 * char value;  // [A-Z]
 * Node left;
 * Node right;
 * };
 */
public class EquivalentTrees {

    public static class Node {
        char value;  // [A-Z]
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
        }

        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "{" +
                    value +
                    ((left != null) ? (", l=" + left) : "") +
                    ((right != null) ? (", r=" + right) : "") +
                    '}';
        }
    }

    public List<Node> findEquivalentSubtrees(Node root) {
        if (root == null) {
            return null;
        }

        // Build map { Node -> (Vocabulary of sub nodes)}
        Map<Node, Set<Character>> node2Voc = new HashMap<>();
        buildNodeVocabulary(root, node2Voc);

        // Build Node->nodeSize map
        Map<Node, Integer> node2Size = new HashMap<>();
        buildNode2Size(root, node2Size);

        // Build Set<Character> -> List<Node> map
        Map<Set<Character>, List<Node>> voc2Nodes = new HashMap<>();
        node2Voc = node2Voc.entrySet().stream()
//                .filter(nodeSetEntry -> !nodeSetEntry.getValue().isEmpty())
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue()
                ));

        for (Node node : node2Voc.keySet()) {
            Set<Character> value = node2Voc.get(node);

            if (!voc2Nodes.containsKey(value)) {
                voc2Nodes.put(value, new ArrayList<>());
            }
            voc2Nodes.get(value).add(node);
        }

        // Found equivalent nodes
        voc2Nodes = voc2Nodes.entrySet().stream()
                .filter(entry -> entry.getValue().size() >= 2)
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue().stream()
                                .sorted((o1, o2) -> node2Size.get(o2) - node2Size.get(o1))
                                .limit(2)
                                .collect(Collectors.toList())
                ));
        // Only absent sets with at least 2 related nodes remain

        if (voc2Nodes.isEmpty()) {
            return null;
        }

        Map<Set<Character>, List<Node>> map = voc2Nodes.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().stream().mapToInt(node2Size::get).sum() - o1.getValue().stream().mapToInt(node2Size::get).sum())
                .limit(1)
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue()
                ));

        return (List<Node>) map.values().toArray()[0];
    }

    private Set<Character> buildNodeVocabulary(Node node, Map<Node, Set<Character>> node2Voc) {
        if (!node2Voc.containsKey(node)) {
            node2Voc.put(node, new HashSet());
        }
        if (node.left != null) {
            node2Voc.get(node).add(node.left.value);
            node2Voc.get(node).addAll(buildNodeVocabulary(node.left, node2Voc));
        }
        if (node.right != null) {
            node2Voc.get(node).add(node.right.value);
            node2Voc.get(node).addAll(buildNodeVocabulary(node.right, node2Voc));
        }
        return node2Voc.get(node);
    }

    private int buildNode2Size(Node node, Map<Node, Integer> node2Size) {
        if (!node2Size.containsKey(node)) {
            node2Size.put(node, 0);
        }
        if (node.left != null) {
            node2Size.put(node, node2Size.get(node) + 1);
            node2Size.put(node, node2Size.get(node) + buildNode2Size(node.left, node2Size));
        }
        if (node.right != null) {
            node2Size.put(node, node2Size.get(node) + 1);
            node2Size.put(node, node2Size.get(node) + buildNode2Size(node.right, node2Size));
        }
        return node2Size.get(node);
    }
}
