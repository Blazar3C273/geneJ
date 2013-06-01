/**
 * @author Stepanenko Anatoliy
 * Lab1EvM&GA
 * 17:01:21
 * 18.05.2013
 * TODO
 */
package geneJ;

import java.util.ArrayList;

/**
 * 
 */
public class SympleSumFitness implements FitnessFunction {

	/* (non-Javadoc)
	 * @see geneJ.FitnessFunction#calculateMyFitness(geneJ.Chromosome)
	 */
	@Override
	public Comparable<? extends Comparable<?>> calculateFitness(Fitnessable paramInput) {
		// TODO Auto-generated method stub
		if (paramInput.getClass() != IntChromosome.class) {
			//TODO exeption
		}
		Integer out = new Integer(0);  
		ArrayList<Gen<?>> in = ((Chromosome) paramInput).getGenom();
		for (Gen<?> localGen : in) {
			//TODO
			out+=(Integer)localGen.value;
		}
		return out;
	}

}
