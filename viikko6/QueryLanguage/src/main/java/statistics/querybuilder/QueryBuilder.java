package statistics.querybuilder;

import java.util.ArrayDeque;
import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.PlaysIn;
import statistics.Player;

public class QueryBuilder {
    
    private ArrayDeque<Matcher> matcher;

    public QueryBuilder() {
        this.matcher = new ArrayDeque<>();
    }

    private QueryBuilder queryBuilder() {
        return new QueryBuilder();
    }

    public Matcher build() {
        return this.matcher.isEmpty() ? new All() : new And(this.matcher.toArray(new Matcher[0]));
	}

    public QueryBuilder playsIn(String team) {
    this.matcher.add(new PlaysIn(team));
    return this;
    }

}