/**
 * @author Stepanenko Anatoliy
 * geneJ
 * 1:48:13
 * 09.06.2013
 * TODO
 */
package ru.Blazar3C273.geneJ.GeneticOperators;

import ru.Blazar3C273.geneJ.Chromosome;
import ru.Blazar3C273.geneJ.Population;

/**
 * 
 */
public interface SelectionRule {
	public abstract Chromosome[] getParetsPair(Population population); 
}
