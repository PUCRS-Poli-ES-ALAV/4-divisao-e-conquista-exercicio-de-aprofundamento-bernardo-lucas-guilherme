package br.pucrs;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        App app = new App();

        List<Integer> list = new ArrayList();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        List<Integer> expectedList = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        assertEquals(expectedList, app.mergeSort(list));
    }
}
