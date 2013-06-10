/**
 * @author Stepanenko Anatoliy
 * Lab1EvM&GA
 * 19:17:43
 * 18.05.2013
 * TODO
 */
package ru.Blazar3C273.geneJ;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import ru.Blazar3C273.geneJ.Exeptions.OperatorNotInitializedException;
import ru.Blazar3C273.geneJ.Exeptions.WrongArgumentsExeption;
import ru.Blazar3C273.geneJ.FitnessFunctions.SympleSumFitness;
import ru.Blazar3C273.geneJ.GeneticOperators.Mutation;
import ru.Blazar3C273.geneJ.GeneticOperators.NPointsCrossingover;
import ru.Blazar3C273.geneJ.GeneticOperators.Reproduction;
import ru.Blazar3C273.geneJ.chromosomes.IntChromosome;

/**
 * 
 */
public class GeneticAlgorithm {

	
	public static void main(String[] args){
		Random random = new Random();
		Population currentPopulation;
		ArrayList<Chromosome> tmp = new IntChromosome().generateSomeChromosomes(50, 10, random,new IntChromosome());
	    currentPopulation = PopulationFactory.generatePopulationByShotGunMethod(random, tmp, 10);
		
	    System.out.println(currentPopulation);
		
		ArrayList<GeneticOperator> operatorArray = new ArrayList<GeneticOperator>();
		
		try {
			operatorArray.add(new Mutation().initialize(new Mutation.MutationParams(random, 0.2)));
			operatorArray.add(new NPointsCrossingover().initialize(new NPointsCrossingover.NRandomPointsStrategy(random, 2)));
			operatorArray.add(new Reproduction().initialize(new Reproduction.ReproductionParpms(random,new SympleSumFitness())));
		} catch (WrongArgumentsExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Population localFindSolution = new GeneticAlgorithm().findSolution(1000000, 10000000, 9000, currentPopulation, operatorArray, random);
		
		System.out.println(localFindSolution + localFindSolution.whyCreate);
		
	}
	/**
	 * 
	 * @param maxIteration
	 *            //TODO wrote description
	 * @param requiredFitnessValue
	 */
	public Population findSolution(
								   int maxIteration,
								   long maxWorkingTime,
								   int requiredFitnessValue,
								   Population startPopulation,
								   ArrayList<GeneticOperator> operatorSequence,
								   Random rand) 
	{
		 Population currentPopulation = startPopulation;
		 Date startTime = Calendar.getInstance().getTime();
		do {
			currentPopulation = executeGeneticOperatorSequence(currentPopulation,operatorSequence);
		} while (currentPopulation.getGenerationCount() <= maxIteration
				&& !isTimesUp(maxWorkingTime,startTime)
				&& !isEnoughtFitnessFunction(requiredFitnessValue,currentPopulation));
		return currentPopulation;
	}

	private static Population executeGeneticOperatorSequence(
			Population paramPopulation, ArrayList<GeneticOperator> operatorArray) {
		
		Population result = paramPopulation;

		for (GeneticOperator geneticOperator : operatorArray) {
			try {
				result = geneticOperator.executeOperator(result);
			} catch (OperatorNotInitializedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	private  boolean isEnoughtFitnessFunction(int requiredValue,Population currentPopulation) {
		if (currentPopulation.maxFitnessFunction == null) {
			currentPopulation.calculateFitness(new SympleSumFitness());
		}
		if ((Integer) currentPopulation.maxFitnessFunction >= requiredValue) {
			currentPopulation.whyCreate = "isEnothFitness";
			return true;
		}
		return false;
	}

	private  boolean isTimesUp(long maxWorkingTime,Date startTime) {
		Date currentTime = Calendar.getInstance().getTime();
		if (currentTime.after(new Date(startTime.getTime() + maxWorkingTime))) {
			return true;
		}
		return false;
	}

}
