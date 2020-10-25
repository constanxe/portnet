package com.portnet.entity.storage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An domain model of a Vessel that represents the joined database table
 */

@Entity
@Table(name = "vessel")
@SecondaryTable(name = "vessel_history", pkJoinColumns = @PrimaryKeyJoinColumn(name = "uniqueId", referencedColumnName = "uniqueId"))
public class Vessel {
    
    /**
     * Constructs a specified VoyageId object
     * @param uniqueId the auto-generated ID of the voyage, identified by vesselName and voyageNum
     * ...
     */
    
    @JsonProperty("uniqueId") @Id
    @Column(nullable = false, name = "uniqueId")
    private String uniqueId;
    
    @JsonProperty("imoN")
    @Column(nullable = true, name = "imoN")
    private String imoN;

    @JsonProperty("fullVslM")
    @Column(nullable = false, name = "fullVslM")
    private String fullVslM;

    @JsonProperty("abbrVslM")
    @Column(nullable = false, name = "abbrVslM")
    private String abbrVslM;

    @JsonProperty("fullInVoyN")
    @Column(nullable = true, name = "fullInVoyN")
    private String fullInVoyN;

    @JsonProperty("inVoyN")
    @Column(nullable = false, name = "inVoyN")
    private String inVoyN;

    @JsonProperty("outVoyN")
    @Column(nullable = false, name = "outVoyN")
    private String outVoyN;

    @JsonProperty("fullOutVoyN")
    @Column(nullable = true, name = "fullOutVoyN")
    private String fullOutVoyN;

    @JsonProperty("shiftSeqN")
    @Column(nullable = false, name = "shiftSeqN")
    private String shiftSeqN;

    @JsonProperty("bthgDt")
    @Column(nullable = false, name = "bthgDt")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private String bthgDt;
    
    @JsonProperty("unbthgDt")
    @Column(nullable = false, name = "unbthgDt")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private String unbthgDt;

    @JsonProperty("berthN")
    @Column(nullable = true, name = "berthN")
    private String berthN;

    @JsonProperty("status")
    @Column(nullable = false, name = "status")
    private String status;

    @JsonProperty("abbrTerminalM")
    @Column(nullable = true, name = "abbrTerminalM")
    private String abbrTerminalM;
    
    @JsonProperty("last_bthgDt")
    @Column(nullable = false, name = "last_bthgDt", table = "vessel_history")
    private String last_bthgDt;
    
    @JsonProperty("last_unbthgDt")
    @Column(nullable = false, name = "last_unbthgDt", table = "vessel_history")
    private String last_unbthgDt;

    @JsonProperty("bthgDt_change_count")
    @Column(nullable = false, name = "bthgDt_change_count", table = "vessel_history")
    private int bthgDt_change_count;
    
    @JsonProperty("unbthgDt_change_count")
    @Column(nullable = false, name = "unbthgDt_change_count", table = "vessel_history")
    private int unbthgDt_change_count;

    @JsonProperty("first_arrival")
    @Column(nullable = false, name = "first_arrival", table = "vessel_history")
    private String first_arrival;
        
    // Getter & setters
    public String getImoN() {
        return imoN;
    }

    public void setImoN(String imoN) {
        this.imoN = imoN;
    }

    public String getfullVslM() {
        return fullVslM;
    }

    public void setFullVs1M(String fullVslM) {
        this.fullVslM = fullVslM;
    }

    public String getAbbrVslM() {
        return abbrVslM;
    }

    public void setAbbrVslM(String abbrVslM) {
        this.abbrVslM = abbrVslM;
    }

    public String getFullInVoyN() {
        return fullInVoyN;
    }

    public void setFullInVoyN(String fullInVoyN) {
        this.fullInVoyN = fullInVoyN;
    }

    public String getInVoyN() {
        return inVoyN;
    }

    public void setInVoyN(String inVoyN) {
        this.inVoyN = inVoyN;
    }

    public String getOutVoyN() {
        return outVoyN;
    }

    public void setOutVoyN(String outVoyN) {
        this.outVoyN = outVoyN;
    }

    public String getFullOutVoyN() {
        return fullOutVoyN;
    }

    public void setFullOutVoyN(String fullOutVoyN) {
        this.fullOutVoyN = fullOutVoyN;
    }

    public String getShiftSeqN() {
        return shiftSeqN;
    }

    public void setShiftSeqN(String shiftSeqN) {
        this.shiftSeqN = shiftSeqN;
    }

    public String getBthgDt() {
        return bthgDt;
    }

    public void setBthgDt(String bthgDt) {
        this.bthgDt = bthgDt;
    }

    public String getUnbthgDt() {
        return unbthgDt;
    }

    public void setUnbthgDt(String unbthgDt) {
        this.unbthgDt = unbthgDt;
    }

    public String getBerthN() {
        return berthN;
    }

    public void setBerthN(String berthN) {
        this.berthN = berthN;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAbbrTerminalM() {
        return abbrTerminalM;
    }

    public void setAbbrTerminalM(String abbrTerminalM) {
        this.abbrTerminalM = abbrTerminalM;
    }
        
    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
    
    public void setFullVslM(String fullVslM) {
        this.fullVslM = fullVslM;
    }

    @Override
    public String toString() {
        return "Vessel [abbrTerminalM=" + abbrTerminalM + ", abbrVslM=" + abbrVslM + ", berthN=" + berthN + ", bthgDt="
                + bthgDt + ", fullInVoyN=" + fullInVoyN + ", fullOutVoyN=" + fullOutVoyN + ", fullVslM=" + fullVslM
                + ", imoN=" + imoN + ", inVoyN=" + inVoyN + ", outVoyN=" + outVoyN + ", shiftSeqN=" + shiftSeqN
                + ", status=" + status + ", unbthgDt=" + unbthgDt + ", uniqueId=" + uniqueId + "]";
    }

}
