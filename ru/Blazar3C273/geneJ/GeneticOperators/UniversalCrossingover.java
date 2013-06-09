/**
 * @author Stepanenko Anatoliy
 * geneJ
 * 21:27:51
 * 08.06.2013
 * TODO
 */
package ru.Blazar3C273.geneJ.GeneticOperators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import ru.Blazar3C273.geneJ.GeneticOperator;
import ru.Blazar3C273.geneJ.GeneticOperatorParams;
import ru.Blazar3C273.geneJ.Population;
import ru.Blazar3C273.geneJ.Exeptions.OperatorNotInitializedException;
import ru.Blazar3C273.geneJ.Exeptions.WrongArgumentsExeption;
import ru.Blazar3C273.geneJ.chromosomes.Gen;

/**
 * 
 */
public class UniversalCrossingover extends GeneticOperator {

	public class UniversalCrossingoverParams1 extends GeneticOperatorParams {
		public ArrayList<Boolean> binaryMask;
		public SelectionRule selectRule;

		public UniversalCrossingoverParams1(Random rnd,
				ArrayList<Boolean> _binaryMask, SelectionRule _selectionRule) {
			super(rnd);
			this.binaryMask = _binaryMask;
			this.selectRule = _selectionRule;
		}
	}

	public class UniversalCrossingoverParams2 extends GeneticOperatorParams {
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
	public Population executeOperator(Population paramInput) throws OperatorNotInitializedException {
		if (!isInitilised) {
		 throw new OperatorNotInitializedException();	
		}
		for (ParentsPairIterator pairIterator = this.paretsPairSelectRule.iterator(parpmInput); pairIterator
				.hasNext();) {
			ArrayList<Gen<?>> localType = (ArrayList<Gen<?>>) pairIterator.next();
			
		}
		ArrayList<Gen<?>> child1,child2;
		
		return null;
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
		} else if(param.getClass() == UniversalCrossingoverParams2.class) {
			UniversalCrossingoverParams2 param2 = (UniversalCrossingoverParams2) param;
			rnd = param2.getRandom();
			paretsPairSelectRule =  param2.selectRule;
		}else{
			throw new WrongArgumentsExeption("Current class is "+ param.getClass().getName() 
				+". Need a valid class UniversalCrossingoverParams1 || UniversalCrossingoverParams2.");
		}
		isInitilised = true;
		return this;
	}
}
