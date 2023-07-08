package s13_14_15_16_17.repository;

import s13_14_15_16_17.model.TargetList;
import s13_14_15_16_17.util.ReadAnhWrite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Repository {
    static List<TargetList> targetLists = new ArrayList<>();

    static ReadAnhWrite readAnhWrite = new ReadAnhWrite();

    static {
//        targetLists.add(new TargetList("a ăn nhậu", "20-06-2023", 100, "oke"));
//        targetLists.add(new TargetList("b ăn nhậu", "20-06-2023", 100, "oke"));
//        targetLists.add(new TargetList("c ăn nhậu", "20-06-2023", 2000, "oke"));
//        targetLists.add(new TargetList("d ăn nhậu", "20-06-2023", 1000, "oke"));
//        targetLists.add(new TargetList("e ăn nhậu", "20-06-2023", 1000, "oke"));
//        Collections.sort(targetLists);
//        List<String> stringList = new ArrayList<>();
//        for (TargetList targetList : targetLists) {
//            stringList.add(targetList.getId() + "," +
//                    targetList.getName() + "," +
//                    targetList.getDate() + "," +
//                    targetList.getMoney() + "," +
//                    targetList.getDescription());
//        }
//        System.out.println(stringList);
//        readAnhWrite.writeFile(ReadAnhWrite.PATH_FILE, stringList, false);
    }

    public List<String> change() {
        List<String> stringList = new ArrayList<>();
        for (TargetList targetList : targetLists) {
            stringList.add(targetList.getId() + "," +
                    targetList.getName() + "," +
                    targetList.getDate() + "," +
                    targetList.getMoney() + "," +
                    targetList.getDescription());
        }
        return stringList;
    }

    public void display() {
        List<TargetList> list = readAnhWrite.readFileBinary(ReadAnhWrite.PATH_FILE_BINARY);
        for (TargetList targetList : list) {
            System.out.println(targetList);
        }
//        readAnhWrite.writeFileBinary(ReadAnhWrite.PATH_FILE_BINARY, readFile());
    }

    public List<TargetList> readFile() {
        List<String> stringList = readAnhWrite.readFile(ReadAnhWrite.PATH_FILE);
        targetLists.clear();
        for (int i = 0; i < stringList.size(); i++) {
            String[] line = stringList.get(i).split(",");
            targetLists.add(new TargetList(Integer.parseInt(line[0]), line[1], line[2], Integer.parseInt(line[3]), line[4]));
        }
        return targetLists;
    }

    public int searchId(int id) {

        for (int i = 0; i < targetLists.size(); i++) {
            if (targetLists.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void addNew(TargetList targetList) {
        targetLists.add(targetList);
        List<String> stringList = change();
        readAnhWrite.writeFile(ReadAnhWrite.PATH_FILE, stringList, false);
    }

    public void remove(int index) {
        System.out.println(targetLists.get(index));
        targetLists.remove(index);
    }

    public void edit(int index, TargetList targetList) {

    }
}
