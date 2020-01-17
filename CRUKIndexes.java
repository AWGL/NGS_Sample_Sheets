package nhs.cardiff.genetics.ngssamplesheets;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Sara Rey
 * @Date 16/09/2019
 * @version 1.5.2
 *
 */

public class CRUKIndexes {
    //All available indices used for CRUK
    private static final LinkedHashMap<String, List<String>> CrukIndices = new LinkedHashMap<String, List<String>>(){{
        put("1", Arrays.asList("CP01", "D721", "D507", "CATCGAGG","ACGTCCTG"));
        put("2", Arrays.asList("CP02", "D723", "D508", "CTCGACTG", "GTCAGTAC"));
        put("3", Arrays.asList("CP03", "D709", "D519", "CGGCTATG", "CCGTCGCC"));
        put("4", Arrays.asList("CP04", "D711", "D520", "TCTCGCGC", "GTCCGAGG"));
        put("5", Arrays.asList("CP05", "D723", "D507", "CTCGACTG", "ACGTCCTG"));
        put("6", Arrays.asList("CP06", "D709", "D507", "CGGCTATG", "ACGTCCTG"));
        put("7", Arrays.asList("CP07", "D711", "D507", "TCTCGCGC", "ACGTCCTG"));
        put("8", Arrays.asList("CP08", "D721", "D508", "CATCGAGG", "GTCAGTAC"));
        put("9", Arrays.asList("CP09", "D709", "D508", "CGGCTATG", "GTCAGTAC"));
        put("10", Arrays.asList("CP10", "D711", "D508", "TCTCGCGC", "GTCAGTAC"));
        put("11", Arrays.asList("CP11", "D721", "D519", "CATCGAGG", "CCGTCGCC"));
        put("12", Arrays.asList("CP12", "D723", "D519", "CTCGACTG", "CCGTCGCC"));
        put("13", Arrays.asList("CP13", "D711", "D519", "TCTCGCGC", "CCGTCGCC"));
        put("14", Arrays.asList("CP14", "D721", "D520", "CATCGAGG", "GTCCGAGG"));
        put("15", Arrays.asList("CP15", "D723", "D520", "CTCGACTG", "GTCCGAGG"));
        put("16", Arrays.asList("CP16", "D709", "D520", "CGGCTATG", "GTCCGAGG"));
        put("17", Arrays.asList("UP01", "D702", "D503", "TCCGGAGA", "AGGATAGG"));
        put("18", Arrays.asList("UP02", "D707", "D504", "CTGAAGCT", "TCAGAGCC"));
        put("19", Arrays.asList("UP03", "D717", "D509", "CGTAGCTC", "CATCCGAA"));
        put("20", Arrays.asList("UP04", "D706", "D510", "GAATTCGT", "TTATGAGT"));
        put("21", Arrays.asList("UP05", "D712", "D513", "AGCGATAG", "ACGAATAA"));
        put("22", Arrays.asList("UP06", "D724", "D515", "GCGATTAA", "GATCTGCT"));
        put("23", Arrays.asList("UP07", "D705", "D501", "ATTCAGAA", "AGGCTATA"));
        put("24", Arrays.asList("UP08", "D713", "D502", "GAATAATC", "GCCTCTAT"));
        put("25", Arrays.asList("UP09", "D715", "D505", "TTAATCAG", "CTTCGCCT"));
        put("26", Arrays.asList("UP10", "D703", "D506", "CGCTCATT", "TAAGATTA"));
        put("27", Arrays.asList("UP11", "D710", "D517", "TCCGCGAA", "AGTAAGTA"));
        put("28", Arrays.asList("UP12", "D701", "D518", "ATTACTCG", "GACTTCCT"));
        put("29", Arrays.asList("UP13", "D716", "D511", "ACTGCTTA", "AGAGGCGC"));
        put("30", Arrays.asList("UP14", "D714", "D512", "ATGCGGCT", "TAGCCGCG"));
        put("31", Arrays.asList("UP15", "D718", "D514", "GCCTCTCT", "TTCGTAGG"));
        put("32", Arrays.asList("UP16", "D719", "D516", "GCCGTAGG", "CGCTCCGC"));
    }};

    /**
     *
     * @return Returns crukIndices all of the possible keys and indexes for the CRUK TST170 panel
     */
    public LinkedHashMap<String, List<String>> getCrukIndices() { return CrukIndices; }

}
