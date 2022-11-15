package by.andd3dfx.common;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Ваша задача: посчитать максимальное количество пользователей,
 * одновременно смотревших игровой стрим.
 * <p>
 * Каждый пользователь подключался к стриму в какой-то момент времени t_in,
 * и отключался в момент времени t_out – время измеряется в секундах (от 0 до 10^9).
 * У каждого пользователя это время своё.
 * <p>
 * Вам дан массив (неупорядоченный) из пар (t_in, t_out) – длина массива от 0 до 10^6.
 * Требуется вывести число – максимальное количество пользователей,
 * которые одновременно смотрели стрим.
 */
public class CountStreamers {

    public static int count(int[][] times) {
        List<EventItem> events = new ArrayList<>();
        for (int[] time : times) {
            events.add(new EventItem(time[0], EventType.START));
            events.add(new EventItem(time[1], EventType.STOP));
        }

        Collections.sort(events, Comparator.comparingInt(eventItem -> eventItem.time));

        int current = 0;
        int max = 0;
        for (EventItem event : events) {
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

    @AllArgsConstructor
    public static class EventItem {
        int time;
        EventType eventType;
    }
}
