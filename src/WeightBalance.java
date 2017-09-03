import java.util.Arrays;
import java.util.Scanner;


public class WeightBalance {

	public static void balanceWeight(int arr[], int margin) {
		Arrays.sort(arr);
		//left

		int k = 0;
		int right = 0;
		int left = 0;
		int half = 0;
		int flag = 0;
		int limit = 0;
		//int addedindex = 0;

		int x=0;
		do {

			left = arr[arr.length - x - 1] + 1;
			right = 0;


			//right
			for(int j=0 ; j<arr.length ; j++) {
				if(j!=(arr.length - x - 1))
					right += arr[j];
			}

			
			System.out.println("in do while ::: left: " + left + " right: " + right);
			int sum = 0;

			for(int j=0 ; j<arr.length ; j++) {
				sum += arr[j];
			}

			half = sum/2;
			System.out.println(half);

			x++;

		}while(right < half);

		limit = arr.length - x;
		System.out.println("after do while left: " + left + " right: " + right + " x: " +x);

		if(left == right) {
			System.out.println("Perfectly Balanced");
			flag = 1;
		}

		else if(Math.abs(left-right) <= margin) {
			System.out.println("Balanced: " + " left: " + left + " right: " + right + " difference: " +Math.abs(left-right));
			flag = 1;
		}

		else if(right>=half){

			outer : for(int i=0 ; i<arr.length ; i++) {


				System.out.println("Entering loop...");

				while((k < limit)) {
					if(right >= half) {

						System.out.print("arr[k]: " + arr[k]);
						if(k!=0 && k!=(arr.length-x)) {
							left = (left - arr[k-1]) -1;
							System.out.print("   added " + arr[k]);
							left = left + arr[k] + 1;
							//addedindex = k;
						}
						else if(k==0) {
							System.out.print("   added " + arr[k]);
							left = left + arr[k] + 1;
						}

						if(k!=0 && k!=(arr.length-x)) {
							right = right + arr[k-1];
							System.out.print("   subtracted " + arr[k]);
							right = right - arr[k];
						}
						else if(k==0) {
							System.out.print("   subtracted " + arr[k]);
							right = right - arr[k];
						}
						
						
						
						System.out.println("   1. left: " + left + " right: " + right);
						//comparison----------------------------------------------------------------------------------------------------------
						if(right == left) {
							System.out.println("Perfectly Balanced");
							flag = 1;
							break outer;
						}

						else if(Math.abs(left-right) <= margin) {
							System.out.println("Balanced: " + " left: " + left + " right: " + right + " difference: " +Math.abs(left-right));
							flag = 1;
							break outer;
						}
						//end comparison-------------------------------------------------------------------------------------------------------
						
						
					}

					k++;
					
					System.out.print("  limit: " + limit);

				}
				limit--;
				System.out.println("Exiting loop...");
				k=0;			
			}
		} // end else main



		if(flag == 0) {
			System.out.println(" Not Balanced " + "left: " + left + " right: " + right);
		}
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int arr[] = new int[size];

		for(int i=0 ; i<size ; i++) {
			arr[i] = in.nextInt();
		}

		int margin = in.nextInt();

		balanceWeight(arr, margin);

		in.close();

	}

}
