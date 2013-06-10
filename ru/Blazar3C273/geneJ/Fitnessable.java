package ru.Blazar3C273.geneJ;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Stepanenko Anatoliy
 * Lab1EvM&GA
 * 23:53:31
 * 15.05.2013
 * TODO
 */

/**
 * 
 */
public interface Fitnessable {
Comparable<? extends Comparable<?>> calculateMyFitness(FitnessFunction outside_fitness_function);
Comparable<? extends Comparable<?>> getFitness();
public abstract ArrayList<Chromosome> generateSomeChromosomes(int paramQuantity,
		int paramChromosomValue, Random paramRandom, Chromosome paramSample);
}
