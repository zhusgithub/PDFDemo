package com.zhushen.pdfdemo.pdf;

import android.graphics.Bitmap;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhushen on 2018/4/28.
 */
public class PDFManager {
    private String filePath = "";

    private PDFManager instance;

    public PDFManager getInstance() {
        if(instance == null){
            instance = new PDFManager();
        }
        return instance;
    }

    public List<String> getFileList(){
        List<String> pathList = new ArrayList<>();
        File[] files = getFiles(filePath);
        for (File file :files) {
            pathList.add(file.getName());
        }
        return pathList;
    }

    public File[] getFiles(String path){
        File file=new File(path);
        File[] files=file.listFiles();
        return files;
    }

    public void createPDFFromBitMap(Bitmap bitmap,String path){
        Document doc = new Document();

        //create file
        File dir = new File(filePath);
        if(!dir.exists()){
            dir.mkdirs();
        }

        //create pdf file
        File file = new File(dir,path);
        try {
            FileOutputStream fOut = new FileOutputStream(file);

            PdfWriter.getInstance(doc, fOut);

            //open the document
            doc.open();

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100 , stream);
            Image myImg = Image.getInstance(stream.toByteArray());
            myImg.setAlignment(Image.MIDDLE);
            //add image to document
            doc.add(myImg);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            doc.close();
        }
    }
}
