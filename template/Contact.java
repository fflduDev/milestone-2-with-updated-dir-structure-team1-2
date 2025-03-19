package template;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

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
		 System.out.println("added: "+p.getPhoneNumber());//test print, delete
	 }
	 //TODO override 
	 @Override
	 public boolean equals(Object obj) {
		 /*if (obj == this)
			return true;
		if (!(obj instanceof Employee))
			return false;

		Employee employee = (Employee) obj;
		
		//we're saying equals is true if age == age && name == name.   
		return employee.getAge() == this.getAge() && employee.getName() == this.getName();*/
		 if(obj==this) {return true;}
		 if(!(obj instanceof Contact)) {return false;}
		 Contact contact=(Contact) obj;
		 return this.getName()==contact.getName();
	 }
	 public int hashCode() {
		 //HashMap<Character, Integer> chars=new HashMap<>();//a=2 b=2 ...
		 char first=this.getName().charAt(0);
		 
		 return first;
	 }//TODO return int

}
