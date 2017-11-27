/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_07_16;

/**
 *
 * @author ASUS
 */
public class Ejercicio_07_16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // randomly generates an array of 100,000
		// integers and a key
		int num;
		int[] numeros = new int[10000];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = getRandomInt();
		}
		int key = getRandomInt();
		
		// Estimate the execution time of invoking the linearSearch
		int resultadodebusqueda;
		long startTime = System.currentTimeMillis();
		resultadodebusqueda = linearSearch(numeros, key);
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println(
			"Tiempo de ejecución de invocación de linearSearch en milisegundos:" 
			+ executionTime);

		// Sort array
		selectionSort(numeros);

		// Estimate the execution time of invoking the linearSearch
		startTime = System.currentTimeMillis();
		resultadodebusqueda = binarySearch(numeros, key);
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		System.out.println(
			"Tiempo de ejecución de invocar la búsqueda binaria en milisegundos:: " 
			+ executionTime + " ");
	}

	/** getRandomInt */
	public static int getRandomInt() {
		return 1 + (int)(Math.random() * 100000);
	}

	/** linearSearch */
	public static int linearSearch(int[] array, int key) {
		for (int i = 0; i < array.length; i++) {
			if (key == array[i])
				return i;
		}
		return -1;
	}

	/** binarySearch */
	public static int binarySearch(int[] array, int key) {
		int low = 0;
		int high = array.length - 1;
		
		while (high >= low) {
			int mid = (low + high) / 2;
			if (key < mid)
				high = mid - 1;
			else if (key == mid)
				return mid;
			else
				low = mid + 1;
		}
		return -low -1;
	}

	/** selectionSort */
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			// Find the mimum in the array
			int min = array[i];
			int minIndex = i;

			for (int j = i + 1; j < array.length; j++) {
				if (min > array[j]) {
					min = array[j];
					minIndex = j;
				}
			}

			// Swap array[i] with array[minIndex] if necessary
			if (minIndex != i) {
				array[minIndex] = array[i];
				array[i] = min; 
			}
		}
	}
}