import java.util.ArrayList;
import java.util.Random;

import geneJ.BinChromosome;
import geneJ.Chromosome;
import geneJ.Crossingover;
import geneJ.GeneticOperator;
import geneJ.Population;
import geneJ.PopulationFactory;

/**
 * @author Stepanenko Anatoliy
 * Lab1EvM&GA
 * 19:31:30
 * 10.05.2013
 * TODO
 */

/**
 * 
 */
public class Lab2 {

	/**
	 * 
	 */
	public Lab2() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random random = new Random();
		
	BinChromosome first = new BinChromosome(5, random), second = new BinChromosome(5, random);
	ArrayList<Chromosome> parentChomosomes = new ArrayList<Chromosome>();
Population population =	PopulationFactory.generatePopulationByShotGunMethod(random,
														new BinChromosome().generateSomeChromosomes(100, 10, random, new BinChromosome()),
														10);
	//System.out.println();
	System.out.println(population);
	GeneticOperator operator = new Crossingover().initialize(random,random);
	System.out.println(operator.executeOperator(population));
	}

}
