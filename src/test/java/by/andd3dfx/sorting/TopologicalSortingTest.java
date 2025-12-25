package by.andd3dfx.sorting;

import by.andd3dfx.sorting.TopologicalSorting.Dependency;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class TopologicalSortingTest {

    private TopologicalSorting topologicalSorting;

    @Before
    public void setUp() throws Exception {
        topologicalSorting = new TopologicalSorting();
    }

    @Test
    public void сборкаРоботаИзДеталей() {
        var купитьДеталиНаAliexpress = "купитьДеталиНаAliexpress";
        var собратьРобота = "собратьРобота";
        var проверитьРаботуРобота = "проверитьРаботуРобота";
        var tasks = List.of(купитьДеталиНаAliexpress, собратьРобота, проверитьРаботуРобота);

        var dependencies = List.of(
            new Dependency(собратьРобота, List.of(купитьДеталиНаAliexpress)),
            new Dependency(проверитьРаботуРобота, List.of(собратьРобота))
        );

        assertThat(topologicalSorting.sort(tasks, dependencies))
            .isEqualTo(List.of("купитьДеталиНаAliexpress", "собратьРобота", "проверитьРаботуРобота"));
        assertFalse(topologicalSorting.isCyclePresent(tasks, dependencies));
    }

    @Test
    public void устройствоНаРаботу() {
        var естьОпыт = "естьОпыт";
        var естьРабота = "естьРабота";
        var tasks = List.of(естьОпыт, естьРабота);

        var dependencies = List.of(
            new Dependency(естьОпыт, List.of(естьРабота)),
            new Dependency(естьРабота, List.of(естьОпыт))
        );

        assertNull(topologicalSorting.sort(tasks, dependencies));
        assertTrue(topologicalSorting.isCyclePresent(tasks, dependencies));
    }

    @Test
    public void ремонтКухни_byRodStephens() {
        var получениеРазрешения = "получениеРазрешения";
        var покупкаБытовойТехники = "покупкаБытовойТехники";
        var установкаБытовойТехники = "установкаБытовойТехники";
        var сносСтен = "сносСтен";
        var монтажПроводки = "монтажПроводки";
        var установкаГипсокартонныхСтен = "установкаГипсокартонныхСтен";
        var прокладкаТруб = "прокладкаТруб";
        var начальнаяПроверка = "начальнаяПроверка";
        var покраскаСтен = "покраскаСтен";
        var покраскаПотолка = "покраскаПотолка";
        var отделкаПола = "отделкаПола";
        var итоговаяПроверка = "итоговаяПроверка";
        var установкаКафеля = "установкаКафеля";
        var установкаОсвещения = "установкаОсвещения";
        var установкаШкафов = "установкаШкафов";
        var установкаСтолешницы = "установкаСтолешницы";

        var tasks = List.of(получениеРазрешения, покупкаБытовойТехники, установкаБытовойТехники, сносСтен,
            монтажПроводки, установкаГипсокартонныхСтен, прокладкаТруб, начальнаяПроверка, покраскаСтен,
            покраскаПотолка, отделкаПола, итоговаяПроверка, установкаКафеля, установкаОсвещения, установкаШкафов,
            установкаСтолешницы);

        var dependencies = List.of(
            new Dependency(установкаБытовойТехники, List.of(покупкаБытовойТехники, отделкаПола)),
            new Dependency(сносСтен, List.of(получениеРазрешения)),
            new Dependency(монтажПроводки, List.of(сносСтен)),
            new Dependency(установкаГипсокартонныхСтен, List.of(монтажПроводки, прокладкаТруб, начальнаяПроверка)),
            new Dependency(прокладкаТруб, List.of(сносСтен)),
            new Dependency(начальнаяПроверка, List.of(монтажПроводки, прокладкаТруб)),
            new Dependency(покраскаСтен, List.of(установкаГипсокартонныхСтен)),
            new Dependency(покраскаПотолка, List.of(установкаГипсокартонныхСтен)),
            new Dependency(отделкаПола, List.of(покраскаСтен, покраскаПотолка, установкаГипсокартонныхСтен)),
            new Dependency(установкаКафеля, List.of(установкаГипсокартонныхСтен)),
            new Dependency(установкаОсвещения, List.of(покраскаПотолка)),
            new Dependency(установкаШкафов, List.of(отделкаПола)),
            new Dependency(установкаСтолешницы, List.of(установкаШкафов)),
            new Dependency(итоговаяПроверка, List.of(отделкаПола, установкаОсвещения, установкаШкафов, установкаСтолешницы, установкаБытовойТехники))
        );

        assertThat(topologicalSorting.sort(tasks, dependencies)).isEqualTo(List.of(
            "получениеРазрешения",
            "покупкаБытовойТехники",
            "сносСтен",
            "монтажПроводки",
            "прокладкаТруб",
            "начальнаяПроверка",
            "установкаГипсокартонныхСтен",
            "покраскаСтен",
            "покраскаПотолка",
            "отделкаПола",
            "установкаБытовойТехники",
            "установкаКафеля",
            "установкаОсвещения",
            "установкаШкафов",
            "установкаСтолешницы",
            "итоговаяПроверка"
        ));
        assertFalse(topologicalSorting.isCyclePresent(tasks, dependencies));
    }
}
