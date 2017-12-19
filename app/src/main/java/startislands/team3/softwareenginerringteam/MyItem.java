package startislands.team3.softwareenginerringteam;

public class MyItem {

    private String PAYMENT_time;
    private String PAYMENT_method;
    private String PAYMENT_total_price;
    private String PAYMENT_date;
    private String PAYMENT_number;

    public String getTime(){
        return PAYMENT_time;
    }
    public void setTime(String time){
        this.PAYMENT_time = time;
    }

    public String getMethod(){
        return PAYMENT_method;
    }
    public void setMethod(String method){
        this.PAYMENT_method = method;
    }

    public String getTotalPrice(){
        return PAYMENT_total_price;
    }
    public void setTotalPrice(String TotalPrice){
        this.PAYMENT_total_price = TotalPrice;
    }

    public String getDate(){
        return PAYMENT_date;
    }
    public void setDate(String date){
        this.PAYMENT_date = date;
    }

    public String getNumber(){
        return PAYMENT_number;
    }
    public void setNumber(String number){
        this.PAYMENT_number = number;
    }

}