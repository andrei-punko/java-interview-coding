package by.andd3dfx.interview.wf;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class PathTest {

  @Test
  public void moveToParentDir() {
    Path path = new Path("/a/b/c/d");
    path.cd("../x");
    assertThat("Unexpected path", path.getPath(), is("/a/b/c/x"));
  }

  @Test
  public void moveToParentDir2() {
    Path path = new Path("/a/b/c/d");
    path.cd("../../x/d");
    assertThat("Unexpected path", path.getPath(), is("/a/b/x/d"));
  }

  @Test
  public void moveToPathFromRoot() {
    Path path = new Path("/a/b/c/d");
    path.cd("/f/g/h");
    assertThat("Unexpected path", path.getPath(), is("/f/g/h"));
  }

  @Test
  public void moveToRootDirectly() {
    Path path = new Path("/a/b/c/d");
    path.cd("/");
    assertThat("Unexpected path", path.getPath(), is("/"));
  }

  @Test
  public void moveFromCurrentDir() {
    Path path = new Path("/a/b/c/d");
    path.cd("./f/g");
    assertThat("Unexpected path", path.getPath(), is("/a/b/c/d/f/g"));
  }

  @Test
  public void moveFromCurrentDir2() {
    Path path = new Path("/a/b/c/d");
    path.cd("f/g");
    assertThat("Unexpected path", path.getPath(), is("/a/b/c/d/f/g"));
  }
}
