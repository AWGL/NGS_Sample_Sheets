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
import java.util.ArrayList;

public class PanIndexes {
    //All available indices used for PanCancer

    private static final LinkedHashMap<String, List<String>> panIndices = new LinkedHashMap<String, List<String>>(){{
        put("A1",Arrays.asList("ATTACTCG","AGGCTATA"));
        put("B1",Arrays.asList("ATTACTCG","GCCTCTAT"));
        put("C1",Arrays.asList("ATTACTCG","AGGATAGG"));
        put("D1",Arrays.asList("ATTACTCG","TCAGAGCC"));
        put("E1",Arrays.asList("ATTACTCG","CTTCGCCT"));
        put("F1",Arrays.asList("ATTACTCG","TAAGATTA"));
        put("G1",Arrays.asList("ATTACTCG","ACGTCCTG"));
        put("H1",Arrays.asList("ATTACTCG","GTCAGTAC"));
        put("A2",Arrays.asList("TCCGGAGA","AGGCTATA"));
        put("B2",Arrays.asList("TCCGGAGA","GCCTCTAT"));
        put("C2",Arrays.asList("TCCGGAGA","AGGATAGG"));
        put("D2",Arrays.asList("TCCGGAGA","TCAGAGCC"));
        put("E2",Arrays.asList("TCCGGAGA","CTTCGCCT"));
        put("F2",Arrays.asList("TCCGGAGA","TAAGATTA"));
        put("G2",Arrays.asList("TCCGGAGA","ACGTCCTG"));
        put("H2",Arrays.asList("TCCGGAGA","GTCAGTAC"));
        put("A3",Arrays.asList("CGCTCATT","AGGCTATA"));
        put("B3",Arrays.asList("CGCTCATT","GCCTCTAT"));
        put("C3",Arrays.asList("CGCTCATT","AGGATAGG"));
        put("D3",Arrays.asList("CGCTCATT","TCAGAGCC"));
        put("E3",Arrays.asList("CGCTCATT","CTTCGCCT"));
        put("F3",Arrays.asList("CGCTCATT","TAAGATTA"));
        put("G3",Arrays.asList("CGCTCATT","ACGTCCTG"));
        put("H3",Arrays.asList("CGCTCATT","GTCAGTAC"));
        put("A4",Arrays.asList("GAGATTCC","AGGCTATA"));
        put("B4",Arrays.asList("GAGATTCC","GCCTCTAT"));
        put("C4",Arrays.asList("GAGATTCC","AGGATAGG"));
        put("D4",Arrays.asList("GAGATTCC","TCAGAGCC"));
        put("E4",Arrays.asList("GAGATTCC","CTTCGCCT"));
        put("F4",Arrays.asList("GAGATTCC","TAAGATTA"));
        put("G4",Arrays.asList("GAGATTCC","ACGTCCTG"));
        put("H4",Arrays.asList("GAGATTCC","GTCAGTAC"));
        put("A5",Arrays.asList("ATTCAGAA","AGGCTATA"));
        put("B5",Arrays.asList("ATTCAGAA","GCCTCTAT"));
        put("C5",Arrays.asList("ATTCAGAA","AGGATAGG"));
        put("D5",Arrays.asList("ATTCAGAA","TCAGAGCC"));
        put("E5",Arrays.asList("ATTCAGAA","CTTCGCCT"));
        put("F5",Arrays.asList("ATTCAGAA","TAAGATTA"));
        put("G5",Arrays.asList("ATTCAGAA","ACGTCCTG"));
        put("H5",Arrays.asList("ATTCAGAA","GTCAGTAC"));
        put("A6",Arrays.asList("GAATTCGT","AGGCTATA"));
        put("B6",Arrays.asList("GAATTCGT","GCCTCTAT"));
        put("C6",Arrays.asList("GAATTCGT","AGGATAGG"));
        put("D6",Arrays.asList("GAATTCGT","TCAGAGCC"));
        put("E6",Arrays.asList("GAATTCGT","CTTCGCCT"));
        put("F6",Arrays.asList("GAATTCGT","TAAGATTA"));
        put("G6",Arrays.asList("GAATTCGT","ACGTCCTG"));
        put("H6",Arrays.asList("GAATTCGT","GTCAGTAC"));
        put("A7",Arrays.asList("CTGAAGCT","AGGCTATA"));
        put("B7",Arrays.asList("CTGAAGCT","GCCTCTAT"));
        put("C7",Arrays.asList("CTGAAGCT","AGGATAGG"));
        put("D7",Arrays.asList("CTGAAGCT","TCAGAGCC"));
        put("E7",Arrays.asList("CTGAAGCT","CTTCGCCT"));
        put("F7",Arrays.asList("CTGAAGCT","TAAGATTA"));
        put("G7",Arrays.asList("CTGAAGCT","ACGTCCTG"));
        put("H7",Arrays.asList("CTGAAGCT","GTCAGTAC"));
        put("A8",Arrays.asList("TAATGCGC","AGGCTATA"));
        put("B8",Arrays.asList("TAATGCGC","GCCTCTAT"));
        put("C8",Arrays.asList("TAATGCGC","AGGATAGG"));
        put("D8",Arrays.asList("TAATGCGC","TCAGAGCC"));
        put("E8",Arrays.asList("TAATGCGC","CTTCGCCT"));
        put("F8",Arrays.asList("TAATGCGC","TAAGATTA"));
        put("G8",Arrays.asList("TAATGCGC","ACGTCCTG"));
        put("H8",Arrays.asList("TAATGCGC","GTCAGTAC"));
        put("A9",Arrays.asList("CGGCTATG","AGGCTATA"));
        put("B9",Arrays.asList("CGGCTATG","GCCTCTAT"));
        put("C9",Arrays.asList("CGGCTATG","AGGATAGG"));
        put("D9",Arrays.asList("CGGCTATG","TCAGAGCC"));
        put("E9",Arrays.asList("CGGCTATG","CTTCGCCT"));
        put("F9",Arrays.asList("CGGCTATG","TAAGATTA"));
        put("G9",Arrays.asList("CGGCTATG","ACGTCCTG"));
        put("H9",Arrays.asList("CGGCTATG","GTCAGTAC"));
        put("A10",Arrays.asList("TCCGCGAA","AGGCTATA"));
        put("B10",Arrays.asList("TCCGCGAA","GCCTCTAT"));
        put("C10",Arrays.asList("TCCGCGAA","AGGATAGG"));
        put("D10",Arrays.asList("TCCGCGAA","TCAGAGCC"));
        put("E10",Arrays.asList("TCCGCGAA","CTTCGCCT"));
        put("F10",Arrays.asList("TCCGCGAA","TAAGATTA"));
        put("G10",Arrays.asList("TCCGCGAA","ACGTCCTG"));
        put("H10",Arrays.asList("TCCGCGAA","GTCAGTAC"));
        put("A11",Arrays.asList("TCTCGCGC","AGGCTATA"));
        put("B11",Arrays.asList("TCTCGCGC","GCCTCTAT"));
        put("C11",Arrays.asList("TCTCGCGC","AGGATAGG"));
        put("D11",Arrays.asList("TCTCGCGC","TCAGAGCC"));
        put("E11",Arrays.asList("TCTCGCGC","CTTCGCCT"));
        put("F11",Arrays.asList("TCTCGCGC","TAAGATTA"));
        put("G11",Arrays.asList("TCTCGCGC","ACGTCCTG"));
        put("H11",Arrays.asList("TCTCGCGC","GTCAGTAC"));
        put("A12",Arrays.asList("AGCGATAG","AGGCTATA"));
        put("B12",Arrays.asList("AGCGATAG","GCCTCTAT"));
        put("C12",Arrays.asList("AGCGATAG","AGGATAGG"));
        put("D12",Arrays.asList("AGCGATAG","TCAGAGCC"));
        put("E12",Arrays.asList("AGCGATAG","CTTCGCCT"));
        put("F12",Arrays.asList("AGCGATAG","TAAGATTA"));
        put("G12",Arrays.asList("AGCGATAG","ACGTCCTG"));
        put("H12",Arrays.asList("AGCGATAG","GTCAGTAC"));

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
     * @return Returns panIndices all of the possible keys and indexes for the pan cancer panel
     */
    public LinkedHashMap<String, List<String>> getPanIndices() { return panIndices; }



}
