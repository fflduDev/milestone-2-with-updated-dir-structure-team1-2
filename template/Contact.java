package template;
import java.util.List;
import java.util.ArrayList;

/**
 * model a Contact 
 * Contact has a name & list of phonebook entries
 * 
 * Support adding phonebookEntry to a contact
 * 
 * @Override hashCode and equals
 * 
 */

class Contact {
	 String name;
	 List<PhonebookEntry> entries;
	 
	 public Contact(String name) {
		 this.name=name;
		 entries=new ArrayList<PhonebookEntry>();
	 }
	 
	 public String getName() {
		 return name;
	 }
	 public void setName(String name) {
		 this.name=name;
	 }
	 public void addPhonebookEntry(String number, String type) {
		 PhonebookEntry p=new PhonebookEntry(number,type);
		 entries.add(p);
		 System.out.println("added: "+p.getNumber());//test print, delete
	 }
	 //TODO override 

}
