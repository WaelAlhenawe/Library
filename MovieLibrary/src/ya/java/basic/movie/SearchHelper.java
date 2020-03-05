/**
 * 
 */
package ya.java.basic.movie;


/**
 * @author wael
 *
 */
public class SearchHelper {
	
	enum SearchType {ID, TITLE, ACTOR, YEAR, LENGHT, GO_BACK}


	protected static SearchType searchCLI() {
		boolean ok = false;
		int choice=-1;
		String temp;
		do {
			if (ok) {
				System.out.println();
				System.out.println("   ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
				System.out.println(">> ONLY DIGITS FROM 0 TO 5 ALLOWED <<<");
				System.out.println("   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println();
			}
			System.out.println("***********************");
			System.out.println("_______Search By_______");
			System.out.println("1 - ID");
			System.out.println("2 - Title");
			System.out.println("3 - Main Actor");
			System.out.println("4 - Production Year");
			System.out.println("5 - Movie Length");
			System.out.println("0-  Go Back");
			System.out.println("***********************");

			System.out.print("Please Enter the Number of your Choice: ");

			temp = Lib_App.input.next();
			System.out.println("***********************");

			try {
				ok = false;
				choice = Integer.parseInt(temp);
			} catch (NumberFormatException e) {
				ok = true;
			}

			if (!(choice >= 0 && choice <= 5)) ok = true;
		}
		while (ok);
		switch(choice) {
		case 1:
			return SearchType.ID;
		case 2:
			return SearchType.TITLE;
		case 3:
			return SearchType.ACTOR;
		case 4:
			return SearchType.YEAR;	
		case 5:
			return SearchType.LENGHT;	
		case 0:
			return SearchType.GO_BACK;
		}
		return null;
	}
	/**
	 * @return
	 */
	protected static String userSearchInput(String outputMessage) {
		String userInput;
		System.out.print(outputMessage);
		userInput = Lib_App.input.next();
		System.out.println("***********************");
		return userInput;
	}
	
}
