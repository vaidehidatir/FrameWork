package runManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import lib.Global;
import lib.InitDriver;
import lib.Report;
import lib.Utility;

public class RunManager {
	
	
	public static void main(String[] args) throws FilloException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		

		
		Report.createHTMLReport();
		String strQuery =  "Select * from Groups where Run = 'Y'";
		List lgroups=  Utility.readGroups(Global.groupControlFilePath, strQuery);
		
		for(int i=0 ; i< lgroups.size();i++) {
			String strSheetName = lgroups.get(i).toString();
			String strTestcaseQuery = "Select * from " + strSheetName + " where Run ='Y'";
			Recordset rs_TestCase = Utility.readTestcases(Global.groupControlFilePath, strTestcaseQuery);
			while(rs_TestCase.next()){
				Global.gstrID=rs_TestCase.getField("ID");
				Global.gstrAutomationID=rs_TestCase.getField("AutomationID");
				Global.gstrManualID=rs_TestCase.getField("ManualTcID");
				Global.gstrDescription=rs_TestCase.getField("Description");
				String strComponents = rs_TestCase.getField("BatchFile");
				String[] arrComponents = strComponents.split("_");
				
				new Utility("CHROME");
				for(int j=0; j<arrComponents.length;j++) {
					String strClassname = arrComponents[j].split("\\.")[0];
					Global.gstrClassName=strClassname;
					
					String strMethodName = arrComponents[j].split("\\.")[1];
					Global.gstrMethodName=strMethodName;
					
					
					Class cls = Class.forName("pages."+strClassname);
					Object obj = cls.newInstance();
					Method m = cls.getDeclaredMethod(strMethodName);
					m.invoke(obj);
					system.out.println("a");
				}
				
				
			}
		}
		
		Global.report.flush();
		
		
	}
	
	

}
