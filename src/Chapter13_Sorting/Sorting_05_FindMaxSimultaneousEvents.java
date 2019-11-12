package Chapter13_Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorting_05_FindMaxSimultaneousEvents {
    public static class Event {
        public int start, finish;
        Event(int start, int finish){
            this.start = start;
            this.finish = finish;
        }
    }

    public static class Endpoint implements Comparable<Endpoint>{
        public boolean isStart;
        public int time;
        Endpoint(int time, boolean isStart){
            this.isStart = isStart;
            this.time = time;
        }
        @Override
        public int compareTo(Endpoint other){
            if (time != other.time){
                return Integer.compare(time, other.time);
            }
            return isStart && !other.isStart ? -1 : (!isStart && other.isStart ? 1 : 0);
        }
    }

    public static int findMaxSimultaneousEvents(List<Event> events){
        List<Endpoint> endpoints = new ArrayList<>();
        for (Event e : events){
            endpoints.add(new Endpoint(e.start, true));
            endpoints.add(new Endpoint(e.finish, false));
        }
        Collections.sort(endpoints);
        int counter = 0;
        int maxEvents = 0;
        for (Endpoint e : endpoints){
            if (e.isStart){
                counter++;
            }
            else {
                counter--;
            }
            if (counter > maxEvents){
                maxEvents = counter;
            }
        }
        return maxEvents;
    }
    public static void test(){
        List<Event> events = new ArrayList<>(Arrays.asList(
                new Event(1, 5),
                new Event(2, 7),
                new Event(4, 5),
                new Event(6, 10),
                new Event(8, 9),
                new Event(9, 17),
                new Event(11, 13),
                new Event(12, 15),
                new Event(14, 15)
        ));
        System.out.println(findMaxSimultaneousEvents(events));
    }
}
