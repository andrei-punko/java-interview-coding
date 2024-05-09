package by.andd3dfx.tree;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

/**
 * Предложить структуру данных, чтобы хранить в ней структуру папок и файлов.
 * <p>
 * Описать алгоритм, который измерит размер содержимого определенной папки.
 *
 * @see <a href="https://www.youtube.com/watch?v=j6wr8qCaVeE">Video solution</a>
 */
public class FileSystemTree {

    @Builder
    @AllArgsConstructor
    public static class Node {
        private List<Node> children;
        private NodeType type;
        private Long size;

        public long calcSize() {
            return calcSize(this);
        }

        public static long calcSize(Node node) {
            if (node.type == NodeType.FILE) {
                return node.size;
            }

            var result = 0;
            for (var child : node.children) {
                result += calcSize(child);
            }
            return result;
        }
    }

    public enum NodeType {
        FILE, FOLDER
    }
}
