import org.junit.jupiter.api.Test;

import java.sql.*;

public class QueryExecutor {

    @Test
    public static void exportToDatabase() {
        //Parsing value imported from website
        String stringToFloat = String.valueOf(GoldPriceImporter.goldPrice).replace("USD/uncja", "").replace(" ", "").replace(",", ".");
        float currentGoldPrice = Float.parseFloat(stringToFloat);
        //Creating timestamp
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        String query = "INSERT INTO public.gold_rate_table(\"price\", \"price_date\") VALUES(?,?)";
        //Creating PreparedStatement
        PreparedStatement pstmt;
        try {
            pstmt = DbConnector.goldDbConncect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setFloat(1, currentGoldPrice);
            pstmt.setTimestamp(2, currentTime);

            pstmt.execute();

            ResultSet rs = pstmt.getGeneratedKeys();

            int idValue = 0;
            if (rs.next()) {
                idValue = rs.getInt(1);
            }
            System.out.println("price_id: " + idValue);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
