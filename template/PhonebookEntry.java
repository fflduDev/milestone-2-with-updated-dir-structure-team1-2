package template;

/**
 *   model a PhonebookEntry 
 *   
 *   PhonebookEntry has a phoneNumber and type
 *   
 *   
 *   
 */

class PhonebookEntry{
	String number;
	String type;
	public PhonebookEntry(String number, String type) {
		this.number=number;
		this.type=type;
	}
	
	public String getPhoneNumber() {
		return number;
	}
	public String getType() {
		return type;
	}
	
	public void setPhoneNumber(String number) {
		this.number=number;
	}
	public void setType(String type) {
		this.type=type;
	}
	@Override  
	public String toString() {  
	    return number + " " + type;  
	}  
}
	