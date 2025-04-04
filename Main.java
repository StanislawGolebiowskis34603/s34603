public class Main {
    public static void main(String[] args) {
        SklepKomputerowy sklep = new SklepKomputerowy();

        Produkt p1 = new Produkt();
        p1.setId(1); p1.setNazwa("Laptop Lenovo ThinkPad X1 Carbon");
        p1.setKategoria("Laptop"); p1.setCena(6799.99); p1.setIloscWMagazynie(10);  // nowa cena

        Produkt p2 = new Produkt();
        p2.setId(2); p2.setNazwa("Klawiatura mechaniczna Keychron K6");
        p2.setKategoria("Klawiatura"); p2.setCena(459.50); p2.setIloscWMagazynie(30);  // nowa cena

        Produkt p3 = new Produkt();
        p3.setId(3); p3.setNazwa("Monitor LG UltraFine 27\"");
        p3.setKategoria("Monitor"); p3.setCena(1899.00); p3.setIloscWMagazynie(15);  // nowa cena

        sklep.dodajProdukt(p1); sklep.dodajProdukt(p2); sklep.dodajProdukt(p3);

        Klient k1 = new Klient();
        k1.setId(1); k1.setImie("Jan"); k1.setNazwisko("Kowalski");
        k1.setEmail("jan@example.com"); k1.setCzyStaly(true);

        Klient k2 = new Klient();
        k2.setId(2); k2.setImie("Anna"); k2.setNazwisko("Nowak");
        k2.setEmail("anna@example.com"); k2.setCzyStaly(false);

        sklep.dodajKlienta(k1); sklep.dodajKlienta(k2);

        Zamowienie z1 = sklep.utworzZamowienie(k1, new Produkt[]{p1, p2}, new int[]{1, 1});
        z1.zastosujZnizke();
        sklep.aktualizujStanMagazynowy(z1);

        System.out.println("Informacje o zamówieniu:");
        z1.wyswietlSzczegoly();

        System.out.println("\nStan magazynowy po zamówieniu:");
        sklep.wyswietlProduktyWKategorii("Laptop");
        sklep.wyswietlProduktyWKategorii("Klawiatura");

        sklep.zmienStatusZamowienia(z1.getId(), "Zrealizowane");
        System.out.println("\nStatus zamówienia po aktualizacji:");
        z1.wyswietlSzczegoly();

        Zamowienie z2 = sklep.utworzZamowienie(k2, new Produkt[]{p3, p2}, new int[]{2, 1});
        sklep.aktualizujStanMagazynowy(z2);

        System.out.println("\nZamówienia klienta Jan Kowalski:");
        sklep.wyswietlZamowieniaKlienta(1);
    }
}
