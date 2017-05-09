package org.apache.coheigea.camel.xmlsecurity;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "lpgdetails")
@XmlAccessorType (XmlAccessType.FIELD)

public class lpglist {

	
		
		    @XmlElement(name = "lpgdetails")
		    private List<lpgdetails> lpdetail = null;
		 
		    public List<lpgdetails> getlpgdetail() {
		        return lpdetail;
		    }
		 
		    public void setlpdetail(List<lpgdetails> lpdetail) {
		        this.lpdetail = lpdetail;
		    }
		}
	
	

