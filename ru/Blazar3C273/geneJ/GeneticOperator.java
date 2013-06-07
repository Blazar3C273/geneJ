package ru.Blazar3C273.geneJ;

import ru.Blazar3C273.geneJ.Exeptions.WrongArgumentsExeption;


/**
 * 
 */
public interface GeneticOperator {
	
abstract public	Population executeOperator(Population input);
abstract public GeneticOperator initialize(Object ...params) throws WrongArgumentsExeption;
}
