package org.apache.coheigea.camel.xmlsecurity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class XmlFormer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List<HashMap<String, String>> lstrow = new ArrayList<>();
		
		HashMap<String, String> clmdata = new HashMap<>();

		HashMap<String, String> clmdata1 = new HashMap<>();

		clmdata.put("key1","kalidas");
		clmdata.put("key2","kumbharkar");
		clmdata.put("key3","vashi");
		clmdata.put("key4","msc");
		
		lstrow.add(clmdata);
		
		
		clmdata1.put("key1","pradeep");
		clmdata1.put("key2","kadam");
		clmdata1.put("key3","kurla");
		clmdata1.put("key4","bsc");
		
		
		lstrow.add(clmdata1);

		
		
		
		
		StringBuilder st = new StringBuilder();
		st.append("<lpgdata>\n");
		st.append("<data>\n");
		for(int i=0; i<lstrow.size();i++){
			st.append("\n");
			st.append(lstrow.get(i).get("key1")+"\t\t\t\t");
			st.append(lstrow.get(i).get("key2")+"\t\t\t\t");
			st.append(lstrow.get(i).get("key3")+"\t\t\t\t");
			st.append(lstrow.get(i).get("key4"));
			
		}
		st.append("</data>\n");
		st.append("</lpgdata>");
		
		System.out.println(st.toString());
	}

}
