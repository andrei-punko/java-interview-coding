package by.andd3dfx.tree;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

/**
 * Предложить структуру данных, чтобы хранить в ней структуру папок и файлов.
 * <p>
 * Описать алгоритм, который измерит размер содержимого определенной папки.
 */
public class FileSystemTree {

    @Builder
    @AllArgsConstructor
    public static class Node {
        private List<Node> children;
        private NodeType type;
        private Long size;

        public enum NodeType {
            FILE, FOLDER
        }

        public long calcSize() {
            return calcSize(this);
        }

        private long calcSize(Node node) {
            if (node.type == Node.NodeType.FILE) {
                return node.size;
            }

            long result = 0;
            for (var child : node.children) {
                result += calcSize(child);
            }
            return result;
        }
    }
}
