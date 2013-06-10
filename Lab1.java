import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

import ru.Blazar3C273.geneJ.Chromosome;
import ru.Blazar3C273.geneJ.Population;
import ru.Blazar3C273.geneJ.PopulationFactory;
import ru.Blazar3C273.geneJ.Chromosomes.BinChromosome;
import ru.Blazar3C273.geneJ.Chromosomes.IntChromosome;
import ru.Blazar3C273.geneJ.Chromosomes.VectorChromosome;

/**
 * @author Stepanenko Anatoliy
 * Lab1EvM&GA
 * 14:33:46
 * 10.05.2013
 * 
 */

/**
 * ������������ ������ � 1 �� ����� ������������� ������������� � ������������
 * ���������� ��������� ��������� ������ ������������� ������
 */
public class Lab1 {

	private static final int CHROMOSOME_DEF_SIZE = 10;
	private static final Random RANDOM = new Random();
	private static final int VOLUME_OF_ACCESEBLE_SOLUTION_SPACE = 100;
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
	}

	private static void makeChromosome() {
		System.out
				.println("�������� ��� ����������� ���������:1-Int 2-Bin 3-vector int 4-vector bin");
		Chromosome chromosome;
		Scanner in = new Scanner(System.in);
		flag = false;
		while (!flag)
			try {
				switch (in.nextInt()) {
				case 1: {
					chromosome = new IntChromosome(CHROMOSOME_DEF_SIZE, RANDOM);
					System.out.print("\n���������� ��������� ���������: "
							+ chromosome.toString());
					flag = true;
					break;
				}
				case 2: {
					chromosome = new BinChromosome(CHROMOSOME_DEF_SIZE, RANDOM);
					System.out.print("\n���������� ��������� ���������: "
							+ chromosome.toString());
					flag = true;
					break;
				}
				case 3: {
					chromosome = new VectorChromosome(CHROMOSOME_DEF_SIZE,
							RANDOM, new IntChromosome());
					System.out.print("\n���������� ��������� ���������: "
							+ chromosome.toString());
					flag = true;
					break;
				}
				case 4: {
					chromosome = new VectorChromosome(CHROMOSOME_DEF_SIZE,
							RANDOM, new BinChromosome());
					System.out.print("\n���������� ��������� ���������: "
							+ chromosome.toString());
					flag = true;
					break;
				}
				default:
					throw new java.util.InputMismatchException();
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("������ ������� ������");
				flag = false;
			}
	}

	private static void makeCreationDemo() {
		flag = false;
		System.out
				.println("�������� ���������. �������� �����: 1-�����������,2-������,3-��������");
		while (!flag) {
			try {
				int size;
				int border1, border2;
				long time;
				Scanner in = new Scanner(System.in);
				Population pop;
				switch (in.nextInt()) {
				case 1:
					System.out.println("������� ������ ���������:");
					size = in.nextInt();
					if (size < 0) {
						throw new IOException();
					}
					System.out.println("������� 1 ������� 0-100 :");
					border1 = in.nextInt();
					if (size < 0) {

						throw new IOException();
					}
					System.out.println("������� 2 ������� 0-100 :");
					border2 = in.nextInt();
					if (size < 0) {
						throw new IOException();
					}

					time = GregorianCalendar.getInstance().getTime().getTime();
					ArrayList<Chromosome> solutionSpaceBIN = new BinChromosome()
							.generateSomeChromosomes(
									VOLUME_OF_ACCESEBLE_SOLUTION_SPACE,
									CHROMOSOME_DEF_SIZE, RANDOM,
									new BinChromosome());
					pop = PopulationFactory.generatePopulationByFocusMethod(
							RANDOM, solutionSpaceBIN, size, border1, border2);
					time -= GregorianCalendar.getInstance().getTime().getTime();
					System.out.println("�������� �������� ��������� ������� "
							+ size + " ������  " + -time + " �����������\n");
					System.out.println("\n " + pop);
					flag = true;
					break;
				case 2:
					System.out.println("������� ������ ���������:");
					size = in.nextInt();
					if (size < 0) {

						throw new IOException();
					}
					time = GregorianCalendar.getInstance().getTime().getTime();
					pop = PopulationFactory
							.generatePopulationByBlanketMethod(new BinChromosome()
									.generateSomeChromosomes(size,
											CHROMOSOME_DEF_SIZE, RANDOM,
											new BinChromosome()));
					time -= GregorianCalendar.getInstance().getTime().getTime();
					System.out
							.println("�������� ������������� ��������� ������ "
									+ -time + " �����������\n");
					System.out.println("\n " + pop);
					flag = true;
					break;

				case 3:
					System.out.println("������� ������ ���������:");
					size = in.nextInt();
					if (size < 0) {

						throw new IOException();
					}
					time = GregorianCalendar.getInstance().getTime().getTime();

					pop = PopulationFactory.generatePopulationByShotGunMethod(
							RANDOM, new BinChromosome()
									.generateSomeChromosomes(
											VOLUME_OF_ACCESEBLE_SOLUTION_SPACE,
											CHROMOSOME_DEF_SIZE, RANDOM,
											new BinChromosome()), size);
					time -= GregorianCalendar.getInstance().getTime().getTime();
					System.out.println("�������� ��������� ������ " + -time
							+ " �����������\n");
					System.out.println("\n " + pop);
					flag = true;
					break;
				default:
					IOException ioException = new IOException();
					throw ioException;
				}
			} catch (IOException e) {
				System.out.println("������ ������� ������");
				flag = false;
			} catch (java.util.InputMismatchException e) {
				System.out.println("������ ������� ������");
				flag = false;
			}
		}

	}

}
