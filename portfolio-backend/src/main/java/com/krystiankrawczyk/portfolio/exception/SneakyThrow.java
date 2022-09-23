package com.krystiankrawczyk.portfolio.exception;

public class SneakyThrow {

    public static RuntimeException throwSneaky(Throwable throwable) {
        if (throwable == null) throw new NullPointerException("throwable");
        return SneakyThrow.sneakyThrow(throwable);
    }

    private static <E extends Throwable> E sneakyThrow(Throwable throwable) throws E {
        throw (E) throwable;
    }
}
