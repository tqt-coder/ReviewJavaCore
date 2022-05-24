package OOP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class LifeInsurance extends Insurance implements Due{

    @Override
    public void startDay() throws ParseException {
        LocalDate currentDay =  LocalDate.now();
        System.out.println(currentDay.now());
    }

    @Override
    public void endDay() {
        System.out.println("2022-10-14");
    }



    @Override
    public void priceInsurance(){
        System.out.println("The LifeInsurance have price 2000$ for person with name: "+ this.getName());
    }

    public LifeInsurance(String name, int yearOfBirth, String address) {
        super(name, yearOfBirth, address);
    }

    public LifeInsurance() {
    }
}
