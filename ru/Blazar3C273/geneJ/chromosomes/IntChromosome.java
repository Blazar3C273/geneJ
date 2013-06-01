package ru.Blazar3C273.geneJ.chromosomes;


import java.util.ArrayList;
import java.util.Random;

import ru.Blazar3C273.geneJ.Chromosome;
import ru.Blazar3C273.geneJ.FitnessFunction;

/**
 * @author Stepanenko Anatoliy
 * Lab1EvM&GA
 * 14:46:35
 * 04.04.2013
 * TODO
 */

/**
 * 
 */
public class IntChromosome extends  Chromosome implements Comparable<IntChromosome>  {
	public IntChromosome(int paramChromosomeSize, Random paramRandom) {
		super(paramChromosomeSize, paramRandom);
		setGenom(new ArrayList<Gen<?>>(paramChromosomeSize));
		for (int i = 0; i < paramChromosomeSize; i++) {
			Gen<Integer> tmp = new Gen<Integer>() {
			};
			tmp.setValue(paramRandom.nextInt(1000));
			getGenom().add(tmp);
		}
	}

	public IntChromosome() {
		super();
	}

	@Override
	public ArrayList<Chromosome> generateSomeChromosomes(int paramQuantity,
			int chromosomeValue, Random paramRandom, Chromosome sample) {
		ArrayList<Chromosome> returnValue = new ArrayList<Chromosome>(
				paramQuantity);
		for (int i = 0; i < paramQuantity; i++) {
			returnValue.add(new IntChromosome(chromosomeValue, paramRandom));
		}
		return returnValue;
	}


	@Override
	public int compareTo(IntChromosome in) {
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
