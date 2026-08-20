
public class Main {
    public static void main(String[] args) {
        EhoBank bank = new EhoBank();

        try {
            System.out.println("Пробуем добавить кривое Эхо...");
            bank.addUniqueEcho(""); // Специально передаем пустоту, чтобы спровоцировать ошибку
        } catch (InvalidEchoException e) {
            // Программа не падает, а прыгает сюда
            System.out.println("Перехватили проблему: " + e.getMessage());
        }

        System.out.println("Программа не крашнулась и спокойно работает дальше!");
    }
}