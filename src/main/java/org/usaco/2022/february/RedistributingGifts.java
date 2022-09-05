import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RedistributingGifts {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numCows = sc.nextInt();
		int[] cowGifts = new int[numCows+1]; 
		
		for(int i = 1; i <= numCows; i++) {
			cowGifts[i] = i; 
		}
		
		int input; 
		
		int cowPrefs[][] = new int[numCows+1][numCows+1]; 
		int cowOrder[] = new int[numCows+1]; 
		ArrayList<Integer> cowsOrder[] = new ArrayList[numCows+1]; 
		for (int i = 0; i <= numCows; i++) {
			cowsOrder[i] = new ArrayList<Integer>();
        }
		for(int i = 1; i <= numCows; i++) {
			for(int j = 1; j <= numCows; j++) {
				input = sc.nextInt();
				cowPrefs[i][j] = input;
				if(input == i) {
					cowsOrder[j].add(i); 
					cowOrder[i] = j; 
					sc.nextLine();
					break; 
				}
				
			}
		}
		
		
		/*for(int i = 1; i <= numCows; i++) {
			for(int j = 1; j <= numCows; j++) {
		//		System.out.print(cowPrefs[i][j]);
			}
		//	System.out.println();
		}
		for(ArrayList<Integer> elem : cowsOrder) {
	//		System.out.println(elem);
		}
		*/
		int currCow = 0; 
		boolean tookGift = false; 
		int currNum = 0; 
		boolean[] giftTaken = new boolean[numCows+1];
		for(ArrayList<Integer> elem : cowsOrder ) {
			for(int i = elem.size() -1 ; i >= 0; i--) {
				currCow = elem.get(i);
				currNum = 0; 
				
				//System.out.println("cc = " + currCow);
				for(int j = 1; j < cowPrefs[currCow].length; j++) {
				//	System.out.println(Arrays.toString(cowPrefs[currCow]));
						currNum = cowPrefs[currCow][j]; 
				//		System.out.println("CN: " + currNum);
				//		System.out.println("Current Cow: " + currCow + "\tCurrent Number : " + currNum);
						if(!tookGift && !giftTaken[currNum]) {
				//			System.out.println("Cow " + currCow + " is taking gift " + currNum);
							cowGifts[currCow] = currNum; 
							giftTaken[currNum] = true; 
							tookGift = true; 
							break;
									
					}
					
				}
				
				currNum = 0;
				tookGift = false; 
			}
		}
		
		for(int i = 1; i < numCows+1; i++) {
			System.out.println(cowGifts[i]);
		}	}

}
