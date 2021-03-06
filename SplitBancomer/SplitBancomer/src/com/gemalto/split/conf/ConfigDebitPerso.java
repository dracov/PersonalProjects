/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemalto.split.conf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author aldmendo
 */

@XStreamAlias("DebitPerso")
public class ConfigDebitPerso implements IConfig {
    
    @XStreamAlias("recordSize")
    private int recordSize;
    
    @XStreamAlias("headerKeyName")
    private String headerKeyName;
    
    @XStreamAlias("headerKeyStart")
    private int headerKeyStart;
    
    @XStreamAlias("headerKeyEnd")
    private int headerKeyEnd;
    
    @XStreamAlias("groupByStart_1Name")
    private String groupByStart_1Name;
    
    @XStreamAlias("groupByStart_1")
    private int groupByStart_1;
    
    @XStreamAlias("groupByEnd_1")
    private int groupByEnd_1;

    @XStreamAlias("recordLimit")
    private int recordLimit;
    
    @XStreamAlias("extraRecords")
    private int extraRecords;
    
    @XStreamAlias("headerKeyQtyStart")
    private int headerKeyQtyStart;
    
    @XStreamAlias("headerKeyQtyEnd")
    private int headerKeyQtyEnd;
    
    @XStreamAlias("blockSize")
    private int blockSize;

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }
        
    public int getRecordSize() {
        return recordSize;
    }

    public void setRecordSize(int recordSize) {
        this.recordSize = recordSize;
    }

    public String getHeaderKeyName() {
        return headerKeyName;
    }

    public void setHeaderKeyName(String headerKeyName) {
        this.headerKeyName = headerKeyName;
    }

    public int getHeaderKeyStart() {
        return headerKeyStart;
    }

    public void setHeaderKeyStart(int headerKeyStart) {
        this.headerKeyStart = headerKeyStart;
    }

    public int getHeaderKeyEnd() {
        return headerKeyEnd;
    }

    public void setHeaderKeyEnd(int headerKeyEnd) {
        this.headerKeyEnd = headerKeyEnd;
    }

    public String getGroupByStart_1Name() {
        return groupByStart_1Name;
    }

    public void setGroupByStart_1Name(String groupByStart_1Name) {
        this.groupByStart_1Name = groupByStart_1Name;
    }

    public int getGroupByStart_1() {
        return groupByStart_1;
    }

    public void setGroupByStart_1(int groupByStart_1) {
        this.groupByStart_1 = groupByStart_1;
    }

    public int getGroupByEnd_1() {
        return groupByEnd_1;
    }

    public void setGroupByEnd_1(int groupByEnd_1) {
        this.groupByEnd_1 = groupByEnd_1;
    }

    public int getRecordLimit() {
        return recordLimit;
    }

    public void setRecordLimit(int recordLimit) {
        this.recordLimit = recordLimit;
    }

    public int getExtraRecords() {
        return extraRecords;
    }

    public void setExtraRecords(int extraRecords) {
        this.extraRecords = extraRecords;
    }

    public int getHeaderKeyQtyEnd() {
        return headerKeyQtyEnd;
    }

    public void setHeaderKeyQtyEnd(int headerKeyQtyEnd) {
        this.headerKeyQtyEnd = headerKeyQtyEnd;
    }

    public int getHeaderKeyQtyStart() {
        return headerKeyQtyStart;
    }

    public void setHeaderKeyQtyStart(int headerKeyQtyStart) {
        this.headerKeyQtyStart = headerKeyQtyStart;
    }

    

    
    
}
