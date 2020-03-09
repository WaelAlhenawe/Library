package ya.java.basic.movie;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ABTestJUnitJavaM_Library {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	private final PrintStream originalOut = System.out;
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	}
	Library<Movie> lib = new M_Library();
	Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
	Movie temp1 = new Movie("Golden Eye", "Pierce Brosnan", 1995, 130);	
	Movie temp2 = new Movie("Tomorrow Never Dies", "Pierce Brosnan", 1997, 119);
	@Test
	public void AAtestJavaM_Library1() {
		Assert.assertNotNull(lib);
	}
	
	@Test
	public void ABtestJavaM_Library2() {
		Assert.assertTrue(lib.addItem(temp));
	}
	
	@Test
	public void ACtestJavaM_Library3() {
		lib.addItem(temp);
		Assert.assertTrue(lib.removeItem(temp));
	}
	
	@Test
	public void ADtestJavaM_Library4() {
		lib.addItem(temp);
		lib.addItem(temp1);
		lib.addItem(temp2);
		Assert.assertEquals(3, lib.getNoOfItems());
	}
	
	@Test
	public void AEtestJavaM_Library5() {
		lib.addItem(temp);
		lib.showLibraryContents();
		String expectedValue = "Movie [ Id: 48, Title: Casino Royale, Main Actor: Daniel Craig, Production Year: 2006, Length: 100]\n";
		Assert.assertEquals(expectedValue, outContent.toString());
	}
	
	@Test
	public void AFtestJavaM_Library6() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);
		
		result.add(temp);
		Assert.assertEquals(tempList1.searchID("54"),(result));
	}
	
	@Test
	public void AGtestJavaM_Library7() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);
		
		Assert.assertEquals(tempList1.searchID("0"),(result));
	}
	
	@Test
	public void AHtestJavaM_Library8() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);
		
		Assert.assertEquals(tempList1.searchID("h"),(result));
	}
	
	@Test
	public void AItestJavaM_Library9() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);
		
		Assert.assertEquals(tempList1.searchID(""),(result));
	}
	
	@Test
	public void AJtestJavaM_Library10() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);
		result.add(null);
		
		Assert.assertEquals(tempList1.searchID("25"),(result));
	}

	@Test
	public void AKtestJavaM_Library11() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);
		
		result.add(temp);
		Assert.assertEquals(tempList1.searchTitle("Casino Royale"),(result));
	}
	
	@Test
	public void ALtestJavaM_Library12() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);
		
		Assert.assertEquals(tempList1.searchTitle(" "),(result));
	}
	
	@Test
	public void AMtestJavaM_Library13() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);
		
		Assert.assertEquals(tempList1.searchTitle(""),(result));
	}
	
	@Test
	public void ANtestJavaM_Library14() {
		M_Library tempList1 = new M_Library();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);
		
		Assert.assertEquals(tempList1.searchTitle("ssss"),Collections.emptyList());
	}
	
	@Test
	public void AOtestJavaM_Library15() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);
		
		result.add(temp);
		Assert.assertEquals(tempList1.searchActor("Daniel Craig"),(result));
	}
	
	@Test
	public void APtestJavaM_Library16() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);
		
		Assert.assertEquals(tempList1.searchActor(" "),(result));
	}
	
	@Test
	public void AQtestJavaM_Library17() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);
		
		Assert.assertEquals(tempList1.searchActor(""),(result));
	}
	
	@Test
	public void ARtestJavaM_Library18() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);
		
		Assert.assertEquals(tempList1.searchActor("ssss"),(result));
	}
	
	@Test
	public void AStestJavaM_Library19() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);
		
		result.add(temp);
		Assert.assertEquals(tempList1.searchYear("2006"),(result));
	}
	
	@Test
	public void ATtestJavaM_Library20() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);
		
		Assert.assertEquals(tempList1.searchYear("2021"),(result));
	}
	
	@Test
	public void AUtestJavaM_Library21() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);
		
		Assert.assertEquals(tempList1.searchYear("1899"),(result));
	}
	
	@Test
	public void AVtestJavaM_Library22() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);
		
		Assert.assertEquals(tempList1.searchYear(""),(result));
	}
	
	@Test
	public void AWtestJavaM_Library23() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);

		Assert.assertEquals(tempList1.searchYear("2005"),(result));
	}
	
	@Test
	public void AXtestJavaM_Library24() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);

		Assert.assertEquals(tempList1.searchYear("yyyy"),(result));
	}
	
	@Test
	public void AYtestJavaM_Library25() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);
		
		result.add(temp);
		Assert.assertEquals(tempList1.searchLength("100"),(result));
	}
	
	@Test
	public void AZtestJavaM_Library26() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);
		
		Assert.assertEquals(tempList1.searchLength("99"),(result));
	}
	
	@Test
	public void BAtestJavaM_Library27() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);
		
		Assert.assertEquals(tempList1.searchLength(""),(result));
	}
	
	@Test
	public void BBtestJavaM_Library28() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);
		
		Assert.assertEquals(tempList1.searchLength("LLL"),(result));
	}
	
	@Test
	public void BCtestJavaM_Library29() {
		M_Library tempList1 = new M_Library();
		var result = new ArrayList<Movie>();
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		tempList1.addItem(temp);

		Assert.assertEquals(tempList1.searchLength("59"),(result));
	}
	
	@Test
	public void BDtestJavaM_Library30() {
		M_Library tempList1 = new M_Library();
		Movie result = tempList1.parcing("Movie [ Id: 48, Title: Casino Royale, Main Actor: Daniel Craig, Production Year: 2006, Length: 100]");
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		Assert.assertTrue(temp.equals(result));
	}
}
