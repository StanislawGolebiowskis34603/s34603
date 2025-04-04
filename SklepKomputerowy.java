import java.util.ArrayList;
import java.util.List;

public class SklepKomputerowy {
    private List<Produkt> produkty = new ArrayList<>();
    private List<Klient> klienci = new ArrayList<>();
    private List<Zamowienie> zamowienia = new ArrayList<>();
    private int licznikZamowien = 1;

    public void dodajProdukt(Produkt p) {
        produkty.add(p);
    }

    public void dodajKlienta(Klient k) {
        klienci.add(k);
    }

    public Zamowienie utworzZamowienie(Klient klient, Produkt[] produkty, int[] ilosci) {
        Zamowienie z = new Zamowienie();
        z.setId(licznikZamowien++);
        z.setKlient(klient);
        z.setProdukty(produkty);
        z.setIlosci(ilosci);
        z.setDataZamowienia(java.time.LocalDate.now().toString());
        z.setStatus("Nowe");
        zamowienia.add(z);
        return z;
    }

    public void aktualizujStanMagazynowy(Zamowienie z) {
        for (int i = 0; i < z.getProdukty().length; i++) {
            Produkt p = z.getProdukty()[i];
            int ilosc = z.getIlosci()[i];
            p.setIloscWMagazynie(p.getIloscWMagazynie() - ilosc);
        }
    }

    public void zmienStatusZamowienia(int id, String nowyStatus) {
        for (Zamowienie z : zamowienia) {
            if (z.getId() == id) {
                z.setStatus(nowyStatus);
            }
        }
    }

    public void wyswietlProduktyWKategorii(String kategoria) {
        for (Produkt p : produkty) {
            if (p.getKategoria().equalsIgnoreCase(kategoria)) {
                p.wyswietlInformacje();
            }
        }
    }

    public void wyswietlZamowieniaKlienta(int idKlienta) {
        for (Zamowienie z : zamowienia) {
            if (z.getKlient().getId() == idKlienta) {
                z.wyswietlSzczegoly();
                System.out.println();
            }
        }
    }
}