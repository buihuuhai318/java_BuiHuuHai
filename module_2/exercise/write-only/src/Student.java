public class Student {
    private String name = "John";
    private String room = "C02";

    Student() {
    }

    protected void setName(String name) {
        this.name = name;
    }

    void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", room='" + room + '\'' +
                '}';
    }
}
