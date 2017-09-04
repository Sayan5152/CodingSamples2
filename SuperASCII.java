/* 
	1<= T <= 100
	1<= S <= 400 
*/
import java.io.*;
import java.util.Hashtable;

public class SuperASCII {
	
	public static void main(String[] args) {
		Hashtable<Integer, Character> alphabets = new Hashtable<Integer, Character>();
	alphabets.put(1, 'a');
	alphabets.put(2, 'b');
	alphabets.put(3, 'c');
	alphabets.put(4, 'd');
	alphabets.put(5, 'e');
	alphabets.put(6, 'f');
	alphabets.put(7, 'g');
	alphabets.put(8, 'h');
	alphabets.put(9, 'i');
	alphabets.put(10, 'j');
	alphabets.put(11, 'k');
	alphabets.put(12, 'l');
	alphabets.put(13, 'm');
	alphabets.put(14, 'n');
	alphabets.put(15, 'o');
	alphabets.put(16, 'p');
	alphabets.put(17, 'q');
	alphabets.put(18, 'r');
	alphabets.put(19, 's');
	alphabets.put(20, 't');
	alphabets.put(21, 'u');
	alphabets.put(22, 'v');
	alphabets.put(23, 'w');
	alphabets.put(24, 'x');
	alphabets.put(25, 'y');
	alphabets.put(26, 'z');

	try {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T>0) {
		String str = br.readLine();
		//int length = str.length();
		char strArr[] = str.toCharArray();
		int key = 1;
		int index;
		int countArr[] = new int[27];
		int flag =0;
		countArr[0] = 0;
		for(key=1 ; key<=26 ; key++) {
			char c = alphabets.get(key);
			//System.out.println("in outer for...");
			for(index=0 ; index < strArr.length ; index++) {
				if(strArr[index] == c) {
					countArr[key]++;
					//System.out.println("in innermost if...countArr["+key+"] = " + countArr[key]);
				}
				else continue;
				//System.out.println("in inner for...");
				
			}//inner for loop closes

		}//1st for loop closes
		for(int i=0 ; i<27 ; i++) {
			if(countArr[i] == i || countArr[i] == 0) {
				flag = 1;
				//System.out.println("Yes");
			}
			else {
				flag = 0;
				//System.out.println("No");
				break;
			}
		}
		if (flag == 1) {
		 	System.out.println("Yes");
		 } 
		 else if(flag == 0) {
		 	System.out.println("No");
		 }
		 T--;
		}
	}	catch(IOException e) {
			System.out.println(e);
		}

	}//main closes
}