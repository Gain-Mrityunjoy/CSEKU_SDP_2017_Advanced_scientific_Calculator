package com.example.gain.advance_scientific_calculator;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;




public class Main2Activity extends Activity implements View.OnClickListener{

    Button btn11,btn22,btn33,btn44,btn55,btn66,btn77,btn88,btn99,btnDotDot;
    Button btnClear,btnBackSpace;
    Button btnSeven,btnNine,btnEight,btnDiv;
    Button btnFour,btnFive,btnSix,btnMulti;
    Button btnOne,btnTwo,btnThree,btnMinus,btnAdd;
    Button btnZero,btnDot;
    Button btnAns,btnA,btnB,btnC,btnD,btnE,btnF;
    Button btnDec,btnBin,btnOct,btnHex;

    TextView screenAns, screenMath,calDec,calBin,calOct,calHex,checkBox,fireBox;

    StringBuilder textMath = new StringBuilder("");
    StringBuilder decAns = new StringBuilder("");
    StringBuilder screenTextMath=new StringBuilder("");
    StringBuilder binAns = new StringBuilder("");
    StringBuilder octAns = new StringBuilder("");
    StringBuilder hexAns=new StringBuilder("");


    int checkSubmit = 0;
    int converter;
    StringBuilder M = new StringBuilder("");
    StringBuilder N = new StringBuilder("");

    int count=0,A,B=0;


