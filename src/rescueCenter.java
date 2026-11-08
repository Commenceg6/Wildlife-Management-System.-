class RescueCenter {
    private String enclosure;
    private String location;

    public RescueCenter(String enclosure, String location) {
        this.enclosure = enclosure;
        this.location = location;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Rescue Center Information:" +
                "\n- Enclosure: " + enclosure +
                "\n- Location: " + location;
    }

    public static void main(String[] args) {
        RescueCenter rescueCenter = new RescueCenter("Enclosure A", "Chinhoyi");
        System.out.println(rescueCenter);
    }
}