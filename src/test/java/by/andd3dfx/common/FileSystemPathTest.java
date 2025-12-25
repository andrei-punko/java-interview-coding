package by.andd3dfx.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FileSystemPathTest {

    @Test
    public void moveToParentDir() {
        FileSystemPath path = new FileSystemPath("/a/b/c/d");
        path.cd("../x");

        assertThat(path.getPath()).isEqualTo("/a/b/c/x");
    }

    @Test
    public void moveToParentDir2() {
        FileSystemPath path = new FileSystemPath("/a/b/c/d");
        path.cd("../../x/d");

        assertThat(path.getPath()).isEqualTo("/a/b/x/d");
    }

    @Test
    public void moveToPathFromRoot() {
        FileSystemPath path = new FileSystemPath("/a/b/c/d");
        path.cd("/f/g/h");

        assertThat(path.getPath()).isEqualTo("/f/g/h");
    }

    @Test
    public void moveToRootDirectly() {
        FileSystemPath path = new FileSystemPath("/a/b/c/d");
        path.cd("/");

        assertThat(path.getPath()).isEqualTo("/");
    }

    @Test
    public void moveFromCurrentDir() {
        FileSystemPath path = new FileSystemPath("/a/b/c/d");
        path.cd("./f/g");

        assertThat(path.getPath()).isEqualTo("/a/b/c/d/f/g");
    }

    @Test
    public void moveFromCurrentDir2() {
        FileSystemPath path = new FileSystemPath("/a/b/c/d");
        path.cd("f/g");

        assertThat(path.getPath()).isEqualTo("/a/b/c/d/f/g");
    }
}
