package org.apache.coheigea.camel.xmlsecurity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.apache.coheigea.camel.xmlsecurity.lpgdetails;
import org.apache.coheigea.camel.xmlsecurity.lpglist;

public class lpgprocessor implements Processor{

	@SuppressWarnings("unchecked")
	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
	
		
		List<?> rows = exchange.getIn().getBody(List.class);
        System.out.println("Processing " + exchange.getIn().getBody());
        
     
        
        
        try{
        	
lpglist dplist = new lpglist();
        dplist.setlpdetail(new ArrayList<lpgdetails>());
        for (Object row : rows) {
            lpgdetails article = new lpgdetails();
 
            
            Map<String, Object> rowlst = (Map<String, Object>) row ;
            article.setAccount_no((Integer) rowlst.get("account_no"));
            
            article.setConsumer_no((Integer) rowlst.get("consumer_no"));
            
            article.setDealer_no((Integer) rowlst.get("dealer_no"));
            article.setIfsc_code((Integer) rowlst.get("ifsc_code"));
            article.setDealer_name((String) rowlst.get("dealer_name"));
            
            dplist.getlpgdetail().add(article);
        }
        exchange.getOut().setBody(dplist);
    
		
                     }catch(Exception e){
        	 e.printStackTrace();
             System.out.println(e);
         }   
	
         }
	
}
