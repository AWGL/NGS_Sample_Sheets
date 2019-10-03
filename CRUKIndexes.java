package nhs.cardiff.genetics.ngssamplesheets;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Sara Rey
 * @Date 16/09/2019
 * @version 1.5.0
 *
 */

public class CRUKIndexes {
    //All available indices used for CRUK
    private static final LinkedHashMap<String, List<String>> CrukIndices = new LinkedHashMap<String, List<String>>(){{
        put("CP01", Arrays.asList("CATCGAGG","ACGTCCTG"));
        put("CP02", Arrays.asList("CTCGACTG", "GTCAGTAC"));
        put("CP03", Arrays.asList("CGGCTATG", "CCGTCGCC"));
        put("CP04", Arrays.asList("TCTCGCGC", "GTCCGAGG"));
        put("CP05", Arrays.asList("CTCGACTG", "ACGTCCTG"));
        put("CP06", Arrays.asList("CGGCTATG", "ACGTCCTG"));
        put("CP07", Arrays.asList("TCTCGCGC", "ACGTCCTG"));
        put("CP08", Arrays.asList("CATCGAGG", "GTCAGTAC"));
        put("CP09", Arrays.asList("CGGCTATG", "GTCAGTAC"));
        put("CP10", Arrays.asList("TCTCGCGC", "GTCAGTAC"));
        put("CP11", Arrays.asList("CATCGAGG", "CCGTCGCC"));
        put("CP12", Arrays.asList("CTCGACTG", "CCGTCGCC"));
        put("CP13", Arrays.asList("TCTCGCGC", "CCGTCGCC"));
        put("CP14", Arrays.asList("CATCGAGG", "GTCCGAGG"));
        put("CP15", Arrays.asList("CTCGACTG", "GTCCGAGG"));
        put("CP16", Arrays.asList("CGGCTATG", "GTCCGAGG"));
        put("UP01", Arrays.asList("TCCGGAGA", "AGGATAGG"));
        put("UP02", Arrays.asList("CTGAAGCT", "TCAGAGCC"));
        put("UP03", Arrays.asList("CGTAGCTC", "CATCCGAA"));
        put("UP04", Arrays.asList("GAATTCGT", "TTATGAGT"));
        put("UP05", Arrays.asList("AGCGATAG", "ACGAATAA"));
        put("UP06", Arrays.asList("GCGATTAA", "GATCTGCT"));
        put("UP07", Arrays.asList("ATTCAGAA", "AGGCTATA"));
        put("UP08", Arrays.asList("GAATAATC", "GCCTCTAT"));
        put("UP09", Arrays.asList("TTAATCAG", "CTTCGCCT"));
        put("UP10", Arrays.asList("CGCTCATT", "TAAGATTA"));
        put("UP11", Arrays.asList("TCCGCGAA", "AGTAAGTA"));
        put("UP12", Arrays.asList("ATTACTCG", "GACTTCCT"));
        put("UP13", Arrays.asList("ACTGCTTA", "AGAGGCGC"));
        put("UP14", Arrays.asList("ATGCGGCT", "TAGCCGCG"));
        put("UP15", Arrays.asList("GCCTCTCT", "TTCGTAGG"));
        put("UP16", Arrays.asList("GCCGTAGG", "CGCTCCGC"));
    }};

    /**
     *
     * @return Returns crukIndices all of the possible keys and indexes for the CRUK TST170 panel
     */
    public LinkedHashMap<String, List<String>> getCrukIndices() { return CrukIndices; }

}
