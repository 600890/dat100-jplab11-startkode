package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import no.hvl.dat100.jplab11.oppgave1.Innlegg;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

    public static boolean skriv(Blogg samling, String mappe, String filnavn)  {

        boolean ok = true;
        int antall = samling.getAntall();
        Innlegg[] a = samling.getSamling();
        String inn = antall + "\n";
        System.out.println(a[2]);
        for(int i = 0; i<antall; i++) {
            inn += a[i];
        }
        System.out.println(inn);
        try {
            PrintWriter skriver = new PrintWriter(mappe + filnavn);

                skriver.println(inn);
                skriver.close();


        } catch (FileNotFoundException e) {
            System.out.println("Filnavn ikke funnet");
            ok = false;
        }

        return ok;
    }
}