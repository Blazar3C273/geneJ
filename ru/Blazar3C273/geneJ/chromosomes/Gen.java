package ru.Blazar3C273.geneJ.chromosomes;

public abstract class Gen<T> {
	public T value;
	public T getValue() {
		return value;
	}
	public Gen<?> setValue(T inValue) {
	this.value = inValue;
	return this;
	}
	
	@Override
	public String toString() {
		if (value.getClass() == Boolean.class) {
			if ((Boolean)value) {
				return "1";
			}
			return "0";
		} else {
		
		return value.toString();
		}
	}
}
