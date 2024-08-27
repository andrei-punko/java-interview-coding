package by.andd3dfx.core.predict;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Рассказать свои мысли о данном коде:
 *
 * List<Employee> list = new ArrayList<Employee>();
 * list.add(new Manager(100));
 * list.add(new Manager(200));
 * ((List<Manager>)list).get(1).getBonus();
 * </pre>
 */
public class DangerousCasting {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Manager(100));
        list.add(new Manager(200));
        //((List<Manager>)list).get(1).getBonus();
        var bonus = ((Manager)list.get(0)).getBonus();
        System.out.println(bonus);

        /**
         * Во время выполнения в 4й строке вывалится ClassCastException.
         * Но такой каст бы прошел: ((Manager)list.get(0)).getBonus()
         */
    }

    public static class Employee {
    }

    public static class Manager extends Employee{
        private int bonus;

        public Manager(int bonus) {
            this.bonus = bonus;
        }

        public int getBonus() {
            return bonus;
        }
    }
}
