package javarush.javarush_Tutorial;
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
