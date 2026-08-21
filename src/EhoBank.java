import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.TreeSet;

public class EhoBank {
    private HashSet<CaughtEcho> echoSet = new HashSet<>();

    private final String FILE_NAME = "echo_data.bin";

    public void addUniqueEcho(String echoName){
        if (echoName == null || echoName.isEmpty()) {
            throw new InvalidEchoException ("Error, echoName is null or empty");
        }
        CaughtEcho caughtEcho = new CaughtEcho(echoName, LocalDateTime.now());
        echoSet.add(caughtEcho);
    }
    public boolean isEchoCaught(String echoName){
        if (echoName == null || echoName.isEmpty()) {
            throw new IllegalArgumentException("Error, echoName is null or empty");
        }
        CaughtEcho dummy = new CaughtEcho(echoName, LocalDateTime.now());
        return echoSet.contains(dummy);
    }
    public int getCaughtEchoesCount(){
        return echoSet.size();
    }
    public void showAllEchoes(){
        if (echoSet.isEmpty()){
            System.out.println("No echoes found");
            return;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (CaughtEcho echoName : echoSet) {
            String name = echoName.getName();
            String formattedTime = echoName.getCatchTime().format(formatter);
            System.out.println(name + " [Пойман: " + formattedTime + "]");
        }
    }
    public void showSortedEchoes(){
        if (echoSet.isEmpty()){
            System.out.println("No echoes found");
            return;
        }
        TreeSet<CaughtEcho> sortedEchoSet = new TreeSet<>(echoSet);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (CaughtEcho echoName : sortedEchoSet) {
            String name = echoName.getName();
            String formattedTime = echoName.getCatchTime().format(formatter);
            System.out.println(name + " [Пойман: " + formattedTime + "]");
        }
    }

    public void saveData(){
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(echoSet);
            System.out.println("Successfully wrote echo data to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("File not found" + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadData(){
        try(FileInputStream fis = new FileInputStream(FILE_NAME);
        ObjectInputStream ois = new ObjectInputStream(fis)){

            echoSet = (HashSet<CaughtEcho>) ois.readObject();
        } catch (IOException | ClassNotFoundException e){
            System.out.println("Save not found, create empty inventory" + e.getMessage());
        }
    }
}
