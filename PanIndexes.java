package nhs.cardiff.genetics.ngssamplesheets;

/**
 * @author Rhys Cooper & Sara Rey
 * @Date 13/06/2019
 * @version 1.4.5
 *
 */

import java.util.LinkedHashMap;
import java.util.Arrays;
import java.util.List;

public class PanIndexes {
    //All available indices used for PanCancer

    private static final LinkedHashMap<String, List<String>> panIndices = new LinkedHashMap<String, List<String>>(){{
        put("A1",Arrays.asList("ATTACTCG","AGGCTATA"));
        put("A2",Arrays.asList("TCCGGAGA","AGGCTATA"));
        put("A3",Arrays.asList("CGCTCATT","AGGCTATA"));
        put("A4",Arrays.asList("GAGATTCC","AGGCTATA"));
        put("A5",Arrays.asList("ATTCAGAA","AGGCTATA"));
        put("A6",Arrays.asList("GAATTCGT","AGGCTATA"));
        put("A7",Arrays.asList("CTGAAGCT","AGGCTATA"));
        put("A8",Arrays.asList("TAATGCGC","AGGCTATA"));
        put("A9",Arrays.asList("CGGCTATG","AGGCTATA"));
        put("A10",Arrays.asList("TCCGCGAA","AGGCTATA"));
        put("A11",Arrays.asList("TCTCGCGC","AGGCTATA"));
        put("A12",Arrays.asList("AGCGATAG","AGGCTATA"));
        put("B1",Arrays.asList("ATTACTCG","GCCTCTAT"));
        put("B2",Arrays.asList("TCCGGAGA","GCCTCTAT"));
        put("B3",Arrays.asList("CGCTCATT","GCCTCTAT"));
        put("B4",Arrays.asList("GAGATTCC","GCCTCTAT"));
        put("B5",Arrays.asList("ATTCAGAA","GCCTCTAT"));
        put("B6",Arrays.asList("GAATTCGT","GCCTCTAT"));
        put("B7",Arrays.asList("CTGAAGCT","GCCTCTAT"));
        put("B8",Arrays.asList("TAATGCGC","GCCTCTAT"));
        put("B9",Arrays.asList("CGGCTATG","GCCTCTAT"));
        put("B10",Arrays.asList("TCCGCGAA","GCCTCTAT"));
        put("B11",Arrays.asList("TCTCGCGC","GCCTCTAT"));
        put("B12",Arrays.asList("AGCGATAG","GCCTCTAT"));
        put("C1",Arrays.asList("ATTACTCG","AGGATAGG"));
        put("C2",Arrays.asList("TCCGGAGA","AGGATAGG"));
        put("C3",Arrays.asList("CGCTCATT","AGGATAGG"));
        put("C4",Arrays.asList("GAGATTCC","AGGATAGG"));
        put("C5",Arrays.asList("ATTCAGAA","AGGATAGG"));
        put("C6",Arrays.asList("GAATTCGT","AGGATAGG"));
        put("C7",Arrays.asList("CTGAAGCT","AGGATAGG"));
        put("C8",Arrays.asList("TAATGCGC","AGGATAGG"));
        put("C9",Arrays.asList("CGGCTATG","AGGATAGG"));
        put("C10",Arrays.asList("TCCGCGAA","AGGATAGG"));
        put("C11",Arrays.asList("TCTCGCGC","AGGATAGG"));
        put("C12",Arrays.asList("AGCGATAG","AGGATAGG"));
        put("D1",Arrays.asList("ATTACTCG","TCAGAGCC"));
        put("D2",Arrays.asList("TCCGGAGA","TCAGAGCC"));
        put("D3",Arrays.asList("CGCTCATT","TCAGAGCC"));
        put("D4",Arrays.asList("GAGATTCC","TCAGAGCC"));
        put("D5",Arrays.asList("ATTCAGAA","TCAGAGCC"));
        put("D6",Arrays.asList("GAATTCGT","TCAGAGCC"));
        put("D7",Arrays.asList("CTGAAGCT","TCAGAGCC"));
        put("D8",Arrays.asList("TAATGCGC","TCAGAGCC"));
        put("D9",Arrays.asList("CGGCTATG","TCAGAGCC"));
        put("D10",Arrays.asList("TCCGCGAA","TCAGAGCC"));
        put("D11",Arrays.asList("TCTCGCGC","TCAGAGCC"));
        put("D12",Arrays.asList("AGCGATAG","TCAGAGCC"));
        put("E1",Arrays.asList("ATTACTCG","CTTCGCCT"));
        put("E2",Arrays.asList("TCCGGAGA","CTTCGCCT"));
        put("E3",Arrays.asList("CGCTCATT","CTTCGCCT"));
        put("E4",Arrays.asList("GAGATTCC","CTTCGCCT"));
        put("E5",Arrays.asList("ATTCAGAA","CTTCGCCT"));
        put("E6",Arrays.asList("GAATTCGT","CTTCGCCT"));
        put("E7",Arrays.asList("CTGAAGCT","CTTCGCCT"));
        put("E8",Arrays.asList("TAATGCGC","CTTCGCCT"));
        put("E9",Arrays.asList("CGGCTATG","CTTCGCCT"));
        put("E10",Arrays.asList("TCCGCGAA","CTTCGCCT"));
        put("E11",Arrays.asList("TCTCGCGC","CTTCGCCT"));
        put("E12",Arrays.asList("AGCGATAG","CTTCGCCT"));
        put("F1",Arrays.asList("ATTACTCG","TAAGATTA"));
        put("F2",Arrays.asList("TCCGGAGA","TAAGATTA"));
        put("F3",Arrays.asList("CGCTCATT","TAAGATTA"));
        put("F4",Arrays.asList("GAGATTCC","TAAGATTA"));
        put("F5",Arrays.asList("ATTCAGAA","TAAGATTA"));
        put("F6",Arrays.asList("GAATTCGT","TAAGATTA"));
        put("F7",Arrays.asList("CTGAAGCT","TAAGATTA"));
        put("F8",Arrays.asList("TAATGCGC","TAAGATTA"));
        put("F9",Arrays.asList("CGGCTATG","TAAGATTA"));
        put("F10",Arrays.asList("TCCGCGAA","TAAGATTA"));
        put("F11",Arrays.asList("TCTCGCGC","TAAGATTA"));
        put("F12",Arrays.asList("AGCGATAG","TAAGATTA"));
        put("G1",Arrays.asList("ATTACTCG","ACGTCCTG"));
        put("G2",Arrays.asList("TCCGGAGA","ACGTCCTG"));
        put("G3",Arrays.asList("CGCTCATT","ACGTCCTG"));
        put("G4",Arrays.asList("GAGATTCC","ACGTCCTG"));
        put("G5",Arrays.asList("ATTCAGAA","ACGTCCTG"));
        put("G6",Arrays.asList("GAATTCGT","ACGTCCTG"));
        put("G7",Arrays.asList("CTGAAGCT","ACGTCCTG"));
        put("G8",Arrays.asList("TAATGCGC","ACGTCCTG"));
        put("G9",Arrays.asList("CGGCTATG","ACGTCCTG"));
        put("G10",Arrays.asList("TCCGCGAA","ACGTCCTG"));
        put("G11",Arrays.asList("TCTCGCGC","ACGTCCTG"));
        put("G12",Arrays.asList("AGCGATAG","ACGTCCTG"));
        put("H1",Arrays.asList("ATTACTCG","GTCAGTAC"));
        put("H2",Arrays.asList("TCCGGAGA","GTCAGTAC"));
        put("H3",Arrays.asList("CGCTCATT","GTCAGTAC"));
        put("H4",Arrays.asList("GAGATTCC","GTCAGTAC"));
        put("H5",Arrays.asList("ATTCAGAA","GTCAGTAC"));
        put("H6",Arrays.asList("GAATTCGT","GTCAGTAC"));
        put("H7",Arrays.asList("CTGAAGCT","GTCAGTAC"));
        put("H8",Arrays.asList("TAATGCGC","GTCAGTAC"));
        put("H9",Arrays.asList("CGGCTATG","GTCAGTAC"));
        put("H10",Arrays.asList("TCCGCGAA","GTCAGTAC"));
        put("H11",Arrays.asList("TCTCGCGC","GTCAGTAC"));
        put("H12",Arrays.asList("AGCGATA","GTCAGTAC"));
    }};


    private String selectStartingIndex;
    private String selectNumIndex;

    public PanIndexes(){

    }

    /**
     *
     * @return Returns selectStartingIndex the index from which to start on the sample sheet
     */
    public String getStartingIndex() { return selectStartingIndex; }


    /**
     *
     * @param selectStartingIndex The selected index to start from the available list
     */
    public void setStartingIndex(String selectStartingIndex) {
        this.selectStartingIndex = selectStartingIndex;
    }

    /**
     *
     * @return Returns selectNumIndex the number of indexes to retrieve from the available list
     */
    public String getNumIndex() { return selectNumIndex; }


    /**
     *
     * @param selectNumIndex The selected number of indexes to retrieve from the available list
     */
    public void setNumIndex(String selectNumIndex) {
        this.selectNumIndex = selectNumIndex;
    }

    //Add params
    public LinkedHashMap<String, List<String>> getPanIndices() { return panIndices; }


    //Code to return a sliced list? of the required indices
    //Add params
    //public LinkedHashMap<String, List<String>> getPanIndexRange() {

        //return panIndices.get();
    //}




}
