package transkop.tracking.utils.convertors;

public class DecimalConverter {

    public static String toDotriacontatetra(long decimal){
        char chars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int rem;
        String hex="";
        while(decimal>0)
        {
            rem=(int)decimal%36;
            hex=chars[rem]+hex;
            decimal=decimal/36;
        }
        return hex;
    }
}
