package org.apache.coheigea.camel.xmlsecurity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.apache.coheigea.camel.xmlsecurity.LPGDao;

public class lpgprocessor implements Processor {

	@SuppressWarnings("unchecked")
	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub

		List<?> rows = exchange.getIn().getBody(List.class);
		 System.out.println("Processing " + exchange.getIn().getBody());

		try {

			// LpgWrapper dplist = new LpgWrapper();
			List<LPGDao> dplist = new ArrayList<LPGDao>();
			for (Object row : rows) {
				LPGDao article = new LPGDao();

				Map<String, Object> rowlst = (Map<String, Object>) row;
				article.setAccount_no((Integer) rowlst.get("account_no"));

				article.setConsumer_no((Integer) rowlst.get("consumer_no"));

				article.setDealer_no((Integer) rowlst.get("dealer_no"));
				article.setIfsc_code((Integer) rowlst.get("ifsc_code"));
				article.setDealer_name((String) rowlst.get("dealer_name"));

				dplist.add(article);
			}

			JAXBContext ctxt = JAXBContext.newInstance(LpgWrapper.class);
			Marshaller m = ctxt.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			JAXBElement<LpgWrapper> root = new JAXBElement<LpgWrapper>(new QName("lpg_Subsidy_data"), LpgWrapper.class,
					new LpgWrapper(dplist));
			// m.marshal(root, System.err);
			// m.marshal(root, System.out);
			m.marshal(root, new File("/opt/data/test.xml"));

			/*
			 * LpgWrapper wrp=new LpgWrapper(); wrp.setLpgdao(dplist);
			 * System.out.println("wrp"+wrp.getLpgdao());
			 * exchange.getOut().setBody(wrp.getLpgdao());
			 */

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}

}
