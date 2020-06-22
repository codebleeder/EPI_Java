package Util;

public class TestCase<T, K> {
    public T input;
    public K expected;

    public TestCase(T input, K expected) {
        this.input = input;
        this.expected = expected;
    }
}
