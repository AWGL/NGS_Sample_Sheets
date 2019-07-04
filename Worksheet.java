package nhs.cardiff.genetics.ngssamplesheets;

/**
 * @author Rhys Cooper & Sara Rey
 * @Date 13/06/2019
 * @version 1.4.6
 *
 */

import java.util.ArrayList;

public class Worksheet {
	
	private ArrayList<String> worksheet;
	private ArrayList<String> labNo;
	private ArrayList<String> position;
	private ArrayList<String> user;
	private ArrayList<String> test;
	private ArrayList<String> updateDate;
	private ArrayList<String> panel;
	private ArrayList<String> comments;
	private ArrayList<String> sexes;
	private ArrayList<String> genes;
	private ArrayList<String> index;
	private ArrayList<String> first;
	private ArrayList<String> second;
	
	public Worksheet(){
		this.worksheet = new ArrayList<String>();
		this.labNo = new ArrayList<String>();
		this.position = new ArrayList<String>();
		this.user = new ArrayList<String>();
		this.test = new ArrayList<String>();
		this.updateDate = new ArrayList<String>();
		this.panel = new ArrayList<String>();
		this.comments = new ArrayList<String>();
		this.sexes = new ArrayList<String>();
		this.genes = new ArrayList<String>();
		this.index = new ArrayList<String>();
		this.first = new ArrayList<String>();
		this.second = new ArrayList<String>();
	}

	/**
	 * 
	 * @return Returns worksheet, The shire number of the worksheet
	 */
	public ArrayList<String> getWorksheet() {
		return worksheet;
	}

	/**
	 * 
	 * @param worksheet The shire number of the worksheet
	 */
	public void setWorksheet(String worksheet) {
		this.worksheet.add(worksheet);
	}

	/**
	 * 
	 * @return Returns labNo, The lab number of the particular sample on the worksheet
	 */
	public ArrayList<String> getLabNo() {
		return labNo;
	}
	
	/**
	 * 
	 * @param labNo The lab number of the particular sample on the worksheet
	 */
	public void setLabNo(String labNo) {
		this.labNo.add(labNo);
	}

	/**
	 * 
	 * @return Returns position, The position of the sample on the worksheet
	 */
	public ArrayList<String> getPosition() {
		return position;
	}

	/**
	 * 
	 * @param position The position of the sample on the worksheet
	 */
	public void setPosition(String position) {
		this.position.add(position);
	}

	/**
	 * 
	 * @return Returns user, The initials of the user who created the worksheet
	 */
	public ArrayList<String> getUser() {
		return user;
	}

	/**
	 * 
	 * @param user The initials of the user who created the worksheet
	 */
	public void setUser(String user) {
		this.user.add(user);
	}

	/**
	 * 
	 * @return Returns test, The Test requested for this sample on this worksheet
	 */
	public ArrayList<String> getTest() {
		return test;
	}

	/**
	 * 
	 * @param test The Test requested for this sample on this worksheet
	 */
	public void setTest(String test) {
		this.test.add(test);
	}

	/**
	 * 
	 * @return Returns updateDate, The date the worksheet was created
	 */
	public ArrayList<String> getUpdateDate() {
		return updateDate;
	}

	/**
	 * 
	 * @param updateDate The date the worksheet was created
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate.add(updateDate);
	}

	/**
	 * 
	 * @return Returns panel, The panel the requested test is on
	 */
	public ArrayList<String> getPanel() {
		return panel;
	}

	/**
	 * 
	 * @param panel The panel the requested test is on
	 */
	public void setPanel(String panel) {
		this.panel.add(panel);
	}

	/**
	 * 
	 * @return Returns comments, The comments controls which pipeline is requested on samplesheet FOCUS 4, WCB etc...
	 */
	public ArrayList<String> getComments() {
		return comments;
	}

	/**
	 * 
	 * @param comments The comments controls which pipeline is requested on samplesheet FOCUS 4, WCB etc...
	 */
	public void setComments(String comments) {
		this.comments.add(comments);
	}

	/**
	 *
	 * @return Returns sexes, The sex of the patient.
	 */
	public ArrayList<String> getSexes() { return sexes; }

	/**
	 *
	 * @param sexes The sex of the patient.
	 */
	public void setSexes(String sexes) {
		this.sexes.add(sexes);
	}

	/**
	 *
	 * @return Returns genes, The genes to be analysed (TAM) or panel applied (PanCancer).
	 */
	public ArrayList<String> getGenes() { return genes; }

	/**
	 *
	 * @param genes The genes to be analysed (TAM) or panel applied (PanCancer).
	 */
	public void setGenes(String genes) {
		this.genes.add(genes);
	}

	/**
	 *
	 * @return Returns index, The index name/identifier for pan cancer samples.
	 */
	public ArrayList<String> getPanIndexId() { return index; }

	/**
	 *
	 * @param index The index name/identifier for pan cancer samples.
	 */
	public void setPanIndexId(String index) {
		this.index.add(index);
	}

    /**
     *
     * @return Returns first, The first index for pan cancer samples.
     */
    public ArrayList<String> getPanFirstIndex() { return first; }

    /**
     *
     * @param first The first index for pan cancer samples.
     */
    public void setPanFirstIndex(String first) {
        this.first.add(first);
    }

    /**
     *
     * @return Returns second, The second index for pan cancer samples (reverse complement).
     */
    public ArrayList<String> getPanSecondIndex() { return second; }

    /**
     *
     * @param second The second index for pan cancer samples (reverse complement).
     */
    public void setPanSecondIndex(String second) {
        this.second.add(second);
    }
}
