package by.andd3dfx.tree;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileSystemTreeTest {

    @Test
    public void calcSize() {
        var file1 = buildFile(1);
        var file2 = buildFile(10);
        var folder1 = buildFolder(List.of(file1, file2));
        var folder2 = buildFolder(List.of());

        var file3 = buildFile(50);
        var root = buildFolder(List.of(folder1, folder2, file3));

        assertThat(root.calcSize()).isEqualTo(61);
        assertThat(folder1.calcSize()).isEqualTo(11);
        assertThat(folder2.calcSize()).isEqualTo(0);
    }

    private FileSystemTree.Node buildFolder(List<FileSystemTree.Node> children) {
        return FileSystemTree.Node.builder()
                .type(FileSystemTree.Node.NodeType.FOLDER)
                .children(children)
                .build();
    }

    private FileSystemTree.Node buildFile(long size) {
        return FileSystemTree.Node.builder()
                .type(FileSystemTree.Node.NodeType.FILE)
                .size(size)
                .build();
    }
}
