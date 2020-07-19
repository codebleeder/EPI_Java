package Chapter18_Graphs;

import java.util.*;

public class Graphs_00_CanTeamABeatTeamB {
    public static class MatchResult {
        public String winningTeam;
        public String losingteam;

        public MatchResult(String winningTeam, String losingteam) {
            this.winningTeam = winningTeam;
            this.losingteam = losingteam;
        }
    }

    public static boolean canTeamABeatTeamB(List<MatchResult> matches, String teamA, String teamB) {
        Set<String> visited = new HashSet<>();
        return isReachableDFS(buildGraph(matches), teamA, teamB, visited);
    }

    public static boolean isReachableDFS(Map<String, Set<String>> graph, String curr,
                                         String dest, Set<String> visited) {
        // graph traversal from curr to dest
        if (curr.equals(dest)) {
            return true;
        } else if (visited.contains(curr) || graph.get(curr) == null) {
            return false;
        }
        visited.add(curr);
        for (String team : graph.get(curr)) {
            if (isReachableDFS(graph, team, dest, visited)) {
                return true;
            }
        }
        return false;
    }

    public static Map<String, Set<String>> buildGraph(List<MatchResult> matches) {
        Map<String, Set<String>> graph = new HashMap<>();
        for (MatchResult match : matches) {
            Set<String> edges = graph.get(match.winningTeam);
            if (edges == null) {
                edges = new HashSet<>();
                graph.put(match.winningTeam, edges);
            }
            edges.add(match.losingteam);
        }
        return graph;
    }

    public static void test() {
        List<MatchResult> matches = new ArrayList<>();
        matches.add(new MatchResult("a", "b"));
        matches.add(new MatchResult("b", "e"));
        matches.add(new MatchResult("c", "f"));
        matches.add(new MatchResult("d", "a"));
        matches.add(new MatchResult("e", "f"));
        System.out.println("b beats f expected = true  result = " +
                canTeamABeatTeamB(matches, "b", "f"));
        System.out.println("d beats c expected = false  result = " +
                canTeamABeatTeamB(matches, "d", "c"));
    }

}
