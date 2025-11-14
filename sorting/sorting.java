//Deegan @deegan.hansen@malad.us

//for software development 1

//teacher Mr Gross

public class sorting{

    public static int[] swapTwoArrayElements(int[] arrayToSwap, int lowerIndex){

            int temp;

temp=arrayToSwap[lowerIndex];

arrayToSwap[lowerIndex]=arrayToSwap[lowerIndex+1];

arrayToSwap[lowerIndex+1]=temp;

return arrayToSwap;

}

public static void main(String[] args){

int[] arrayToSort={1,3,4,5,23,57,126,4,543,345,23,12,45,67,97};

boolean swapNeeded = false;

if (arrayToSort[2] > arrayToSort[3]) {
    swapNeeded = true;
}
if (swapNeeded) {
    System.out.println("Swapping elements at index " + 2 + " and " + (2  + 1));
    arrayToSort=swapTwoArrayElements(arrayToSort, 2);
}
}

