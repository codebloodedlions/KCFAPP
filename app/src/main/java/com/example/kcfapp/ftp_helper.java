package com.example.kcfapp;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.net.InetAddress;

public class ftp_helper {
    public void runInBackground(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                uploadData();
            }
        });
    }

    private void uploadData(){
        String domain = "access907484405.webspace-data.io";
        String username = "u108050938";
        String password = "cbLU!2022";
        String serverPath = "";

        @SuppressLint("SdCardPath")
        File file = new File("/data/data/com.example.kcfapp/locations.json");
        String fileName = "locations.json";
        FTPClient ftp = new FTPClient();
        try {
            ftp.connect(InetAddress.getByName(domain));
            ftp.login(username, password);

            //ftp.changeWorkingDirectory()  //for changing folder
            ftp.setFileType(FTP.BINARY_FILE_TYPE);

            FileInputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            ftp.enterLocalPassiveMode();
            ftp.storeFile(fileName, bufferedInputStream);
            bufferedInputStream.close();

            ftp.logout();
            ftp.disconnect();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
