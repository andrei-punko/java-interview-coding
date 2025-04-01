package by.andd3dfx.tree.equivalent;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.ToIntFunction;

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
 */
public class EquivalentTrees {

    public List<Node> findEquivalentSubtrees(Node root) {
        if (root == null) {
            return null;
        }

        // Fill `vocabulary` field of nodes
        fillNodeVocabulary(root);

        // Build Set<Character> -> List<Node> map
        Map<Set<Character>, List<Node>> voc2Nodes = new HashMap<>();

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

            if (!voc2Nodes.containsKey(vocabulary)) {
                voc2Nodes.put(vocabulary, new ArrayList<>());
            }
            voc2Nodes.get(vocabulary).add(current);
        }

        return voc2Nodes.values().stream()
                .filter(nodesList -> nodesList.size() >= 2)
                .sorted((o1, o2) -> o2.stream().mapToInt(nodeToIntFunction()).sum() - o1.stream().mapToInt(nodeToIntFunction()).sum())
                .limit(1)
                .findFirst().orElse(null);
    }

    private static ToIntFunction<Node> nodeToIntFunction() {
        return node -> node.vocabulary.size();
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
}
