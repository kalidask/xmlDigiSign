package org.apache.coheigea.camel.xmlsecurity;

import java.util.ArrayList;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class myOrderAggregatorStrategy implements AggregationStrategy {

	/*   @Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		if(oldExchange == null) {
			return newExchange;
		}
 
		String oldBody = oldExchange.getIn().getBody(String.class);
		String newBody = newExchange.getIn().getBody(String.class);
		String body = oldBody + newBody;
		
		//System.out.println("body in aggregate pojo class:---------"+"["+oldBody + "," + newBody+"]");
 
		oldExchange.getIn().setBody(body);
 
		return oldExchange;
	}
	*/
	
	 @SuppressWarnings("unchecked")
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
	    if (oldExchange == null) {
	      ArrayList<Object> list = new ArrayList<Object>();
	      list.add(newExchange.getIn().getBody());
	      newExchange.getIn().setBody(list);
	      return newExchange;
	    } else {
	      Object oldIn = oldExchange.getIn().getBody();
	      ArrayList<Object> list = null;
	      if(oldIn instanceof ArrayList) {
	        list = (ArrayList<Object>) oldIn;
	      } else {
	        list = new ArrayList<Object>();
	        list.add(oldIn);
	      }
	      list.add(newExchange.getIn().getBody());
	      newExchange.getIn().setBody(list);
	      return newExchange;
	    }
	  }
	
    }
	


