package ru.Blazar3C273.geneJ;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import ru.Blazar3C273.geneJ.Chromosomes.BinChromosome;
import ru.Blazar3C273.geneJ.Chromosomes.IntChromosome;
import ru.Blazar3C273.geneJ.Chromosomes.VectorChromosome;


/**
 * @author Stepanenko Anatoliy
 * Lab1EvM&GA
 * 12:45:50
 * 21.03.2013
 * TODO
 */

/**
 * 
 */
public class Population {
	private ArrayList<Chromosome> persons ;
	public int generationCount;
	public Comparable<? extends Comparable<?>> maxFitnessFunction;
	public boolean isFitnessChanged;
	public String whyCreate;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random random = new Random();
		ArrayList<Chromosome> tmp = new ArrayList<Chromosome>(3);
		tmp.add(new BinChromosome(3,random));
		tmp.add(new IntChromosome(3,random));
		tmp.add(new VectorChromosome(3,random,new BinChromosome()));
		tmp.toString();
		String str = tmp.get(0).getGenom().get(0).getValue().getClass().getName();
		System.out.println(str+" "+tmp);
	}
	
	public Population() {
		persons = new ArrayList<Chromosome>();
		generationCount = 0;
		isFitnessChanged = true;
		whyCreate = Method.class.getName();
	}

	public Population(int populationValue, Chromosome sample,Random random) {		
		persons = new ArrayList<Chromosome>();
		generationCount = 0;		
		isFitnessChanged = true;
		persons.addAll(sample.generateSomeChromosomes(populationValue, 0, random, sample));
	}

	public Population(ArrayList<Chromosome> paramSolutionSpace) {
		persons = paramSolutionSpace;
		generationCount = 0;
		isFitnessChanged = true;
	}

	public ArrayList<Chromosome> getPersons() {
		return persons;
	}

	public void setPersons(ArrayList<Chromosome> persons) {
		this.persons = persons;
		this.isFitnessChanged = true;
	}

	@Override
	public String toString() {
		return super.toString() + ":\n" + persons.toString()
				+ "\n"; 	
	}
	@Override
	public Object clone() throws CloneNotSupportedException {

		Population ret = new Population();
		ret.persons = new ArrayList<Chromosome>();
		for (Chromosome iterable : persons) {
			ret.persons.add((Chromosome) iterable.clone());
		}
		ret.generationCount = generationCount;
		ret.isFitnessChanged = isFitnessChanged;
		return ret;
	}

	public int getGenerationCount() {
		
		return generationCount;
	}

	public Population calculateFitness(FitnessFunction paramFitnessFunction) {
		for (Fitnessable iter : persons) {
			iter.calculateMyFitness(paramFitnessFunction);
		}
		Arrays.sort(persons.toArray());
		maxFitnessFunction = persons.get(0).getFitness();
		isFitnessChanged = false;
		return this;
	}
	
	
}
