import java.util.ArrayList;
import java.util.Random;

import ru.Blazar3C273.geneJ.Chromosome;
import ru.Blazar3C273.geneJ.GeneticOperator;
import ru.Blazar3C273.geneJ.Population;
import ru.Blazar3C273.geneJ.PopulationFactory;
import ru.Blazar3C273.geneJ.Exeptions.WrongArgumentsExeption;
import ru.Blazar3C273.geneJ.GeneticOperators.UniversalCrossingover;
import ru.Blazar3C273.geneJ.chromosomes.Gen;
import ru.Blazar3C273.geneJ.chromosomes.IntChromosome;


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

	private static final Integer[] QUANTITY_OF_CROSSINGOVER_POINTS = new Integer[2];


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
		
	ArrayList<Chromosome> parentChomosomes = new IntChromosome().generateSomeChromosomes(4, 10, random, new IntChromosome());
	QUANTITY_OF_CROSSINGOVER_POINTS[0]=new Integer(3);
	QUANTITY_OF_CROSSINGOVER_POINTS[1]=new Integer(7);
	for (int i = 0; i < parentChomosomes.get(0).getGenom().size(); i++) {
		Gen<Integer> localElement = new Gen<Integer>() {};
		localElement.setValue(new Integer(1));
		parentChomosomes.get(0).getGenom().set(i, localElement);		
		
		localElement = new Gen<Integer>() {};
		localElement.setValue(new Integer(2));
		parentChomosomes.get(1).getGenom().set(i, localElement);		
		
		localElement = new Gen<Integer>() {};
		localElement.setValue(new Integer(3));
		parentChomosomes.get(2).getGenom().set(i, localElement);		
		
		localElement = new Gen<Integer>() {};
		localElement.setValue(new Integer(4));
		parentChomosomes.get(3).getGenom().set(i, localElement);		
	}
	Population population =	PopulationFactory.generatePopulationByBlanketMethod(parentChomosomes);
	//System.out.println();
	System.out.println(population);
	GeneticOperator operator;
	try {
		
		operator = new UniversalCrossingover().initialize(random, QUANTITY_OF_CROSSINGOVER_POINTS);
		System.out.println(operator.executeOperator(population));
		operator.initialize(random,new Integer(3));
		System.out.println(operator.executeOperator(population));
	} catch (WrongArgumentsExeption e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
