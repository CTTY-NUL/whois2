package novi.basics;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws Exception{
//dsfsdasdgh
        Socket s = new Socket("whois.internic.net",43);

        OutputStream os = s.getOutputStream();
        String domain = "google.com"+"\n";
        byte[] stringToByte = domain.getBytes();
        os.write(stringToByte);

        InputStream is = s.getInputStream();
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader buf = new BufferedReader(reader);

        String temp;
        while((temp=buf.readLine())!="\n" && (temp=buf.readLine())!= null ){
//        while((temp=buf.readLine())!="\n" && (temp=buf.readLine())!= null && (temp=buf.readLine())!= ""){
//            System.out.println("111" + temp + "111");

            if (temp != null) {
                System.out.println(temp);
            }

            if (temp.contains("Registrars.")) {
                //ik probeer de regels die Registrars bevat the matchen maar als ik em kopieer naar t klembord en dat probeer te matchen werkt dat niet
                StringSelection selection = new StringSelection(temp);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(selection, selection);
                System.out.println("mja hij bevat het wel... maar hoe kan ik het precies matchen");

//                char c = 'a';
//                String a = Integer.toHexString(c);
                String zz = temp;
                for (int i = 0; i < zz.length(); i++){
                    char c = zz.charAt(i);
                    String a = Integer.toHexString(c);
                    System.out.print(a + " ");
                }
                System.out.println();
                //TODO Nick vragen waarom er -2 en -1  en 0 staat bij de UTF-16
                byte [] array2 = temp.getBytes("UTF-16");
                for(byte b1: array2){
                    System.out.print(b1 + " ");
                }

                System.out.println();
                byte [] array = temp.getBytes("UTF-8");
                for(byte b2: array){
                    System.out.print(b2 + " ");
                }
            }

            if (temp == "Registrars."){
                //TODO geen idee waarom ik deze niet krijg, heb al \r\n etc toegevoegd
                System.out.println("WAAROM KRIJG IK DEZE NIET!-------------------------------------------------------");
            }


        }

    }
}

