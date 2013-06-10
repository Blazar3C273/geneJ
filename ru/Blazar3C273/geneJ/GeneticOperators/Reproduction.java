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
import ru.Blazar3C273.geneJ.GeneticOperatorParams;
import ru.Blazar3C273.geneJ.Population;
import ru.Blazar3C273.geneJ.Exeptions.WrongArgumentsExeption;
import ru.Blazar3C273.geneJ.FitnessFunctions.Roulette;
import ru.Blazar3C273.geneJ.FitnessFunctions.Roulette.RouletteIsEmptyExeption;

/**
 * 
 */
public class Reproduction extends GeneticOperator {

	private FitnessFunction fitnessFunction;
	private Random rnd;
	public static class ReproductionParpms extends GeneticOperatorParams{
		public FitnessFunction fitnessFunction;
		public ReproductionParpms(Random _rnd, FitnessFunction _fitnessFunction) {
			super(_rnd);
			this.fitnessFunction = _fitnessFunction;
		}
		
	} 

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
			int rouletteIteration = result.getPersons().size()/3;
			Roulette roulette = new Roulette(rnd,result);
			result = new Population();
			for (int i = 0; i < rouletteIteration; i++) {
				result.getPersons().add(roulette.rotate());
			}
			result.isFitnessChanged = true;
			result.generationCount++;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongArgumentsExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RouletteIsEmptyExeption e) {
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
	public GeneticOperator initialize(GeneticOperatorParams _inParams) throws WrongArgumentsExeption {
		if (_inParams.getClass() == ReproductionParpms.class) {
			ReproductionParpms _inParamsLocal = (ReproductionParpms) _inParams;
			rnd = _inParams.getRandom();
			fitnessFunction =  _inParamsLocal.fitnessFunction;
			return this;			
		} else {
			throw new WrongArgumentsExeption("Parametrs class is "+_inParams.getClass().getName() + ". Need class is ReproductionParpms");
		}
	}

}
