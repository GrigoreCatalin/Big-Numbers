public class CautareBinara {

    public static int firstBinarySearch(int[] array, int key) {
        int startArray = 0;
        int endArray = array.length - 1;
        int position = -1;

        while (startArray <= endArray) {
            int middleArray = (startArray + endArray) / 2;
            if (array[middleArray] == key) {
                endArray = middleArray - 1;
                position = middleArray;
            } else if (array[middleArray] < key) {
                startArray = middleArray + 1;
            } else if (array[middleArray] > key) {
                endArray = middleArray - 1;
            }
        }
        return position;
    }

    public static int lastbinarySearch(int[] array, int key) {
        int startArray = 0;
        int endArray = array.length - 1;
        int position = -1;

        while (startArray <= endArray) {
            int middleArray = (startArray + endArray) / 2;
            if (array[middleArray] == key) {
                startArray = middleArray + 1;
                position = middleArray;
            } else if (array[middleArray] < key) {
                startArray = middleArray + 1;
            } else if (array[middleArray] > key) {
                endArray = middleArray - 1;
            }
        }
           return position;
    }

    public static int countOccurrences(int[] array, int key) {
        int firstPosition = firstBinarySearch(array, key);
        int lastPosition = lastbinarySearch(array, key);

        if (firstPosition == -1 || lastPosition == -1){
            return -1;
        }
        return lastPosition - firstPosition + 1;
    }

    public static void main(String[] args) {
        System.out.println("Checking input...");

        int[] array = {0, 1, 2, 3, 5, 5, 5, 8, 11, 11, 101, 101, 101};

        int rez = countOccurrences(array, 101);
        System.out.println("You got: " + rez + " Correct: " + 2);
    }
}