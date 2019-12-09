package statistics.querybuilder;

import java.util.ArrayDeque;
import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.PlaysIn;
import statistics.matcher.Or;

public class QueryBuilder {
    
    private ArrayDeque<Matcher> matcher;

    public QueryBuilder() {
        this.matcher = new ArrayDeque<>();
    }

    public Matcher build() {
        return this.matcher.isEmpty() ? new All() : new And(this.matcher.toArray(new Matcher[0]));
	}

    public QueryBuilder playsIn(String team) {
        this.matcher.add(new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
		this.matcher.add(new HasAtLeast(value, category));
		return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
		this.matcher.add(new HasFewerThan(value, category));
		return this;
    }
    
    public QueryBuilder oneOf(Matcher...matcher) {
        this.matcher.add(new Or(matcher));
        return this;
    }
}