package database;

import Cihaz.*;

import java.sql.*;

public class AkilliCihazPostgreSQL implements ISirketBilgiSistemi {

    private Connection baglan(){
        Connection conn=null;
        try{
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/akilliCihaz","postgres","432432");
           /* if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    @Override
    public KullaniciBilgileri kullaniciDogrula(String kullaniciAdi, String kullaniciSifre){
        KullaniciBilgileri kullanici=null;
        String sql= "SELECT \"kullaniciAdi\",\"kullaniciSoyAdi\",\"sifre\",\"yetki\" FROM \"kullanicilar\" WHERE \"kullaniciAdi\"='"+kullaniciAdi+"'";

        Connection conn=this.baglan();
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //***** Bağlantı sonlandırma *****
            conn.close();

            String ad;

            String sifre;
            boolean yetki;

            while(rs.next())
            {
                ad  = rs.getString("kullaniciAdi");

                sifre  = rs.getString("sifre");
                yetki  = rs.getBoolean("yetki");

                //giris yapilan kullanicinin sifresi kontrol ediliyor, yanlis sifre girilirse hata mesaji ekrana basiliyor
                if(kullaniciSifre.equals(sifre))
                    kullanici=new KullaniciBilgileri(ad, sifre,yetki);
                else
                    System.out.println("Hatali Sifre!");
            }
            rs.close();
            stmt.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return kullanici;

    }




}