package model;

public class Player {
    private String id;
    private String name;
    private String birthday;
    private String address;
    private String club;

    public Player() {
    }

    public Player(String id, String name, String birthday, String address, String club) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.club = club;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", club='" + club + '\'' +
                '}';
    }

    public String infoToFile() {
        return id + "," + name + "," + birthday + "," + address + "," + club;
    }
}
