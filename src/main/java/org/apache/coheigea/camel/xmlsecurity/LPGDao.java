package org.apache.coheigea.camel.xmlsecurity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement

@XmlType
public class LPGDao {

	private long consumer_no;
	private long account_no;

	private long dealer_no;
	private long ifsc_code;
	private String dealer_name;

	public LPGDao(long consumer_no, long account_no, long dealer_no, long ifsc_code, String dealer_name) {
		super();
		this.consumer_no = consumer_no;
		this.account_no = account_no;
		this.dealer_no = dealer_no;
		this.ifsc_code = ifsc_code;
		this.dealer_name = dealer_name;
	}

	public LPGDao() {
		// TODO Auto-generated constructor stub
	}

	public long getConsumer_no() {
		return consumer_no;
	}

	public void setConsumer_no(long consumer_no) {
		this.consumer_no = consumer_no;
	}

	public long getAccount_no() {
		return account_no;
	}

	public void setAccount_no(long account_no) {
		this.account_no = account_no;
	}

	public long getDealer_no() {
		return dealer_no;
	}

	public void setDealer_no(long dealer_no) {
		this.dealer_no = dealer_no;
	}

	public long getIfsc_code() {
		return ifsc_code;
	}

	public void setIfsc_code(long ifsc_code) {
		this.ifsc_code = ifsc_code;
	}

	public String getDealer_name() {
		return dealer_name;
	}

	public void setDealer_name(String dealer_name) {
		this.dealer_name = dealer_name;
	}

}
