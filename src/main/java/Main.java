import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        int speed;
        Race race = new Race();
        for (int i = 1; i<=3; i++) {
            System.out.println("— Введите название машины №" + i +":");
            name = scanner.nextLine();
            while (true) {
                System.out.println("— Введите скорость машины №" + i +":");
                String input = scanner.nextLine();
                try {
                    speed = Integer.parseInt(input.trim());
                    if (speed > 0 && speed <=250) {
                        break;
                    } else {
                        System.out.println("— Неправильная скорость");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("— Неверный формат числа");
                }
            }
            Car car = new Car(name, speed);
            race.addParticipant(car);
        }
        race.defineLeader();
        System.out.println(race);
    }
}