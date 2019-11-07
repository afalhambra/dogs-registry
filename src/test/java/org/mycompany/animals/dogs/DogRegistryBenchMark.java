package org.mycompany.animals.dogs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mycompany.animals.dogs.domain.DogsBreedEnum;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import javax.xml.bind.JAXBException;
import java.util.concurrent.TimeUnit;

public class DogRegistryBenchMark {

    static AbstractFactory abstractFactory;
    static Registry dogRegistry;

    static  {
        abstractFactory = FactoryProvider.getFactory(AnimalType.DOG);
        try {
            dogRegistry = (Registry) abstractFactory.load("target/classes/dogs.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void launchBenchMark() throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(this.getClass().getName() + ".*")
                .mode(Mode.AverageTime)
                .timeUnit(TimeUnit.MICROSECONDS)
                .warmupTime(TimeValue.microseconds(1))
                .warmupIterations(10)
                .measurementTime(TimeValue.microseconds(1))
                .measurementIterations(2)
                .threads(2)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                //.jvmArgs("-XX:+UnlockDiagnosticVMOptions", "-XX:+PrintInlining")
                //.addProfiler(WinPerfAsmProfiler.class)
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public void benchMarkAverageWeight(){
        dogRegistry.averageWeight(DogsBreedEnum.GREYHOUND);
    }
}
