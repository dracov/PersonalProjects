/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemalto.split.util;

import com.gemalto.split.masivos.beans.CsvFileBean;
import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.annotations.internal.ValueProcessorProvider;
import com.googlecode.jcsv.reader.CSVEntryParser;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.AnnotationEntryParser;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author aldmendo
 */
public class Util {
    
    
      //This method gets the file name read in the Input Directory and changes it to add the sucursal, and remesa and a counter in its name
   public static String getFileNameWithPostInformation(String originalName,String postInformation){
       String newName="";
       String extension= originalName.substring(originalName.indexOf("."), originalName.length());
       String tempName= originalName.substring(0, originalName.indexOf("."));
       newName=tempName+postInformation+extension;
       
       return newName;
   }
   
   
   public static void main(String args[]){
   String mensaje= "asdasdsa|?|saff435r";
   
       System.out.println(mensaje.replace("|?", ""));
   
   
   }
   
   

   
   
    
}
