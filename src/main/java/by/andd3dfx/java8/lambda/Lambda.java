package by.andd3dfx.java8.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambda {

    public void usualApproach(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
    }

    public void lambda1(List<String> names) {
        Collections.sort(names, (String a, String b) -> {
            return a.compareTo(b);
        });
    }

    public void lambda2(List<String> names) {
        Collections.sort(names, (String a, String b) -> a.compareTo(b));
    }

    public void lambda3(List<String> names) {
        Collections.sort(names, (a, b) -> a.compareTo(b));
    }
}
