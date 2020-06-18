package jhm.benchmark;

import org.openjdk.jmh.annotations.Benchmark;

public class StringConnectBenchmark {

    @Benchmark
    public void testStringAdd() {
        print("1" + "2" + "3" + "4" + "5");
    }

    @Benchmark
    public void testStringAdd2() {
        print(new String() + 1 + 2 + 3 + 4 + 5);
    }

    @Benchmark
    public void testStringBuilder() {
        print(new StringBuilder().append(1).append(2).append(3).append(4).append(5).toString());
    }

    @Benchmark
    public void testStringBuffer() {
        print(new StringBuffer().append(1).append(2).append(3).append(4).append(5).toString());
    }

    public void print(String str) {

    }
}
