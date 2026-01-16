package by.andd3dfx.collections;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SimplifyPathTest {

    @Test
    public void testSimplifyPath() {
        assertThat(SimplifyPath.simplifyPath("/home/")).isEqualTo("/home");
        assertThat(SimplifyPath.simplifyPath("/home//foo/")).isEqualTo("/home/foo");
        assertThat(SimplifyPath.simplifyPath("/home/user/Documents/../Pictures"))
            .isEqualTo("/home/user/Pictures");
        assertThat(SimplifyPath.simplifyPath("/../")).isEqualTo("/");
        assertThat(SimplifyPath.simplifyPath("/.../a/../b/c/../d/./"))
            .isEqualTo("/.../b/d");
    }
}
