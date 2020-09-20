package lib;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Utility {
	static WebDriver driver;

	public Utility(String browserName) {
		driver =  InitDriver.getDriverInstance(browserName);
		Global.logger  = Global.report.createTest(Global.gstrAutomationID, Global.gstrDescription);
	}


	public static WebDriver returnDriver() {

		return driver;

	}

	/**
	 * @author Ethans
	 * Funnction name :- getRecordUsingFillo
	 */
	public static Recordset getRecordUsingFillo(String fileName , String strQuery) throws FilloException {
		Connection con = null;
		Fillo fil = null;
		Recordset rs = null;

		try {
			fil = new Fillo();
			con = fil.getConnection(fileName);
			rs = con.executeQuery(strQuery);
		}
		catch(Exception e) {

		}

		return rs;

	}


	/**
	 * @author Ethans
	 * Funnction name :- readGroups 
	 */
	public static List readGroups(String fileName , String strQuery) throws FilloException {

		ArrayList l = new ArrayList();
		try {
			Recordset rs = Utility.getRecordUsingFillo(fileName, strQuery);

			while(rs.next()) {
				String grps = rs.getField("Groups");
				l.add(grps);
			}
		}
		catch(Exception e) {

		}

		return l;

	}


	/**
	 * @author Ethans
	 * Funnction name :- readTestcases 
	 */
	public static Recordset readTestcases(String fileName , String strQuery) throws FilloException {			
		Recordset rs = Utility.getRecordUsingFillo(fileName, strQuery);
		return rs;

	}

	/**
	 * @author Ethans
	 * Funnction name :- clickElement
	 * @return 
	 */
	public static String clickElement (WebElement ele , String label  , String value) {

		String s = "";
		String strVar = TestData.readTestdataValue(value);
		if(strVar.contentEquals("")||strVar.contentEquals("SKIP")) {
			return s;
		}
		try {
			ele.click();
			Report.writeHTMLLogs("PASS", "Sucesfully click on the "+ label);
		}
		catch(Exception e) {
			Report.writeHTMLLogs("FAIL", "Fail to click on the "+ label + " " + e.getMessage());
		}


		return strVar;

	}


	/**
	 * @author Ethans
	 * Funnction name :- EnterText
	 * @return 
	 */
	public static String EnterText (WebElement ele , String label  , String value) {

		String s = "";
		String strVar = TestData.readTestdataValue(value);
		if(strVar.contentEquals("")||strVar.contentEquals("SKIP")) {
			return s;
		}
		try {
			ele.sendKeys(strVar);;
			Report.writeHTMLLogs("PASS", "Sucesfully enter " + strVar + " on the text box "+ label);
		}
		catch(Exception e) {
			Report.writeHTMLLogs("FAIL", "Failed to enter " + strVar + " on the text box "+ label+ " " + e.getMessage());
		}


		return strVar;

	}


}
