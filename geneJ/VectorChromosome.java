package geneJ;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Stepanenko Anatoliy
 * Lab1EvM&GA
 * 14:55:06
 * 04.04.2013
 * TODO
 */

/**
 * 
 */
public class VectorChromosome extends Chromosome implements Comparable<VectorChromosome> {

	/**
	 * @param <T>
	 *            Hromosome Constructor
	 * @param paramChromosomeSize
	 * @param paramRandom
	 */
	public VectorChromosome(int paramChromosomeSize, Random paramRandom,
			Chromosome inChromosomeSample) {
		super(paramChromosomeSize, paramRandom);
		setGenom(new ArrayList<Gen<?>>());
		for (int i = 0; i < paramChromosomeSize; i++) {
			Gen<Chromosome> gen = new Gen<Chromosome>(){};
			gen.setValue(inChromosomeSample.generateSomeChromosomes(1, paramChromosomeSize, paramRandom, null).get(0));
			getGenom().add(gen);
		}

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Vector chromosome \n" + super.toString();
	}

	@Override
	public ArrayList<Chromosome> generateSomeChromosomes(int paramQuantity,
			int paramChromosomeValue, Random paramRandom, Chromosome sample) {
		ArrayList<Chromosome> returnValue = new ArrayList<Chromosome>(
				paramQuantity);
		returnValue.addAll(sample.generateSomeChromosomes(paramQuantity,
				paramChromosomeValue, paramRandom, sample));
		return returnValue;

	}

	@Override
	public int compareTo(VectorChromosome in) {
		return fitnessValue.compareTo((Integer) in.getFitness());
	}

	

	public void setFitnessValue(Integer paramFitnessValue) {
		fitnessValue = paramFitnessValue;
	}

	@Override
	public Comparable<? extends Comparable<?>> calculateMyFitness(
			FitnessFunction paramOutside_fitness_function) {
		//TODO if !fitnessIsMeasured { 
		fitnessValue = (Integer) paramOutside_fitness_function.calculateFitness(this);
		fitnessIsMeasured = true;
		return fitnessValue;
	}


Integer fitnessValue;

@Override
public Comparable<? extends Comparable<?>> getFitness() {
	return fitnessValue;
}
}
