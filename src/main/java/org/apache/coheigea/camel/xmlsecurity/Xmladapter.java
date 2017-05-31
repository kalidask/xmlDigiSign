

package org.apache.coheigea.camel.xmlsecurity;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;

import java.util.ArrayList;
import java.util.List;

public class Xmladapter {

    
    public static void main(String[] args) throws Exception {

        JAXBContext ctxt = JAXBContext.newInstance(CustomerWrapper.class);
        Marshaller m = ctxt.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        Customer customer = new Customer("John", "Doe");
        Customer customer1 = new Customer("kali", "K");
        Customer customer3 = new Customer("AAAA", "K");
        Customer customer4 = new Customer("BBBB", "K");
        Customer customer5 = new Customer("CCCC", "K");
        
        
        List<Customer> list=new ArrayList<>();
        list.add(customer);
        list.add(customer1);
        list.add(customer3);
        list.add(customer4);
        list.add(customer5);
        
        JAXBElement<CustomerWrapper> root = new JAXBElement<CustomerWrapper>(new QName("items"), 
                CustomerWrapper.class, new CustomerWrapper(list));
       // m.marshal(new JAXBElement<CustomerWrapper>(new QName("cwrapper"), CustomerWrapper[].class, new CustomerWrapper(customer,customer1)), System.err);
        m.marshal(root, System.err);
    }

    static class CustomerWrapper {
        private List<Customer> cust;

        public CustomerWrapper() {
        }

        public CustomerWrapper(List<Customer> customer) {
            this.cust = customer;
        }

        public List<Customer> getCustomer() {
            return cust;
        }

        @XmlJavaTypeAdapter(CustomerAdapter.class)
        public void setCustomer(List<Customer> customer) {
            this.cust = customer;
        }
    }

    
    static class Customer {
        private String name;
        private String lastName;
        
        public Customer() {
        }
        public Customer(String name, String lastName) {
            this.name = name;
            this.lastName = lastName;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

    static class CustomerAdapter extends XmlAdapter<String, List<Customer>> {

		@Override
		public List<Customer> unmarshal(String v) throws Exception {
			String[] str = v.split("|");
			ArrayList<Customer> cust=new ArrayList<>();
			System.out.println("hello");
			for(String ss:str){
				String[] t=ss.split(" ");
	           Customer c= new Customer(t[0], t[1]);
	           cust.add(c);
			}
			return cust;
		}

		@Override
		public String marshal(List<Customer> custlist) throws Exception {
			StringBuilder str=new StringBuilder();
			str.append("\n");
			for(Customer v:custlist){
				str.append("\t"+v.getName() + "\t" + v.getLastName()+"\n");
			}
			System.out.println("----------"+str.toString());
			return str.toString();
		}

       /* @Override
        public Customer unmarshal(String v) throws Exception {
            String[] ss = v.split(" ");
            return new Customer(ss[0], ss[1]);
        }

        @Override
        public String marshal(Customer v) throws Exception {
            return v.getName() + " " + v.getLastName();
        }*/

    }
    
    
}