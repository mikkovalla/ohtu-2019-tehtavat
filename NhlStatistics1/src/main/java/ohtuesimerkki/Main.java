package ohtuesimerkki;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReader("https://nhlstatisticsforohtu.herokuapp.com/players.txt"));

        System.out.println("New York Rangers");
        for (Player player : stats.team("NYR")) {
            System.out.println(player);
        }

        System.out.println("");

        System.out.println("Top scorers");
        for (Player player : stats.topScorers(10)) {
            System.out.println(player);
        }
    }
}