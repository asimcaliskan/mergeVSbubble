package bubbleVSmerge;

public class classA {
	
	public void bubbleSort( int arr[] ) {
		int lenArr = arr.length;
		for( int i = 0; i < lenArr - 1 ; i++ ) {
			for( int k = 0; k < lenArr - i - 1 ; k++ ) {
				if( arr[ k + 1 ]  < arr[ k ] ) {
					int temp = arr[ k + 1 ];
					arr[ k + 1 ] = arr[ k ];
					arr[ k ] = temp;
				}
			}
		}
	}
	
	public void mergeConquer( int arr[], int leftIn , int rightIn, int midIn) {
		int leftLen = midIn - leftIn + 1;
		int rightLen = rightIn - midIn;
		
		int leftList[] = new int[ leftLen ];
		int rightList[] = new int[ rightLen ];
		
		for( int i = 0; i < leftLen; i++ ) {
			leftList[ i ] = arr[ leftIn + i ];
		}
		
		for( int k = 0; k < rightLen; k++ ) {
			rightList[ k ] = arr[ midIn + k + 1 ];
		}
		
		int left = 0; int right = 0;
		int startIn = leftIn;
		while( left < leftLen && right < rightLen) {
			if( leftList[ left ] <= rightList[ right ] ) {//left smaller
				arr[ startIn ] = leftList[ left ];
				left++;
			}
			else {//right smaller
				arr[ startIn ] = rightList[ right ];
				right++;
			}
			startIn ++;
		}
		
		while( left < leftLen ) {
			arr[ startIn ] = leftList[ left ];
			startIn ++;
			left ++;
		}

		while( right < rightLen ) {
			arr[ startIn ] = rightList[ right ];
			startIn ++;
			right ++;
		}
	}
	
	void printArr( int arr[] ) {
		int lenArr = arr.length;
		for( int i = 0; i < lenArr; i ++) {
			System.out.print( arr[ i ] + " ");
		}
		//System.out.println();
	}
	
	public void mergeDivide( int arr[], int leftIn, int rightIn) {//Divides the arrays into smallest arrays
		if( leftIn < rightIn) {//when array was divided into two part. Length of array must be bigger than 0,
			int midIn = ( leftIn + rightIn ) / 2;
			mergeDivide( arr, leftIn, midIn );
			mergeDivide( arr, midIn + 1, rightIn );
			mergeConquer( arr, leftIn, rightIn, midIn );
		}
	}
	
	public static void main(String [] args) throws InterruptedException {
		classA myClass = new classA();
		long startTime;
		long endTime;
		int randArr[] = { 64, 34, 25, 12, 22, 11, 90, 23, 4, 15, 636, 25, 123, 3213, 41, 4, 1242, 1424, 142, 35, 75, 47, 245, 124, 2135, 346, 75, 235, 14, 47, 235, 2562, -14, 2342, 0};
		startTime = System.nanoTime();
		myClass.bubbleSort( randArr );
		endTime = System.nanoTime();
		myClass.printArr( randArr );
		System.out.println( "Elapsed time for bubble sort : " + ( endTime - startTime ) );

		startTime = System.nanoTime();
		myClass.mergeDivide(randArr, 0, randArr.length - 1 );
		endTime = System.nanoTime();
		myClass.printArr( randArr );
		System.out.println( "Elapsed time for  merge sort : " + ( endTime - startTime ) );
	}
}
