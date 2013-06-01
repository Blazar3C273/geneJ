package geneJ;
import java.util.ArrayList;
import java.util.Random;

public abstract class PopulationFactory {

	public static Population generatePopulationByShotGunMethod(Random inRand,
			ArrayList<Chromosome> solutionSpace, int populationValue) {
		Population result = new Population();
		ArrayList<Chromosome> localPersons = new ArrayList<Chromosome>(
				populationValue);
		for (int i = 0; i < populationValue; i++) {
			localPersons.add(solutionSpace.get(inRand.nextInt(solutionSpace
					.size())));
		}
		result.setPersons(localPersons);
		return result;
	}

	public static Population generatePopulationByBlanketMethod(
			ArrayList<Chromosome> solutionSpace) {
		return new Population(solutionSpace);
	}

	/**
	 * TODO make a comment
	 */
	public static Population generatePopulationByFocusMethod(Random inRand,
			ArrayList<Chromosome> solutionSpace, int populationValue,
			int firstBorder, int secondBorder) throws WrongFocusBand {
		if (firstBorder < 0) {
			throw new WrongFocusBand("First Border <0!");
		}
		if (secondBorder > solutionSpace.size()) {
			throw new WrongFocusBand(
					"Second border > solution spase array size");
		}
		int bandSize = secondBorder - firstBorder;
		if (bandSize <= 0) {
			throw new WrongFocusBand("Band size is zero or negative");
		}

		Population result = new Population();
		int index;
		ArrayList<Chromosome> list = new ArrayList<Chromosome>(populationValue);
		
		for (int localI = 0; localI < populationValue; localI++) {
			index = firstBorder + inRand.nextInt(bandSize);
			list.add(solutionSpace.get(index));
		}
		result.setPersons(list);
		return result;
	}

}
