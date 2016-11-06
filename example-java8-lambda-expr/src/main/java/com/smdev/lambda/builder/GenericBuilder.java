package com.smdev.lambda.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Generic builder of different types
 * 
 * @author Ireth
 */
public class GenericBuilder<T> {

	public static <T> GenericBuilder<T> of(Supplier<T> instantiator) {
		return new GenericBuilder<>(instantiator);
	}

	private List<Consumer<T>> instanceModifiers = new ArrayList<>();

	private final Supplier<T> instantiator;

	public GenericBuilder(Supplier<T> instantiator) {
		this.instantiator = instantiator;
	}

	public T build() {
		T value = this.instantiator.get();
		this.instanceModifiers.forEach(modifier -> modifier.accept(value));
		this.instanceModifiers.clear();
		return value;
	}

	public <U> GenericBuilder<T> with(BiConsumer<T, U> consumer, U value) {
		Consumer<T> c = instance -> consumer.accept(instance, value);
		this.instanceModifiers.add(c);
		return this;
	}
}
