package Day08;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public record Vector(int x, int y) {}
    public static class Antinode {
        String frequency;
        Vector location;

        public Antinode(String frequency, Vector location) {
            this.frequency = frequency;
            this.location = location;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Antinode antinode = (Antinode) o;
            return Objects.equals(location, antinode.location);
        }

        @Override
        public int hashCode() {
            return Objects.hash(location);
        }

    }

    public static List<Antinode> calculateAntinodes(String input) {
        List<List<String >> map = parseInput(input);
        Map<String, List<Vector>> antennas = locateAntennas(map);
        Set<Antinode> antinodes = new HashSet<>();

        for (Map.Entry<String, List<Vector>> antenna : antennas.entrySet()) {
            antinodes.addAll(placeAntinode(antenna.getKey(), antenna.getValue()));
        }

        return antinodes.stream().filter(antinode -> {
            Vector location = antinode.location;
            if (location.y < 0) return false;
            if (location.y >= map.size()) return false;
            if (location.x < 0) return false;
            if (location.x >= map.getFirst().size()) return false;
            return true;
        }).toList();
    }

    private static List<List<String>> parseInput(String input) {
        return Arrays.stream(input.split("\n"))
                .map(row -> Arrays.stream(row.split(""))
                        .collect(Collectors.toCollection(ArrayList::new)))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static Map<String, List<Vector>> locateAntennas(List<List<String>> map) {
        Map<String, List<Vector>> antennas = new HashMap<>();
        for (int row = 0; row < map.size(); row++) {
            for (int column = 0; column < map.get(row).size(); column++) {
                String element = map.get(row).get(column);
                if (element.equals(".")) continue;
                antennas.putIfAbsent(element, new ArrayList<>());
                List<Vector> locations = antennas.get(element);
                locations.add(new Vector(column, row));
            }
        }
        return antennas;
    }

    private static Set<Antinode> placeAntinode(String frequency, List<Vector> locations) {
        Set<Antinode>  antinodes = new HashSet<>();
        for (int i = 0; i < locations.size(); i++) {
            for (int j = 0; j < locations.size(); j++) {
                if (i == j) continue;
                Vector current = locations.get(i);
                Vector target = locations.get(j);

                Vector relativeLocationToCurrent = subtractVectors(current, target);
                Vector location = addVectors(current, relativeLocationToCurrent);
                antinodes.add(new Antinode(frequency, location));
            }
        }
        return antinodes;
    }

    private static Vector subtractVectors(Vector current, Vector target) {
        return new Vector(current.x - target.x, current.y - target.y);
    }

    private static Vector addVectors(Vector current, Vector target) {
        return new Vector(current.x + target.x, current.y + target.y);
    }

    public static void main() {
        String part1Input = """
                ...............................6.B..........P.....
                n..............M..................................
                ....n.....sM7.............................6.....p.
                ......................Mr......................P...
                .......n.......................................p.E
                .......................6...................p......
                r..............................C........B....P....
                .....................d........6......B4....P......
                .........................7....................4...
                .n......................R..............4..........
                .....N........S.................K.C..........4....
                ...........N..r.....................B....K........
                ..................................................
                ......N.......x.............7.......K.....2....E..
                ...................r..H........R..................
                .....................s....p........C...........2..
                ....3.......................M.....................
                ........k....................H....5...............
                .....x....N................d.5..y................J
                m.....................d7...................J......
                .......exk........................................
                .......x.............5.......R....................
                ..........eY......................................
                ...S.3..............................O.E...J.......
                .......8...H....k...............J.................
                ......S.e.........C.H.....................X.....y.
                ................j..........y.........2............
                ...........e.........k............................
                ......YS...3..............5..........K...XR.......
                ...m..............j.s..........c..................
                .........................j........................
                ...............j..................................
                .....m................................2...........
                .........Y......................................b.
                ..................................................
                .......................h...........b..............
                ............m......D..............d...............
                ........o......D..................................
                ...................................O..............
                ..................................................
                ......8...........................................
                ........D.Y..o...................1................
                .....................................b..9.........
                ........................h..0......................
                .....o......................h..0........b1........
                .........8.............X..........................
                ..........o..........c..........1...........O.....
                ....8....................y0...c...................
                ..............D.......c..................9..0.....
                ............................1..........O..9.......
                """;
        System.out.println(calculateAntinodes(part1Input).size());
    }
}
