package by.andd3dfx.tree.equivalent;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 * Дано бинарное дерево с выделенным корнем, в каждой вершине которого записано по одной букве A-Z.
 * Две вершины считаются эквивалентными, если поддеревья этих вершин содержат одинаковое множество
 * (т.е. без учета частот) букв.
 * Нужно найти две эквивалентные вершины с максимальным суммарным размером поддеревьев.
 *
 * public class Node {
 *     char value;  // [A-Z]
 *     Node left;
 *     Node right;
 * }
 * </pre>
 *
 * @see <a href="https://youtu.be/Ued_W2Xs7ng">Video solution</a>
 */
public class EquivalentNodesOfTree {

    public List<Node> findEquivalentNodes(Node root) {
        if (root == null) {
            return null;
        }

        // Fill `vocabulary` field of tree nodes
        fillNodeVocabulary(root);
        // Fill `subtreeSize` field of tree nodes
        fillSubTreeSize(root);

        // Build Set<Character> -> List<Node> map
        Map<Set<Character>, List<Node>> voc2NodesMap = new HashMap<>();

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var current = queue.poll();
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }

            Set<Character> vocabulary = current.vocabulary;
            if (!voc2NodesMap.containsKey(vocabulary)) {
                voc2NodesMap.put(vocabulary, new ArrayList<>());
            }
            voc2NodesMap.get(vocabulary).add(current);
        }

        return voc2NodesMap.values().stream()
                .filter(nodes -> nodes.size() >= 2)
                .map(nodes -> nodes.stream().sorted(this::compare).limit(2).toList())
                .min(this::compare)
                .orElse(null);
    }

    private int compare(Node n1, Node n2) {
        return n2.subtreeSize - n1.subtreeSize;
    }

    private int compare(List<Node> list1, List<Node> list2) {
        return list2.stream().mapToInt(node -> node.subtreeSize).sum() - list1.stream().mapToInt(node -> node.subtreeSize).sum();
    }

    private Set<Character> fillNodeVocabulary(Node node) {
        if (node.left != null) {
            node.vocabulary.add(node.left.value);
            node.vocabulary.addAll(fillNodeVocabulary(node.left));
        }
        if (node.right != null) {
            node.vocabulary.add(node.right.value);
            node.vocabulary.addAll(fillNodeVocabulary(node.right));
        }
        return node.vocabulary;
    }

    private int fillSubTreeSize(Node node) {
        if (node.left != null) {
            node.subtreeSize += 1 + fillSubTreeSize(node.left);
        }
        if (node.right != null) {
            node.subtreeSize += 1 + fillSubTreeSize(node.right);
        }
        return node.subtreeSize;
    }
}
