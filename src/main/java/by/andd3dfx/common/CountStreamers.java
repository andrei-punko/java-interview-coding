package by.andd3dfx.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static by.andd3dfx.common.CountStreamers.EventType.START;
import static by.andd3dfx.common.CountStreamers.EventType.STOP;

/**
 * <pre>
 * Ваша задача: посчитать максимальное количество пользователей,
 * одновременно смотревших игровой стрим.
 *
 * Каждый пользователь подключался к стриму в какой-то момент времени t_in,
 * и отключался в момент времени t_out – время измеряется в секундах (от 0 до 10^9).
 * У каждого пользователя это время своё.
 *
 * Вам дан массив (неупорядоченный) из пар (t_in, t_out) – длина массива от 0 до 10^6.
 * Требуется вывести число – максимальное количество пользователей,
 * которые одновременно смотрели стрим.
 *
 * @see <a href="https://youtu.be/uMikT-xpE-w">Video solution</a>
 * </pre>
 */
public class CountStreamers {

    public static int count(int[][] times) {
        var events = new ArrayList<EventItem>();
        for (var time : times) {
            events.add(new EventItem(time[0], START));
            events.add(new EventItem(time[1], STOP));
        }

        Collections.sort(events, Comparator.comparingInt(EventItem::getTime));

        var current = 0;
        var max = 0;
        for (var event : events) {
            current += (event.eventType == EventType.START) ? +1 : -1;
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

    public enum EventType {
        START, STOP
    }

    @Data
    @AllArgsConstructor
    public static class EventItem {
        private int time;
        private EventType eventType;
    }
}
