package lib;

import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Global {
	
	public static String groupControlFilePath = System.getProperty("user.dir")+"\\TestArtifacts\\GroupControlFile.xlsx";
	
	public static String gstrID;
	public static String gstrAutomationID;
	public static String gstrManualID;
	public static String gstrDescription;
	
	//Reporting variables:
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report; 
	public static ExtentTest logger;
	
	public static String  gstrClassName;
	public static String  gstrMethodName;
	
	public static String gstrTestArtifacts = System.getProperty("user.dir")+"\\TestArtifacts\\";
	
	public static Map gstrObjDataMap;
	
	public static String gstrAppURL="https://rightstartmath.com/";
	
	public static String gtsrScreenshotPath= System.getProperty("user.dir")+"\\Reports\\Screenshots\\";
	

}
