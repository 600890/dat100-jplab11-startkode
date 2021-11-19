package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

    private static String TEKST = "TEKST";
    private static String BILDE = "BILDE";

    public static Blogg les(String mappe, String filnavn) {
        
        
            File file = new File(mappe + filnavn);
        try {
            Scanner reader = new Scanner(file);
        // les innhold i filen linje for linje
        
        int antall = Integer.parseInt(reader.nextLine());
        Blogg samling = new Blogg(antall);
        
        while (reader.hasNextLine()) {
            if(reader.nextLine().equals(TEKST)) {
                    int id = Integer.parseInt(reader.nextLine());
                    String bruker = reader.nextLine();
                    String dato = reader.nextLine();
                    int likes = Integer.parseInt(reader.nextLine());
                    String tekst = reader.nextLine();
                    Tekst innlegg = new Tekst(id, bruker, dato, likes, tekst);
                    samling.leggTil(innlegg);
            }else
                 {
                    int id = Integer.parseInt(reader.nextLine());
                    String bruker = reader.nextLine();
                    String dato = reader.nextLine();
                    int likes = Integer.parseInt(reader.nextLine());
                    String tekst = reader.nextLine();
                    String url = reader.nextLine();
                    Bilde innlegg = new Bilde(id, bruker, dato, likes, tekst, url);
                    samling.leggTil(innlegg);
                }
        
        }

        reader.close();
        return samling;
        }
        catch(FileNotFoundException e){
            System.out.println("Filnavn er feil");
            return null;
        }
        
    }
}