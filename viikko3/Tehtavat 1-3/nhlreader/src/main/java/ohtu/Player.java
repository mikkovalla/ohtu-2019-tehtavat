
package ohtu;

public class Player implements Comparable<Player>{
    private String name;
    private String nationality;
    private String team;
    private int goals;
    private int assists;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(String team) {
        this.team = team;
    }

    /**
     * @param goals the goals to set
     */
    public void setGoals(int goals) {
        this.goals = goals;
    }

    /**
     * @param assists the assists to set
     */
    public void setAssists(int assists) {
        this.assists = assists;
    }

    /**
     * @return the nationality
     */
    public String getNationality() {
        return this.nationality;
    }

    /**
     * @return the team
     */
    public String getTeam() {
        return this.team;
    }

    /**
     * @return the goals
     */
    public int getGoals() {
        return this.goals;
    }

    /**
     * @return the assists
     */
    public int getAssists() {
        return this.assists;
    }

    @Override
    public String toString() {
        return this.name + " | " + this.team + " > " + this.goals + " + " + this.assists + " = " + this.getPoints();
    }

    public int getPoints() {
        return this.goals + this.assists;
    }
      
    @Override
    public int compareTo(Player o) {
        return Integer.compare(o.getPoints(), o.getPoints());
    }
}
