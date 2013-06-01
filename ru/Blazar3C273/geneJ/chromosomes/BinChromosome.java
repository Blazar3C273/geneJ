package ru.Blazar3C273.geneJ.chromosomes;

import java.util.ArrayList;
import java.util.Random;

import ru.Blazar3C273.geneJ.Chromosome;
import ru.Blazar3C273.geneJ.FitnessFunction;

/**
 * @author Stepanenko Anatoliy
 * Lab1EvM&GA
 * 11:25:21
 * 04.04.2013
 * TODO
 */

/**
 * 
 */
public class BinChromosome extends Chromosome implements Comparable<BinChromosome> {
	
	/**
	 * @param chromosomeSize
	 * @param random Random value generator
	 */
	public BinChromosome(int chromosomeSize,Random random) {
		super(chromosomeSize, random);
		setGenom(new ArrayList<Gen<?>>());
		for (int i = 0; i < chromosomeSize; i++) {
			Gen<Boolean> tmp = new Gen<Boolean>(){};
			tmp.setValue(random.nextBoolean());
			getGenom().add(tmp);
		}
	}
	public BinChromosome() {
	super();
	}
	@Override
	public ArrayList<Chromosome> generateSomeChromosomes(int paramQuantity,int chromosomValue,
			Random paramRandom, Chromosome sample) {
		ArrayList<Chromosome> returnValue = new ArrayList<Chromosome>(paramQuantity);
		for (int i = 0; i < paramQuantity; i++) {
			returnValue.add(new BinChromosome(chromosomValue,paramRandom));
		}
		return returnValue;
	}
	
	@Override
	public int compareTo(BinChromosome in) {
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
	// TODO Auto-generated method stub
	return fitnessValue;
}
	

}
