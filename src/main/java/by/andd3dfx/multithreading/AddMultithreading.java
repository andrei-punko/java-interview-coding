package by.andd3dfx.multithreading;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

/**
 * <pre>
 * Модифицировать данный код, чтобы добавить многопоточность при выполнении запросов в systemA и systemB.
 *
 * public class Aggregator {
 *     private SystemA systemA;
 *     private SystemB systemB;
 *
 *     Object doRequest() { // 10 sec
 *         Object responseA = systemA.doRequest(); // 5 sec
 *         Object responseB = systemB.doRequest(); // 5 sec
 *         return aggregate(responseA, responseB);
 *     }
 *
 *     Object aggregate(Object responseA, Object responseB) {
 *         // ...
 *         return data;
 *     }
 * }
 *
 * class SystemA {
 *     Object doRequest() {
 *         // ...
 *         return data;
 *     }
 * }
 *
 * class SystemB {
 *     Object doRequest() {
 *         // ...
 *         return data;
 *     }
 * }
 * </pre>
 *
 * @see <a href="https://youtu.be/3IGsZy0uTSk">Video solution</a>
 */
public class AddMultithreading {

    public static class Aggregator {
        private SystemA systemA;
        private SystemB systemB;

        private SystemA[] aSystems;
        private SystemB[] bSystems;

        public Aggregator(SystemA systemA, SystemB systemB) {
            this.systemA = systemA;
            this.systemB = systemB;
        }

        public Aggregator(SystemA[] aSystems, SystemB[] bSystems) {
            this.aSystems = aSystems;
            this.bSystems = bSystems;
        }

        public Object doRequestOld() {
            Object responseA = systemA.doRequest();
            Object responseB = systemB.doRequest();
            return aggregate(responseA, responseB);
        }

        @SneakyThrows
        public Object doRequest() {
            var futureA = CompletableFuture.supplyAsync(() -> systemA.doRequest());
            var futureB = CompletableFuture.supplyAsync(() -> systemB.doRequest());

            return futureA
                    .thenCombine(futureB, Aggregator::aggregate)
                    .get();
        }

        @SneakyThrows
        public Object doRequest10() {
            var futures = new ArrayList<CompletableFuture<Object>>();
            for (var system : aSystems) {
                futures.add(CompletableFuture.supplyAsync(() -> system.doRequest()));
            }
            for (var system : bSystems) {
                futures.add(CompletableFuture.supplyAsync(() -> system.doRequest()));
            }

            var resultFuture = CompletableFuture.supplyAsync(() -> "");
            for (var future : futures) {
                resultFuture = resultFuture.thenCombine(
                        future, Aggregator::aggregate
                );
            }
            return resultFuture.get();
        }

        private static String aggregate(Object responseA, Object responseB) {
            return "%s%s".formatted(responseA, responseB);
        }
    }

    @AllArgsConstructor
    public static class SystemA {

        private String data;

        @SneakyThrows
        Object doRequest() {
            Thread.sleep(1_000);
            return data;
        }
    }

    @AllArgsConstructor
    public static class SystemB {
        private String data;

        @SneakyThrows
        Object doRequest() {
            Thread.sleep(1_000);
            return data;
        }
    }
}
