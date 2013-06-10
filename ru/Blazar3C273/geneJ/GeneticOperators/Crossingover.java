/*package ru.Blazar3C273.geneJ.GeneticOperators;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import ru.Blazar3C273.geneJ.Chromosome;
import ru.Blazar3C273.geneJ.GeneticOperator;
import ru.Blazar3C273.geneJ.GeneticOperatorParams;
import ru.Blazar3C273.geneJ.Population;
import ru.Blazar3C273.geneJ.Exeptions.WrongArgumentsExeption;
import ru.Blazar3C273.geneJ.chromosomes.Gen;


*//**
 * @author Stepanenko Anatoliy
 * Lab1EvM&GA
 * 19:44:49
 * 10.05.2013
 * TODO
 *//*

*//**
 * 
 *//*
public class Crossingover extends GeneticOperator {

	private Random rnd;
	private int crossingoverPoint;
	private boolean isRandom;


	
	 * (non-Javadoc)
	 * 
	 * @see GeneticOperator#executeOperator(java.util.ArrayList)
	 
	*//**
	 * @param parentPopulation
	 *            Initial population. Her size should be a multiple of two.
	 * @param _crossingoverPoint
	 *            Shold be int[1] <i>(int[1] should belong to the set [0;
	 *            population_size] )</i> or Random[1].
	 * *//*
	@Override
	public Population executeOperator(Population parentPopulation) {
		assert (parentPopulation.getPersons().size() % 2 == 0) : "\n Size of population is not a multiple of two";
		//TODO
		

		Population result = null;
		try {
			result = (Population) parentPopulation.clone();
		ArrayList<Chromosome> localChromosomes = parentPopulation.getPersons();
		ArrayList<Chromosome> resultChromosomes = new ArrayList<Chromosome>(localChromosomes.size());
		
		ArrayList<Gen<?>> child_genom1;
		ArrayList<Gen<?>> child_genom2;
		ArrayList<Gen<?>> localGenom2;
		ArrayList<Gen<?>> localGenom;
		for (int i = 0; i < localChromosomes.size()-1; i += 2) {
			localGenom = localChromosomes.get(i).getGenom();
			localGenom2 = localChromosomes.get(i+1).getGenom();
			child_genom1 = new ArrayList<Gen<?>>(localGenom.size());
			child_genom2 = new ArrayList<Gen<?>>(localGenom.size());
			if (isRandom) {
				crossingoverPoint = rnd.nextInt(localGenom.size());
			}
			Collection<? extends Gen<?>> l = localGenom.subList(0, crossingoverPoint);
			child_genom1.addAll(l);
			l = localGenom2.subList(crossingoverPoint, localGenom2.size());
			child_genom1.addAll(l);
			l = localGenom2.subList(0, crossingoverPoint);
			child_genom2.addAll(l);
			l = localGenom.subList(crossingoverPoint, localGenom.size());
			child_genom2.addAll(l);
			Chromosome tmp;
				tmp = (Chromosome) localChromosomes.get(0).clone();
				tmp.setGenom(child_genom1);
				resultChromosomes.add((Chromosome) tmp.clone());
				tmp.setGenom(child_genom2);
				resultChromosomes.add(tmp);
		}
		result.getPersons().addAll(resultChromosomes);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		return result;
	}

	*//**
	 * @return 
	 * @throws WrongArgumentsExeption 
	 * @params определяют точку кроссинговера. int ждолжен принадлежать множеству 1,L-1, где L длинна хромосомы || Random
	 * *//*
	@Override
	public GeneticOperator initialize(GeneticOperatorParams paramParams) throws WrongArgumentsExeption {
		
		crossingoverPoint = 0;
		isRandom = false;
		if (params[0].getClass().equals(int.class)) {
			crossingoverPoint = (int) params[0];
		} else if (params[0].getClass().equals(Random.class)) {
			isRandom = true;
			rnd = (Random) params[0];
		} else {
			throw new WrongArgumentsExeption(params[0].getClass().getName() + "Wrond aruments type");
		}
		return this;
	}

	

}
*/