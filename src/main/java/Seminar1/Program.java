package Seminar1;

import java.util.Random;


public class Program {
	public static void main(String[] args) {
		cats();

		getFactorial(0);

		task2_2();


	}

	private static void cats() {
		int catNumber;
		int zero;

		try { // мониторим код
			catNumber = 1; // у меня один кот
			zero = 0; // ноль, он и в Африке ноль
			int result = catNumber / zero;
			// Создадим массив из трёх котов
			String[] catNames = {"Васька", "Барсик", "Мурзик"};
			catNames[3] = "Рыжик";
			System.out.println("Не увидите это сообщение!");
		} catch (ArithmeticException e) {
			System.out.println(e + ": Нельзя котов делить на ноль!");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println( "Ошибка: " + e.toString());
		}
	}


	public static int getFactorial(int num){

		int result=1;
		try{
			if(num<1) throw new Exception("The number is less than 1");

			for(int i=1; i<=num;i++){

				result*=i;
			}
		}
		catch(Exception ex){

			System.out.println(ex.getMessage());
			result=num;
		}
		return result;
	}


	public static void task2_2(){
	try {
		int [] arr1 = generateArray();
		int [] arr2 = generateArray();
		int [] result = new ProcessArray().arraysDifference(arr1, arr2);
		for (int a1 : arr1) System.out.printf("%d\t", a1);
		System.out.println();
		for (int a2 : arr2) System.out.printf("%d\t", a2);
		System.out.println();
		System.out.println("Разности элементов двух массивов равна:");
		for (int i : result) System.out.printf("%d\t", i);
	} catch (ProcessArray.CustomArraySizeException e) {
		System.out.println(e.getClass().getName());
		System.out.println(e.getMessage());
		System.out.printf(
				"Длина первого массива: %d\nДлина второго массива: %d\n",
				e.getLength1(), e.getLength2());
	} catch (ProcessArray.CustomDivideException e) {
		System.out.println(e.getClass().getName());
		System.out.println(e.getMessage());
		System.out.printf("Элемент по индексу %d равен нулю", e.getElement());
	}
}

	public static int [] generateArray() {
		Random random = new Random();
		int [] arr = new int[random.nextInt(2) + 4];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(10);
		}
		return arr;
	}
}
