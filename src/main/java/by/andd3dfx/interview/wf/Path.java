package by.andd3dfx.interview.wf;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Write a function that provides change directory (cd) function for an abstract file system.
Notes:
    Root path is '/'.
    Path separator is '/'.
    Parent directory is addressable as "..".
    Directory names consist only of English alphabet letters (A-Z and a-z).
    The function should support both relative and absolute paths.
    The function will not be passed any invalid paths.
    Do not use built-in path-related functions.

For example:
    Path path = new Path("/a/b/c/d");
    path.cd('../x');
    System.out.println(path.getPath());

    should display '/a/b/c/x'.
 */
public class Path {

  private String path;
  private Deque<String> deque = new ArrayDeque<>();

  public Path(String path) {
    this.path = path;

    String[] directories = path.split("/");
    for (String directory : directories) {
      deque.addLast(directory);
    }
  }

  public String getPath() {
    return path;
  }

  public void cd(String newPath) {
    path = process(path, newPath);
  }

  private String process(String path, String newPath) {
    if (newPath.startsWith("/")) {
      return newPath;
    }

    if (newPath.startsWith("./")) {
      return path + newPath.substring(1);
    }

    String[] directories = newPath.split("/");
    for (String directory : directories) {
      if (directory.equals("..")) {
        deque.removeLast();
      } else {
        deque.addLast(directory);
      }
    }
    return String.join("/", deque);
  }

  public static void main(String[] args) {
    Path path = new Path("/a/b/c/d");
    path.cd("../x");
    System.out.println(path.getPath());
  }
}
