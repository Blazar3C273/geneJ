/**
 * @author Stepanenko Anatoliy
 * Lab1EvM&GA
 * 4:30:31
 * 30.05.2013
 * TODO
 */
package ru.Blazar3C273.geneJ.GeneticOperators;


import java.util.Arrays;
import java.util.Random;

import ru.Blazar3C273.geneJ.FitnessFunction;
import ru.Blazar3C273.geneJ.GeneticOperator;
import ru.Blazar3C273.geneJ.Population;
import ru.Blazar3C273.geneJ.FitnessFunctions.Roulette;

/**
 * 
 */
public class Reproduction implements GeneticOperator {

	private FitnessFunction fitnessFunction;
	private Random rnd;

	/* (non-Javadoc)
	 * @see geneJ.GeneticOperator#executeOperator(geneJ.Population)
	 */
	@Override
	public Population executeOperator(Population paramInput) {
		Population result = null;
		try {
			//TODO мб все спрятать в рулетку? мб это ее функциональность?
			result = (Population) paramInput.clone();
			if (result.isFitnessChanged) {
				result.calculateFitness(fitnessFunction);
			}
			Arrays.sort(result.getPersons().toArray());
			int rouletteIteration = result.getPersons().size()/2;
			Roulette roulette = new Roulette(rnd,result);
			result.getPersons().clear();
			for (int i = 0; i < rouletteIteration; i++) {
				result.getPersons().add(roulette.rotate());
			}
			result.isFitnessChanged = true;
			result.generationCount++;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO if null throw exeption or try refactor it!
		return result;
	}

	/* (non-Javadoc)
	 * @see geneJ.GeneticOperator#initialize(java.lang.Object[])
	 */
	@Override
	public GeneticOperator initialize(Object... paramParams) {
		// TODO в этом методе выполняется в частности проверка аргументов на соответствие. подумать как унифицировать эту проверку. 
		//возможно я неправильно передаю параметры в метод
		rnd = (Random) paramParams[0];
		fitnessFunction = (FitnessFunction) paramParams[1];
		return this;
	}

}
