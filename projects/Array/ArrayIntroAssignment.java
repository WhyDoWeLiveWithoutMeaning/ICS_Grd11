public class ArrayIntroAssignment {
    public static void main(String[] args){
        q1();

        //Create array 50
        int[] intArr = new int[50];

        //Assign array random number between 1 and 100
        for(int i = 0; i < intArr.length; i++){
            intArr[i] = (int) (Math.random() * 100 + 1);
        }

        printReverse(intArr);

        System.out.println();

        reverseArr(intArr);

        printReverse(intArr);

    }

    public static void q1(){
        String[] pets = {"John", "Terry", "Marcus", "Josh", "Muhammed", "Peter", "Rick"};
        for(String name : pets){
            System.out.println(name);
        }
        System.out.printf("The array of pets contains %d pets.\n", pets.length);
    }

    public static void q2(){
        //Create array 50
        int[] intArr = new int[50];

        //Assign array random number between 1 and 100
        for(int i = 0; i < intArr.length; i++){
            intArr[i] = (int) (Math.random() * 100 + 1);
        }

        //Print values seperated by comma
        for(int i : intArr){
            System.out.print(i + ", ");
        }
        System.out.println();

        //Print highest and lowest value
        int highest = intArr[0];
        for(int i = 1; i < intArr.length; i++){
            if (intArr[i] > highest){
                highest = intArr[i];
            }
        }
        System.out.println(highest);
        int lowest = intArr[0];
        for(int i = 1; i < intArr.length; i++){
            if (intArr[i] < lowest){
                lowest = intArr[i];
            }
        }
        System.out.println(lowest);
        //calculate and print average of all values.
        double average = 0;

        for(int i : intArr) average += i;

        average /= intArr.length;

        System.out.println(average);
    }

    public static void printReverse(int[] arr){
        for(int i = arr.length-1; i >= 0; i--){
            System.out.println(arr[i]);
        }
    }

    public static void reverseArr(int[] arr){
        for(int i = 0; i < arr.length / 2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }
}
