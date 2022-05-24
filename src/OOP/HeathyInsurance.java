package OOP;

import java.text.ParseException;
import java.time.LocalDate;

public class HeathyInsurance extends Insurance implements Due{

    @Override
    public void startDay() throws ParseException {
        LocalDate currentDay =  LocalDate.now();
        System.out.println(currentDay.now());
    }

    @Override
    public void endDay() {
        System.out.println("2030-10-14");
    }



    @Override
    public void priceInsurance(){
        System.out.println("The HeathyInsurance have price 5000$ for person with name: "+ this.getName());
    }

    public HeathyInsurance(String name, int yearOfBirth, String address) {
        super(name, yearOfBirth, address);
    }

    public HeathyInsurance() {
    }
}
