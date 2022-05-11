package Cihaz;


public class KullaniciBilgileri {
    private String ad;
    private String soyAd;
    private String sifre;
    private boolean yetki;


    public KullaniciBilgileri(String ad,String sifre,boolean yetki)
    {
        this.ad=ad;
        this.soyAd=soyAd;
        this.sifre=sifre;
        this.yetki=yetki;
    }

    public String getAd() {
        return ad;
    }
    public String getSoyAd() {
        return soyAd;
    }
    public String getSifre() {
        return sifre;
    }
    public boolean getYetki() {
        return yetki;
    }

    public void setAd(String ad) {
        this.ad=ad;
    }
    public void setSoyAd(String soyAd) {
        this.soyAd=soyAd;
    }
    public void setSifre(String sifre) { this.sifre=sifre; }
    public void setYetki(boolean yetki) {
        this.yetki=yetki;
    }

    public String yetkiliMi(boolean yetkiVar)
    {
        if(yetkiVar==true)
            return "Yetkili Kullanici";
        else
            return "Yetkisiz Kullanici";
    }
    @Override
    public String toString() {
        return //"Kullanici Adi= " + ad +
                //", Kullanici Soyadi= " + soyAd +
                //", Kullanici Sifresi= " + sifre +
                // ", Kullanici Yetkisi= " +
                yetkiliMi(yetki) ;
    }


}