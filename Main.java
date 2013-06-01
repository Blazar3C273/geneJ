import geneJ.BinChromosome;
import geneJ.Chromosome;
import geneJ.IntChromosome;
import geneJ.Population;
import geneJ.PopulationFactory;
import geneJ.VectorChromosome;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Stepanenko Anatoliy
 * Lab1EvM&GA
 * 19:50:10
 * 10.04.2013
 * TODO
 */

/**
 * 
 */
public class Main {

	private static final int CHROMOSOME_SIZE = 10;
	private static final int VOLUME_OF_ACCESEBLE_SOLUTION_SPACE = 15;

	/**
	 * 
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Main intery point
	 * 
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
		//
		Random rnd = new Random();
		long creationTime;
		ArrayList<Chromosome> solutionSpaceBIN = new ArrayList<Chromosome>();
		ArrayList<Chromosome> solutionSpaceINT = new ArrayList<Chromosome>();
		ArrayList<Chromosome> solutionSpaceVector = new ArrayList<Chromosome>();
		creationTime = GregorianCalendar.getInstance().getTime().getTime();
		for (int i = 0; i < VOLUME_OF_ACCESEBLE_SOLUTION_SPACE; i++) {
			solutionSpaceVector.add(new VectorChromosome(CHROMOSOME_SIZE, rnd,
					new IntChromosome()));
			solutionSpaceBIN.add(new BinChromosome(CHROMOSOME_SIZE, rnd));
			solutionSpaceINT.add(new IntChromosome(CHROMOSOME_SIZE, rnd));
		}
		creationTime -= (GregorianCalendar.getInstance().getTime().getTime());
		String tmpStr = "�����, ��������������� ��� �������� "
				+ VOLUME_OF_ACCESEBLE_SOLUTION_SPACE * 3 + " �������� �� "
				+ CHROMOSOME_SIZE + " ����� : " + -creationTime
				+ " (�����������)";
		System.out.println(tmpStr);

		creationTime = GregorianCalendar.getInstance().getTime().getTime();
		Population binPopulationCreateByShotGun = PopulationFactory
				.generatePopulationByShotGunMethod(rnd, solutionSpaceBIN, 100);
		creationTime -= GregorianCalendar.getInstance().getTime().getTime();
		System.out.println(-creationTime);

		creationTime = GregorianCalendar.getInstance().getTime().getTime();
		Population intPopulationCreateByFocus = PopulationFactory
				.generatePopulationByFocusMethod(rnd, solutionSpaceINT, 100, 0,
						15);
		creationTime -= GregorianCalendar.getInstance().getTime().getTime();
		System.out.println(-creationTime);

		creationTime = GregorianCalendar.getInstance().getTime().getTime();
		Population vectorPopulationCreateByByBlanketMethod = PopulationFactory
				.generatePopulationByBlanketMethod(solutionSpaceVector);
		creationTime -= GregorianCalendar.getInstance().getTime().getTime();
		System.out.println(-creationTime);
		System.out
				.println("��������� ��������. ������� ��� ��������:\n 1-Bin \n 2-Int\n 3-Vector Bin\n 4-Vector Int\n");
		Chromosome chromosome = new BinChromosome();
		boolean flag = false;

		while (!flag) {
			try {
				int result;
				long time;
				Scanner in = new Scanner(System.in);
				switch (in.nextInt()) {
				case 1:
					System.out.println("������� ������ ���������:");
					result = in.nextInt();
					if (result < 0) {
						throw new IOException();
					}
					time = GregorianCalendar.getInstance().getTime().getTime();
					chromosome = new BinChromosome(result, rnd);
					time -= GregorianCalendar.getInstance().getTime().getTime();
					System.out
							.println("�������� �������� ��������� �������"+ result + "������ "
									+ -time + " �����������\n");
					System.out.println("\n " + chromosome);
					flag = true;
					break;
				case 2:
					System.out.println("������� ������ ���������:");
					result = in.nextInt();
					if (result < 0) {
						throw new IOException();
					}
					time = GregorianCalendar.getInstance().getTime().getTime();
					chromosome = new IntChromosome(result, rnd);
					time -= GregorianCalendar.getInstance().getTime().getTime();
					System.out
							.println("�������� ������������� ��������� �������"+ result + " ������"
									+ -time + " �����������\n");
					System.out.println("\n " + chromosome);
					flag = true;
					break;

				case 3:
					System.out.println("������� ������ ���������:");
					result = in.nextInt();
					if (result < 0) {
						throw new IOException();
					}
					time = GregorianCalendar.getInstance().getTime().getTime();
					chromosome = new VectorChromosome(result, rnd,
							new BinChromosome());
					time -= GregorianCalendar.getInstance().getTime().getTime();
					System.out
							.println("�������� ��������� ��������� �������"+ result + " ������"
									+ -time + " �����������\n");
					System.out.println("\n " + chromosome);
					flag = true;
					break;

				case 4:
					System.out.println("������� ������ ���������:");
					result = in.nextInt();
					if (result < 0) {
						throw new IOException();
					}
					time = GregorianCalendar.getInstance().getTime().getTime();
					time = GregorianCalendar.getInstance().getTime().getTime();
					chromosome = new VectorChromosome(result, rnd,
							new IntChromosome());
					time -= GregorianCalendar.getInstance().getTime().getTime();
					System.out
							.println("�������� ��������� ��������� �������"+ result + " ������"
									+ -time + " �����������\n");
					System.out.println("\n " + chromosome);
					flag = true;
					break;
				default:
					break;
				// throw new IOException();
				}

			} catch (IOException e) {
				System.out.println("������ ������� ������");
				flag = false;
			} catch (java.util.InputMismatchException e) {
				System.out.println("������ ������� ������");
				flag = false;
			}
		}

		flag = false;
		System.out
				.println("�������� ���������. �������� �����: 1-�����������,2-������,3-��������");
		while (!flag) {
			try {
				int size;
				int border1,border2;
				long time;
				Scanner in = new Scanner(System.in);
				switch (in.nextInt()) {
				case 1:
					System.out.println("������� ������ ���������:");
					size = in.nextInt();
					if (size < 0) {
						throw new IOException();
					}
					System.out.println("������� 1 �������:");
					border1 = in.nextInt();
					if (size < 0) {
						throw new IOException();
					}
					System.out.println("������� 2 �������:");
					border2 = in.nextInt();
					if (size < 0) {
						throw new IOException();
					}
					
					time = GregorianCalendar.getInstance().getTime().getTime();
					Population pop  = PopulationFactory.generatePopulationByFocusMethod(rnd, solutionSpaceBIN, size, border1, border2);
					time -= GregorianCalendar.getInstance().getTime().getTime();
					System.out
							.println("�������� �������� ��������� ������� " +
									size +" ������  "+ -time + " �����������\n");
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
					chromosome = new IntChromosome(size, rnd);
					time -= GregorianCalendar.getInstance().getTime().getTime();
					System.out
							.println("�������� ������������� ��������� ������� ������ "
									+ -time + " �����������\n");
					System.out.println("\n " + chromosome);
					flag = true;
					break;

				case 3:
					System.out.println("������� ������ ���������:");
					size = in.nextInt();
					if (size < 0) {
						throw new IOException();
					}
					time = GregorianCalendar.getInstance().getTime().getTime();
					chromosome = new VectorChromosome(size, rnd,
							new BinChromosome());
					time -= GregorianCalendar.getInstance().getTime().getTime();
					System.out
							.println("�������� ��������� ��������� ������� ������ "
									+ -time + " �����������\n");
					System.out.println("\n " + chromosome);
					flag = true;
					break;
				default:
					break;
				// throw new IOException();
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