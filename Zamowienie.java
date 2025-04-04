public class Zamowienie {
    private int id;
    private Klient klient;
    private Produkt[] produkty;
    private int[] ilosci;
    private String dataZamowienia;
    private String status;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Klient getKlient() { return klient; }
    public void setKlient(Klient klient) { this.klient = klient; }

    public Produkt[] getProdukty() { return produkty; }
    public void setProdukty(Produkt[] produkty) { this.produkty = produkty; }

    public int[] getIlosci() { return ilosci; }
    public void setIlosci(int[] ilosci) { this.ilosci = ilosci; }

    public String getDataZamowienia() { return dataZamowienia; }
    public void setDataZamowienia(String data) { this.dataZamowienia = data; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double obliczWartoscZamowienia() {
        double suma = 0;
        for (int i = 0; i < produkty.length; i++) {
            suma += produkty[i].getCena() * ilosci[i];
        }
        return suma;
    }

    public void zastosujZnizke() {
        if (klient.isCzyStaly()) {
            for (int i = 0; i < produkty.length; i++) {
                double cena = produkty[i].getCena();
                produkty[i].setCena(cena * 0.9);
            }
        }
    }

    public void wyswietlSzczegoly() {
        System.out.println("Zamówienie ID: " + id + " | Data: " + dataZamowienia + " | Status: " + status);
        klient.wyswietlInformacje();
        System.out.println("Produkty:");
        for (int i = 0; i < produkty.length; i++) {
            System.out.println("- " + produkty[i].getNazwa() + " x" + ilosci[i] + " = " + produkty[i].getCena() * ilosci[i] + " zł");
        }
        System.out.println("Łączna wartość: " + obliczWartoscZamowienia() + " zł");
    }
}