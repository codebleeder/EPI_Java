package Chapter19_ParallelComputing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Parallel_06_ReadersWritersProblem {
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
        private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        private static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        private static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

        private static LinkedHashMap<String, String[]> cachedClosestStrings
                = new LinkedHashMap<String, String[]>() {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > MAX_ENTRIES;
            }
        };

        public static void service(ServiceRequest req, ServiceResponse resp) {
            String w = req.extractWord();
            readLock.lock();
            try {
                if (cachedClosestStrings.containsKey(w)) {
                    resp.encode(cachedClosestStrings.get(w));
                    return;
                }
            } finally {
                readLock.unlock();
            }

            String[] closestToWord = Spell.closestInDictionary(w);

            writeLock.lock();
            try {
                cachedClosestStrings.put(w, closestToWord);
            } finally {
                writeLock.unlock();
            }
        }
    }
}
