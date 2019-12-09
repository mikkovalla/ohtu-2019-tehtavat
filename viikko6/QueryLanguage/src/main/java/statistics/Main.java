package statistics;

import statistics.matcher.*;
import statistics.querybuilder.QueryBuilder;

public class Main {
    public static void main(String[] args) {
        // seuraavassa osoitteessa 27.11.2019 päivitetyt tilastot
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";
        // ajan tasalla olevat tilastot osoitteessa
        // "https://nhlstatisticsforohtu.herokuapp.com/players.txt"

        Statistics stats = new Statistics(new PlayerReaderImpl(url));

        QueryBuilder query = new QueryBuilder();
 
        Matcher m = query.playsIn("NYR").hasAtLeast(5, "goals").hasFewerThan(7, "goals").build();
        
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
