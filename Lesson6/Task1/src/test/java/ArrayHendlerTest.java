import com.sun.jdi.connect.Connector;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayHendlerTest {

    private final ArrayHendler arrayHendler = new ArrayHendler();

    @ParameterizedTest
    @MethodSource("dataValues")
    void getArray(int[] originalArray, int[] expectedArray){
        int[] actualArray = arrayHendler.getArray(originalArray);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    private static Stream<Arguments> dataValues(){
        List<Arguments> arguments = new ArrayList<>() {{
           add(Arguments.arguments(new int[]{1, 2, 3, 4, 5}, new int[]{5}));
           add(Arguments.arguments(new int[]{1, 2, 3, 4}, new int[]{}));
           add(Arguments.arguments(new int[]{1, 2, 3, 4, 3, 2, 7}, new int[]{3, 2, 7}));
           add(Arguments.arguments(new int[]{1, 4, 3, 1, 5}, new int[]{3, 1, 5}));
        }};
        return arguments.stream();
    }


    @Test
    void getArrayExaption() {
        int[] originalArray = {2, 2, 2};
        Assertions.assertThrows(RuntimeException.class, () -> arrayHendler.getArray(originalArray));
    }

    @ParameterizedTest
    @MethodSource("dataValuesCheckArray")
    void checkArray(int[] array, boolean expectedResult){
        boolean actualResult = arrayHendler.checkArray(array);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> dataValuesCheckArray() {
        List<Arguments> arguments = new ArrayList<>() {{
            add(Arguments.arguments(new int[]{1, 1, 1, 4, 4}, true));
            add(Arguments.arguments(new int[]{4, 4, 4, 4}, false));
            add(Arguments.arguments(new int[]{1, 2, 3, 4, 3, 2, 7}, false));
            add(Arguments.arguments(new int[]{1, 1, 1, 1, 1}, false));
        }};
        return arguments.stream();
    }
}