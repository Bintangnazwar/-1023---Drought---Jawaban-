import java.util.*;

public class Drought1023{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int city = 1;

        while (true) {
            int n = sc.nextInt(); // Jumlah rumah di kota
            if (n == 0) break;

            TreeMap<Integer, Integer> map = new TreeMap<>(); // Key: konsumsi per orang, Value: jumlah orang
            int totalPeople = 0;
            int totalConsumption = 0;

            for (int i = 0; i < n; i++) {
                int people = sc.nextInt();
                int consumption = sc.nextInt();
                int avg = consumption / people; // dibulatkan ke bawah

                map.put(avg, map.getOrDefault(avg, 0) + people);
                totalPeople += people;
                totalConsumption += consumption;
            }

            if (city > 1) System.out.println(); // baris kosong antar kota
            System.out.println("Cidade# " + city + ":");

            StringBuilder output = new StringBuilder();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                output.append(entry.getValue()).append("-").append(entry.getKey()).append(" ");
            }
            System.out.println(output.toString().trim());

            double average = (double) totalConsumption / totalPeople;
            System.out.printf("Consumo medio: %.2f m3.%n", Math.floor(average * 100) / 100);

            city++;
        }

        sc.close();
    }
}