/**
 * @author Stepanenko Anatoliy
 * geneJ
 * 1:48:13
 * 09.06.2013
 * TODO
 */
package ru.Blazar3C273.geneJ.GeneticOperators;

import java.util.Random;

import ru.Blazar3C273.geneJ.Population;

/**
 * 
 */
public interface SelectionRule {
	public abstract ParentsPairIterator iterator(Population _population, Random _rnd); 
}
