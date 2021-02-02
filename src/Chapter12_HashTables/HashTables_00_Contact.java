package Chapter12_HashTables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class HashTables_00_Contact {
    public static class Contact {
        public List<String> names;

        public Contact(List<String> names) {
            this.names = names;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Contact)) {
                return false;
            }
            return this == obj
                    ? true
                    : (new HashSet<String>(names)).equals(new HashSet<>(((Contact) obj).names));
        }

        @Override
        public int hashCode() {
            return new HashSet(names).hashCode();
        }

        @Override
        public String toString() {
            return names.toString();
        }
    }

    public static List<Contact> mergeContacts(List<Contact> contacts) {
        return new ArrayList<>(new HashSet<>(contacts));
    }

    public static void main(String[] args) {
        Contact contact1 = new Contact(new ArrayList<>(Arrays.asList(
                "sharad", "surabhi", "ajit"
        )));

        Contact contact2 = new Contact(new ArrayList<>(Arrays.asList(
                "ajit", "sharad", "surabhi"
        )));

        List<Contact> merged = mergeContacts(new ArrayList<>(Arrays.asList(contact1,
                contact2)));

        for (Contact contact : merged) {
            System.out.println(contact);
        }

        Contact contact3 = new Contact(new ArrayList<>(Arrays.asList("jack",
                "regulion")));

        List<Contact> merged2 = mergeContacts(new ArrayList<>(Arrays.asList(contact1, contact3)));

        for (Contact contact : merged2) {
            System.out.println(contact);
        }
    }
}
