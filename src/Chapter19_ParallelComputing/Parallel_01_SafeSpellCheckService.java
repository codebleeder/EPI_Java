package Chapter19_ParallelComputing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class Parallel_01_SafeSpellCheckService {
    private static class SpellCheckService {
    }

    private static class ServiceRequest {
        public String extractWord() {
            return "req string";
        }
    }

    private static class ServiceResponse {
        public void encode(String[] w) {
        }
    }

    private static class Spell {
        public static String[] closestInDictionary(String w) {
            return new String[]{"word1", "word2"};
        }
    }

    private static class UnsafeSpellCheckService extends SpellCheckService {
        private static final int MAX_ENTRIES = 3;

        private static LinkedHashMap<String, String[]> cachedClosestStrings
                = new LinkedHashMap<String, String[]>() {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > MAX_ENTRIES;
            }
        };

        public static void service(ServiceRequest req, ServiceResponse resp) {
            String w = req.extractWord();
            if (cachedClosestStrings.containsKey(w)) {
                resp.encode(cachedClosestStrings.get(w));
                return;
            }
            String[] closestToWord = Spell.closestInDictionary(w);
            cachedClosestStrings.put(w, closestToWord);
        }
    }

    private static class SafeSpellCheckService extends SpellCheckService {
        private static final int MAX_ENTRIES = 3;
        private static ReentrantLock lock = new ReentrantLock();
        private static LinkedHashMap<String, String[]> cachedClosestStrings
                = new LinkedHashMap<String, String[]>() {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > MAX_ENTRIES;
            }
        };

        public static void service(ServiceRequest req, ServiceResponse resp) {
            String w = req.extractWord();
            lock.lock();
            try {
                if (cachedClosestStrings.containsKey(w)) {
                    resp.encode(cachedClosestStrings.get(w));
                    return;
                }
            } finally {
                lock.unlock();
            }

            String[] closestToWord = Spell.closestInDictionary(w);

            lock.lock();
            try {
                cachedClosestStrings.put(w, closestToWord);
            } finally {
                lock.unlock();
            }
        }
    }
}
