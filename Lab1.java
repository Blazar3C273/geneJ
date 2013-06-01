
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

import ru.Blazar3C273.geneJ.Chromosome;
import ru.Blazar3C273.geneJ.Population;
import ru.Blazar3C273.geneJ.PopulationFactory;
import ru.Blazar3C273.geneJ.chromosomes.BinChromosome;
import ru.Blazar3C273.geneJ.chromosomes.IntChromosome;
import ru.Blazar3C273.geneJ.chromosomes.VectorChromosome;


/**
 * @author Stepanenko Anatoliy
 * Lab1EvM&GA
 * 14:33:46
 * 10.05.2013
 * 
 */

/**
 * 
 */
public class Lab1 {

	private static final int CHROMOSOME_DEF_SIZE = 10;
	private static final Random RANDOM = new Random();
	private static final int VOLUME_OF_ACCESEBLE_SOLUTION_SPACE = 100;
	private static final int CHROMOSOME_SIZE = 10;
	private static boolean flag = false;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Make array of acceptable chromosome
		// Chose some of them by 4 ways:
		// Shot gun
		// Focus
		// Blanket
		// Yours method
		// Evolute them
		makeCreationDemo();
		makeChromosome();
		evolute();
		drowGraphs();

	}

	private static void evolute() {
		// TODO Auto-generated method stub

	}

	private static void drowGraphs() {
		// TODO Auto-generated method stub

	}

	private static void makeChromosome() {
		System.out
				.println("Выберите тип создавамой хромосомы:1-Int 2-Bin 3-vector int 4-vector bin");
		Chromosome chromosome;
		Scanner in = new Scanner(System.in);
		flag = false;
		while (!flag)
			try {
				switch (in.nextInt()) {
				case 1: {
					chromosome = new IntChromosome(CHROMOSOME_DEF_SIZE, RANDOM);
					System.out.print("\nСодержимое созданной хромосомы: "
							+ chromosome.toString());
					flag = true;
					break;
				}
				case 2: {
					chromosome = new BinChromosome(CHROMOSOME_DEF_SIZE, RANDOM);
					System.out.print("\nСодержимое созданной хромосомы: "
							+ chromosome.toString());
					flag = true;
					break;
				}
				case 3: {
					chromosome = new VectorChromosome(CHROMOSOME_DEF_SIZE,
							RANDOM, new VectorChromosome(CHROMOSOME_DEF_SIZE, RANDOM, new IntChromosome()));
					System.out.print("\nСодержимое созданной хромосомы: "
							+ chromosome.toString());
					flag = true;
					break;
				}
				case 4: {
					chromosome = new VectorChromosome(CHROMOSOME_DEF_SIZE,
							RANDOM, new VectorChromosome(CHROMOSOME_DEF_SIZE, RANDOM, new BinChromosome()));
					System.out.print("\nСодержимое созданной хромосомы: "
							+ chromosome.toString());
					flag = true;
					break;
				}
				default:
					throw new java.util.InputMismatchException();
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("Неврно введены данные");
				flag = false;
			}
	}

	private static void makeCreationDemo() {
		flag = false;
		System.out
				.println("Создание популяции. Выберите метод: 1-Фокусировка,2-Одеяло,3-Дробовик");
		while (!flag) {
			try {
				int size;
				int border1, border2;
				long time;
				Scanner in = new Scanner(System.in);
				Chromosome chromosome;
				switch (in.nextInt()) {
				case 1:
					System.out.println("Введите размер популяции:");
					size = in.nextInt();
					if (size < 0) {
						throw new IOException();
					}
					System.out.println("Введите 1 границу:");
					border1 = in.nextInt();
					if (size < 0) {

						throw new IOException();
					}
					System.out.println("Введите 2 границу:");
					border2 = in.nextInt();
					if (size < 0) {
						throw new IOException();
					}

					time = GregorianCalendar.getInstance().getTime().getTime();
					ArrayList<Chromosome> solutionSpaceBIN = new ArrayList<Chromosome>();
					for (int i = 0; i < VOLUME_OF_ACCESEBLE_SOLUTION_SPACE; i++) {
						solutionSpaceBIN.add(new BinChromosome(CHROMOSOME_SIZE,
								RANDOM));
					}
					Population pop = PopulationFactory
							.generatePopulationByFocusMethod(RANDOM,
									solutionSpaceBIN, size, border1, border2);
					time -= GregorianCalendar.getInstance().getTime().getTime();
					System.out.println("Создание бинарной популяции размера "
							+ size + " заняло  " + -time + " микросекунд\n");
					System.out.println("\n " + pop);
					flag = true;
					break;
				case 2:
					System.out.println("Введите размер хромосомы:");
					size = in.nextInt();
					if (size < 0) {

						throw new IOException();
					}
					time = GregorianCalendar.getInstance().getTime().getTime();
					chromosome = new IntChromosome(size, RANDOM);
					time -= GregorianCalendar.getInstance().getTime().getTime();
					System.out
							.println("Создание целочисленной хромосомы размера заняло "
									+ -time + " микросекунд\n");
					System.out.println("\n " + chromosome);
					flag = true;
					break;

				case 3:
					System.out.println("Введите размер хромосомы:");
					size = in.nextInt();
					if (size < 0) {

						throw new IOException();
					}
					time = GregorianCalendar.getInstance().getTime().getTime();
					chromosome = new VectorChromosome(size, RANDOM,
							new BinChromosome());
					time -= GregorianCalendar.getInstance().getTime().getTime();
					System.out
							.println("Создание векторной хромосомы размера заняло "
									+ -time + " микросекунд\n");
					System.out.println("\n " + chromosome);
					flag = true;
					break;
				default:
					IOException ioException = new IOException();
					throw ioException;
				}
			} catch (IOException e) {
				System.out.println("Неврно введены данные");
				flag = false;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Неврно введены данные");
				flag = false;
			}
		}

	}

}
