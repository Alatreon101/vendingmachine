public enum Drink {


    JUICE(1, "Сок", 30),
    WATER(2, "Вода", 20);

    private final int number;

    private String description;
    private double cost;

    Drink(int number, String description, double cost) {
        this.number = number;
        this.description = description;
        this.cost = cost;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number + " - " + description + ": " + cost + "руб";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}