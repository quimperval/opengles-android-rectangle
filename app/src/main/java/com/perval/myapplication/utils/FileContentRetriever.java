package com.perval.myapplication.utils;

import android.content.Context;
import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileContentRetriever {

    public static String readTextFileFromResource(Context context, int resourceId){
        StringBuilder sb = new StringBuilder();
        try{
            InputStream is = context.getResources().openRawResource(resourceId);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String nextLine;

            while((nextLine=br.readLine())!=null){
                sb.append(nextLine);
                sb.append('\n');
            }
        }catch (IOException io){
            throw new RuntimeException("Could not open resource " + resourceId);
        }catch(Resources.NotFoundException nfe){
            throw new RuntimeException("Resource not found " + resourceId);
        }
        return sb.toString();
    }
}
