package io.github.resilience4j.core;

import io.github.resilience4j.core.functions.Either;

import java.util.function.BiFunction;

/**
 * An IntervalBiFunction which can be used to calculate the wait interval. The input parameters of the bi
 * function is the number of attempts (attempt) and either result or exception, the output parameter is the wait interval in
 * milliseconds. The attempt parameter starts at 1 and increases with every further attempt.
 *
 *
 * <p>
 *     IntervalBiFunction 能够根据异常类型和重试次数灵活地调整间隔时间。
 * </p>
 */
@FunctionalInterface
public interface IntervalBiFunction<T> extends BiFunction<Integer, Either<Throwable, T>, Long> {

    static <T> IntervalBiFunction<T> ofIntervalFunction(IntervalFunction f) {
        return (attempt, either) -> f.apply(attempt);
    }
}
