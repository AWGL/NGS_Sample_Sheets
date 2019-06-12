package nhs.cardiff.genetics.ngssamplesheets;

import java.util.HashMap;

public class PanIndexes {
    //All available indices used for PanCancer

    private String A1 = "";
    private String A2 = "";
    private String A3 = "";

    HashMap panIndices = new HashMap();


    private String selectStartingIndex;

    public PanIndexes(){

    }

    /**
     *
     * @return Returns selectStartingIndex the index from which to start on the sample sheet
     */
    public String getStartingIndex() { return selectStartingIndex; }


    /**
     *
     * @param indexSelect The selected index from the available list
     */
    public void setStartingIndex(String selectStartingIndex) {
        this.selectStartingIndex = selectStartingIndex;
    }

    //Code to return a sliced list? of the required indices




}
