package net.ukr.automation.transforms;

import java.util.Arrays;

public class ArrayTransformation {

    public int[] transform(int[] arrayToTransform) {

        // definition of variables for size of arrays for even and odd elements of original array
        int arrayEvenSize = 0;
        int arrayOddSize = 0;

        System.out.println("You choosed to transform the array weirdest way.");
        System.out.println("Even elements will be placed first, and odd after them.");
        System.out.println("Predefined array is: " + Arrays.toString(arrayToTransform));
        System.out.println("It contains " + arrayToTransform.length + " elements.");

        // get number of even elements of original array to define size of array for even elements
        for (int i = 0; i < arrayToTransform.length; i++) {
            if (arrayToTransform[i] % 2 == 0) {
                arrayEvenSize++;
            }
        }

        System.out.println("Number of even elements: " + arrayEvenSize);
        // defining array of even elements of original array
        int arrayEven[] = new int[arrayEvenSize];

        // get number of odd elements of original array to define size of array for odd elements
        for (int i = 0; i < arrayToTransform.length; i++) {
            if (arrayToTransform[i] % 2 == 1) {
                arrayOddSize++;
            }
        }

        System.out.println("Number of odd elements: " + arrayOddSize);

        // defining array of odd elements of original array
        int arrayOdd[] = new int[arrayOddSize];

        // temporary variables for indexes of corresponding arrays
        int tempEven = 0;
        int tempOdd = 0;

        // filling arrays with even and odd elements
        for (int i = 0; i < arrayToTransform.length; i++) {
            if (arrayToTransform[i] % 2 == 0) {
                arrayEven[tempEven] = arrayToTransform[i];
                tempEven++;
            } else {
                arrayOdd[tempOdd] = arrayToTransform[i];
                tempOdd++;
            }
        }

        // merging even and odd arrays into original array replacing its value
        System.arraycopy(arrayEven, 0, arrayToTransform, 0, arrayEven.length);
        System.arraycopy(arrayOdd, 0, arrayToTransform, arrayEven.length, arrayOdd.length);

        return arrayToTransform;

    }

    public int[] transform2(int[] arrayToSort) {

        for (int i = 0; i < arrayToSort.length; i++) {
            if (!(0 == arrayToSort[i] % 2)) {//Если текущий элемент нечетный - меняем его местами с ближайшим следующим четным
                for (int j = i; j < arrayToSort.length; j++) {
                    if (0 == arrayToSort[j] % 2) {
                        int buffer = arrayToSort[i];
                        arrayToSort[i] = arrayToSort[j];
                        arrayToSort[j] = buffer;
                        break;
                    }
                }
            }
        }
        return arrayToSort;
    }

    public int[] transform3(int[] array2) {

        int[] array3 = new int[10];
        int[] array4 = new int[10];
        // показываем иизначальный массив
        System.out.println("Here is a second array: " + Arrays.toString(array2));

        //берём вспомогательные переменные - первая ячейка будущего массива, и последняя
        int count1 = 0;
        int count2 = 9;
        // перебираем элементы изначального массива
        for (int i = 0; i < array2.length; i++) {
            // если остаток от деления равен нулю, то это значение занимает первую ячейку
            if ((array2[i] % 2) == 0) {
                array3[count1] = array2[i];
                count1++;
            }
            // если остаток от деления равен единице (условие - иначе) то занимает последнюю ячейку
            else {
                array3[count2] = array2[i];
                count2--;
            }

        }
        //берём ещё раз вспомогательные переменные, чтобы отсортировать нечётные числа в порядок, указанный вначале
        int count3 = 0;
        int count4 = 9;
        for (int j = 0; j < array4.length; j++) {

            if ((array3[j] % 2) == 0) {
                array4[count3] = array3[j];
                count3++;
            } else {
                array4[count4] = array3[j];
                count4--;
            }
        }
        return array4;
    }

    public int[] transform4(int[] mySortArray) {

        System.out.println("\nThe default array: " + Arrays.toString(mySortArray) + ".");

        //об'яляємо новий буферних масива для відсортованих елементів та виділяємо для нього пам'ять
        int[] mySortArrayBuf = new int[mySortArray.length];

        //об'являємо буферні зміні, для формування буферного масива
        int pairPossition1 = 0;
        int oddPossition1 = mySortArray.length - 1;

        //Виконуємо сортування парних чисел й переміщуємо їх на початок масиву
        for (int i = 0; i < mySortArray.length; i++) {
            if (mySortArray[i] % 2 == 0) {
                mySortArrayBuf[pairPossition1] = mySortArray[i];
                pairPossition1++;
            } else {
                mySortArrayBuf[oddPossition1] = mySortArray[i];
                oddPossition1--;
            }
        }

        //об'являємо зміні, для формування відсортованого масиву масива
        int pairPossition2 = 0;
        int oddPossition2 = mySortArray.length - 1;

        //Виконуємо сортування непарних чисел й зміщуємо їх за парні числа
        for (int j = 0; j < mySortArray.length; j++) {
            if (mySortArrayBuf[j] % 2 == 0) {
                mySortArray[pairPossition2] = mySortArrayBuf[j];
                pairPossition2++;
            } else {
                mySortArray[oddPossition2] = mySortArrayBuf[j];
                oddPossition2--;
            }
        }
        return mySortArray;
    }

    public int[] transform5(int[] arrayForSort) {

        int count = 0;
        for (int num : arrayForSort) {
            if (num % 2 == 0) {
                count += 1;
            }
        }

        int[] sortedArray = new int[arrayForSort.length];

        for (int i = 0, countOdd = 0; i < arrayForSort.length; i++) {
            if (arrayForSort[i] % 2 == 0) {
                sortedArray[countOdd] = arrayForSort[i];
                countOdd++;
            } else {
                sortedArray[count] = arrayForSort[i];
                count++;
            }
        }
        return sortedArray;
    }


}
