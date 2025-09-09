package myproject.objs;

import com.github.javafaker.Faker;
import java.util.Random;

public class FakeUserData {
    String First_Name;
    String Last_Name;
    String Address;
    String City;
    String State;
    String Zip_Code;
    String Phone;
    String SSN;

    String Username;
    String Password;

    Faker faker;
    public FakeUserData(){
        Random random=new Random();
        this.faker=new Faker();
        this.First_Name=this.faker.name().firstName();
        this.Last_Name=this.faker.name().lastName();
        this.Address=this.faker.address().streetAddress();
        this.City=this.faker.address().city();
        this.State=this.faker.address().state();
        this.Zip_Code=this.faker.address().zipCode().replaceAll("[-]","");
        this.Phone=this.faker.phoneNumber().phoneNumber().replaceAll("[-().Xx\\s]","");
        this.SSN=this.faker.idNumber().ssnValid().replaceAll("[-\\s]", "");
        this.Username=this.faker.name().username().replaceAll("[.]","")+random.nextInt(100000,300000);
        this.Password=this.Username;//this.faker.internet().password(8,10);
    }

    @Override
    public String toString() {
        return "registerData{" +
                "First_Name='" + First_Name + '\'' +
                ", Last_Name='" + Last_Name + '\'' +
                ", Address='" + Address + '\'' +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                ", Zip_Code='" + Zip_Code + '\'' +
                ", Phone='" + Phone + '\'' +
                ", SSN='" + SSN + '\'' +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getCity() {
        return City;
    }

    public String getState() {
        return State;
    }

    public String getZip_Code() {
        return Zip_Code;
    }

    public String getPhone() {
        return Phone;
    }

    public String getSSN() {
        return SSN;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }
}
