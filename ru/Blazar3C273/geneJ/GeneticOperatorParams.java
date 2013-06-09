/**
 * @author Stepanenko Anatoliy
 * geneJ
 * 22:34:27
 * 08.06.2013
 * TODO
 */
package ru.Blazar3C273.geneJ;

import java.util.Random;

/**
 * 
 */
public abstract class GeneticOperatorParams {
	protected Random random;
	protected static String className;
	public GeneticOperatorParams(Random paramRnd) {
		random = paramRnd;
	}
	public Random getRandom() {
		return random;
	}
	
}
