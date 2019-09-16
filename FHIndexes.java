package nhs.cardiff.genetics.ngssamplesheets;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Sara Rey
 * @Date 22/08/2019
 * @version 1.4.9
 *
 */

public class FHIndexes {

    //All available indices used for Familial Hypercholesterolaemia

    private static final LinkedHashMap<String, String> FhIndices = new LinkedHashMap<String, String>(){{
        put("1", "AACGTGAT");
        put("2", "AAACATCG");
        put("3", "AGTGGTCA");
        put("4", "ACCACTGT");
        put("5", "GATAGACA");
        put("6", "GTGTTCTA");
        put("7", "TGGAACAA");
        put("8", "TGGTGGTA");
        put("9", "ACATTGGC");
        put("10", "CAGATCTG");
        put("11", "CATCAAGT");
        put("12", "AGTACAAG");
        put("13", "AGATCGCA");
        put("14", "GACTAGTA");
        put("15", "GGTGCGAA");
        put("16", "TGAAGAGA");
        put("17", "AATGCGCT");
        put("18", "GACGGCGC");
        put("19", "TTAGCTCC");
        put("20", "GTTCAATC");
        put("21", "GAAAGGAT");
        put("22", "AGTTCCGC");
        put("23", "ACGATCGT");
        put("24", "CGCCTGAG");
        put("25", "TTACCCTG");
        put("26", "TTCGACGA");
        put("27", "TCTAGTAC");
        put("28", "AGTCGGAA");
        put("29", "ATTAGCGC");
        put("30", "GACTACTT");
        put("31", "ACGTATAT");
        put("32", "AAAGTTCT");
        put("33", "ACTGTAAT");
        put("34", "ATTCTACT");
        put("35", "TGACCTGA");
        put("36", "GCCTAAGG");
        put("37", "ACTCGCTT");
        put("38", "GCGGCGCA");
        put("39", "GGAGCGAC");
        put("40", "AGCATGTA");
        put("41", "ACGGGGAA");
        put("42", "ACGATGAT");
        put("43", "TAGCAGCT");
        put("44", "TGCGAGCC");
        put("45", "GGCATATC");
        put("46", "CTTGAATC");
        put("47", "CGCTCAGT");
        put("48", "GAACTCGT");

    }};

    /**
     *
     * @return Returns fhIndices all of the possible keys and indexes for the familial hypercholesterolaemia panel
     */
    public LinkedHashMap<String, String> getFhIndices() { return FhIndices; }




}
