import java.util.ArrayList;
import java.util.Random;

import ru.Blazar3C273.geneJ.Chromosome;
import ru.Blazar3C273.geneJ.GeneticOperator;
import ru.Blazar3C273.geneJ.Population;
import ru.Blazar3C273.geneJ.PopulationFactory;
import ru.Blazar3C273.geneJ.Chromosomes.BinChromosome;
import ru.Blazar3C273.geneJ.Chromosomes.Gen;
import ru.Blazar3C273.geneJ.Chromosomes.IntChromosome;
import ru.Blazar3C273.geneJ.Exeptions.OperatorNotInitializedException;
import ru.Blazar3C273.geneJ.Exeptions.WrongArgumentsExeption;
import ru.Blazar3C273.geneJ.GeneticOperators.NPointsCrossingover;
import ru.Blazar3C273.geneJ.GeneticOperators.ParentsPairIterator;
import ru.Blazar3C273.geneJ.GeneticOperators.SelectionRule;
import ru.Blazar3C273.geneJ.GeneticOperators.UniversalCrossingover;
import ru.Blazar3C273.geneJ.GeneticOperators.UniversalCrossingover.UniversalCrossingoverParams1;
import ru.Blazar3C273.geneJ.GeneticOperators.UniversalCrossingover.UniversalCrossingoverParams2;

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

	private static Integer QUANTITY_OF_CROSSINGOVER_POINTS = 1;

	/**
 * @param args
 */
public static void main(String[] args) {
	Random random = new Random();
	/*
	 * 1т 2т 3т унив
	 */

	ArrayList<Chromosome> parentChomosomes = new BinChromosome()
			.generateSomeChromosomes(4, 10, random, new BinChromosome());
	Population population = PopulationFactory
			.generatePopulationByBlanketMethod(parentChomosomes);
	System.out.println(population);
	GeneticOperator operator;
	try {

		operator = new NPointsCrossingover()
				.initialize(new NPointsCrossingover.NRandomPointsStrategy(
						random, QUANTITY_OF_CROSSINGOVER_POINTS));
		System.out.println(operator.executeOperator(population));

		QUANTITY_OF_CROSSINGOVER_POINTS = 2;
		parentChomosomes = new BinChromosome().generateSomeChromosomes(
					4,10, random, new BinChromosome());
		population = PopulationFactory
				.generatePopulationByBlanketMethod(parentChomosomes);
		operator = new NPointsCrossingover()
				.initialize(new NPointsCrossingover.NRandomPointsStrategy(
						random, QUANTITY_OF_CROSSINGOVER_POINTS));
		System.out.println(population);
		System.out.println(operator.executeOperator(population));

		QUANTITY_OF_CROSSINGOVER_POINTS = 3;
		parentChomosomes = new BinChromosome().generateSomeChromosomes(4,
				10, random, new BinChromosome());
		population = PopulationFactory
				.generatePopulationByBlanketMethod(parentChomosomes);
		operator = new NPointsCrossingover()
				.initialize(new NPointsCrossingover.NRandomPointsStrategy(
						random, QUANTITY_OF_CROSSINGOVER_POINTS));
		operator = new NPointsCrossingover()
				.initialize(new NPointsCrossingover.NRandomPointsStrategy(
						random, QUANTITY_OF_CROSSINGOVER_POINTS));
		System.out.println(population);
		System.out.println(operator.executeOperator(population));

		parentChomosomes = new BinChromosome().generateSomeChromosomes(4,
				10, random, new BinChromosome());
		population = PopulationFactory
				.generatePopulationByBlanketMethod(parentChomosomes);

		ArrayList<Boolean> _binaryMask = new ArrayList<Boolean>();
		_binaryMask.add(true);
		_binaryMask.add(true);
		_binaryMask.add(true);
		_binaryMask.add(!true);
		_binaryMask.add(false);
		_binaryMask.add(!true);
		_binaryMask.add(!true);
		_binaryMask.add(true);
		_binaryMask.add(true);
		_binaryMask.add(true);
		SelectionRule _selectionRule = new SelectionRule() {
			ParentsPairIterator pairIterator;
			@Override
			public ParentsPairIterator iterator(
					final Population paramInput, final Random rnd) {
				if (pairIterator != null) {
					return pairIterator;
				} else {
					try {
						return pairIterator = new ParentsPairIterator() {
							Population population = (Population) paramInput
									.clone();
							int counter = 0;

							@Override
							public void remove() {
								// TODO Auto-generated method stub
							}

							@Override
							public Chromosome[] next() {
								Chromosome[] pair = new Chromosome[2];
								pair[0] = paramInput.getPersons().get(
										rnd.nextInt(paramInput.getPersons()
												.size()));
								pair[1] = paramInput.getPersons().get(
										rnd.nextInt(paramInput.getPersons()
												.size()));
								counter++;
								return pair;
							}

							@Override
							public boolean hasNext() {
								if (counter >= population.getPersons()
										.size()) {
									return false;
								} else {
									return true;
								}
							}
						};
					} catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						if (pairIterator != null) {
							return pairIterator;
						} else {
							return null;
						}
					}
				}
			}
		};

		UniversalCrossingoverParams1 params = new UniversalCrossingoverParams1(
				random, _binaryMask, _selectionRule);
		operator = new UniversalCrossingover().initialize(params);
		System.out.println(_binaryMask);
		System.out.println(population);
		System.out.println(operator.executeOperator(population));
	} catch (WrongArgumentsExeption e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (OperatorNotInitializedException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
