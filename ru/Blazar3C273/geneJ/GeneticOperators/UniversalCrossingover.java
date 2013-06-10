/**
 * @author Stepanenko Anatoliy
 * geneJ
 * 21:27:51
 * 08.06.2013
 * TODO
 */
package ru.Blazar3C273.geneJ.GeneticOperators;

import java.util.ArrayList;
import java.util.Random;

import ru.Blazar3C273.geneJ.Chromosome;
import ru.Blazar3C273.geneJ.GeneticOperator;
import ru.Blazar3C273.geneJ.GeneticOperatorParams;
import ru.Blazar3C273.geneJ.Population;
import ru.Blazar3C273.geneJ.Exeptions.OperatorNotInitializedException;
import ru.Blazar3C273.geneJ.Exeptions.WrongArgumentsExeption;
import ru.Blazar3C273.geneJ.chromosomes.BinChromosome;
import ru.Blazar3C273.geneJ.chromosomes.Gen;

/**
 * 
 */
public class UniversalCrossingover extends GeneticOperator {

	static public class UniversalCrossingoverParams1 extends
			GeneticOperatorParams {
		public ArrayList<Boolean> binaryMask;
		public SelectionRule selectRule;

		public UniversalCrossingoverParams1(Random rnd,
				ArrayList<Boolean> _binaryMask, SelectionRule _selectionRule) {
			super(rnd);
			this.binaryMask = _binaryMask;
			this.selectRule = _selectionRule;
		}
	}

	static public class UniversalCrossingoverParams2 extends
			GeneticOperatorParams {
		public UniversalCrossingoverParams2(Random _random, SelectionRule _rule) {
			super(_random);
			this.selectRule = _rule;
		}

		public SelectionRule selectRule;
	}

	private Random rnd;
	private ArrayList<Boolean> binaryMask;
	private SelectionRule paretsPairSelectRule;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ru.Blazar3C273.geneJ.GeneticOperator#executeOperator(ru.Blazar3C273.geneJ
	 * .Population)
	 */
	@Override
	public Population executeOperator(Population paramInput)
			throws OperatorNotInitializedException {
		if (!isInitilised) {
			throw new OperatorNotInitializedException();
		}

		for (ParentsPairIterator pairIterator = this.paretsPairSelectRule
				.iterator(paramInput, rnd); pairIterator.hasNext();) {
			Chromosome[] paretns = pairIterator.next();
			BinChromosome childChromosome1 = new BinChromosome(), childChromosome2 = new BinChromosome();
			ArrayList<Gen<Boolean>> parent1 = (ArrayList<Gen<Boolean>>) paretns[0]
					.getGenom().clone(), parent2 = (ArrayList<Gen<Boolean>>) paretns[1]
					.getGenom().clone();
			if (parent2.size() != parent2.size()) {
				// TODO exeption
			}
			ArrayList<Gen<?>> child1 = new ArrayList<Gen<?>>();
			ArrayList<Gen<?>> child2 = new ArrayList<Gen<?>>();
			for (int i = 0; i < parent1.size(); i++) {
				if (this.binaryMask.get(i) ^ parent1.get(i).value) {
					child1.add((Gen<Boolean>) BinChromosome.TRUE_GEN
							.clone());
				} else {
					child1.add((Gen<Boolean>) BinChromosome.FALSE_GEN
							.clone());
				}
				if (this.binaryMask.get(i) ^ parent2.get(i).value) {
					child2.add((Gen<Boolean>) BinChromosome.TRUE_GEN
							.clone());
				} else {
					child2.add((Gen<Boolean>) BinChromosome.TRUE_GEN
							.clone());
				}
			}
			childChromosome1.setGenom(child1);
			childChromosome2.setGenom(child2);
			paramInput.getPersons().add(childChromosome1);
			paramInput.getPersons().add(childChromosome2);
		}

		return paramInput;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.Blazar3C273.geneJ.GeneticOperator#initialize(java.lang.Object[])
	 */
	/**
	 * Стратегии поведения: 1-маска - случайный выбор родителей 2-маска + <?>
	 * extended StrategyOfChoosingParents - выбор родителей на основе правила,
	 * переданного как параметр.
	 * 
	 * */
	@Override
	public GeneticOperator initialize(GeneticOperatorParams param)
			throws WrongArgumentsExeption {
		if (param.getClass() == UniversalCrossingoverParams1.class) {
			UniversalCrossingoverParams1 param1 = (UniversalCrossingoverParams1) param;
			paretsPairSelectRule = param1.selectRule;
			binaryMask = param1.binaryMask;
			rnd = param.getRandom();
		} else if (param.getClass() == UniversalCrossingoverParams2.class) {
			UniversalCrossingoverParams2 param2 = (UniversalCrossingoverParams2) param;
			rnd = param2.getRandom();
			paretsPairSelectRule = param2.selectRule;
		} else {
			throw new WrongArgumentsExeption(
					"Current class is "
							+ param.getClass().getName()
							+ ". Need a valid class UniversalCrossingoverParams1 || UniversalCrossingoverParams2.");
		}
		isInitilised = true;
		return this;
	}
}
