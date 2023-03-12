package com.microprocessor8086.microprocessor8086simulator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.Locale;

public class home_activity extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private static String URL_web = "https://drive.google.com/viewerng/viewer?embedded=true&url=https://www.davuniversity.org/images/files/study-material/Intel%208086.pdf";
    private EditText AH, AL, BH, BL, CH, CL, DH, DL;
    private EditText inputCode0,inputCode1,inputCode2,inputCode3,inputCode4,inputCode5,inputCode6,inputCode7,inputCode8,inputCode9,inputCode10,inputCode11,inputCode12;
    private EditText HEX_Location_input1,
            HEX_Location_input2,HEX_Location_input3,HEX_Location_input4,HEX_Location_input5,HEX_Location_input6,
            HEX_Location_input7,HEX_Location_input8,HEX_Location_input9,HEX_Location_input10,HEX_Location_input11,
            HEX_Location_input12,HEX_Location_input13,HEX_Location_input14,HEX_Location_input15,HEX_Location_input16,
            HEX_Location_input17,HEX_Location_input18,HEX_Location_input19,HEX_Location_input20,HEX_Location_input21,
            HEX_Location_input22,HEX_Location_input23,HEX_Location_input24,HEX_Location_input25,HEX_Location_input26,
            HEX_Location_input27,HEX_Location_input28,HEX_Location_input29,HEX_Location_input30;
    EditText[] HEX_Input;

    private WebView webView_point;
    private ProgressBar webLoding;

    private Button RUN, REG, DATA,exit_btn_no,exit_btn_yes,larn_code_BTN, allButon[];
    private TextView textnow, terminal;
    private ImageView close_btn,Close_BTN_ADD_DATA;
    private LinearLayout REG_LAYOUT, CODE_LAYOUT, ADDRASSING_LAYOUT, exit_windows,web_view_liner,all_layouts[];
    private String[] inputData, inputData2;
    private String fristNumber, secondNumber;
    private boolean Loop_ON_OFF = false,Loop_calling__temp_ON_Off = true,reg_8bit_out_on = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        /*ads part*/
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView_reg);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        InterstitialAd.load(this,getString(R.string.interstitial), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;
                        mInterstitialAd.show(home_activity.this);
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                    }
                });
        /*ads part*/



        inputCode0 = (EditText) findViewById(R.id.inputcode0);
        inputCode1 = (EditText) findViewById(R.id.inputcode1);
        inputCode2 = (EditText) findViewById(R.id.inputcode2);
        inputCode3 = (EditText) findViewById(R.id.inputcode3);
        inputCode4 = (EditText) findViewById(R.id.inputcode4);
        inputCode5 = (EditText) findViewById(R.id.inputcode5);
        inputCode6 = (EditText) findViewById(R.id.inputcode6);
        inputCode7 = (EditText) findViewById(R.id.inputcode7);
        inputCode8 = (EditText) findViewById(R.id.inputcode8);
        inputCode9 = (EditText) findViewById(R.id.inputcode9);
        inputCode10 = (EditText) findViewById(R.id.inputcode10);
        inputCode11 = (EditText) findViewById(R.id.inputcode11);
        inputCode12 = (EditText) findViewById(R.id.inputcode12);


        AH = (EditText) findViewById(R.id.reg_AH);
        AL = (EditText) findViewById(R.id.reg_AL);
        BH = (EditText) findViewById(R.id.reg_BH);
        BL = (EditText) findViewById(R.id.reg_BL);
        CH = (EditText) findViewById(R.id.reg_CH);
        CL = (EditText) findViewById(R.id.reg_CL);
        DH = (EditText) findViewById(R.id.reg_DH);
        DL = (EditText) findViewById(R.id.reg_DL);

        webView_point = findViewById(R.id.webView_point);
        webLoding = findViewById(R.id.progressBar_webView);


        int[] AD_HEX_DATA = new int[]{R.id.AD_2001H_INP,R.id.AD_2002H_INP,R.id.AD_2003H_INP,R.id.AD_2004H_INP,R.id.AD_2005H_INP,
                R.id.AD_2006H_INP,R.id.AD_2007H_INP,R.id.AD_2008H_INP,R.id.AD_2009H_INP,R.id.AD_2010H_INP,R.id.AD_2011H_INP,R.id.AD_2012H_INP,
                R.id.AD_2013H_INP,R.id.AD_2014H_INP,R.id.AD_2015H_INP,R.id.AD_2016H_INP,R.id.AD_2017H_INP,R.id.AD_2018H_INP,R.id.AD_2019H_INP,
                R.id.AD_2020H_INP,R.id.AD_2021H_INP,R.id.AD_2022H_INP,R.id.AD_2023H_INP,R.id.AD_2024H_INP,R.id.AD_2025H_INP,R.id.AD_2026H_INP,
                R.id.AD_2027H_INP,R.id.AD_2028H_INP,R.id.AD_2029H_INP,R.id.AD_2030H_INP};
        HEX_Input = new EditText[]{HEX_Location_input1,
                HEX_Location_input2,HEX_Location_input3,HEX_Location_input4,HEX_Location_input5,HEX_Location_input6,HEX_Location_input7,
                HEX_Location_input8,HEX_Location_input9,HEX_Location_input10,HEX_Location_input11,HEX_Location_input12,HEX_Location_input13,
                HEX_Location_input14,HEX_Location_input15,HEX_Location_input16,HEX_Location_input17,HEX_Location_input18,HEX_Location_input19,
                HEX_Location_input20,HEX_Location_input21,HEX_Location_input22,HEX_Location_input23,HEX_Location_input24,HEX_Location_input25,
                HEX_Location_input26,HEX_Location_input27,HEX_Location_input28,HEX_Location_input29,HEX_Location_input30};
        for (int i=0; i<HEX_Input.length; i++)
        {
            HEX_Input[i] = (EditText) findViewById(AD_HEX_DATA[i]);
        }

        int[] buttons = new int[]{R.id.RUN_BTN, R.id.REG_WINDOW_OPEN_BTN, R.id.addDATA_WINDOW_OPEN_BTN, R.id.exitPanel_no, R.id.exitPanel_yes, R.id.larn_code_8086};
        allButon = new Button[]{RUN, REG, DATA, exit_btn_no, exit_btn_yes, larn_code_BTN};
        for (int i=0; i<allButon.length; i++){
            allButon[i] = (Button) findViewById(buttons[i]);
        }
        int[] Layouts = new int[]{R.id.REG_WINDOW, R.id.mainCodePanel, R.id.addressing_location_pannel, R.id.application_close_notic, R.id.webView_point_liner};
        all_layouts = new LinearLayout[]{REG_LAYOUT, CODE_LAYOUT, ADDRASSING_LAYOUT, exit_windows,web_view_liner};
        for(int i=0; i<all_layouts.length; i++){
            all_layouts[i] = (LinearLayout) findViewById(Layouts[i]);
        }

        textnow = (TextView) findViewById(R.id.nametext);
        terminal = (TextView) findViewById(R.id.terminal);
        taskCall();

        allButon[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_Set();
                run_function();
            }
        });
        allButon[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                all_layouts[1].setVisibility(View.GONE);
                all_layouts[2].setVisibility(View.GONE);
                all_layouts[0].setVisibility(View.VISIBLE);
                all_layouts[3].setVisibility(View.GONE);
                all_layouts[4].setVisibility(View.GONE);
            }
        });
        allButon[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                all_layouts[1].setVisibility(View.GONE);
                all_layouts[0].setVisibility(View.GONE);
                all_layouts[2].setVisibility(View.VISIBLE);
                all_layouts[3].setVisibility(View.GONE);
                all_layouts[4].setVisibility(View.GONE);
            }
        });

        allButon[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("not exit");
                all_layouts[3].setVisibility(View.GONE);
            }
        });
        allButon[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                System.exit(1);
            }
        });
        allButon[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                all_layouts[0].setVisibility(View.GONE);
                all_layouts[1].setVisibility(View.GONE);
                all_layouts[2].setVisibility(View.GONE);
                all_layouts[3].setVisibility(View.GONE);
                all_layouts[4].setVisibility(View.VISIBLE);
                webView_point.loadUrl(URL_web);
                webView_point.getSettings().setJavaScriptEnabled(true);
                webView_point.setWebViewClient(new WebViewClient(){
                    @Override
                    public void onPageFinished(WebView view, String url) {
                        super.onPageFinished(view, url);
                        webView_point.setVisibility(View.VISIBLE);
                        webLoding.setVisibility(View.GONE);
                    }
                });
            }
        });


    }

    public void close_layout(View v){
        all_layouts[0].setVisibility(View.GONE);
        all_layouts[2].setVisibility(View.GONE);
        all_layouts[1].setVisibility(View.VISIBLE);
        all_layouts[3].setVisibility(View.GONE);
        all_layouts[4].setVisibility(View.GONE);
    }

    private void data_Set()
    {
        for (int i=0; i<=29; i++){
            switch (HEX_Input[i].getText().toString()){
                case "":
                    HEX_Input[i].setText("0000");
            }
        }
        EditText[] REG = new EditText[]{AH,AL,BH,BL,CH,CL,DH,DL};
        for(int i=0; i<=7; i++){
            switch (REG[i].getText().toString()){
                case "":
                    REG[i].setText("00");
            }
        }


    }

    @Override
    public void onBackPressed() {
        if(all_layouts[1].getVisibility() == View.GONE){
            all_layouts[0].setVisibility(View.GONE);
            all_layouts[2].setVisibility(View.GONE);
            all_layouts[1].setVisibility(View.VISIBLE);
            all_layouts[3].setVisibility(View.GONE);
            all_layouts[4].setVisibility(View.GONE);
        }
        else{
            all_layouts[3].setVisibility(View.VISIBLE);
        }
    }

    private  void run_function() {

        if (!inputCode0.getText().toString().isEmpty()
                ||!inputCode1.getText().toString().isEmpty()
                ||!inputCode2.getText().toString().isEmpty()
                ||!inputCode3.getText().toString().isEmpty()
                ||!inputCode4.getText().toString().isEmpty()
                ||!inputCode5.getText().toString().isEmpty()
                ||!inputCode6.getText().toString().isEmpty()
                ||!inputCode7.getText().toString().isEmpty()
                ||!inputCode8.getText().toString().isEmpty()
                ||!inputCode9.getText().toString().isEmpty()
                ||!inputCode10.getText().toString().isEmpty()
                ||!inputCode11.getText().toString().isEmpty()
                ||!inputCode12.getText().toString().isEmpty()) {
            for (int i = 0; i <= 12; i++) {
                switch (i) {
                    case 0:
                        if (!inputCode0.getText().toString().isEmpty()) {
                            inputData = inputCode0.getText().toString().toUpperCase(Locale.ROOT).split(" ");
                            switch (inputData[0]) {
                                case "HLT":
                                    terminal.setText("error___404_Not_any_function_run");
                                    break;
                                default:
                                        inputData2 = inputData[1].split(",");
                                        if(inputData.length==2){
                                            inputcodeDivArange();
                                        }
                                        else{
                                             Syntax_error("1");
                                        }
                               /* inputData2 = inputData[1].split(",");
                                inputcodeDivArange();*/
                                //reg_data_read_Show_in_terminal();
                                Loop_ON_OFF = false;
                                break;
                            }

                        }
                        break;
                    case 1:
                        if (!inputCode1.getText().toString().isEmpty()) {
                                inputData = inputCode1.getText().toString().toUpperCase(Locale.ROOT).split(" ");
                                switch (inputData[0]) {
                                case "HLT":
                                    HLT_function(1);
                                    inputcodeDivArange();
                                    Loop_ON_OFF = true;
                                    break;
                                default:
                                    inputData2 = inputData[1].split(",");
                                    if(inputData2.length==2) {
                                        inputcodeDivArange();
                                    }
                                    else {
                                        Syntax_error("2");
                                    }
                                    //reg_data_read_Show_in_terminal();
                                    Loop_ON_OFF = false;
                                    break;
                            }
                        }
                        break;
                    case 2:
                        if (!inputCode2.getText().toString().isEmpty()) {
                                inputData = inputCode2.getText().toString().toUpperCase(Locale.ROOT).split(" ");
                                switch (inputData[0]) {
                                    case "HLT":
                                        HLT_function(2);
                                        inputcodeDivArange();
                                        Loop_ON_OFF = true;
                                        break;
                                    default:
                                        inputData2 = inputData[1].split(",");
                                        if(inputData2.length==2){
                                            inputcodeDivArange();
                                        }
                                        else{Syntax_error("3");}
                                        //reg_data_read_Show_in_terminal();
                                        Loop_ON_OFF = false;
                                        break;
                                }
                        }
                        break;
                    case 3:
                        if (!inputCode3.getText().toString().isEmpty()) {
                                inputData = inputCode3.getText().toString().toUpperCase(Locale.ROOT).split(" ");
                                switch (inputData[0]) {
                                case "HLT":
                                    HLT_function(3);
                                    inputcodeDivArange();
                                    Loop_ON_OFF = true;
                                    break;
                                default:
                                    inputData2 = inputData[1].split(",");
                                    if(inputData2.length==2) {
                                        inputcodeDivArange();
                                    }
                                    else{Syntax_error("4");}
                                    //reg_data_read_Show_in_terminal();
                                    Loop_ON_OFF = false;
                                    break;
                            }
                        }
                        break;
                    case 4:
                        if (!inputCode4.getText().toString().isEmpty()) {
                                inputData = inputCode4.getText().toString().toUpperCase(Locale.ROOT).split(" ");
                                switch (inputData[0]) {
                                    case "HLT":
                                        HLT_function(4);
                                        inputcodeDivArange();
                                        Loop_ON_OFF = true;
                                        break;
                                    default:
                                        inputData2 = inputData[1].split(",");
                                        if(inputData2.length==2) {
                                            inputcodeDivArange();
                                        }
                                        else {Syntax_error("5");}
                                        //reg_data_read_Show_in_terminal();
                                        Loop_ON_OFF = false;
                                        break;
                                }
                        }
                        break;
                    case 5:
                        if (!inputCode5.getText().toString().isEmpty()) {
                                inputData = inputCode5.getText().toString().toUpperCase(Locale.ROOT).split(" ");
                                switch (inputData[0]) {
                                case "HLT":
                                    HLT_function(5);
                                    inputcodeDivArange();
                                    Loop_ON_OFF = true;
                                    break;
                                default:
                                    inputData2 = inputData[1].split(",");
                                    if(inputData2.length==2) {
                                        inputcodeDivArange();
                                    }
                                    else {Syntax_error("6");}
                                    //reg_data_read_Show_in_terminal();
                                    Loop_ON_OFF = false;
                                    break;
                            }
                        }
                        break;
                    case 6:
                        if (!inputCode6.getText().toString().isEmpty()) {
                                inputData = inputCode6.getText().toString().toUpperCase(Locale.ROOT).split(" ");
                                switch (inputData[0]) {
                                case "HLT":
                                    HLT_function(6);
                                    inputcodeDivArange();
                                    Loop_ON_OFF = true;
                                    break;
                                default:
                                    inputData2 = inputData[1].split(",");
                                    if(inputData2.length==2) {
                                        inputcodeDivArange();
                                    }
                                    else{
                                        Syntax_error("7");
                                    }
                                    //reg_data_read_Show_in_terminal();
                                    Loop_ON_OFF = false;
                                    break;
                            }
                        }
                        break;
                    case 7:
                        if (!inputCode7.getText().toString().isEmpty()) {
                                inputData = inputCode7.getText().toString().toUpperCase(Locale.ROOT).split(" ");
                                switch (inputData[0])
                                {
                                    case "HLT":
                                        HLT_function(7);
                                        inputcodeDivArange();
                                        Loop_ON_OFF = true;
                                        break;
                                    default:
                                        inputData2 = inputData[1].split(",");
                                        if(inputData2.length==2) {
                                            inputcodeDivArange();
                                        }
                                        else {Syntax_error("8");}
                                        //reg_data_read_Show_in_terminal();
                                        Loop_ON_OFF = false;
                                        break;
                                }
                        }
                        break;
                    case 8:
                        if (!inputCode8.getText().toString().isEmpty()) {
                                inputData = inputCode8.getText().toString().toUpperCase(Locale.ROOT).split(" ");
                                switch (inputData[0])
                                {
                                case "HLT":
                                    HLT_function(8);
                                    inputcodeDivArange();
                                    Loop_ON_OFF = true;
                                    break;
                                default:
                                    inputData2 = inputData[1].split(",");
                                    if(inputData2.length==2) {
                                        inputcodeDivArange();
                                    }
                                    else{Syntax_error("9");}
                                    //reg_data_read_Show_in_terminal();
                                    Loop_ON_OFF = false;
                                    break;
                                }
                        }
                        break;
                    case 9:
                        if (!inputCode9.getText().toString().isEmpty()) {
                                inputData = inputCode9.getText().toString().toUpperCase(Locale.ROOT).split(" ");
                                switch (inputData[0])
                                {
                                case "HLT":
                                    HLT_function(9);
                                    inputcodeDivArange();
                                    Loop_ON_OFF = true;
                                    break;
                                default:
                                    inputData2 = inputData[1].split(",");
                                    if(inputData2.length==2) {
                                        inputcodeDivArange();
                                    }
                                    else{Syntax_error("10");}
                                    //reg_data_read_Show_in_terminal();
                                    Loop_ON_OFF = false;
                                    break;
                                }
                        }
                        break;
                    case 10:
                        if (!inputCode10.getText().toString().isEmpty()) {
                                inputData = inputCode10.getText().toString().toUpperCase(Locale.ROOT).split(" ");
                                switch (inputData[0])
                                {
                                case "HLT":
                                    HLT_function(10);
                                    inputcodeDivArange();
                                    Loop_ON_OFF = true;
                                    break;
                                default:
                                    inputData2 = inputData[1].split(",");
                                    if(inputData2.length==2) {
                                        inputcodeDivArange();
                                    }
                                    else{Syntax_error("11");}
                                    //reg_data_read_Show_in_terminal();
                                    Loop_ON_OFF = false;
                                    break;
                                }
                        }
                        break;
                    case 11:
                        if (!inputCode11.getText().toString().isEmpty()) {
                                inputData = inputCode11.getText().toString().toUpperCase(Locale.ROOT).split(" ");
                                switch (inputData[0])
                                {
                                case "HLT":
                                    HLT_function(11);
                                    inputcodeDivArange();
                                    Loop_ON_OFF = true;
                                    break;
                                default:
                                    inputData2 = inputData[1].split(",");
                                    if(inputData2.length==2) {
                                        inputcodeDivArange();
                                    }
                                    else{Syntax_error("12");}
                                    //reg_data_read_Show_in_terminal();
                                    Loop_ON_OFF = false;
                                    break;
                                }
                        }
                        break;
                    case 12:
                        if (!inputCode12.getText().toString().isEmpty()) {
                                inputData = inputCode12.getText().toString().toUpperCase(Locale.ROOT).split(" ");
                                switch (inputData[0])
                                {
                                case "HLT":
                                    HLT_function(12);
                                    inputcodeDivArange();
                                    Loop_ON_OFF = true;
                                    break;
                                default:
                                    inputData2 = inputData[1].split(",");
                                    if(inputData2.length==2) {
                                        inputcodeDivArange();
                                    }
                                    else{Syntax_error("13");}
                                    //reg_data_read_Show_in_terminal();
                                    Loop_ON_OFF = false;
                                    break;
                                }
                        }

                        break;
                }
            }
        }
        else{
            Toast.makeText(getApplicationContext(),"CODE_MISSING_ERROR_",Toast.LENGTH_LONG);
        }
        if(Loop_calling__temp_ON_Off == true) {
            Loop_status();
        }

    }
    private void Syntax_error(String SyntaxErrorData)
    {
        terminal.setText("Syntax Error Line Number"+SyntaxErrorData+"\n"+terminal.getText());
    }
    private void taskCall() {
        String Terminal = terminal.getText().toString();
        terminal.setText(Terminal+" \n"+"16-bit");
        reg_data_read_Show_in_terminal();
    }

    private void Loop_status() {
        if (Loop_ON_OFF == false)
        {
            Loop_calling__temp_ON_Off = false;
            for(int i=0; i<=50; i++) {run_function();}
            terminal.setText("RUN_50_TIME_STOP_ERROR_404\n"+terminal.getText());
            Loop_calling__temp_ON_Off = true;
        }

    }

    private void reg_data_read_Show_in_terminal() {
        String reg_data = "AH:-"+AH.getText().toString()+" , "+
                "AL:-"+AL.getText().toString()+" , "+
                "BH:-"+BH.getText().toString()+" , "+
                "BL:-"+BL.getText().toString()+" , "+
                "CH:-"+CH.getText().toString()+" , "+
                "CL:-"+CL.getText().toString()+" , "+
                "DH:-"+DH.getText().toString()+" , "+
                "DL:-"+DL.getText().toString();

        terminal.setText(reg_data+"\n"+terminal.getText().toString());
    }

    private void inputcodeDivArange() {
        switch (inputData[0]) {
            case "ADD":
                choice_REG();
                int temp_ADD = Integer.parseInt(fristNumber) + Integer.parseInt(secondNumber);
                if (reg_8bit_out_on == true){
                    String[] reg_8bit_data_set_temp = {"","","",""};
                    reg_8bit_data_set_temp = String.valueOf(temp_ADD).split("",4);
                    if (temp_ADD != 0) {
                        AH.setText(reg_8bit_data_set_temp[0] + reg_8bit_data_set_temp[1]);
                        AL.setText(reg_8bit_data_set_temp[2] + reg_8bit_data_set_temp[3]);
                        reg_8bit_out_on = false;
                    }
                }
                else {AH.setText(String.valueOf(temp_ADD));}
                reg_data_read_Show_in_terminal();
                break;
            case "SUB":
                choice_REG();
                int temp_SUB = Integer.parseInt(fristNumber) - Integer.parseInt(secondNumber);
                if (reg_8bit_out_on == true){
                    String[] reg_8bit_data_set_temp = {"","","",""};
                    reg_8bit_data_set_temp = String.valueOf(temp_SUB).split("",4);
                    if(temp_SUB != 0) {
                        AH.setText(reg_8bit_data_set_temp[0] + reg_8bit_data_set_temp[1]);
                        AL.setText(reg_8bit_data_set_temp[2] + reg_8bit_data_set_temp[3]);
                        reg_8bit_out_on = false;
                    }
                }
                else {AH.setText(String.valueOf(temp_SUB));}
                reg_data_read_Show_in_terminal();
                break;
            case "MUL":
                choice_REG();
                int temp_MUL = Integer.parseInt(fristNumber) * Integer.parseInt(secondNumber);
                if (reg_8bit_out_on == true){
                    String[] reg_8bit_data_set_temp = {"","","",""};
                    reg_8bit_data_set_temp = String.valueOf(temp_MUL).split("",4);
                    if (temp_MUL != 0) {
                        AH.setText(reg_8bit_data_set_temp[0] + reg_8bit_data_set_temp[1]);
                        AL.setText(reg_8bit_data_set_temp[2] + reg_8bit_data_set_temp[3]);
                        reg_8bit_out_on = false;
                    }
                }
                else {AH.setText(String.valueOf(temp_MUL));}
                reg_data_read_Show_in_terminal();
                break;
            case "DIV":
                choice_REG();
                int temp_DIV = Integer.parseInt(fristNumber) / Integer.parseInt(secondNumber);
                if (reg_8bit_out_on == true){
                    String[] reg_8bit_data_set_temp = {"","","",""};
                    reg_8bit_data_set_temp = String.valueOf(temp_DIV).split("",4);
                    if (temp_DIV != 0) {
                        AH.setText(reg_8bit_data_set_temp[0] + reg_8bit_data_set_temp[1]);
                        AL.setText(reg_8bit_data_set_temp[2] + reg_8bit_data_set_temp[3]);
                        reg_8bit_out_on = false;
                    }
                }
                else {AH.setText(String.valueOf(temp_DIV));}
                reg_data_read_Show_in_terminal();
                break;
            case "MOV":
                Move_Function();
                terminal.setText(inputData2[1]+" --> "+inputData2[0]+"\n"+terminal.getText().toString());
                break;
            case "HLT":
                terminal.setText("HLT_\n"+terminal.getText());
                break;
        }
    }

    private void Move_Function() {
        String temp_reg = null;
        String[] temp_reg_8bit = {"00","00"};
        switch (inputData2[1]){
            case "AH":
                temp_reg = AH.getText().toString();
                AH.setText("00");
                break;
            case "AL":
                temp_reg =AL.getText().toString();
                AL.setText("00");
                break;
            case "BH":
                temp_reg =BH.getText().toString();
                BH.setText("00");
                break;
            case "BL":
                temp_reg =BL.getText().toString();
                BL.setText("00");
                break;
            case "CH":
                temp_reg =CH.getText().toString();
                CH.setText("00");
                break;
            case "CL":
                temp_reg =CL.getText().toString();
                CL.setText("00");
                break;
            case "DH":
                temp_reg =DH.getText().toString();
                DH.setText("00");
                break;
            case "DL":
                temp_reg =DL.getText().toString();
                DL.setText("00");
                break;
            case "AX":
                temp_reg_8bit = new String[]{AH.getText().toString(),AL.getText().toString()};
                temp_reg = temp_reg_8bit[0]+temp_reg_8bit[1];
                AH.setText("00");
                AL.setText("00");
                break;
            case "BX":
                temp_reg_8bit = new String[]{BH.getText().toString(),BL.getText().toString()};
                temp_reg = temp_reg_8bit[0]+temp_reg_8bit[1];
                BH.setText("00");
                BL.setText("00");
                break;
            case "CX":
                temp_reg_8bit = new String[]{CH.getText().toString(),CL.getText().toString()};
                temp_reg = temp_reg_8bit[0]+temp_reg_8bit[1];
                CH.setText("00");
                CL.setText("00");
                break;
            case "DX":
                temp_reg_8bit = new String[]{DH.getText().toString(),DL.getText().toString()};
                temp_reg = temp_reg_8bit[0]+temp_reg_8bit[1];
                DH.setText("00");
                DL.setText("00");
                break;
            case "2001H":
                temp_reg = HEX_Input[0].getText().toString();
                HEX_Input[0].setText("0000");
                break;
            case "2002H":
                temp_reg = HEX_Input[1].getText().toString();
                HEX_Input[1].setText("0000");
                break;
            case "2003H":
                temp_reg = HEX_Input[2].getText().toString();
                HEX_Input[2].setText("0000");
                break;
            case "2004H":
                temp_reg = HEX_Input[3].getText().toString();
                HEX_Input[3].setText("0000");
                break;
            case "2005H":
                temp_reg = HEX_Input[4].getText().toString();
                HEX_Input[4].setText("0000");
                break;
            case "2006H":
                temp_reg = HEX_Input[5].getText().toString();
                HEX_Input[5].setText("0000");
                break;
            case "2007H":
                temp_reg = HEX_Input[6].getText().toString();
                HEX_Input[6].setText("0000");
                break;
            case "2008H":
                temp_reg = HEX_Input[7].getText().toString();
                HEX_Input[7].setText("0000");
                break;
            case "2009H":
                temp_reg = HEX_Input[8].getText().toString();
                HEX_Input[8].setText("0000");
                break;
            case "2010H":
                temp_reg = HEX_Input[9].getText().toString();
                HEX_Input[9].setText("0000");
                break;
            case "2011H":
                temp_reg = HEX_Input[10].getText().toString();
                HEX_Input[10].setText("0000");
                break;
            case "2012H":
                temp_reg = HEX_Input[11].getText().toString();
                HEX_Input[11].setText("0000");
                break;
            case "2013H":
                temp_reg = HEX_Input[12].getText().toString();
                HEX_Input[12].setText("0000");
                break;
            case "2014H":
                temp_reg = HEX_Input[13].getText().toString();
                HEX_Input[13].setText("0000");
                break;
            case "2015H":
                temp_reg = HEX_Input[14].getText().toString();
                HEX_Input[14].setText("0000");
                break;
            case "2016H":
                temp_reg = HEX_Input[15].getText().toString();
                HEX_Input[15].setText("0000");
                break;
            case "2017H":
                temp_reg = HEX_Input[16].getText().toString();
                HEX_Input[16].setText("0000");
                break;
            case "2018H":
                temp_reg = HEX_Input[17].getText().toString();
                HEX_Input[17].setText("0000");
                break;
            case "2019H":
                temp_reg = HEX_Input[18].getText().toString();
                HEX_Input[18].setText("0000");
                break;
            case "2020H":
                temp_reg = HEX_Input[19].getText().toString();
                HEX_Input[19].setText("0000");
                break;
            case "2021H":
                temp_reg = HEX_Input[20].getText().toString();
                HEX_Input[20].setText("0000");
                break;
            case "2022H":
                temp_reg = HEX_Input[21].getText().toString();
                HEX_Input[21].setText("0000");
                break;
            case "2023H":
                temp_reg = HEX_Input[22].getText().toString();
                HEX_Input[22].setText("0000");
                break;
            case "2024H":
                temp_reg = HEX_Input[23].getText().toString();
                HEX_Input[23].setText("0000");
                break;
            case "2025H":
                temp_reg = HEX_Input[24].getText().toString();
                HEX_Input[24].setText("0000");
                break;
            case "2026H":
                temp_reg = HEX_Input[25].getText().toString();
                HEX_Input[25].setText("0000");
                break;
            case "2027H":
                temp_reg = HEX_Input[26].getText().toString();
                HEX_Input[26].setText("0000");
                break;
            case "2028H":
                temp_reg = HEX_Input[27].getText().toString();
                HEX_Input[27].setText("0000");
                break;
            case "2029H":
                temp_reg = HEX_Input[28].getText().toString();
                HEX_Input[28].setText("0000");
                break;
            case "2030H":
                temp_reg = HEX_Input[29].getText().toString();
                HEX_Input[29].setText("0000");
                break;
        }
        switch (inputData2[0]){
            case "AH":
                AH.setText(temp_reg);
                break;
            case "AL":
                AL.setText(temp_reg);
                break;
            case "BH":
                BH.setText(temp_reg);
                break;
            case "BL":
                BL.setText(temp_reg);
                break;
            case "CH":
                CH.setText(temp_reg);
                break;
            case "CL":
                CL.setText(temp_reg);
                break;
            case "DH":
                DH.setText(temp_reg);
                break;
            case "DL":
                DL.setText(temp_reg);
                break;
            case "AX":
                AH.setText(temp_reg_8bit[0]);
                AL.setText(temp_reg_8bit[1]);
                break;
            case "BX":
                BH.setText(temp_reg_8bit[0]);
                BL.setText(temp_reg_8bit[1]);
                break;
            case "CX":
                CH.setText(temp_reg_8bit[0]);
                CL.setText(temp_reg_8bit[1]);
                break;
            case "DX":
                DH.setText(temp_reg_8bit[0]);
                DL.setText(temp_reg_8bit[1]);
                break;
            case "2001H":
                 HEX_Input[0].setText(temp_reg);
                break;
            case "2002H":
                HEX_Input[1].setText(temp_reg);
                break;
            case "2003H":
                HEX_Input[2].setText(temp_reg);
                break;
            case "2004H":
                HEX_Input[3].setText(temp_reg);
                break;
            case "2005H":
                HEX_Input[4].setText(temp_reg);
                break;
            case "2006H":
                HEX_Input[5].setText(temp_reg);
                break;
            case "2007H":
                HEX_Input[6].setText(temp_reg);
                break;
            case "2008H":
                HEX_Input[7].setText(temp_reg);
                break;
            case "2009H":
                HEX_Input[8].setText(temp_reg);
                break;
            case "2010H":
                HEX_Input[9].setText(temp_reg);
                break;
            case "2011H":
                HEX_Input[10].setText(temp_reg);
                break;
            case "2012H":
                HEX_Input[11].setText(temp_reg);
                break;
            case "2013H":
                HEX_Input[12].setText(temp_reg);
                break;
            case "2014H":
                HEX_Input[13].setText(temp_reg);
                break;
            case "2015H":
                HEX_Input[14].setText(temp_reg);
                break;
            case "2016H":
                HEX_Input[15].setText(temp_reg);
                break;
            case "2017H":
                HEX_Input[16].setText(temp_reg);
                break;
            case "2018H":
                HEX_Input[17].setText(temp_reg);
                break;
            case "2019H":
                HEX_Input[18].setText(temp_reg);
                break;
            case "2020H":
                HEX_Input[19].setText(temp_reg);
                break;
            case "2021H":
                HEX_Input[20].setText(temp_reg);
                break;
            case "2022H":
                HEX_Input[21].setText(temp_reg);
                break;
            case "2023H":
                HEX_Input[22].setText(temp_reg);
                break;
            case "2024H":
                HEX_Input[23].setText(temp_reg);
                break;
            case "2025H":
                HEX_Input[24].setText(temp_reg);
                break;
            case "2026H":
                HEX_Input[25].setText(temp_reg);
                break;
            case "2027H":
                HEX_Input[26].setText(temp_reg);
                break;
            case "2028H":
                HEX_Input[27].setText(temp_reg);
                break;
            case "2029H":
                HEX_Input[28].setText(temp_reg);
                break;
            case "2030H":
                HEX_Input[29].setText(temp_reg);
                break;
        }
    }

    private void choice_REG() {
        switch (inputData2[0]) {
            case "AH":
                fristNumber = AH.getText().toString();
                break;
            case "AL":
                fristNumber = AL.getText().toString();
                break;
            case "BH":
                fristNumber = BH.getText().toString();
                break;
            case "BL":
                fristNumber = BL.getText().toString();
                break;
            case "CH":
                fristNumber = CH.getText().toString();
                break;
            case "CL":
                fristNumber = CL.getText().toString();
                break;
            case "DH":
                fristNumber = DH.getText().toString();
                break;
            case "DL":
                fristNumber = DL.getText().toString();
                break;
            case "AX":
                fristNumber = AH.getText().toString()+AL.getText().toString();
                reg_8bit_out_on = true;
                break;
            case "BX":
                fristNumber = BH.getText().toString()+BL.getText().toString();
                reg_8bit_out_on = true;
                break;
            case "CX":
                fristNumber = CH.getText().toString()+CL.getText().toString();
                reg_8bit_out_on = true;
                break;
            case "DX":
                fristNumber = DH.getText().toString()+DL.getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2001H":
                fristNumber = HEX_Input[0].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2002H":
                fristNumber = HEX_Input[1].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2003H":
                fristNumber = HEX_Input[2].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2004H":
                fristNumber = HEX_Input[3].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2005H":
                fristNumber = HEX_Input[4].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2006H":
                fristNumber = HEX_Input[5].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2007H":
                fristNumber = HEX_Input[6].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2008H":
                fristNumber = HEX_Input[7].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2009H":
                fristNumber = HEX_Input[8].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2010H":
                fristNumber = HEX_Input[9].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2011H":
                fristNumber = HEX_Input[10].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2012H":
                fristNumber = HEX_Input[11].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2013H":
                fristNumber = HEX_Input[12].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2014H":
                fristNumber = HEX_Input[13].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2015H":
                fristNumber = HEX_Input[14].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2016H":
                fristNumber = HEX_Input[15].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2017H":
                fristNumber = HEX_Input[16].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2018H":
                fristNumber = HEX_Input[17].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2019H":
                fristNumber = HEX_Input[18].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2020H":
                fristNumber = HEX_Input[19].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2021H":
                fristNumber = HEX_Input[20].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2022H":
                fristNumber = HEX_Input[21].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2023H":
                fristNumber = HEX_Input[22].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2024H":
                fristNumber = HEX_Input[23].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2025H":
                fristNumber = HEX_Input[24].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2026H":
                fristNumber = HEX_Input[25].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2027H":
                fristNumber = HEX_Input[26].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2028H":
                fristNumber = HEX_Input[27].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2029H":
                fristNumber = HEX_Input[28].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2030H":
                fristNumber = HEX_Input[29].getText().toString();
                reg_8bit_out_on = true;
                break;
        }
        switch (inputData2[1]) {
            case "AH":
                secondNumber = AH.getText().toString();
                break;
            case "AL":
                secondNumber = AL.getText().toString();
                break;
            case "BH":
                secondNumber = BH.getText().toString();
                break;
            case "BL":
                secondNumber = BL.getText().toString();
                break;
            case "CH":
                secondNumber = CH.getText().toString();
                break;
            case "CL":
                secondNumber = CL.getText().toString();
                break;
            case "DH":
                secondNumber = DH.getText().toString();
                break;
            case "DL":
                secondNumber = DL.getText().toString();
                break;
            case "AX":
                secondNumber = AH.getText().toString()+AL.getText().toString();
                reg_8bit_out_on = true;
                break;
            case "BX":
                secondNumber = BH.getText().toString()+BL.getText().toString();
                reg_8bit_out_on = true;
                break;
            case "CX":
                secondNumber = CH.getText().toString()+CL.getText().toString();
                reg_8bit_out_on = true;
                break;
            case "DX":
                secondNumber = DH.getText().toString()+DL.getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2001H":
                secondNumber = HEX_Input[0].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2002H":
                secondNumber = HEX_Input[1].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2003H":
                secondNumber = HEX_Input[2].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2004H":
                secondNumber = HEX_Input[3].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2005H":
                secondNumber = HEX_Input[4].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2006H":
                secondNumber = HEX_Input[5].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2007H":
                secondNumber = HEX_Input[6].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2008H":
                secondNumber = HEX_Input[7].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2009H":
                secondNumber = HEX_Input[8].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2010H":
                secondNumber = HEX_Input[9].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2011H":
                secondNumber = HEX_Input[10].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2012H":
                secondNumber = HEX_Input[11].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2013H":
                secondNumber = HEX_Input[12].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2014H":
                secondNumber = HEX_Input[13].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2015H":
                secondNumber = HEX_Input[14].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2016H":
                secondNumber = HEX_Input[15].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2017H":
                secondNumber = HEX_Input[16].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2018H":
                secondNumber = HEX_Input[17].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2019H":
                secondNumber = HEX_Input[18].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2020H":
                secondNumber = HEX_Input[19].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2021H":
                secondNumber = HEX_Input[20].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2022H":
                secondNumber = HEX_Input[21].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2023H":
                secondNumber = HEX_Input[22].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2024H":
                secondNumber = HEX_Input[23].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2025H":
                secondNumber = HEX_Input[24].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2026H":
                secondNumber = HEX_Input[25].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2027H":
                secondNumber = HEX_Input[26].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2028H":
                secondNumber = HEX_Input[27].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2029H":
                secondNumber = HEX_Input[28].getText().toString();
                reg_8bit_out_on = true;
                break;
            case "2030H":
                secondNumber = HEX_Input[29].getText().toString();
                reg_8bit_out_on = true;
                break;
        }

         if(reg_8bit_out_on == true){
             String []temp_intConvartFS = fristNumber.split("");
             if(temp_intConvartFS.length<4){
                 if(temp_intConvartFS.length==3) {
                     fristNumber = "0" + fristNumber;
                 }
                 else if(temp_intConvartFS.length==2){
                     fristNumber = "00" + fristNumber;
                 }
                 else if(temp_intConvartFS.length==1){
                     fristNumber = "000" + fristNumber;
                 }
                 else{
                     fristNumber = "0000";
                 }
             }
             String []temp_intConvartSC = secondNumber.split("");
             if(temp_intConvartSC.length<4){
                 if(temp_intConvartSC.length==3) {
                     secondNumber = "0" + secondNumber;
                 }
                 else if(temp_intConvartSC.length==2){
                     secondNumber = "00" + secondNumber;
                 }
                 else if(temp_intConvartSC.length==1){
                     secondNumber = "000" + secondNumber;
                 }
                 else {
                     secondNumber = "0000";
                 }
             }
         }
    }

    private void HLT_function(int set_hlt_function){
        EditText[] HLT_functin_get = new EditText[]
                {inputCode0, inputCode1, inputCode2,
                inputCode3, inputCode4, inputCode5,
                inputCode6, inputCode7, inputCode8,
                inputCode9, inputCode10, inputCode11,
                        inputCode12};
        for (int i=set_hlt_function+1; i<=12; i++)
        {
            HLT_functin_get[i].setText("");
        }

    }
}
