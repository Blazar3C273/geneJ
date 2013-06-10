package ru.Blazar3C273.geneJ.GeneticOperators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import ru.Blazar3C273.geneJ.Chromosome;
import ru.Blazar3C273.geneJ.GeneticOperator;
import ru.Blazar3C273.geneJ.GeneticOperatorParams;
import ru.Blazar3C273.geneJ.Population;
import ru.Blazar3C273.geneJ.Exeptions.WrongArgumentsExeption;
import ru.Blazar3C273.geneJ.chromosomes.Gen;

/**
 * @author Stepanenko Anatoliy
 * geneJ
 * 17:19:27
 * 01.06.2013
 * TODO
 */

/**
 * TODO косяк тут. число хромосом утроилось на первой итерации. Это правильно. родители + по 2 потомка к каждой паре.N пар,где n кол-во хромосом .
 * TODO переписать выбор родителей. мб выполнять репродкцию тут же?
 */
public class NPointsCrossingover extends GeneticOperator {

	public static class NPointsStrategy extends GeneticOperatorParams{
		public Integer[] crossingoverPoints;

		public NPointsStrategy(Random _inRnd,Integer[] _crossingoverPoits) {
			super(_inRnd);
			this.crossingoverPoints = _crossingoverPoits;
		}
			
	}
	public static class NRandomPointsStrategy extends GeneticOperatorParams{
		public int quantityOfRandomCrossingoverPoints;
		
		public NRandomPointsStrategy(Random _inRnd,int _quantityOfCrossingoverPoits) {
			super(_inRnd);
			this.quantityOfRandomCrossingoverPoints = _quantityOfCrossingoverPoits;
		}
		
	}
	private Random rnd;
	private enum STRATEGY_ENUM {
		RANDOM_N_POINTS, N_POINTS
	};
	private static Integer[] points;
	private static STRATEGY_ENUM stategy;
	private static Integer quantityOfRandomCutPoits;

	/*
	 * (non-Javadoc)
	 * 
	 * @see geneJ.GeneticOperator#executeOperator(geneJ.Population)
	 */
	@Override
	public Population executeOperator(Population paramInput) {
		ArrayList<Chromosome> childs = new ArrayList<Chromosome>();
		ArrayList<Chromosome> paretns = paramInput.getPersons();

		if (stategy == STRATEGY_ENUM.RANDOM_N_POINTS) {
			points = new Integer[quantityOfRandomCutPoits];
			for (int i = 0; i < quantityOfRandomCutPoits; i++) {
				points[i] = rnd.nextInt(paretns.get(0).getGenom().size());
			}
			Arrays.sort(points);
		}

		for (int i = 0; i < paretns.size(); i++) {
			ArrayList<Gen<?>> parent1 = (ArrayList<Gen<?>>) paretns
					.get(rnd.nextInt(paretns.size())).getGenom().clone();
			ArrayList<Gen<?>> parent2 = (ArrayList<Gen<?>>) paretns
					.get(rnd.nextInt(paretns.size())).getGenom().clone();
			ArrayList<Gen<?>> children1 = new ArrayList<Gen<?>>();
			ArrayList<Gen<?>> children2 = new ArrayList<Gen<?>>();
			int index = 0;
			boolean flag = true;
			for (int j = 0; j < parent1.size(); j++) {
				if (flag) {
					children1.add(parent1.get(j));
					children2.add(parent2.get(j));
				} else {
					children1.add(parent2.get(j));
					children2.add(parent1.get(j));
				}

				if (index < points.length && j == points[index]) {
					flag = !flag;
					index++;
				}
			}
			try {
				Chromosome localClone = (Chromosome) paretns.get(0).clone();
				localClone.setGenom(children1);
				childs.add(localClone);
				localClone = (Chromosome) paretns.get(0).clone();
				localClone.setGenom(children2);
				childs.add(localClone);
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		paramInput.getPersons().addAll(childs);
		paramInput.isFitnessChanged = true;
		return paramInput;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see geneJ.GeneticOperator#initialize(java.lang.Object[])
	 */
	@Override
	public GeneticOperator initialize(GeneticOperatorParams _inParams)
			throws WrongArgumentsExeption {
		if (_inParams.getClass() == NPointsStrategy.class) {
			stategy = STRATEGY_ENUM.N_POINTS;
			points = ((NPointsStrategy) _inParams).crossingoverPoints;
			rnd = _inParams.getRandom();
		} else if (_inParams.getClass() == NRandomPointsStrategy.class) {
			stategy = STRATEGY_ENUM.RANDOM_N_POINTS;
			this.quantityOfRandomCutPoits =((NRandomPointsStrategy)_inParams).quantityOfRandomCrossingoverPoints;
			rnd = _inParams.getRandom();
		} else {
			//TODO
			String massegeString = "Wrond aruments type. Wolid be Random,(Integer[] if N points,"
					+ " non random Crossingover || Integer if N points random Crossingover)";
			throw new WrongArgumentsExeption(massegeString);
		}
		return this;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
