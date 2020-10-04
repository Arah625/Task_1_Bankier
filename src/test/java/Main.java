

public class Main {

    public static void main(String[] args) {
        //Connecting to database
        DbConnector.goldDbConncect();
        //Setting up webdriver
        GoldPriceImporter.driverSetup();
        //importing gold price from website www.bankier.pl
        GoldPriceImporter.priceImport();
        //Displaying gold price
        PriceDisplay.displayCurrentPrice();
        //Closing all browser windows
        GoldPriceImporter.driverQuit();
        //Exporting current gold price and current time into table in database
        QueryExecutor.exportToDatabase();

    }
}

