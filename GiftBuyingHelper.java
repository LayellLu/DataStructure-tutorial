import java.io.*;

public class GiftBuyingHelper {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\FamilyMembers.txt");
        File file1 = new File("D:\\ShoppingList.txt");
        if (file1.exists()){
            file1.createNewFile();
        }
        BufferedReader reader = null;
        FileOutputStream fos=null;
        String tempString = null;
        int line = 1;
        int watch=0;
        int Necklace=0;
        int ipad=0;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
            fos=new FileOutputStream(file1);
            while ((tempString = reader.readLine()) != null) {
                String[] s = tempString.split("\\s");
                if (!"E".equals(s[0])&&!"I".equals(s[0])){
                    throw new InvalidTypeException("error message");
                }
                String age=s[3];
                String giftName="";
                if ("E".equals(s[0])&&Integer.valueOf(age)<=20){
                    giftName="Necklace";
                    Necklace++;
                }else if ("I".equals(s[0])&&Integer.valueOf(age)>=20&&Integer.valueOf(age)<=30){
                    giftName="iPad";
                    ipad++;
                }else {
                    giftName="Watch";
                    watch++;
                }

                String s1=s[2]+" "+s[1]+" "+giftName+"\n";
                fos.write(s1.getBytes());

                line++;
            }
            fos.write(("Watch:"+watch+"\n").getBytes());
            fos.write(("Necklace:"+Necklace+"\n").getBytes());
            fos.write(("iPad:"+ipad+"\n").getBytes());
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidTypeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
