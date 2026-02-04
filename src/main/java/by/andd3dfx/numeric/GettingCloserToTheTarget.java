package by.andd3dfx.numeric;

import lombok.Builder;

/**
 * <pre>
 * <a href="https://w.acmp.ru/?main=task&id_task=492">Task description</a>
 *
 *  Вы являетесь одним из разработчиков программного обеспечения боевой информационной системы для ракетного крейсера
 *  нового поколения РК-2000. Один из компонентов этой системы отвечает за решение задач тактического маневрирования.
 *  В настоящее время вы занимаетесь решением задачи о сближении с целью.
 *
 * Заданы координаты x0 и y0 цели в начальный момент времени, а также вектор (Vx; Vy) ее скорости. Считается, что
 * цель движется равномерно и прямолинейно. В начальный момент времени РК-2000 находится в начале координат.
 * Его максимальная скорость равна V.
 *
 * Необходимо выяснить, может ли РК-2000 через заданное время t оказаться ровно на заданном расстоянии d от цели.
 * Для простоты считайте, что РК-2000 может мгновенно изменять свою скорость.
 * </pre>
 *
 * @see <a href="https://youtu.be/OXpju4Yzmo0">Video solution</a>
 */
public class GettingCloserToTheTarget {

    public static boolean isPossibleToReachTheTarget(Condition condition) {
        var x0 = condition.x0;
        var y0 = condition.y0;
        var vx = condition.vx;
        var vy = condition.vy;
        var vRocket = condition.vRocket;
        var t = condition.t;
        var distance = condition.distance;
        return Math.pow(vRocket * t + distance, 2) >= Math.pow(x0 + vx * t, 2) + Math.pow(y0 + vy * t, 2);
    }

    @Builder
    public record Condition(double x0, double y0, double vx, double vy,
                            double vRocket,
                            double t, double distance
    ) {

    }
}
