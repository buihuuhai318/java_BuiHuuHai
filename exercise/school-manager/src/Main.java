public class Main {
    public static void main(String[] args) {
        UnivercityManager.humansArrayList.add(new Student("Hải", "11/22/3333", true, "C0423G1", 8));
        UnivercityManager.humansArrayList.add(new Student("Sang", "11/22/3333", true, "C0423G1", 8));
        UnivercityManager.humansArrayList.add(new Student("Thiện", "11/22/3333", true, "C0423G1", 8));
        UnivercityManager.humansArrayList.add(new Student("Nguyên", "11/22/3333", true, "C0423G1", 8));
        UnivercityManager.humansArrayList.add(new Student());
        UnivercityManager.humansArrayList.add(new Teacher("Quang" , "11/22/3333", true, "Java"));
        UnivercityManager.humansArrayList.add(new Teacher("Trung" , "11/22/3333", true, "Java"));
        UnivercityManager.humansArrayList.add(new Teacher("Hải" , "11/22/3333", true, "Java"));
        UnivercityManager.humansArrayList.add(new Teacher("Chánh" , "11/22/3333", true, "Java"));
        UnivercityManager.menu();
    }
}