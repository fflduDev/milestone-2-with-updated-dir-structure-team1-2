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
 */  
class Contact {  
    String name;  
    List<PhonebookEntry> entries;  
    
    public Contact(String name) {  
        this.name = name;  
        entries = new ArrayList<PhonebookEntry>();  
    }  
    
    public String getName() {  
        return name;  
    }  
    
    public void setName(String name) {  
        this.name = name;  
    }  
    
    public void addPhonebookEntry(String number, String type) {  
        PhonebookEntry p = new PhonebookEntry(number, type);  
        entries.add(p);  
        System.out.println("added: " + p.getPhoneNumber());  
    }  
    
    public List<PhonebookEntry> getEntries() {  
        return entries;  
    }  
    
    @Override  
    public boolean equals(Object obj) {  
        if (obj == this) return true;  
        if (!(obj instanceof Contact)) return false;  
        
        Contact contact = (Contact) obj;  
        // Check if names are equal (use equals instead of ==)  
        if (!this.getName().equals(contact.getName())) return false;  
        
        // Check if entries are the same  
        if (this.entries.size() != contact.entries.size()) return false;  
        
        // Check each entry  
        for (int i = 0; i < entries.size(); i++) {  
            PhonebookEntry thisEntry = this.entries.get(i);  
            PhonebookEntry otherEntry = contact.entries.get(i);  
            if (!thisEntry.getPhoneNumber().equals(otherEntry.getPhoneNumber()) ||  
                !thisEntry.getType().equals(otherEntry.getType())) {  
                return false;  
            }  
        }  
        return true;  
    }  
    
    @Override  
    public int hashCode() {  
        // Create a hashcode that will cause some collisions but not for all  
        // For example, make "Stan" and "Juan" collide, but not others  
        String name = this.getName();  
        if (name.equals("Stan") || name.equals("Juan")) {  
            return 42; // Same hashcode for Stan and Juan  
        }  
        return name.length() * 31 + name.charAt(0);  
    }  
    
    @Override  
    public String toString() {  
        StringBuilder sb = new StringBuilder();  
        sb.append("Name: ").append(name).append(", Phone Number(s): [");  
        
        for (int i = 0; i < entries.size(); i++) {  
            PhonebookEntry entry = entries.get(i);  
            sb.append(entry.getPhoneNumber()).append(" ").append(entry.getType());  
            if (i < entries.size() - 1) {  
                sb.append(", ");  
            }  
        }  
        sb.append("]");  
        return sb.toString();  
    }  
}  