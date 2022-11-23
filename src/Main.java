import java.util.Scanner;

public class Main {
    /*
    Java ile mesafeye ve şartlara göre uçak bileti fiyatı hesaplayan programı yapın.
    Kullanıcıdan Mesafe (KM), yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş) bilgilerini alın.
    Mesafe başına ücret 0,10 TL / km olarak alın.
    İlk olarak uçuşun toplam fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki indirimleri uygulayın ;
    Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
    Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.
    Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
    Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
    Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.
    Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.
     */

    public static void main(String[] args) {

        // Declare variables

        double flightDistance, ticketAmount = 0.0, fareForPerKm = 0.10;
        int customerAge, ticketType;
        boolean isError = false;

        // Create a new object
        Scanner input = new Scanner(System.in);

        // Prompt the user to input flight distance, age, ticket type 
        System.out.print(" Enter flight distance in KM : ");
        flightDistance = input.nextDouble();

        System.out.print(" Enter your age : ");
        customerAge = input.nextInt();

        System.out.print(" Enter ticket type (1 => One way, 2 => Round trip ) : ");
        ticketType = input.nextInt();

        ticketAmount = flightDistance * fareForPerKm;

        // calculate ticket amount according to ticket type
        switch (ticketType) {
            case 1:
                ticketAmount = ticketAmount;
                break;
            case 2:
                // For round trip apply 0.8 discount.
                ticketAmount *= 2 * 0.8;
                break;
            default:
                isError = true;
        }
            if (!isError) {
            if (0 < customerAge && customerAge < 12) {
                ticketAmount *= 0.5;
                System.out.println(" Ticket amount : " +ticketAmount + " TL");
            } else if (12 <= customerAge && customerAge < 24) {
                ticketAmount *= 0.9;
                System.out.println(" Ticket amount : " + ticketAmount + " TL");
            } else if (24 <= customerAge && customerAge < 65) {
                ticketAmount = ticketAmount;
                System.out.println(" Ticket amount : " + ticketAmount + " TL");
            } else if ( customerAge > 65) {
                ticketAmount *= 0.7;
                System.out.println(" Ticket amount : " + ticketAmount + " TL");
            } else {
                System.out.println(" Opps. You have entered the wrong info .");
            }
            } else {
            System.out.println(" Unfortunately, You have entered the wrong trip type. Please, enter 1 or 2. ");
        }
    }
}