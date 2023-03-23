public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] array = new int[]{4, 13, 23, 45, 7, 4, 28, 6, 34, 2, 9, 66, 12, 5, 76, 24, 17};
        print(array);
        int n = array.length;
        // построение кучи
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);
        System.out.println("построили");
// Один за другим извлекаем элементы из кучи
        for (int i=n-1; i>=0; i--)
        {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            System.out.println("переворот");
            // вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
        print(array);
    }



    public static void heapify(int arr[], int n, int i)
    {
        int largest = i;
// Инициализируем наибольший элемент как корень
        int l = 2*i + 1; // левый = 2*i + 1
        int r = 2*i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Если самый большой элемент не корень
        if (largest != i)
        {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
        print(arr);
// Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, largest);
        }
    }


    public static void print(int [] array){
        System.out.println();
        for (int i:array) {
            System.out.print(i + " ");
        }
    }
}