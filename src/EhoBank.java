import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.TreeSet;

public class EhoBank {
    private HashSet<CaughtEcho> echoSet = new HashSet<>();

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
}
