package ie.gmit.sw.Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckValidWord {

	static void check() {

		try {
			Scanner s = new Scanner(new File("C:\\Users\\Thomas\\Desktop\\NewCountdown\\ScrabbleProject\\src\\main\\java\\ie\\gmit\\sw\\Game\\outputCode.txt"));
			int statusCode = s.nextInt();
			//s.close();

			if (statusCode == 200) {
				System.out.println("Word is valid");
				
				Scanner sc = new Scanner(new File("C:\\Users\\Thomas\\Desktop\\NewCountdown\\ScrabbleProject\\src\\main\\java\\ie\\gmit\\sw\\Game\\output.txt"));
				String userWord = sc.nextLine();
				
				CompareWordToLetters.compare(userWord); 
				
			} else {
				System.out.println("Invalid Word");
				// TODO return user to enter word again
				System.exit(0);
			}

			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Can't find status code python file");
		}


	}// end check()

}// end CheckValidWord
