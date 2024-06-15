package by.andd3dfx.stream;

@FunctionalInterface
public interface Converter<F, T> {

    T convert(F from);
}
