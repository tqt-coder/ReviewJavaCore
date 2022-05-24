package OOP;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        boolean i = true;
        do{
            System.out.println("------------- Welcome you to come we serive insurance --------------");
            System.out.println("------------- Press 1: Lift Insurance --------------");
            System.out.println("------------- Press 2: Heathy Insurance --------------");
            System.out.println("------------- Press 3: Exit program --------------");
            System.out.println("------------- Please your opotion --------------");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();

            boolean flag  = true;
            switch (option){
                case 1:
                    heathyInsurance();
                    break;
                case 2:
                    lifeInsurance();
                    break;
                case 3:
                    flag = false;
            }
            if(!flag) {
                System.out.println("=====^^ Thank you ^^=====");
                break;
            }
        }while(i);



    }

    private static void lifeInsurance() throws ParseException {
        LifeInsurance lifeInsurance = new LifeInsurance();
        lifeInsurance.name= "Nguyen A";
        lifeInsurance.yearOfBirth = 2001;
        lifeInsurance.address= "Ho Chi Minh";

        lifeInsurance.priceInsurance();

        System.out.println("Due from ");
        lifeInsurance.startDay();
        lifeInsurance.endDay();
    }

    private static void heathyInsurance() throws ParseException {
        HeathyInsurance lifeInsurance = new HeathyInsurance();
        lifeInsurance.name= "Nguyen B";
        lifeInsurance.yearOfBirth = 2011;
        lifeInsurance.address= "Ha Noi";

        lifeInsurance.priceInsurance();

        System.out.println("Due from ");
        lifeInsurance.startDay();
        lifeInsurance.endDay();
    }
}
