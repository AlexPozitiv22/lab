package s1;

public class City {
    private static int id;
    private static int stateId;
    private static String name;


    public City(int id, String name, int stateId) {
        this.id = id;
        this.name = name;
        this.stateId = stateId;
    }

    public City(String name, int stateId) {
        this.name = name;
        this.stateId = stateId;
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }
}
