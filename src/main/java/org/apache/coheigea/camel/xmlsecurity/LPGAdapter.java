package org.apache.coheigea.camel.xmlsecurity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LPGAdapter extends XmlAdapter<String, List<LPGDao>> {

	@Override
	public List<LPGDao> unmarshal(String v) throws Exception {
		String[] str = v.split("|");
		ArrayList<LPGDao> cust = new ArrayList<>();
		System.out.println("hello");
		for (String ss : str) {
			String[] t = ss.split(" ");
			// lpgdetails c= new lpgdetails(t[0], t[1]);
			// cust.add(c);
		}
		return cust;
	}

	@Override
	public String marshal(List<LPGDao> custlist) throws Exception {
		StringBuilder str = new StringBuilder();
		str.append("\n");
		for (LPGDao v : custlist) {
			str.append("\t" + v.getAccount_no() + "\t" + v.getConsumer_no() + "\t" + v.getDealer_no() + "\t"
					+ v.getIfsc_code() + "\n");
		}
		return str.toString();
	}

	/*
	 * @Override public Customer unmarshal(String v) throws Exception { String[]
	 * ss = v.split(" "); return new Customer(ss[0], ss[1]); }
	 * 
	 * @Override public String marshal(Customer v) throws Exception { return
	 * v.getName() + " " + v.getLastName(); }
	 */

}
