import java.util.ArrayList;

public class AddressBook {

        Contact contact = new Contact();


        public AddressBook() {
            currentContactIndex = null;
        }


        public void addContact(Contact contact) {
            contacts.add(contact);
            currentContactIndex = contacts.size() - 1;

        }

        // Temporary printout
        public void printItems() {
            for (Contact contact : contacts)
                System.out.println("*** = " + contact);
        }


        public void deleteContact() {
            if (contacts.size() == 0)
                return;
            contacts.remove(currentContactIndex.intValue());
            if (currentContactIndex == contacts.size()) {
                currentContactIndex = currentContactIndex - 1;
            }
            if(contacts.size()==0)
                currentContactIndex = null;
        }


        public void next() {
            if (contacts.size() == 0)
                return;
            currentContactIndex = currentContactIndex + 1;
            if (currentContactIndex == contacts.size())
                currentContactIndex = 0;
        }


        public void previous() {
            if (contacts.size() == 0)
                return;
            else
                currentContactIndex = currentContactIndex - 1;
            if (currentContactIndex == -1)
                currentContactIndex = contacts.size() - 1;

        }


        public Boolean isEmpty() {
            boolean isEmpty = contacts.isEmpty();
            return isEmpty;
        }


        public void updateContact(String fieldName, String fieldValue) {
            if (contacts.size() == 0)
                return;
            switch (fieldName.toLowerCase()) {
                case "firstname":
                case "first name":
                    getCurrentContact().setFirstName(fieldValue);
                    break;
                case "lastname":
                case "last name":
                    getCurrentContact().setLastName(fieldValue);
                    break;
                case   "Address":
                case   "Address Name":

                    getCurrentContact().setAddress(fieldValue);
                    break;
                case "City":
                case "City name":
                    getCurrentContact().setCity(fieldValue);
                case "State":
                case "State name":
                    getCurrentContact().setState("State name");
                case "Zip":
                case "Zip code":
                    getCurrentContact().setZip(fieldValue);
                    break;
                case "phonenumber":
                case "phone number":
                    getCurrentContact().setPhoneNumber(fieldValue);
                    break;
                case "emailaddress":
                case "email address":
                    getCurrentContact().setEmailAddress(fieldValue);
                    break;
                default:
                    getCurrentContact().setCustomField(fieldName, fieldValue);
            }
        }


        public Integer getContactCount() {
            if (contacts == null) {
                contactCount = 0;
            } else
                contactCount = contacts.size();
            return contactCount;
        }


        public Contact getCurrentContact() {
            if (currentContactIndex != null)
                return contacts.get(currentContactIndex);
            else
                return null;
        }


        public ArrayList<Contact> searchForContact(String valueToSearchFor) {
            searchHits.clear();
            for (Contact value : contacts)
                if (value.toString().toLowerCase().contains(valueToSearchFor.toLowerCase()))
                    searchHits.add(value);
            return searchHits;
        }

        public ArrayList<Contact> getContacts() {
            return contacts;
        }

        public void setContacts(ArrayList<Contact> contacts) {
            this.contacts = contacts;
        }

        public Integer getCurrentContactIndex() {
            return currentContactIndex;
        }

        public void setCurrentContactIndex(Integer currentContactIndex) {
            this.currentContactIndex = currentContactIndex;
        }

        private int contactCount;
        private ArrayList<Contact> searchHits = new ArrayList<Contact>();
        private ArrayList<Contact> contacts = new ArrayList<Contact>();
        private Integer currentContactIndex;
    }


