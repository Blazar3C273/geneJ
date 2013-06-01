package ru.Blazar3C273.geneJ;

import java.util.ArrayList;
import java.util.Random;

import ru.Blazar3C273.geneJ.chromosomes.Gen;


/**
 * @author Stepanenko Anatoliy
 * Lab1EvM&GA
 * 12:42:55
 * 21.03.2013
 * TODO
 */

/**
 * 
 */
public abstract class Chromosome implements Fitnessable  {
	private ArrayList<Gen<?>> genom;
	//protected Comparable<? extends Comparable<?>> fitnessValue;
	public boolean fitnessIsMeasured = false;
	
	public Chromosome() {
		genom = new ArrayList<Gen<?>>();			
	}
	
	public  Chromosome(int hromosomeSize,Random random) {
		genom = new ArrayList<Gen<?>>(hromosomeSize);			
	}
	
	public ArrayList<Gen<?>> getGenom() {
		return genom;
	}


	public void setGenom(ArrayList<Gen<?>> genom) {
		this.genom = genom;
	}

	@Override
	public String toString() {
		String retStr = new String("\n{");
		for (Gen<?> iter : genom) {
			retStr +=iter+",";
		}
		retStr = retStr.substring(0,(retStr.length()-1));
		retStr+="}";
		return retStr;
	}
	
	public abstract ArrayList<Chromosome> generateSomeChromosomes(int quantity,int chromosomeSize,Random random,Chromosome sample);
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Chromosome ret = null;
		try {
			ret = this.getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ret.genom = (ArrayList<Gen<?>>) genom.clone();
		return ret;
	}

	
}
