package nhs.cardiff.genetics.ngssamplesheets;

public class Index {

	// I5 INDEXES
	private String E501 = "TAGATCGC";
	private String E502 = "CTCTCTAT";
	private String E503 = "TATCCTCT";
	private String E504 = "AGAGTAGA";
	private String E505 = "GTAAGGAG";
	private String E506 = "ACTGCATA";
	private String E517 = "GCGTAAGA";
	private String FH1to24 = "FH1to24";
	private String FH25to48 = "FH25to48";
	private String CRUKset1 = "CRUKset1";
	private String CRUKset2 = "CRUKset2";
	
	
	private String indexSelect;

	public Index(){

	}

	/**
	 * 
	 * @return Returns indexSelect, The selected index from the available list
	 */
	public String getIndexSelect() {
		return indexSelect;
	}

	/**
	 * 
	 * @param indexSelect The selected index from the available list
	 */
	public void setIndexSelect(String indexSelect) {
		this.indexSelect = indexSelect;
	}

	/**
	 * 
	 * @return Returns String for E501 index
	 */
	public String getE501() {
		return E501;
	}

	/**
	 * 
	 * @return Returns String for E502 index
	 */
	public String getE502() {
		return E502;
	}
	
	/**
	 * 
	 * @return Returns String for E503 index
	 */
	public String getE503() {
		return E503;
	}

	/**
	 * 
	 * @return Returns String for E504 index
	 */
	public String getE504() {
		return E504;
	}

	/**
	 * 
	 * @return Returns String for E505 index
	 */
	public String getE505() {
		return E505;
	}
	
	/**
	 * 
	 * @return Returns String for E506 index
	 */
	public String getE506() {
		return E506;
	}
	
	/**
	 * 
	 * @return Returns String for E517 index
	 */
	public String getE517() {
		return E517;
	}

	/**
	 *
	 * @return Returns FH1to24 index name
	 */
	public String getFH1to24() {
		return FH1to24;
	}

	/**
	 *
	 * @return Returns FH25to48 index name
	 */
	public String getFH25to48() {
		return FH25to48;
	}

	/**
	 *
	 * @return Returns CRUK set 1 index name
	 */
	public String getCRUKset1() {
		return CRUKset1;
	}

	/**
	 *
	 * @return Returns CRUK set 2 index name
	 */
	public String getCRUKset2() {
		return CRUKset2;
	}

}
