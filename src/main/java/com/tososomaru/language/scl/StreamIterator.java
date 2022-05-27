package com.tososomaru.language.scl;

import java.util.Iterator;
import java.util.stream.Stream;
interface StreamIterator {

    static <T> Stream<T> finite(final Iterator<T> iterator) {
        return Stream.generate(iterator::next).takeWhile(v -> iterator.hasNext());
    }
}
