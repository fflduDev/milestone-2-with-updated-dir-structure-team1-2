package template;  

import java.util.*;  

/**  
 * PhonebookHandler - supports   
 * Phonebook operations  
 */  
public class PhonebookHandler implements iPhonebookHander {  
    private Map<Contact, List<PhonebookEntry>> phonebook;  
    
    public PhonebookHandler(Map<Contact, List<PhonebookEntry>> phonebook) {  
        this.phonebook = phonebook;  
    }  
    
    @Override  
    public List<Contact> sortByName() {  
        // Get all contacts from phonebook  
        List<Contact> contacts = new ArrayList<>(phonebook.keySet());  
        
        // Implement bubble sort  
        for (int i = 0; i < contacts.size() - 1; i++) {  
            for (int j = 0; j < contacts.size() - i - 1; j++) {  
                if (contacts.get(j).getName().compareTo(contacts.get(j + 1).getName()) > 0) {  
                    // Swap contacts  
                    Contact temp = contacts.get(j);  
                    contacts.set(j, contacts.get(j + 1));  
                    contacts.set(j + 1, temp);  
                }  
            }  
        }  
        
        System.out.println("\nSorted Phonebook (Bubble Sort):");  
        return contacts;  
    }  
    
    @Override  
    public List<PhonebookEntry> binarySearch(List<Contact> sortedContacts, String name) {  
        int left = 0;  
        int right = sortedContacts.size() - 1;  
        
        while (left <= right) {  
            int mid = left + (right - left) / 2;  
            Contact midContact = sortedContacts.get(mid);  
            
            int comparison = midContact.getName().compareTo(name);  
            
            if (comparison == 0) {  
                // Found the contact  
                return midContact.getEntries();  
            } else if (comparison < 0) {  
                // Search in the right half  
                left = mid + 1;  
            } else {  
                // Search in the left half  
                right = mid - 1;  
            }  
        }  
        
        // Contact not found  
        return new ArrayList<>();  
    }  
    
    @Override  
    public void display(List<Contact> sortedContacts) {  
        for (Contact contact : sortedContacts) {  
            System.out.println(contact.getName());  
        }  
    }  
}  