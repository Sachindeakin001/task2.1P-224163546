package sit707_week2;

/**
 * Hello world!
 * @author Ahsan Habib
 */
public class Main 
{
    public static void main(String[] args) {
        // Open the OfficeWorks registration page and simulate form submission
        System.out.println("Starting OfficeWorks registration automation...");
        SeleniumOperations.officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");

        // Open the chemist warehouse registration page and simulate form submission
        System.out.println("Starting chemist warehouse ...");
        SeleniumOperations.chemist_warehouse_registration_page("https://www.chemistwarehouse.com.au/login");
        
        // Add any additional steps you need here
        System.out.println("Registration automation for both sites is complete.");
    }
}
