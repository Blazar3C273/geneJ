/**
 * @author Stepanenko Anatoliy
 * Lab1EvM&GA
 * 22:07:02
 * 23.05.2013
 * TODO
 */
package ru.Blazar3C273.geneJ.GeneticOperators;


import java.util.ArrayList;
import java.util.Random;

import ru.Blazar3C273.geneJ.Chromosome;
import ru.Blazar3C273.geneJ.GeneticOperator;
import ru.Blazar3C273.geneJ.GeneticOperatorParams;
import ru.Blazar3C273.geneJ.Population;
import ru.Blazar3C273.geneJ.Exeptions.WrongArgumentsExeption;
import ru.Blazar3C273.geneJ.chromosomes.Gen;


/**
 * 
 */
public class Mutation extends GeneticOperator {
	public static class MutationParams extends GeneticOperatorParams{
		public Random random;
		public double oddsRatio;		
		public MutationParams(Random _inRnd,double _oddsRatio) {
			super(_inRnd);
			this.oddsRatio = _oddsRatio;
			this.random = _inRnd;
		}
		
	}
	private Random random;
	private double oddsRatio;
	
	/**
	 * @param paramArgs int вероятность мутации в хромосоме 0 - 100
	 * TODO предусмотреть дробный коэф
	 * */
	@Override
	public Population executeOperator(Population paramInput) {
		Population result = null;
		result =paramInput;
		//get params
		
		for (Chromosome localChromosome : result.getPersons()) {
			if (random.nextInt(100)/100 <= oddsRatio) {
				//TODO index warning
				ArrayList<Gen<?>> localGenom = localChromosome.getGenom();
				int point = random.nextInt(localGenom.size()-1);
				if (point < 0) point = 0;
				Gen<?> tmp=localGenom.get(point+1);
				localGenom.set(point+1, localGenom.get(point));
				localGenom.set(point, tmp);
			}
		}
		return result;
	}

	@Override
	public GeneticOperator initialize(GeneticOperatorParams _inParams) throws WrongArgumentsExeption {
		if (_inParams.getClass() == MutationParams.class ) {
			MutationParams localMutationParams = (MutationParams) _inParams;
			random = _inParams.getRandom();
			oddsRatio = localMutationParams.oddsRatio;
			return this;			
		} else {
			throw new WrongArgumentsExeption("Current params class is "+_inParams.getClass().getName()+". Need class is MutationParams.");
		}
	}

}
