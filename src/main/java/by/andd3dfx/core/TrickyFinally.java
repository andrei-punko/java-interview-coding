package by.andd3dfx.core;

/**
 * Какую из трёх исключительных ситуаций мы получим на выходе в данном блоке кода? Почему?
 * <pre>
 * try {
 *     throw new Exception1();
 * } catch (Exception ex) {
 *     throw new Exception2();
 * } finally {
 *     throw new Exception3();
 * }
 * </pre>
 * <p>
 * Что будет возвращено в данном блоке кода ниже? Почему?
 * <pre>
 * try {
 *     return 1;
 * } catch(Exception e) {
 *     return 2;
 * } finally {
 *     return 3;
 * }
 * </pre>
 *
 * @see <a href="https://youtu.be/Man9zRalhPs">Video solution</a>
 */
public class TrickyFinally {

    public void case1() throws Exception3 {
        try {
            throw new Exception1();
        } catch (Exception ex) {
            throw new Exception2();
        } finally {
            throw new Exception3();
        }
    }

    public int case2() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

    public class Exception1 extends Exception {
    }

    public class Exception2 extends Exception {
    }

    public class Exception3 extends Exception {
    }
}
