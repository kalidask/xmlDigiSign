package org.apache.coheigea.camel.xmlsecurity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement

@XmlAccessorType
public class LpgWrapper {

	private List<LPGDao> Data;

	public LpgWrapper() {
		super();
	}

	public LpgWrapper(List<LPGDao> lpdetail) {
		super();
		this.Data = lpdetail;
	}

	public List<LPGDao> getLpgdao() {
		return Data;
	}

	@XmlElement(name = "Data")
	@XmlJavaTypeAdapter(LPGAdapter.class)
	public void setLpgdao(List<LPGDao> lpgdao) {
		this.Data = lpgdao;
	}
}
