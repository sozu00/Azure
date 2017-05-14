package com.example.sozu.apml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class getJson {
    private FuncionesMat F;

    public String get() {
        try {
            //connections settings
            String data = "{\"Inputs\": " +
                    "{\"input1\": " +
                    "[{\"tBodyAcc-Mean-1\": \""+String.valueOf(F.meanX()).replace('.',',')+
                    "\",\"tBodyAcc-Mean-2\": \""+String.valueOf(F.meanY()).replace('.',',')+
                    "\",\"tBodyAcc-Mean-3\": \""+String.valueOf(F.meanZ()).replace('.',',')+
                    "\",\"tBodyAcc-STD-1\": \""+String.valueOf(F.stdX()).replace('.',',')+
                    "\",\"tBodyAcc-STD-2\": \""+String.valueOf(F.stdY()).replace('.',',')+
                    "\",\"tBodyAcc-STD-3\": \""+String.valueOf(F.stdZ()).replace('.',',')+
                    "\",\"tBodyAcc-Mad-1\": \""+String.valueOf(F.madX()).replace('.',',')+
                    "\",\"tBodyAcc-Mad-2\": \""+String.valueOf(F.madY()).replace('.',',')+
                    "\",\"tBodyAcc-Mad-3\": \""+String.valueOf(F.madZ()).replace('.',',')+
                    "\",\"tBodyAcc-Max-1\": \""+String.valueOf(F.maxX()).replace('.',',')+
                    "\",\"tBodyAcc-Max-2\": \""+String.valueOf(F.maxY()).replace('.',',')+
                    "\",\"tBodyAcc-Max-3\": \"" +String.valueOf(F.maxZ()).replace('.',',')+
                    "\",\"tBodyAcc-Min-1\": \"" +String.valueOf(F.minX()).replace('.',',')+
                    "\",\"tBodyAcc-Min-2\": \"" +String.valueOf(F.minY()).replace('.',',')+
                    "\",\"tBodyAcc-Min-3\": \"" +String.valueOf(F.minZ()).replace('.',',')+
                    "\",\"tBodyAcc-SMA-1\": \"" +String.valueOf(F.sma()).replace('.',',')+
                    "\",\"tBodyAcc-Energy-1\": \"" +String.valueOf(F.energyX()).replace('.',',')+
                    "\",\"tBodyAcc-Energy-2\": \"" +String.valueOf(F.energyY()).replace('.',',')+
                    "\",\"tBodyAcc-Energy-3\": \"" +String.valueOf(F.energyZ()).replace('.',',')+
                    "\",\"tBodyAcc-IQR-1\": \"" +String.valueOf(F.IQRX()).replace('.',',')+
                    "\",\"tBodyAcc-IQR-2\": \"" +String.valueOf(F.IQRY()).replace('.',',')+
                    "\",\"tBodyAcc-IQR-3\": \"" +String.valueOf(F.IQRZ()).replace('.',',')+
                    "\",\"tBodyAcc-ropy-1\": \"" +String.valueOf(F.entropyX()).replace('.',',')+
                    "\",\"tBodyAcc-ropy-2\": \"" +String.valueOf(F.entropyY()).replace('.',',')+
                    "\",\"tBodyAcc-ropy-3\": \"" +String.valueOf(F.entropyZ()).replace('.',',')+
                    "\",\"tBodyAcc-ARCoeff-1\": \"" +String.valueOf(F.arCoeffX()[0]).replace('.',',')+
                    "\",\"tBodyAcc-ARCoeff-2\": \"" +String.valueOf(F.arCoeffX()[1]).replace('.',',')+
                    "\",\"tBodyAcc-ARCoeff-3\": \"" +String.valueOf(F.arCoeffX()[2]).replace('.',',')+
                    "\",\"tBodyAcc-ARCoeff-4\": \"" +String.valueOf(F.arCoeffX()[3]).replace('.',',')+
                    "\",\"tBodyAcc-ARCoeff-5\": \"" +String.valueOf(F.arCoeffY()[0]).replace('.',',')+
                    "\",\"tBodyAcc-ARCoeff-6\": \"" +String.valueOf(F.arCoeffY()[1]).replace('.',',')+
                    "\",\"tBodyAcc-ARCoeff-7\": \"" +String.valueOf(F.arCoeffY()[2]).replace('.',',')+
                    "\",\"tBodyAcc-ARCoeff-8\": \"" +String.valueOf(F.arCoeffY()[3]).replace('.',',')+
                    "\",\"tBodyAcc-ARCoeff-9\": \"" +String.valueOf(F.arCoeffZ()[0]).replace('.',',')+
                    "\",\"tBodyAcc-ARCoeff-10\": \"" +String.valueOf(F.arCoeffZ()[1]).replace('.',',')+
                    "\",\"tBodyAcc-ARCoeff-11\": \"" +String.valueOf(F.arCoeffZ()[2]).replace('.',',')+
                    "\",\"tBodyAcc-ARCoeff-12\": \"" +String.valueOf(F.arCoeffZ()[3]).replace('.',',')+
                    "\",\"tBodyAccMag-Mean-1\": \"" +String.valueOf(F.meanMag()).replace('.',',')+
                    "\",\"tBodyAccMag-STD-1\": \"" +String.valueOf(F.stdMag()).replace('.',',')+
                    "\",\"tBodyAccMag-Mad-1\": \"" +String.valueOf(F.madMag()).replace('.',',')+
                    "\",\"tBodyAccMag-Max-1\": \"" +String.valueOf(F.maxMag()).replace('.',',')+
                    "\",\"tBodyAccMag-Min-1\": \"" +String.valueOf(F.minMag()).replace('.',',')+
                    "\",\"tBodyAccMag-SMA-1\": \"" +String.valueOf(F.smaMag()).replace('.',',')+
                    "\",\"tBodyAccMag-Energy-1\": \"" +String.valueOf(F.energyMag()).replace('.',',')+
                    "\",\"tBodyAccMag-IQR-1\": \"" +String.valueOf(F.IQRMag()).replace('.',',')+
                    "\",\"tBodyAccMag-ropy-1\": \"" +String.valueOf(F.entropyMag()).replace('.',',')+
                    "\",\"tBodyAccMag-ARCoeff-1\": \"" +String.valueOf(F.arCoeffMag()[0]).replace('.',',')+
                    "\",\"tBodyAccMag-ARCoeff-2\": \"" +String.valueOf(F.arCoeffMag()[1]).replace('.',',')+
                    "\",\"tBodyAccMag-ARCoeff-3\": \"" +String.valueOf(F.arCoeffMag()[2]).replace('.',',')+
                    "\",\"tBodyAccMag-ARCoeff-4\": \"" +String.valueOf(F.arCoeffMag()[3]).replace('.',',')+
                    "\",\"CLASE\": \"4\",}],},\"GlobalParameters\":  {}}";
            String data2 = "{\"Inputs\": {\"input1\": [{\"tBodyAcc-Mean-1\": \"0,043579674\",\"tBodyAcc-Mean-2\": \"-0,005970221\",\"tBodyAcc-Mean-3\": \"-0,035054344\",\"tBodyAcc-STD-1\": \"-0,99538116\",\"tBodyAcc-STD-2\": \"-0,988365863\",\"tBodyAcc-STD-3\": \"-0,937382005\",\"tBodyAcc-Mad-1\": \"-0,995007045\",\"tBodyAcc-Mad-2\": \"-0,988815577\",\"tBodyAcc-Mad-3\": \"-0,953325201\",\"tBodyAcc-Max-1\": \"-0,802536649\",\"tBodyAcc-Max-2\": \"-0,794796369\",\"tBodyAcc-Max-3\": \"-0,648447245\",\"tBodyAcc-Min-1\": \"0,841795574\",\"tBodyAcc-Min-2\": \"0,708440184\",\"tBodyAcc-Min-3\": \"0,651716486\",\"tBodyAcc-SMA-1\": \"-0,975752033\",\"tBodyAcc-Energy-1\": \"-0,999950218\",\"tBodyAcc-Energy-2\": \"-0,999888368\",\"tBodyAcc-Energy-3\": \"-0,998013666\",\"tBodyAcc-IQR-1\": \"-0,993999294\",\"tBodyAcc-IQR-2\": \"-0,991979622\",\"tBodyAcc-IQR-3\": \"-0,970970054\",\"tBodyAcc-ropy-1\": \"-0,547095381\",\"tBodyAcc-ropy-2\": \"-0,70097364\",\"tBodyAcc-ropy-3\": \"-0,622697109\",\"tBodyAcc-ARCoeff-1\": \"0,921884153\",\"tBodyAcc-ARCoeff-2\": \"-0,719482881\",\"tBodyAcc-ARCoeff-3\": \"0,342168007\",\"tBodyAcc-ARCoeff-4\": \"-0,161317646\",\"tBodyAcc-ARCoeff-5\": \"0,266048969\",\"tBodyAcc-ARCoeff-6\": \"-0,274351454\",\"tBodyAcc-ARCoeff-7\": \"0,26720509\",\"tBodyAcc-ARCoeff-8\": \"-0,020958427\",\"tBodyAcc-ARCoeff-9\": \"0,382610239\",\"tBodyAcc-ARCoeff-10\": \"-0,501748058\",\"tBodyAcc-ARCoeff-11\": \"0,51246321\",\"tBodyAcc-ARCoeff-12\": \"-0,206336868\",\"tBodyAccMag-Mean-1\": \"-0,969546337\",\"tBodyAccMag-STD-1\": \"-0,961539739\",\"tBodyAccMag-Mad-1\": \"-0,967645839\",\"tBodyAccMag-Max-1\": \"-0,9472362\",\"tBodyAccMag-Min-1\": \"-0,994174403\",\"tBodyAccMag-SMA-1\": \"-0,969546337\",\"tBodyAccMag-Energy-1\": \"-0,999150002\",\"tBodyAccMag-IQR-1\": \"-0,970525396\",\"tBodyAccMag-ropy-1\": \"-0,21961956\",\"tBodyAccMag-ARCoeff-1\": \"-0,124072048\",\"tBodyAccMag-ARCoeff-2\": \"-0,058240845\",\"tBodyAccMag-ARCoeff-3\": \"0,174306353\",\"tBodyAccMag-ARCoeff-4\": \"0,201620464\",\"CLASE\": \"4\",}],},\"GlobalParameters\":  {}}";

            String api_key = "liSWkYtq1dUfqdQTOKmxnNlmX++O77Vla6fsWE2YR61SK6xdrRvUyM9GeCfSg44cMt2xP46Pg/ispbVJyTNCyA==";
            URL url = new URL("https://ussouthcentral.services.azureml.net/workspaces/ca74073338724abfb41e897d53f7358b/services/9ae215b7a794489ea4815e24031f7d7f/execute?api-version=2.0&format=swagger");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization", "Bearer " + api_key);

            //make the request
            OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
            writer.write(data);
            writer.flush();

            //read the request
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String response;
            StringWriter sw = new StringWriter();
            BufferedWriter bw = new BufferedWriter(sw);
            while((response = reader.readLine())!=null){
                bw.write(response);
            }
            bw.flush();
            bw.close();

            StringBuffer sb = sw.getBuffer();
            return sb.toString();

        } catch (Exception e) {
            return "Excepcion: "+String.valueOf(e);
        }
    }

    public getJson(ArrayList<XYZ> xyz){
        F = new FuncionesMat(xyz);
    }

}
