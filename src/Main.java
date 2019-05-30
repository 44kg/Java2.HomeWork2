import myExceptions.MyArrayDataException;
import myExceptions.MySizeArrayException;

public class Main {
    public static void main(String[] args) {
        String[][] array = new String[4][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = "1";
            }
        }
//        array[3][2] = "Один";
        try {
            int sum = convertArray(array);
            System.out.println("Сумма массива: " + sum);
        }
        catch (MySizeArrayException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    static public int convertArray(String[][] array) throws MySizeArrayException, MyArrayDataException {
        int sum = 0;
        int[][] intArray = new int[4][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array.length != 4 || array[i].length != 4) {
                    throw new MySizeArrayException("Размер массива не равен [4][4]");
                }
                try {
                    sum += intArray[i][j] = Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException("Элемент массива [" + i + "][" + j + "] невозможно" +
                            " преобразовать в int");
                }

            }
        }
        return sum;
    }
}
