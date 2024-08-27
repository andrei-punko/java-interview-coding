package by.andd3dfx.core.predict;

/**
 * <pre>
 * Что выведется в консоль при создании объекта класса B?
 *
 *     public static class A {
 *         private int a = 1;
 *         public A() {
 *             System.out.println(getA());
 *         }
 *
 *         public int getA() {
 *             return a;
 *         }
 *     }
 *
 *     public static class B extends A {
 *         private int a = 2;
 *         public B() {
 *             System.out.println(getA());
 *         }
 *
 *         public int getA() {
 *             return a;
 *         }
 *     }
 * </pre>
 */
public class Inheritance {

    public static void main(String[] args) {
        var b = new B();

        /**
         * Выведется: 0, потом 2, т.к. при вызове конструктора класса A вызовется (из-за полиморфизма)
         * метод getA() класса B, который выведет значение переменной a, к тому моменту еще неинициализированной.
         */
    }

    public static class A {
        private int a = 1;
        public A() {
            System.out.println(getA());
        }

        public int getA() {
            return a;
        }
    }

    public static class B extends A {
        private int a = 2;
        public B() {
            System.out.println(getA());
        }

        public int getA() {
            return a;
        }
    }
}
