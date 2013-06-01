package geneJ;
/**
 * @author Stepanenko Anatoliy
 * Lab1EvM&GA
 * 19:33:49
 * 10.05.2013
 * TODO
 */

/**
 * 
 */
public interface GeneticOperator {
	
abstract public	Population executeOperator(Population input);
abstract public GeneticOperator initialize(Object ...params);
}
