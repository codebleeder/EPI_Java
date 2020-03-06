package Chapter14_BinarySearchTrees;

import java.util.*;

public class BinarySearchTrees_13_ClientsCreditsInfo {
    public static class ClientsCreditsInfo {
        private int offset = 0;
        private Map<String, Integer> clientToCredit = new HashMap<>();
        private NavigableMap<Integer, Set<String>> creditToClients = new TreeMap<>();

        public void insert(String clientId, int c){
            remove(clientId);
            clientToCredit.put(clientId, c - offset);
            Set<String> set = creditToClients.get(c - offset);
            if (set == null){
                set = new HashSet<>();
                creditToClients.put(c - offset, set);
            }
            set.add(clientId);
        }

        public boolean remove(String clientId) {
            Integer credit = clientToCredit.get(clientId);
            if(credit != null){
                creditToClients.get(credit).remove(clientId);
                if (creditToClients.get(credit).isEmpty()){
                    creditToClients.remove(credit);
                }
                clientToCredit.remove(clientId);
                return true;
            }
            return false;
        }

        public int lookup(String clientId){
            Integer credit = clientToCredit.get(clientId);
            return credit == null ? -1 : credit + offset;
        }

        public void addAll(Integer c){
            offset += c;
        }

        public String max(){
            return creditToClients.isEmpty()
                    ? ""
                    : creditToClients.lastEntry().getValue().iterator().next();
        }
    }

    public static void test(){
        ClientsCreditsInfo cc = new ClientsCreditsInfo();
        System.out.println("inserting Raj, 30");
        cc.insert("Raj", 30);

        System.out.println("inserting Akash, 45");
        cc.insert("Akash", 45);

        System.out.println("inserting Pramod, 35");
        cc.insert("Pramod", 35);

        System.out.println("max: " + cc.max() + " expectd: Akash");

        System.out.println("adding credit 10 to all");
        cc.addAll(10);

        System.out.println("lookup for Pramod");
        System.out.println("result = " + cc.lookup("Pramod"));

        System.out.println("adding Chetana, 20");
        cc.insert("Chetana", 20);
        System.out.println("lookup for Chetana: " + cc.lookup("Chetana"));

        System.out.println("removing Akash");
        cc.remove("Akash");

        System.out.println("max: " + cc.max() + " expected: Pramod");
    }
}
