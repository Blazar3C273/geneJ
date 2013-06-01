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
import ru.Blazar3C273.geneJ.Population;
import ru.Blazar3C273.geneJ.chromosomes.Gen;


/**
 * 
 */
public class Mutation implements GeneticOperator {

	private Random random;
	private double randomCoef;

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
			if (random.nextInt(100)/100 <= randomCoef) {
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
	public GeneticOperator initialize(Object... params) {
		// TODO Auto-generated method stub
		random = (Random) params[0];
		//TODO exeptions!!!!!
		randomCoef = (double) params[1];
		return this;
	}

}
