package testing;

public class Listing {
    String price;
    String description;
    String id;

    Listing(String pPrice, String pDiscription, String pID)
    {
       //26
        price =  pPrice.substring(26, pPrice.length()-1);
        description = pDiscription;
        id = pID;
    }

    public String WritetoFile()
    {
        String content = "Price: \""+price  +"\n"+ description +"\n" + id +"\n"+ "URL: https://www.facebook.com/marketplace/item/" + id.substring(6, id.length()-2) + "/"+"\n\n";


        return content;
    }

}
