package lib;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.codoid.products.exception.FilloException;

public class Report {
	
	/**
	 * @author Ethans
	 * Funnction name :- createHTMLReport
	 * @throws FilloException 
	 */
	public static void createHTMLReport() {
		
		Global.htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\TestResultLogs\\Batch.html");
		Global.report = new ExtentReports();
		Global.report.attachReporter(Global.htmlReporter);	
	}
	
	/**
	 * @author Ethans
	 * Funnction name :- writeHTMLLogs
	 * @throws FilloException 
	 */
   public static void writeHTMLLogs(String strpassFail , String desc) {
		
	   if(strpassFail.contentEquals("PASS")) {
		   Global.logger.log(Status.PASS, desc);
	   }
	   else if (strpassFail.contentEquals("FAIL")) {
		   Global.logger.log(Status.FAIL, desc);
	   }
	   else {
		   Global.logger.log(Status.INFO, desc);
	   }	
	}
}
