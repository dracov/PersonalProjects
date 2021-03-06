/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gemalto.split.additionalservices;

import com.gemalto.split.beans.HeaderKey;
import com.gemalto.split.beans.Record;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author aldmendo
 */


public class ViveService_RemoveRecordsFromCsvFile {
   private static Logger logger=Logger.getLogger(ViveService_RemoveRecordsFromCsvFile.class);
    
    //list of keys that will be erased from the main file
   private static List<Record> exceptionRecords=new ArrayList<Record>();
   private Map<HeaderKey, List<Record>> recordsMap; //all the records, the key is the HeaderKey. 

   private File inputFile;
   private String outputPath;
   
   

   public void removeExceptionRecords(){
       Set<HeaderKey> headers=recordsMap.keySet();
       for (HeaderKey headerKey : headers) {  //lets remove the exceptions records
           logger.info("Removing records from header:"+headerKey.getHeaderKey());
           List<Record> recordsByHeader= recordsMap.get(headerKey);
           boolean wasRemoved= recordsByHeader.removeAll(exceptionRecords);
           logger.info("Records were removed? "+wasRemoved+" Quantity now:"+ recordsByHeader.size());
           headerKey.setQuantity(recordsByHeader.size());
       }
       
   }
   
   public static  void loadExceptionRecords(String exceptionFileName){
       logger.info("Loading Records of the Exception File");
       BufferedReader br = null;
       String line = "";
       String cvsSplitBy = ",";
 	try {
 		br = new BufferedReader(new FileReader(exceptionFileName));
		while ((line = br.readLine()) != null) {
		        // use comma as separator
			 String[] exceptionRecordsArray = line.split(cvsSplitBy);
			 Record exceptionRecord=new Record();
                         exceptionRecord.setPan(exceptionRecordsArray[1]);
                        exceptionRecords.add(exceptionRecord);
		}
         logger.info("Loading complete, total of exception records:"+exceptionRecords.size() +" (be careful with the header of the csv file)");       
                    
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
   }
   
   
   public void writeNewFileAndExceptionFile() {
       
        File toWrite= new File(outputPath+"\\"+inputFile.getName());
        logger.info("ArchivoToWrite:"+toWrite.getName());
        int countHeader=0;
        Set<HeaderKey> headers=recordsMap.keySet();
         try {
            for (HeaderKey headerKey : headers) {
               logger.info("Header:"+headerKey.getHeaderKey()+ " quantity:"+headerKey.getQuantity());
               if(countHeader==0)  FileUtils.write(toWrite, headerKey.getHeaderString() , true);
               else FileUtils.write(toWrite, headerKey.getHeaderStringWithoutExtraPart(), true);
               countHeader++;
               List<Record> recordsByHeader= recordsMap.get(headerKey);
               for (Record record : recordsByHeader) {
                   FileUtils.write(toWrite, record.getRecord()+ "\r\n", true);
                }
            }
        } catch (IOException ex) {
               
               logger.error(ex.getMessage(), ex);
           }
    }

    public File getInputFile() {
        return inputFile;
    }

    public void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }
    
    
   public static void main(String args[]){
       String fileExce="I:\\Trabajo\\Gemalto\\RENO_VIVE_TEST.csv";
       loadExceptionRecords(fileExce);
       for (Record record : exceptionRecords) {
           System.out.println("-->"+record.toStringPan());
       }
   }

    public Map<HeaderKey, List<Record>> getRecordsMap() {
        return recordsMap;
    }

    public void setRecordsMap(Map<HeaderKey, List<Record>> recordsMap) {
        this.recordsMap = recordsMap;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

   
    
}
