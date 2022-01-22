package tests.com;


import main.com.lists.AList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class AListTest {
    AList<Integer> cut = new AList<>(new Integer[] {13, 26, 18, 24, 45, 24});

    @Test
    void sizeTest() {
        int expected = 6;
        int actual = cut.size();
        Assertions.assertEquals(expected, actual);
    }

    static List<Arguments> getTestArgs(){
        return List.of(
                Arguments.arguments(3, 24),
                Arguments.arguments(0, 13)
        );
    }

    @ParameterizedTest
    @MethodSource("getTestArgs")
    void getTest(int index, int expected) {
        Object actual = cut.get(index);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void add1Test() {
        boolean expected = true;
        boolean actual = cut.add(33);
        Assertions.assertEquals(expected, actual);
    }

    static List<Arguments> add2TestArgs(){
        return List.of(
                Arguments.arguments(3, 77, true),
                Arguments.arguments(10, 18, true)
        );
    }

    @ParameterizedTest
    @MethodSource("add2TestArgs")
    void add2Test(int index, int value, boolean expected) {
        boolean actual = cut.add(index, value);
        Assertions.assertEquals(expected, actual);
    }

    static List<Arguments> removeTestArgs(){
        return List.of(
                Arguments.arguments(13, true),
                Arguments.arguments(109, false)
        );
    }

    @ParameterizedTest
    @MethodSource("removeTestArgs")
    void removeTest(int number, boolean expected) {
        boolean actual = cut.remove(number);
        Assertions.assertEquals(expected, actual);
    }

    static List<Arguments> removeByIndexTestArgs(){
        return List.of(
                Arguments.arguments(3, 3),
                Arguments.arguments(109, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("removeByIndexTestArgs")
    void removeByIndexTest(int index,  int expected) {
        int actual = cut.removeByIndex(index);
        Assertions.assertEquals(expected, actual);
    }

    static List<Arguments> containsTestArgs(){
        return List.of(
                Arguments.arguments(45, true),
                Arguments.arguments(888, false)
        );
    }

    @ParameterizedTest
    @MethodSource("containsTestArgs")
    void containsTest(int number, boolean expected) {
        boolean actual = cut.contains(number);
        Assertions.assertEquals(expected, actual);
    }

    static List<Arguments> setTestArgs(){
        return List.of(
                Arguments.arguments(3, 33, true),
                Arguments.arguments(888, 777, false)
        );
    }

    @ParameterizedTest
    @MethodSource("setTestArgs")
    void setTest(int index, int value, boolean expected) {
        boolean actual = cut.set(index, value);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void toArrayTest() {
        Integer[] expected = new Integer[] {13, 26, 18, 24, 45, 24};
        Integer[] actual = cut.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    static List<Arguments> removeAllTestArgs(){
        return List.of(
                Arguments.arguments(new Integer[] {13, 18, 888}, true),
                Arguments.arguments(new Integer[] {13, 26, 18, 24, 45, 24}, true),
                Arguments.arguments(new Integer[] {4, 90}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("removeAllTestArgs")
    void removeAllTest(Integer[] arr, boolean expected) {
        boolean actual = cut.removeAll(arr);
        Assertions.assertEquals(expected, actual);
    }
}
