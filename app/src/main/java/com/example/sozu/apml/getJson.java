package com.example.sozu.apml;

import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class getJson {
    private FuncionesMat F;

    public String get() {
        //System.out.println(\"Llamando al modelo azure\");
        try {
            //connections settings
            JSONParser parser = new JSONParser();
            String data = "{\"Inputs\": " +
                    "{\"input1\": " +
                    "[{\"tBodyAcc-Mean-1\": \""+F.meanX()+
                    "\",\"tBodyAcc-Mean-2\": \""+F.meanY()+
                    "\",\"tBodyAcc-Mean-3\": \""+F.meanZ()+
                    "\",\"tBodyAcc-STD-1\": \"-0,99538116\",\"tBodyAcc-STD-2\": \"-0,988365863\",\"tBodyAcc-STD-3\": \"-0,937382005\",\"tBodyAcc-Mad-1\": \"-0,995007045\",\"tBodyAcc-Mad-2\": \"-0,988815577\",\"tBodyAcc-Mad-3\": \"-0,953325201\",\"tBodyAcc-Max-1\": \"-0,802536649\",\"tBodyAcc-Max-2\": \"-0,794796369\",\"tBodyAcc-Max-3\": \"-0,648447245\",\"tBodyAcc-Min-1\": \"0,841795574\",\"tBodyAcc-Min-2\": \"0,708440184\",\"tBodyAcc-Min-3\": \"0,651716486\",\"tBodyAcc-SMA-1\": \"-0,975752033\",\"tBodyAcc-Energy-1\": \"-0,999950218\",\"tBodyAcc-Energy-2\": \"-0,999888368\",\"tBodyAcc-Energy-3\": \"-0,998013666\",\"tBodyAcc-IQR-1\": \"-0,993999294\",\"tBodyAcc-IQR-2\": \"-0,991979622\",\"tBodyAcc-IQR-3\": \"-0,970970054\",\"tBodyAcc-ropy-1\": \"-0,547095381\",\"tBodyAcc-ropy-2\": \"-0,70097364\",\"tBodyAcc-ropy-3\": \"-0,622697109\",\"tBodyAcc-ARCoeff-1\": \"0,921884153\",\"tBodyAcc-ARCoeff-2\": \"-0,719482881\",\"tBodyAcc-ARCoeff-3\": \"0,342168007\",\"tBodyAcc-ARCoeff-4\": \"-0,161317646\",\"tBodyAcc-ARCoeff-5\": \"0,266048969\",\"tBodyAcc-ARCoeff-6\": \"-0,274351454\",\"tBodyAcc-ARCoeff-7\": \"0,26720509\",\"tBodyAcc-ARCoeff-8\": \"-0,020958427\",\"tBodyAcc-ARCoeff-9\": \"0,382610239\",\"tBodyAcc-ARCoeff-10\": \"-0,501748058\",\"tBodyAcc-ARCoeff-11\": \"0,51246321\",\"tBodyAcc-ARCoeff-12\": \"-0,206336868\",\"tBodyAcc-Correlation-1\": \"0,376778004\",\"tBodyAcc-Correlation-2\": \"0,435172317\",\"tBodyAcc-Correlation-3\": \"0,66019853\",\"tBodyAccMag-Mean-1\": \"-0,969546337\",\"tBodyAccMag-STD-1\": \"-0,961539739\",\"tBodyAccMag-Mad-1\": \"-0,967645839\",\"tBodyAccMag-Max-1\": \"-0,9472362\",\"tBodyAccMag-Min-1\": \"-0,994174403\",\"tBodyAccMag-SMA-1\": \"-0,969546337\",\"tBodyAccMag-Energy-1\": \"-0,999150002\",\"tBodyAccMag-IQR-1\": \"-0,970525396\",\"tBodyAccMag-ropy-1\": \"-0,21961956\",\"tBodyAccMag-ARCoeff-1\": \"-0,124072048\",\"tBodyAccMag-ARCoeff-2\": \"-0,058240845\",\"tBodyAccMag-ARCoeff-3\": \"0,174306353\",\"tBodyAccMag-ARCoeff-4\": \"0,201620464\",\"fBodyAcc-Mean-1\": \"-0,994809834\",\"fBodyAcc-Mean-2\": \"-0,982984099\",\"fBodyAcc-Mean-3\": \"-0,939455343\",\"fBodyAcc-STD-1\": \"-0,995272004\",\"fBodyAcc-STD-2\": \"-0,989848258\",\"fBodyAcc-STD-3\": \"-0,996824354\",\"fBodyAcc-Mad-1\": \"-0,996824354\",\"fBodyAcc-Mad-2\": \"-0,984703069\",\"fBodyAcc-Mad-3\": \"-0,933408785\",\"fBodyAcc-Max-1\": \"-0,993663737\",\"fBodyAcc-Max-2\": \"-0,990217401\",\"fBodyAcc-Max-3\": \"-0,942331996\",\"fBodyAcc-Min-1\": \"-0,993952664\",\"fBodyAcc-Min-2\": \"-0,993447891\",\"fBodyAcc-Min-3\": \"-0,923441387\",\"fBodyAcc-SMA-1\": \"-0,974732706\",\"fBodyAcc-Energy-1\": \"-0,999968834\",\"fBodyAcc-Energy-2\": \"-0,999850408\",\"fBodyAcc-Energy-3\": \"-0,997308392\",\"fBodyAcc-IQR-1\": \"-0,996767586\",\"fBodyAcc-IQR-2\": \"-0,989708889\",\"fBodyAcc-IQR-3\": \"-0,990807294\",\"fBodyAcc-ropy-1\": \"-0,94635692\",\"fBodyAcc-ropy-2\": \"-0,904747763\",\"fBodyAcc-ropy-3\": \"-0,591302475\",\"fBodyAcc-MaxInds-1\": \"-1\",\"fBodyAcc-MaxInds-2\": \"-1\",\"fBodyAcc-MaxInds-3\": \"-1\",\"fBodyAcc-MeanFreq-1\": \"0,362081644\",\"fBodyAcc-MeanFreq-2\": \"0,159191141\",\"fBodyAcc-MeanFreq-3\": \"0,04834979\",\"fBodyAcc-Skewness-1\": \"0,141770079\",\"fBodyAcc-Kurtosis-1\": \"-0,151402429\",\"fBodyAcc-Skewness-2\": \"-0,260648523\",\"fBodyAcc-Kurtosis-2\": \"-0,551541897\",\"fBodyAcc-Skewness-3\": \"0,253213642\",\"fBodyAcc-Kurtosis-3\": \"-0,019604287\",\"fBodyAccMag-Mean-1\": \"-0,951549871\",\"fBodyAccMag-STD-1\": \"-0,966537569\",\"fBodyAccMag-Mad-1\": \"-0,948523894\",\"fBodyAccMag-Max-1\": \"-0,981574846\",\"fBodyAccMag-Min-1\": \"-0,921602884\",\"fBodyAccMag-SMA-1\": \"-0,951549871\",\"fBodyAccMag-Energy-1\": \"-0,998989478\",\"fBodyAccMag-IQR-1\": \"-0,972006561\",\"fBodyAccMag-ropy-1\": \"-0,646376446\",\"fBodyAccMag-MaxInds-1\": \"-0,842105263\",\"fBodyAccMag-MeanFreq-1\": \"-0,061629034\",\"fBodyAccMag-Skewness-1\": \"-0,446120233\",\"fBodyAccMag-Kurtosis-1\": \"-0,797046006\",\"CLASE\": \"4\",}],},\"GlobalParameters\":  {}}";
            String data2 = "{\"Inputs\": {\"input1\": [{\"tBodyAcc-Mean-1\": \"0,043579674\",\"tBodyAcc-Mean-2\": \"-0,005970221\",\"tBodyAcc-Mean-3\": \"-0,035054344\",\"tBodyAcc-STD-1\": \"-0,99538116\",\"tBodyAcc-STD-2\": \"-0,988365863\",\"tBodyAcc-STD-3\": \"-0,937382005\",\"tBodyAcc-Mad-1\": \"-0,995007045\",\"tBodyAcc-Mad-2\": \"-0,988815577\",\"tBodyAcc-Mad-3\": \"-0,953325201\",\"tBodyAcc-Max-1\": \"-0,802536649\",\"tBodyAcc-Max-2\": \"-0,794796369\",\"tBodyAcc-Max-3\": \"-0,648447245\",\"tBodyAcc-Min-1\": \"0,841795574\",\"tBodyAcc-Min-2\": \"0,708440184\",\"tBodyAcc-Min-3\": \"0,651716486\",\"tBodyAcc-SMA-1\": \"-0,975752033\",\"tBodyAcc-Energy-1\": \"-0,999950218\",\"tBodyAcc-Energy-2\": \"-0,999888368\",\"tBodyAcc-Energy-3\": \"-0,998013666\",\"tBodyAcc-IQR-1\": \"-0,993999294\",\"tBodyAcc-IQR-2\": \"-0,991979622\",\"tBodyAcc-IQR-3\": \"-0,970970054\",\"tBodyAcc-ropy-1\": \"-0,547095381\",\"tBodyAcc-ropy-2\": \"-0,70097364\",\"tBodyAcc-ropy-3\": \"-0,622697109\",\"tBodyAcc-ARCoeff-1\": \"0,921884153\",\"tBodyAcc-ARCoeff-2\": \"-0,719482881\",\"tBodyAcc-ARCoeff-3\": \"0,342168007\",\"tBodyAcc-ARCoeff-4\": \"-0,161317646\",\"tBodyAcc-ARCoeff-5\": \"0,266048969\",\"tBodyAcc-ARCoeff-6\": \"-0,274351454\",\"tBodyAcc-ARCoeff-7\": \"0,26720509\",\"tBodyAcc-ARCoeff-8\": \"-0,020958427\",\"tBodyAcc-ARCoeff-9\": \"0,382610239\",\"tBodyAcc-ARCoeff-10\": \"-0,501748058\",\"tBodyAcc-ARCoeff-11\": \"0,51246321\",\"tBodyAcc-ARCoeff-12\": \"-0,206336868\",\"tBodyAcc-Correlation-1\": \"0,376778004\",\"tBodyAcc-Correlation-2\": \"0,435172317\",\"tBodyAcc-Correlation-3\": \"0,66019853\",\"tBodyAccMag-Mean-1\": \"-0,969546337\",\"tBodyAccMag-STD-1\": \"-0,961539739\",\"tBodyAccMag-Mad-1\": \"-0,967645839\",\"tBodyAccMag-Max-1\": \"-0,9472362\",\"tBodyAccMag-Min-1\": \"-0,994174403\",\"tBodyAccMag-SMA-1\": \"-0,969546337\",\"tBodyAccMag-Energy-1\": \"-0,999150002\",\"tBodyAccMag-IQR-1\": \"-0,970525396\",\"tBodyAccMag-ropy-1\": \"-0,21961956\",\"tBodyAccMag-ARCoeff-1\": \"-0,124072048\",\"tBodyAccMag-ARCoeff-2\": \"-0,058240845\",\"tBodyAccMag-ARCoeff-3\": \"0,174306353\",\"tBodyAccMag-ARCoeff-4\": \"0,201620464\",\"fBodyAcc-Mean-1\": \"-0,994809834\",\"fBodyAcc-Mean-2\": \"-0,982984099\",\"fBodyAcc-Mean-3\": \"-0,939455343\",\"fBodyAcc-STD-1\": \"-0,995272004\",\"fBodyAcc-STD-2\": \"-0,989848258\",\"fBodyAcc-STD-3\": \"-0,996824354\",\"fBodyAcc-Mad-1\": \"-0,996824354\",\"fBodyAcc-Mad-2\": \"-0,984703069\",\"fBodyAcc-Mad-3\": \"-0,933408785\",\"fBodyAcc-Max-1\": \"-0,993663737\",\"fBodyAcc-Max-2\": \"-0,990217401\",\"fBodyAcc-Max-3\": \"-0,942331996\",\"fBodyAcc-Min-1\": \"-0,993952664\",\"fBodyAcc-Min-2\": \"-0,993447891\",\"fBodyAcc-Min-3\": \"-0,923441387\",\"fBodyAcc-SMA-1\": \"-0,974732706\",\"fBodyAcc-Energy-1\": \"-0,999968834\",\"fBodyAcc-Energy-2\": \"-0,999850408\",\"fBodyAcc-Energy-3\": \"-0,997308392\",\"fBodyAcc-IQR-1\": \"-0,996767586\",\"fBodyAcc-IQR-2\": \"-0,989708889\",\"fBodyAcc-IQR-3\": \"-0,990807294\",\"fBodyAcc-ropy-1\": \"-0,94635692\",\"fBodyAcc-ropy-2\": \"-0,904747763\",\"fBodyAcc-ropy-3\": \"-0,591302475\",\"fBodyAcc-MaxInds-1\": \"-1\",\"fBodyAcc-MaxInds-2\": \"-1\",\"fBodyAcc-MaxInds-3\": \"-1\",\"fBodyAcc-MeanFreq-1\": \"0,362081644\",\"fBodyAcc-MeanFreq-2\": \"0,159191141\",\"fBodyAcc-MeanFreq-3\": \"0,04834979\",\"fBodyAcc-Skewness-1\": \"0,141770079\",\"fBodyAcc-Kurtosis-1\": \"-0,151402429\",\"fBodyAcc-Skewness-2\": \"-0,260648523\",\"fBodyAcc-Kurtosis-2\": \"-0,551541897\",\"fBodyAcc-Skewness-3\": \"0,253213642\",\"fBodyAcc-Kurtosis-3\": \"-0,019604287\",\"fBodyAccMag-Mean-1\": \"-0,951549871\",\"fBodyAccMag-STD-1\": \"-0,966537569\",\"fBodyAccMag-Mad-1\": \"-0,948523894\",\"fBodyAccMag-Max-1\": \"-0,981574846\",\"fBodyAccMag-Min-1\": \"-0,921602884\",\"fBodyAccMag-SMA-1\": \"-0,951549871\",\"fBodyAccMag-Energy-1\": \"-0,998989478\",\"fBodyAccMag-IQR-1\": \"-0,972006561\",\"fBodyAccMag-ropy-1\": \"-0,646376446\",\"fBodyAccMag-MaxInds-1\": \"-0,842105263\",\"fBodyAccMag-MeanFreq-1\": \"-0,061629034\",\"fBodyAccMag-Skewness-1\": \"-0,446120233\",\"fBodyAccMag-Kurtosis-1\": \"-0,797046006\",\"CLASE\": \"4\",}],},\"GlobalParameters\":  {}}";

            //String data = parser.parse(new FileReader("D:\\uni17\\APML1\\data\\datos.json")).toString();
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
            //BufferedWriter bw = new BufferedWriter(new FileWriter(new File(\"archivo.json\")));
            while((response = reader.readLine())!=null){
                bw.write(response);
                //bw.write(response);
            }
            bw.flush();
            bw.close();

            StringBuffer sb = sw.getBuffer();
            return sb.toString();
            //return F.meanY();

        } catch (Exception e) {
            System.out.println("Excepcion: " + e);
            return "Excepcion: "+String.valueOf(e);
        }
    }

    public getJson(ArrayList<XYZ> xyz){
        F  = new FuncionesMat(xyz);
    }

}
