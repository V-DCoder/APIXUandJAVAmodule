package temp;

public class Ticket {

    char name;
    char[] dependancy;

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public char[] getDependancy() {
        return dependancy;
    }

    public void setDependancy(char[] dependancy) {
        this.dependancy = dependancy;
    }

    public Ticket(char name, char[] dependancy) {
        this.name = name;
        this.dependancy = dependancy;
    }

    public Ticket(){}
}
