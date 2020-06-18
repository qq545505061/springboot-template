package jhm.runner;

import jhm.benchmark.StringConnectBenchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class StringBuilderRunner {

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(StringConnectBenchmark.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(10)
                .mode(Mode.Throughput)
                .forks(3)
                .build();
        new Runner(options).run();
    }
}
