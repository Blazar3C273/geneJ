package ru.Blazar3C273.geneJ;

import ru.Blazar3C273.geneJ.Exeptions.OperatorNotInitializedException;
import ru.Blazar3C273.geneJ.Exeptions.WrongArgumentsExeption;


/**
 * 
 */
public abstract class GeneticOperator {
public Boolean isInitilised = false;
abstract public	Population executeOperator(Population input) throws OperatorNotInitializedException;
abstract public GeneticOperator initialize(GeneticOperatorParams params) throws WrongArgumentsExeption;
}
