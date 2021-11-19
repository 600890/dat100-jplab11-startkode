package no.hvl.dat100.jplab11.oppgave3;


import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import java.util.*;

public class Blogg {
    private Innlegg[] innleggtabell;
    private int nesteledig;

    public Blogg() {
        innleggtabell = new Innlegg[20];
        nesteledig = 0;
    }

    public Blogg(int lengde) {
        innleggtabell = new Innlegg[lengde];
        nesteledig = 0;
    }

    public int getAntall() {
        return nesteledig;
    }
    
    public Innlegg[] getSamling() {
    return innleggtabell;

    }
    
    public int finnInnlegg(Innlegg innlegg) {
        boolean funnet = false;
        int pos = 0;
        while(!funnet && pos<nesteledig) {
            if(innleggtabell[pos].erLik(innlegg)) {
                funnet = true;
            }else {
                pos++;
            }
        }
        if(funnet)
            return pos;
                    
        else
            return -1;
    }

    public boolean finnes(Innlegg innlegg) {
        if(finnInnlegg(innlegg)>-1)
            return true;
        
        else 
            return false;
    }

    public boolean ledigPlass() {
        if(nesteledig >= innleggtabell.length)
            return false;
        else
            return true;

    }
    
    public boolean leggTil(Innlegg innlegg) {
        boolean ny = finnInnlegg(innlegg) == -1;
        if(ny && ledigPlass()) {
            innleggtabell[nesteledig] = innlegg;
            nesteledig++;
            return true;
        }else
            return false;
    
    }
    
    public String toString() {
        String ut = nesteledig + "\n";
        for(int i = 0; i<innleggtabell.length; i++) {
            ut += innleggtabell[i].toString();
        }
        return ut;
    }

    // valgfrie oppgaver nedenfor
    
    public void utvid() {
        innleggtabell = Arrays.copyOf(innleggtabell, nesteledig*2);
    }
    
    public boolean leggTilUtvid(Innlegg innlegg) {
        boolean ny = finnInnlegg(innlegg) == -1;
        if(ny && ledigPlass()) {
            innleggtabell[nesteledig] = innlegg;
            nesteledig++;
            return true;
        }else
            return false;
        
    }
    
    public boolean slett(Innlegg innlegg) {
        int pos = finnInnlegg(innlegg);
        if(pos > -1) {
            nesteledig--;
            innleggtabell[pos] = innleggtabell[nesteledig];
            innleggtabell[nesteledig] = null;
            
            return true;
        }
        else {
            return false;
        }
    }
    

    
    public int[] search(String keyword) {
        String sokeStreng = keyword;
        for(int i = 0; i<nesteledig; i++) {
            if(innleggtabell[i].getBruker().contains(keyword)) {
                return null;
            }
                
            }
        return null;
        }    
}