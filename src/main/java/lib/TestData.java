package lib;

import java.util.HashMap;
import java.util.Map;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

public class TestData {
	
	public static Map readTestdata(String id , String className , String methodName) throws FilloException {
		
		HashMap  m = new HashMap();
		String fileName = Global.gstrTestArtifacts + className+ "_TestData.xlsx";
		String strQuery = "Select * from " + methodName + " where ID = '"+ id +"'";
		Recordset rs = Utility.getRecordUsingFillo(fileName, strQuery);
		
		while(rs.next()) {
			for(int i=0;i<rs.getFieldNames().size() ;i++) {
				String ColName = rs.getField(i).name();
				String ColValue = rs.getField(i).value();
				 m.put(ColName, ColValue);
				
			}
		}
		
		return m;
		
	}
	
	public static String readTestdataValue(String colName) {
		String strValue = (String) Global.gstrObjDataMap.get(colName.toUpperCase());
		return strValue;
		
	}

}
