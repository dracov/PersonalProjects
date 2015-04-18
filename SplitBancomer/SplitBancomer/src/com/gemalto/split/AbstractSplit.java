/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemalto.split;


import com.gemalto.split.beans.Outputfile;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
    
/**
 *
 * @author Aldo
 */
public abstract class AbstractSplit {
    public static Logger logger=Logger.getLogger(AbstractSplit.class);
    public abstract void doSplits();
    public abstract void doAction();
     
    public  void writeToAFile(String outputFileName,Outputfile outputfile) {
            try {
                logger.info("Escribiendo al archivo:"+outputFileName +" la cantidad: "+outputfile.getRecords().size());
                File fileToWrite=new File(outputFileName);
                FileUtils.writeStringToFile(fileToWrite, outputfile.getHeaderKey().getHeaderString());
                FileUtils.writeLines(fileToWrite, outputfile.getRecords(),true);
               } catch (Exception ex) {
               logger.error(ex.getMessage(),ex);
               
           }
     }
    
}