    private GestureDetectorCompat gestureObject;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);

        gestureObject=new GestureDetectorCompat(this,new LearnGesture());

   // screenAns = (TextView) findViewById(R.id.textAnsAns);
    screenMath = (TextView) findViewById(R.id.textCalCal);
        calDec = (TextView) findViewById(R.id.calDec);
        calBin = (TextView) findViewById(R.id.calBin);
        calOct = (TextView) findViewById(R.id.calOct);
        calHex = (TextView) findViewById(R.id.calHex);
        checkBox = (TextView) findViewById(R.id.checkBox);
        fireBox = (TextView) findViewById(R.id.fireBox);

    btnZero = (Button)findViewById(R.id.btn00);
        btnZero.setOnClickListener( this);

    btnOne = (Button)findViewById(R.id.btn11);
        btnOne.setOnClickListener(this);

    btnTwo = (Button)findViewById(R.id.btn22);
        btnTwo.setOnClickListener(this);

    btnThree = (Button)findViewById(R.id.btn33);
        btnThree.setOnClickListener(this);

    btnFour = (Button)findViewById(R.id.btn44);
        btnFour.setOnClickListener(this);

    btnFive = (Button)findViewById(R.id.btn55);
        btnFive.setOnClickListener(this);


    btnSix = (Button)findViewById(R.id.btn66);
        btnSix.setOnClickListener(this);

    btnSeven = (Button)findViewById(R.id.btn77);
        btnSeven.setOnClickListener(this);

    btnEight = (Button)findViewById(R.id.btn88);
        btnEight.setOnClickListener(this);

    btnNine = (Button)findViewById(R.id.btn99);
        btnNine.setOnClickListener(this);

    btnClear = (Button)findViewById(R.id.btnAcAc);
        btnClear.setOnClickListener(this);

    btnBackSpace = (Button)findViewById(R.id.btnDelDel);
        btnBackSpace.setOnClickListener(this);

    btnDot = (Button)findViewById(R.id.btnDotDot);
        btnDot.setOnClickListener(this);

    btnDiv = (Button)findViewById(R.id.btnDivDiv);
        btnDiv.setOnClickListener(this);

    btnMulti = (Button)findViewById(R.id.btnMulMul);
        btnMulti.setOnClickListener(this);

    btnMinus = (Button)findViewById(R.id.btnMinusMinus);
        btnMinus.setOnClickListener(this);

    btnAdd = (Button)findViewById(R.id.btnAddAdd);
        btnAdd.setOnClickListener(this);

    btnAns = (Button)findViewById(R.id.btnAnsAns);
        btnAns.setOnClickListener(this);

        btnA = (Button)findViewById(R.id.btnA);
        btnA.setOnClickListener(this);

        btnB = (Button)findViewById(R.id.btnB);
        btnB.setOnClickListener(this);

        btnC = (Button)findViewById(R.id.btnC);
        btnC.setOnClickListener(this);

        btnD = (Button)findViewById(R.id.btnD);
        btnD.setOnClickListener(this);

        btnE = (Button)findViewById(R.id.btnE);
        btnE.setOnClickListener(this);

        btnF = (Button)findViewById(R.id.btnF);
        btnF.setOnClickListener(this);

        btnDec = (Button)findViewById(R.id.btnDec);
        btnDec.setOnClickListener(this);

        btnBin = (Button)findViewById(R.id.btnBin);
        btnBin.setOnClickListener(this);

        btnOct = (Button)findViewById(R.id.btnOct);
        btnOct.setOnClickListener(this);

        btnHex = (Button)findViewById(R.id.btnHex);
        btnHex.setOnClickListener(this);
}


    public void error(){
        screenAns.setText("Math Error !");
        //textAns = textMath = screenTextMath = new StringBuilder();
    }

    public void submit(String[] elementMath){
        ProgrammerMode  ITP = new ProgrammerMode();
        if (textMath.length()>0){
            try{
                if (!ITP.check_error) elementMath = ITP.processString(textMath.toString());		//	split expression to element
                if (!ITP.check_error) elementMath = ITP.postfix(elementMath);// 	format elements to postfix
                if (!ITP.check_error) decAns = new StringBuilder(ITP.valueMath(elementMath));// get result
                converter=Integer.parseInt(String.valueOf(decAns));
                binAns=new StringBuilder(ITP.decToBin(converter));
                octAns=new StringBuilder(ITP.decToOct(converter));
                hexAns=new StringBuilder(ITP.decToHex(converter));
                calDec.setText(decAns);
                calBin.setText(binAns);
                calOct.setText(octAns);
                calHex.setText(hexAns);
                converter=Integer.parseInt(ITP.valueMath(elementMath));
                checkSubmit = 1;

            }catch(Exception e){
                error();
            }
            if (ITP.check_error) error();
        }
    }
    public void Dsubmit(int converter){
        ProgrammerMode  ITP = new ProgrammerMode();

      //  if (!ITP.check_error) textAns = new StringBuilder(ITP.decToDec(converter));		// get result
      //  screenAns.setText(textAns);


    }

    public void Bsubmit(int converter){
        ProgrammerMode  ITP = new ProgrammerMode();

        //        if (!ITP.check_error) textAns = new StringBuilder(ITP.decToBin(converter));		// get result
          //      screenAns.setText(textAns);


    }

    public void Osubmit(int converter){
        ProgrammerMode  ITP = new ProgrammerMode();


            //     textAns = new StringBuilder(ITP.decToOct(converter));		// get result
             //   screenAns.setText(textAns);



    }

    public void Hsubmit(int converter){
        ProgrammerMode  ITP = new ProgrammerMode();

               // if (!ITP.check_error) textAns = new StringBuilder(ITP.decToHex(converter));		// get result
                //screenAns.setText(textAns);


    }
    public void BinSubmit(String[] elementMath){
        BinMode  BM = new BinMode ();
        if (textMath.length()>0){
            try{
                if (!BM.check_error) elementMath = BM.processString(textMath.toString());		//	split expression to element
                if (!BM.check_error) elementMath = BM.postfix(elementMath);// 	format elements to postfix
                if (!BM.check_error) binAns = new StringBuilder(BM.decToBin(Integer.parseInt(BM.valueMath(elementMath))));		// get result
                converter=Integer.parseInt(String.valueOf(binAns));
                int power=0;
                int decimal=0;

               while(converter!=0)
                {
                    int tmp = converter % 10;
                    decimal += tmp * Math.pow(2, power);
                    converter = converter / 10;
                    power++;
                }
                decAns=new StringBuilder(Integer.toString(decimal));
                octAns=new StringBuilder(BM.decToOct(decimal));
                hexAns=new StringBuilder(BM.decToHex(decimal));
                calDec.setText(decAns);
                calBin.setText(binAns);
                calOct.setText(octAns);
                calHex.setText(hexAns);
                //converter=Integer.parseInt(BM.valueMath(elementMath));
                checkSubmit = 1;

            }catch(Exception e){
                error();
            }
            if (BM.check_error) error();
        }
    }

    public void OctSubmit(String[] elementMath){
        OctMode  OM = new OctMode();
        if (textMath.length()>0){
            try{
                if (!OM.check_error) elementMath = OM.processString(textMath.toString());		//	split expression to element
                if (!OM.check_error) elementMath = OM.postfix(elementMath);// 	format elements to postfix
                if (!OM.check_error) octAns = new StringBuilder(OM.decToOct(Integer.parseInt(OM.valueMath(elementMath))));		// get result
                converter=Integer.parseInt(String.valueOf(octAns));
                int power=0;
                int decimal=0;

                while(converter!=0)
                {
                    int tmp = converter % 10;
                    decimal += tmp * Math.pow(8, power);
                    converter = converter / 10;
                    power++;
                }
                decAns=new StringBuilder(Integer.toString(decimal));
                binAns=new StringBuilder(OM.decToBin(decimal));
                hexAns=new StringBuilder(OM.decToHex(decimal));
                calDec.setText(decAns);
                calBin.setText(binAns);
                calOct.setText(octAns);
                calHex.setText(hexAns);
                //converter=Integer.parseInt(OM.valueMath(elementMath));
                checkSubmit = 1;

            }catch(Exception e){
                error();
            }
            if (OM .check_error) error();
        }
    }


    public void HexSubmit(String[] elementMath){

        HexMode  HM = new HexMode();
        if (textMath.length()>0){
            try{
                if (!HM.check_error) elementMath = HM.processString(textMath.toString());		//	split expression to element
                if (!HM.check_error) elementMath = HM.postfix(elementMath);// 	format elements to postfix
                if (!HM.check_error) binAns = new StringBuilder(HM.decToBin(Integer.parseInt(HM.valueMath(elementMath))));		// get result
                converter=Integer.parseInt(String.valueOf(binAns));
                int power=0;
                int decimal=0;

                while(converter!=0)
                {
                    int tmp = converter % 10;
                    decimal += tmp * Math.pow(2, power);
                    converter = converter / 10;
                    power++;
                }
                decAns=new StringBuilder(Integer.toString(decimal));
                hexAns=new StringBuilder(HM.decToHex(decimal));
                octAns=new StringBuilder(HM.decToOct(decimal));
                calDec.setText(decAns);
                calBin.setText(binAns);
                calOct.setText(octAns);
                calHex.setText(hexAns);
                //converter=Integer.parseInt(OM.valueMath(elementMath));
                checkSubmit = 1;
            }catch(Exception e){
                error();
            }
            if (HM.check_error) error();
        }
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        String elementMath[] = null;


        if (id == R.id.btn00) {
            textMath = new StringBuilder("");
            screenTextMath = new StringBuilder("");
            //textAns = new StringBuilder("");
            calDec.setText(" ");
            calBin.setText(" ");
            calOct.setText(" ");
            calHex.setText(" ");
            screenMath.setText("");
            fireBox.setText(" ");
            screenMath.setText(screenTextMath);

        }
        if (id == R.id.btnDelDel) {
            textMath = new StringBuilder("");
            screenTextMath = new StringBuilder("");
            //textAns = new StringBuilder("");
            calDec.setText(" ");
            calBin.setText(" ");
            calOct.setText(" ");
            calHex.setText(" ");
            screenMath.setText("");
            fireBox.setText(" ");
            screenMath.setText(screenTextMath);
        }
        else if (id == R.id.btn11 &&( checkBox.getText()=="DEC"|| checkBox.getText()=="BIN"
                || checkBox.getText()=="OCT" || checkBox.getText()=="HEX")) {
            if (screenTextMath.length() < 9) {
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                if(checkBox.getText()=="HEX")
                    textMath.append("0001");
                else
                    textMath.append("1");
                screenTextMath.append("1");
            }
            screenMath.setText(screenTextMath);

        } else if (id == R.id.btn22 &&( checkBox.getText()=="DEC"
                || checkBox.getText()=="OCT" || checkBox.getText()=="HEX")) {
            if (screenTextMath.length() < 9) {
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                if(checkBox.getText()=="HEX")
                    textMath.append("0010");
                else
                    textMath.append("2");
                screenTextMath.append("2");
            }
            screenMath.setText(screenTextMath);

        } else if (id == R.id.btn33 &&( checkBox.getText()=="DEC"
                || checkBox.getText()=="OCT" || checkBox.getText()=="HEX")) {
            if (screenTextMath.length() < 9) {
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                if(checkBox.getText()=="HEX")
                    textMath.append("0011");
                else
                    textMath.append("3");
                screenTextMath.append("3");
            }

            screenMath.setText(screenTextMath);

        } else if (id == R.id.btn44 &&( checkBox.getText()=="DEC"
                || checkBox.getText()=="OCT" || checkBox.getText()=="HEX")) {
            if (screenTextMath.length() < 9) {
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                if(checkBox.getText()=="HEX")
                    textMath.append("0100");
                else
                    textMath.append("4");
                screenTextMath.append("4");
            }
            screenMath.setText(screenTextMath);

        } else if (id == R.id.btn55 &&( checkBox.getText()=="DEC"
                || checkBox.getText()=="OCT" || checkBox.getText()=="HEX")) {
            if (screenTextMath.length() < 9) {
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                if(checkBox.getText()=="HEX")
                    textMath.append("0101");
                else
                    textMath.append("5");
                screenTextMath.append("5");
            }
            screenMath.setText(screenTextMath);

        } else if (id == R.id.btn66 &&( checkBox.getText()=="DEC"
                || checkBox.getText()=="OCT" || checkBox.getText()=="HEX")) {
            if (screenTextMath.length() < 9) {
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                if(checkBox.getText()=="HEX")
                    textMath.append("0110");
                else
                    textMath.append("6");
                screenTextMath.append("6");
            }
            screenMath.setText(screenTextMath);

        } else if (id == R.id.btn77 &&( checkBox.getText()=="DEC"
                || checkBox.getText()=="OCT" || checkBox.getText()=="HEX")) {
            if (screenTextMath.length() < 9) {
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                if(checkBox.getText()=="HEX")
                    textMath.append("0111");
                else
                    textMath.append("7");
                screenTextMath.append("7");
            }
            screenMath.setText(screenTextMath);

        } else if (id == R.id.btn88 &&( checkBox.getText()=="DEC"
                 || checkBox.getText()=="HEX")) {
            if (screenTextMath.length() < 9) {
                if (checkSubmit == 1) {
                     screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                if(checkBox.getText()=="HEX")
                    textMath.append("1000");
                else
                    textMath.append("8");
                screenTextMath.append("8");
            }
            screenMath.setText(screenTextMath);

        } else if (id == R.id.btn99 &&( checkBox.getText()=="DEC"
                || checkBox.getText()=="HEX")) {
            if (screenTextMath.length() < 9) {
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                if(checkBox.getText()=="HEX")
                    textMath.append("1001");
                else
                    textMath.append("9");
                screenTextMath.append("9");
            }
            screenMath.setText(screenTextMath);

        } else if (id == R.id.btnA && checkBox.getText()=="HEX") {
            if (screenTextMath.length() < 9) {
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("1010");
                screenTextMath.append("A");
            }
            screenMath.setText(screenTextMath);

        } else if (id == R.id.btnB && checkBox.getText()=="HEX") {
            if (screenTextMath.length() < 9) {
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("1011");
                screenTextMath.append("B");
            }
            screenMath.setText(screenTextMath);

        } else if (id == R.id.btnC && checkBox.getText()=="HEX") {
            if (screenTextMath.length() < 9) {
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("1100");
                screenTextMath.append("C");
            }
            screenMath.setText(screenTextMath);

        } else if (id == R.id.btnD && checkBox.getText()=="HEX") {
            if (screenTextMath.length() < 9) {
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("1101");
                screenTextMath.append("D");
            }
            screenMath.setText(screenTextMath);

        } else if (id == R.id.btnE && checkBox.getText()=="HEX") {
            if (screenTextMath.length() < 9) {
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("1110");
                screenTextMath.append("E");
            }
            screenMath.setText(screenTextMath);

        } else if (id == R.id.btnF && checkBox.getText()=="HEX") {
            if (screenTextMath.length() < 9) {
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("1111");
                screenTextMath.append("F");
            }
            screenMath.setText(screenTextMath);

        } else if (id == R.id.btnAddAdd) {
            if (screenTextMath.length() < 9) {
                if (checkSubmit == 1) {
                    // screenTextMath = new StringBuilder("");
                    // textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                char p =screenTextMath.charAt(screenTextMath.length()-1);
                if(p=='+'||p=='-'||p=='*'||p=='/') {
                    textMath = new StringBuilder(textMath.substring(0,textMath.length()-1));
                    screenTextMath = new StringBuilder(screenTextMath.substring(0,screenTextMath.length()-1));
                    textMath.append("+");
                    screenTextMath.append("+");
                }
                else
                {
                    textMath.append("+");
                    screenTextMath.append("+");
                }
            }
            screenMath.setText(screenTextMath);
            fireBox.setText("f");

        } else if (id == R.id.btnMinusMinus) {
            if (screenTextMath.length() < 9) {
                if (checkSubmit == 1) {
                    //  screenTextMath = new StringBuilder("");
                    //  textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                char p =screenTextMath.charAt(screenTextMath.length()-1);
                if(p=='+'||p=='-'||p=='*'||p=='/') {
                    textMath = new StringBuilder(textMath.substring(0,textMath.length()-1));
                    screenTextMath = new StringBuilder(screenTextMath.substring(0,screenTextMath.length()-1));
                    textMath.append("-");
                    screenTextMath.append("-");
                }
                else
                {
                    textMath.append("-");
                    screenTextMath.append("-");
                }
            }
            screenMath.setText(screenTextMath);
            fireBox.setText("f");

        } else if (id == R.id.btnMulMul) {
            if (screenTextMath.length() < 9) {
                if (checkSubmit == 1) {
                    //  screenTextMath = new StringBuilder("");
                    //  textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                char p =screenTextMath.charAt(screenTextMath.length()-1);
                if(p=='+'||p=='-'||p=='*'||p=='/') {
                    textMath = new StringBuilder(textMath.substring(0,textMath.length()-1));
                    screenTextMath = new StringBuilder(screenTextMath.substring(0,screenTextMath.length()-1));
                    textMath.append("*");
                    screenTextMath.append("*");
                }
                else
                {
                    textMath.append("*");
                    screenTextMath.append("*");
                }
            }
            screenMath.setText(screenTextMath);
            fireBox.setText("f");

        } else if (id == R.id.btnDivDiv) {
            if (screenTextMath.length() < 9) {
                if (checkSubmit == 1) {
                    //  screenTextMath = new StringBuilder("");
                    // textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                char p =screenTextMath.charAt(screenTextMath.length()-1);
                if(p=='+'||p=='-'||p=='*'||p=='/') {
                    textMath = new StringBuilder(textMath.substring(0,textMath.length()-1));
                    screenTextMath = new StringBuilder(screenTextMath.substring(0,screenTextMath.length()-1));
                    textMath.append("/");
                    screenTextMath.append("/");
                }
                else
                {
                    textMath.append("/");
                    screenTextMath.append("/");
                }
            }
            screenMath.setText(screenTextMath);
            fireBox.setText("f");
        }

        else if (id == R.id.btnDec) {
                if (screenTextMath.length() < 9) {
                    if (checkSubmit == 1) {
                        //  screenTextMath = new StringBuilder("");
                        //  textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                  //  textMath.append("-");
                  //  screenTextMath.append("-");
                }
                checkBox.setText("DEC");
            fireBox.setText(" ");
            //Dsubmit(converter);
            btnZero.setTextColor(getResources().getColor(R.color.colorAccent));
            btnOne.setTextColor(getResources().getColor(R.color.colorAccent));
            btnTwo.setTextColor(getResources().getColor(R.color.colorAccent));
            btnThree.setTextColor(getResources().getColor(R.color.colorAccent));
            btnFour.setTextColor(getResources().getColor(R.color.colorAccent));
            btnFive.setTextColor(getResources().getColor(R.color.colorAccent));
            btnSix.setTextColor(getResources().getColor(R.color.colorAccent));
            btnSeven.setTextColor(getResources().getColor(R.color.colorAccent));
            btnEight.setTextColor(getResources().getColor(R.color.colorAccent));
            btnNine.setTextColor(getResources().getColor(R.color.colorAccent));
            btnDot.setTextColor(getResources().getColor(R.color.colorAccent));
            btnAns.setTextColor(getResources().getColor(R.color.colorAccent));
            btnAdd.setTextColor(getResources().getColor(R.color.colorAccent));
            btnMinus.setTextColor(getResources().getColor(R.color.colorAccent));
            btnMulti.setTextColor(getResources().getColor(R.color.colorAccent));
            btnDiv.setTextColor(getResources().getColor(R.color.colorAccent));
            btnBackSpace.setTextColor(getResources().getColor(R.color.colorAccent));
            btnClear.setTextColor(getResources().getColor(R.color.colorAccent));
            btnA.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnB.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnC.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnD.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnE.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnF.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDec.setTextColor(getResources().getColor(R.color.colorAccent));
            btnBin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnOct.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnHex.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            textMath = new StringBuilder("");
            screenTextMath = new StringBuilder("");
            //textAns = new StringBuilder("");
            calDec.setText(" ");
            calBin.setText(" ");
            calOct.setText(" ");
            calHex.setText(" ");
            screenMath.setText("");

            } else if (id == R.id.btnBin) {
                if (screenTextMath.length() < 9) {
                    if (checkSubmit == 1) {
                        //  screenTextMath = new StringBuilder("");
                        //  textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    //textMath.append("*");
                   // screenTextMath.append("*");
                }
                checkBox.setText("BIN");
            fireBox.setText(" ");
              // Bsubmit(converter);

            btnZero.setTextColor(getResources().getColor(R.color.colorAccent));
            btnOne.setTextColor(getResources().getColor(R.color.colorAccent));
            btnTwo.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnThree.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnFour.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnFive.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSix.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSeven.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnEight.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnNine.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDot.setTextColor(getResources().getColor(R.color.colorAccent));
            btnAns.setTextColor(getResources().getColor(R.color.colorAccent));
            btnAdd.setTextColor(getResources().getColor(R.color.colorAccent));
            btnMinus.setTextColor(getResources().getColor(R.color.colorAccent));
            btnMulti.setTextColor(getResources().getColor(R.color.colorAccent));
            btnDiv.setTextColor(getResources().getColor(R.color.colorAccent));
            btnBackSpace.setTextColor(getResources().getColor(R.color.colorAccent));
            btnClear.setTextColor(getResources().getColor(R.color.colorAccent));
            btnA.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnB.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnC.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnD.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnE.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnF.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDec.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBin.setTextColor(getResources().getColor(R.color.colorAccent));
            btnOct.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnHex.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            textMath = new StringBuilder("");
            screenTextMath = new StringBuilder("");
            //textAns = new StringBuilder("");
            calDec.setText(" ");
            calBin.setText(" ");
            calOct.setText(" ");
            calHex.setText(" ");
            screenMath.setText("");


        } else if (id == R.id.btnOct) {
                if (screenTextMath.length() < 9) {
                    if (checkSubmit == 1) {
                        //  screenTextMath = new StringBuilder("");
                        // textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    //textMath.append("/");
                    //screenTextMath.append("/");
                }
                checkBox.setText("OCT");
            fireBox.setText(" ");
            //Osubmit(converter);
            btnZero.setTextColor(getResources().getColor(R.color.colorAccent));
            btnOne.setTextColor(getResources().getColor(R.color.colorAccent));
            btnTwo.setTextColor(getResources().getColor(R.color.colorAccent));
            btnThree.setTextColor(getResources().getColor(R.color.colorAccent));
            btnFour.setTextColor(getResources().getColor(R.color.colorAccent));
            btnFive.setTextColor(getResources().getColor(R.color.colorAccent));
            btnSix.setTextColor(getResources().getColor(R.color.colorAccent));
            btnSeven.setTextColor(getResources().getColor(R.color.colorAccent));
            btnDot.setTextColor(getResources().getColor(R.color.colorAccent));
            btnAns.setTextColor(getResources().getColor(R.color.colorAccent));
            btnAdd.setTextColor(getResources().getColor(R.color.colorAccent));
            btnMinus.setTextColor(getResources().getColor(R.color.colorAccent));
            btnMulti.setTextColor(getResources().getColor(R.color.colorAccent));
            btnDiv.setTextColor(getResources().getColor(R.color.colorAccent));
            btnBackSpace.setTextColor(getResources().getColor(R.color.colorAccent));
            btnClear.setTextColor(getResources().getColor(R.color.colorAccent));
            btnEight.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnNine.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnA.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnB.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnC.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnD.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnE.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnF.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDec.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnOct.setTextColor(getResources().getColor(R.color.colorAccent));
            btnHex.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            textMath = new StringBuilder("");
            screenTextMath = new StringBuilder("");
            //textAns = new StringBuilder("");
            calDec.setText(" ");
            calBin.setText(" ");
            calOct.setText(" ");
            calHex.setText(" ");
            screenMath.setText("");


        } else if (id == R.id.btnHex) {
            if (screenTextMath.length() < 9) {
                if (checkSubmit == 1) {
                    //  screenTextMath = new StringBuilder("");
                    // textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                //textMath.append("/");
                //screenTextMath.append("/");
            }
            checkBox.setText("HEX");
            fireBox.setText(" ");
           // Hsubmit(converter);
            btnZero.setTextColor(getResources().getColor(R.color.colorAccent));
            btnOne.setTextColor(getResources().getColor(R.color.colorAccent));
            btnTwo.setTextColor(getResources().getColor(R.color.colorAccent));
            btnThree.setTextColor(getResources().getColor(R.color.colorAccent));
            btnFour.setTextColor(getResources().getColor(R.color.colorAccent));
            btnFive.setTextColor(getResources().getColor(R.color.colorAccent));
            btnSix.setTextColor(getResources().getColor(R.color.colorAccent));
            btnSeven.setTextColor(getResources().getColor(R.color.colorAccent));
            btnEight.setTextColor(getResources().getColor(R.color.colorAccent));
            btnNine.setTextColor(getResources().getColor(R.color.colorAccent));
            btnDot.setTextColor(getResources().getColor(R.color.colorAccent));
            btnAns.setTextColor(getResources().getColor(R.color.colorAccent));
            btnAdd.setTextColor(getResources().getColor(R.color.colorAccent));
            btnMinus.setTextColor(getResources().getColor(R.color.colorAccent));
            btnMulti.setTextColor(getResources().getColor(R.color.colorAccent));
            btnDiv.setTextColor(getResources().getColor(R.color.colorAccent));
            btnBackSpace.setTextColor(getResources().getColor(R.color.colorAccent));
            btnClear.setTextColor(getResources().getColor(R.color.colorAccent));
            btnA.setTextColor(getResources().getColor(R.color.colorAccent));
            btnB.setTextColor(getResources().getColor(R.color.colorAccent));
            btnC.setTextColor(getResources().getColor(R.color.colorAccent));
            btnD.setTextColor(getResources().getColor(R.color.colorAccent));
            btnE.setTextColor(getResources().getColor(R.color.colorAccent));
            btnF.setTextColor(getResources().getColor(R.color.colorAccent));
            btnDec.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnOct.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnHex.setTextColor(getResources().getColor(R.color.colorAccent));

            textMath = new StringBuilder("");
            screenTextMath = new StringBuilder("");
            //textAns = new StringBuilder("");
            calDec.setText(" ");
            calBin.setText(" ");
            calOct.setText(" ");
            calHex.setText(" ");
            screenMath.setText("");

        } else if (id == R.id.btnAnsAns) {
            if (screenTextMath.length() < 9) {
                if (checkSubmit == 1) {
                    //  screenTextMath = new StringBuilder("");
                    // textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                if(fireBox.getText()=="f")
                textMath.append(" ");
                else
                    textMath.append("+0");
                screenTextMath.append(" ");
            }

            if(checkBox.getText()=="DEC")
            submit(elementMath);
            else if(checkBox.getText()=="BIN")
                BinSubmit(elementMath);
            if(checkBox.getText()=="OCT")
               OctSubmit(elementMath);
            else if(checkBox.getText()=="HEX")
                HexSubmit(elementMath);

              screenTextMath = new StringBuilder("");
             textMath = new StringBuilder("");

        } else if (id == R.id.btnAcAc) {

            if (screenTextMath.length() < 72 &&( checkBox.getText()=="DEC" || checkBox.getText()=="BIN"
                    || checkBox.getText()=="OCT" || checkBox.getText()=="HEX")) {
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("0");
                screenTextMath.append("0");
            }
            screenMath.setText(screenTextMath);

        }

        else if (id == R.id.btnDotDot) {
            if (screenMath.length() > 0) {
                char a =screenTextMath.charAt(screenTextMath.length()-1);
                  if (textMath.length() > 1 &&( a=='+'||a=='-'||a=='*'||a=='/')){
                    textMath = new StringBuilder(textMath.substring(0,textMath.length()-1));
                    screenTextMath = new StringBuilder(screenTextMath.substring(0,screenTextMath.length()-1));
                      fireBox.setText(" ");
                }
                else {
                      textMath = new StringBuilder(textMath.substring(0, textMath.length() - 1));
                      screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 1));
                  }

            }
            screenMath.setText(screenTextMath);
        }

    }



    public boolean onTouchEvent(MotionEvent event)
    {
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener
    {
        @Override
        public boolean onFling(MotionEvent event1,MotionEvent event2,float velocityX,float velocityY) {
            if(event2.getX()>event1.getX())
            {
                Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                finish();
                startActivity(intent);
            }
           /* else if(event2.getX()>event1.getX())
            {
                Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                finish();
                startActivity(intent);
            }*/
            return true;
        }
    }
}
