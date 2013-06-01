/**
 * @author Stepanenko Anatoliy
 * Lab1EvM&GA
 * 5:29:49
 * 30.05.2013
 * TODO
 */
package geneJ;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 */
public class Roulette {
	private ArrayList<Chromosome> chromosomes;
	private ArrayList<Chromosome> chromosomesOnRoulette;
	private int fitnessSumm;
	private Random rnd;
	
	public Roulette(Random paramRnd, Population paramResult) {
		chromosomes = paramResult.getPersons();
		fitnessSumm = 0;
		rnd = paramRnd;
		for (Chromosome iterable : chromosomes) {
			fitnessSumm += (Integer)iterable.getFitness();
		}
		chromosomesOnRoulette = new ArrayList<Chromosome>();
		for (Chromosome iterable : chromosomes) {
			//%
			for (int i = 0; i < (Integer)iterable.getFitness() * 100 / fitnessSumm; i++) {
				chromosomesOnRoulette.add(iterable);
			}
		}
	}

	public Chromosome rotate() {
		
		int localNextInt = rnd.nextInt(chromosomesOnRoulette.size()-1);
		return chromosomesOnRoulette.get(localNextInt);
	}

}
