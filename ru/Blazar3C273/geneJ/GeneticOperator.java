package ru.Blazar3C273.geneJ;


/**
 * 
 */
public interface GeneticOperator {
	
abstract public	Population executeOperator(Population input);
abstract public GeneticOperator initialize(Object ...params);
}
