/**
 * @author Stepanenko Anatoliy
 * Lab1EvM&GA
 * 5:29:49
 * 30.05.2013
 * TODO
 */
package ru.Blazar3C273.geneJ.FitnessFunctions;


import java.util.ArrayList;
import java.util.Random;

import ru.Blazar3C273.geneJ.Chromosome;
import ru.Blazar3C273.geneJ.Population;
import ru.Blazar3C273.geneJ.Exeptions.WrongArgumentsExeption;

/**
 * 
 */
public class Roulette {
	private ArrayList<Chromosome> chromosomes;
	private ArrayList<Chromosome> chromosomesOnRoulette;
	private int fitnessSumm;
	private Random rnd;
	public class RouletteIsEmptyExeption extends Throwable{

		/**
		 * TODO
		 * 3:47:20
		 * long
		 * serialVersionUID
		 */
		private static final long serialVersionUID = -3180539898002394233L;
		}
	
	public Roulette(Random paramRnd, Population paramResult) throws WrongArgumentsExeption {
		chromosomes = paramResult.getPersons();
		fitnessSumm = 0;
		if (chromosomes.size() == 0) {
			throw new WrongArgumentsExeption("Empty population. Roulette is unreachable");
		}
		rnd = paramRnd;
		for (Chromosome iterable : chromosomes) {
			fitnessSumm += (Integer)iterable.getFitness();
		}
		chromosomesOnRoulette = new ArrayList<Chromosome>();
		for (Chromosome iterable : chromosomes) {
			// TODO: косяк тут. когда много хромосом, их вклад в общую сумму становиться меньше процента. при округлении до единиц будет 0. 0 раз добавить 
			//добавляем ссылки на хромосомы в количестве, пропорциональном велечине целевой функции
			for (int i = 0; i < (Integer)iterable.getFitness() * 100 / fitnessSumm; i++) {
				chromosomesOnRoulette.add(iterable);
			}
		}
		;
	}

	public Chromosome rotate() throws RouletteIsEmptyExeption {
		if (chromosomesOnRoulette.size() == 0) {
			throw new RouletteIsEmptyExeption();
		}
		int localNextInt = rnd.nextInt(chromosomesOnRoulette.size()-1);
		return chromosomesOnRoulette.get(localNextInt);
	}

}
