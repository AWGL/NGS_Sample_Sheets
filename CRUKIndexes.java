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
    //All available indices used for Familial Hypercholesterolaemia

    private static final LinkedHashMap<String, List<String>> CrukIndices = new LinkedHashMap<String, List<String>>(){{
        put("CP01", Arrays.asList("AACGTGAT",""));
        put("CP02", Arrays.asList("AAACATCG"));
        put("CP03", Arrays.asList("AGTGGTCA"));
        put("CP04", Arrays.asList("ACCACTGT"));
        put("CP05", Arrays.asList("GATAGACA"));
        put("CP06", Arrays.asList("GTGTTCTA"));
        put("CP07", Arrays.asList("TGGAACAA"));
        put("CP08", Arrays.asList("TGGTGGTA"));
        put("CP09", Arrays.asList("ACATTGGC"));
        put("CP10", Arrays.asList("CAGATCTG"));
        put("CP11", Arrays.asList("CATCAAGT"));
        put("CP12", Arrays.asList("AGTACAAG"));
        put("CP13", Arrays.asList("AGATCGCA"));
        put("CP14", Arrays.asList("GACTAGTA"));
        put("CP15", Arrays.asList("GGTGCGAA"));
        put("CP16", Arrays.asList("TGAAGAGA"));
        put("UP01", Arrays.asList("AATGCGCT"));
        put("UP02", Arrays.asList("GACGGCGC"));
        put("UP03", Arrays.asList("TTAGCTCC"));
        put("UP04", Arrays.asList("GTTCAATC"));
        put("UP05", Arrays.asList("GAAAGGAT"));
        put("UP06", Arrays.asList("AGTTCCGC"));
        put("UP07", Arrays.asList("ACGATCGT"));
        put("UP08", Arrays.asList("CGCCTGAG"));
        put("UP09", Arrays.asList("TTACCCTG"));
        put("UP10", Arrays.asList("TTCGACGA"));
        put("UP11", Arrays.asList("TCTAGTAC"));
        put("UP12", Arrays.asList("AGTCGGAA"));
        put("UP13", Arrays.asList("ATTAGCGC"));
        put("UP14", Arrays.asList("GACTACTT"));
        put("UP15", Arrays.asList("ACGTATAT"));
        put("UP16", Arrays.asList("AAAGTTCT"));
    }};

    /**
     *
     * @return Returns crukIndices all of the possible keys and indexes for the CRUK TST170 panel
     */
    public LinkedHashMap<String, List<String>> getCrukIndices() { return CrukIndices; }

}
