package com.example.gain.advance_scientific_calculator;



        import android.app.Activity;
        import android.content.Intent;
        import android.support.v4.view.GestureDetectorCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.Html;
        import android.view.GestureDetector;
        import android.view.View;
        import android.view.Window;
        import android.widget.Button;
        import android.widget.TextView;
        import android.view.MotionEvent;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnSin,btnCos,btnTan,btnFactorial,btnPow;
    Button btnClear,btnBackSpace,btnBracketsOpen,btnbracketClose,btnSquare;
    Button btnSeven,btnNine,btnEight,btnDiv;
    Button btnFour,btnFive,btnSix,btnMulti,btnInverse;
    Button btnOne,btnTwo,btnThree,btnMinus,btnAdd,btnResult;
    Button btnZero,btnDot,btnTenToPow;
    Button btnShift,btnMode;
    Button btnCalc,btnnPr,btnLeft,btnLog,btnLn,btnRight,btnUp,btnDown;
    Button btnMplus,btnSquareRoot,btnDif,btnAns;

    TextView screenAns, screenMath;

    StringBuilder textMath = new StringBuilder("");
    StringBuilder textAns = new StringBuilder("");
    StringBuilder screenTextMath=new StringBuilder("");
    StringBuilder M = new StringBuilder("");

    int checkSubmit = 0;
    char a,b,c,e;

    private GestureDetectorCompat gestureObject;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

    gestureObject=new GestureDetectorCompat(this,new LearnGesture());


        //((TextView)findViewById(R.id.text)).setText(Html.fromHtml("X<sup>2</sup>"));
        screenAns = (TextView) findViewById(R.id.textAns);
        screenMath = (TextView) findViewById(R.id.textCal);

        btnZero = (Button)findViewById(R.id.btn0);
        btnZero.setOnClickListener(this);

        btnOne = (Button)findViewById(R.id.btn1);
        btnOne.setOnClickListener(this);

        btnTwo = (Button)findViewById(R.id.btn2);
        btnTwo.setOnClickListener(this);

        btnThree = (Button)findViewById(R.id.btn3);
        btnThree.setOnClickListener(this);

        btnFour = (Button)findViewById(R.id.btn4);
        btnFour.setOnClickListener(this);

        btnFive = (Button)findViewById(R.id.btn5);
        btnFive.setOnClickListener(this);


        btnSix = (Button)findViewById(R.id.btn6);
        btnSix.setOnClickListener(this);

        btnSeven = (Button)findViewById(R.id.btn7);
        btnSeven.setOnClickListener(this);

        btnEight = (Button)findViewById(R.id.btn8);
        btnEight.setOnClickListener(this);

        btnNine = (Button)findViewById(R.id.btn9);
        btnNine.setOnClickListener(this);

        btnSin = (Button)findViewById(R.id.btnSin);
        btnSin.setOnClickListener(this);

        btnCos = (Button)findViewById(R.id.btnCos);
        btnCos.setOnClickListener(this);


        btnTan = (Button)findViewById(R.id.btnTan);
        btnTan.setOnClickListener(this);

        btnFactorial  = (Button)findViewById(R.id.btnFactorial);
        btnFactorial.setOnClickListener(this);

        btnPow = (Button)findViewById(R.id.btnPow);
        btnPow.setOnClickListener(this);


        btnClear = (Button)findViewById(R.id.btnAc);
        btnClear.setOnClickListener(this);


        btnBackSpace = (Button)findViewById(R.id.btnDel);
        btnBackSpace.setOnClickListener(this);

        btnbracketClose = (Button)findViewById(R.id.btnbracketClose);
        btnbracketClose.setOnClickListener(this);

        btnBracketsOpen  = (Button)findViewById(R.id.btnBracketOpen);
        btnBracketsOpen.setOnClickListener(this);

        btnSquareRoot  = (Button)findViewById(R.id.btnSquareRoot);
        btnSquareRoot.setOnClickListener(this);

        btnDot = (Button)findViewById(R.id.btnDot);
        btnDot.setOnClickListener(this);

        btnTenToPow = (Button)findViewById(R.id.btnTenToPow);
        btnTenToPow.setOnClickListener(this);

        btnDiv = (Button)findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(this);

        btnMulti = (Button)findViewById(R.id.btnMul);
        btnMulti.setOnClickListener(this);

        btnInverse = (Button)findViewById(R.id.btnInverse);
        btnInverse.setOnClickListener(this);

        btnMinus = (Button)findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(this);

        btnAdd = (Button)findViewById(R.id.btnPlus);
        btnAdd.setOnClickListener(this);

        btnResult = (Button)findViewById(R.id.btnEqual);
        btnResult.setOnClickListener(this);

        btnShift = (Button)findViewById(R.id.btnShift);
        btnShift.setOnClickListener(this);

        btnMode = (Button)findViewById(R.id.btnMode);
        btnMode.setOnClickListener(this);

        btnCalc = (Button)findViewById(R.id.btnEqual);
        btnCalc.setOnClickListener(this);

        btnnPr = (Button)findViewById(R.id.btnnPr);
        btnnPr.setOnClickListener(this);

        btnLeft = (Button)findViewById(R.id.btnLeft);
        btnLeft.setOnClickListener(this);

        btnRight = (Button)findViewById(R.id.btnRight);
        btnRight.setOnClickListener(this);

        btnUp = (Button)findViewById(R.id.btnUp);
        btnUp.setOnClickListener(this);

        btnDown = (Button)findViewById(R.id.btnDown);
        btnDown.setOnClickListener(this);

        btnLog = (Button)findViewById(R.id.btnLog);
        btnLog.setOnClickListener(this);

        btnLn = (Button)findViewById(R.id.btnLn);
        btnLn.setOnClickListener(this);

        btnShift = (Button)findViewById(R.id.btnShift);
        btnShift.setOnClickListener(this);

        btnMplus = (Button)findViewById(R.id.btnMplus);
        btnMplus.setOnClickListener(this);

        btnSquareRoot = (Button)findViewById(R.id.btnSquareRoot);
        btnSquareRoot.setOnClickListener(this);

        btnDif = (Button)findViewById(R.id.btnDif);
        btnDif.setOnClickListener(this);

        btnAns = (Button)findViewById(R.id.btnAns);
        btnAns.setOnClickListener(this);

        btnUp.setTextColor(getResources().getColor(R.color.colorAccent));
    }


    public void error(){
        screenAns.setText("Math Error !");
        //textAns = textMath = screenTextMath = new StringBuilder();
    }

    public void submit(String[] elementMath){
        InfixToPostfix  ITP = new InfixToPostfix();
        if (textMath.length()>0){
            try{
                if (!ITP.check_error) elementMath = ITP.processString(textMath.toString());		//	split expression to element
                if (!ITP.check_error) elementMath = ITP.postfix(elementMath);		// 	format elements to postfix
                if (!ITP.check_error) textAns = new StringBuilder(ITP.valueMath(elementMath));		// get result
                screenAns.setText(textAns);

                checkSubmit = 1;

            }catch(Exception e){
                error();
            }
            if (ITP.check_error) error();
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        String elementMath[] = null;

        if (id == R.id.btnUp){
            Intent myIntent = new Intent(view.getContext(), Main3Activity.class);
            startActivityForResult(myIntent, 0);
        }

        if (id == R.id.btn0){
            if (screenTextMath.length()<72) {
                if (checkSubmit == 1)
                {
                    //screenTextMath = new StringBuilder("");
                    //textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("0");
                screenTextMath.append("0");
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else if (id == R.id.btn1){
            if (screenTextMath.length()<72) {
                if (checkSubmit == 1)
                {
                    //screenTextMath = new StringBuilder("");
                    //textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("1");
                screenTextMath.append("1");
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else if (id == R.id.btn2){
            if (screenTextMath.length()<72) {
                if (checkSubmit == 1)
                {
                    //screenTextMath = new StringBuilder("");
                    //textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("2");
                screenTextMath.append("2");
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }



        else if (id == R.id.btn3){
            if (screenTextMath.length()<72) {
                if (checkSubmit == 1)
                {
                    //screenTextMath = new StringBuilder("");
                    //textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("3");
                screenTextMath.append("3");
            }

            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }



        else if (id == R.id.btn4){
            if (screenTextMath.length()<72) {
                if (checkSubmit == 1)
                {
                    //screenTextMath = new StringBuilder("");
                    //textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("4");
                screenTextMath.append("4");
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else if (id == R.id.btn5){
            if (screenTextMath.length()<72) {
                if (checkSubmit == 1)
                {
                    //screenTextMath = new StringBuilder("");
                    //textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("5");
                screenTextMath.append("5");
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else if (id == R.id.btn6){
            if (screenTextMath.length()<72) {
                if (checkSubmit == 1)
                {
                    //screenTextMath = new StringBuilder("");
                    //textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("6");
                screenTextMath.append("6");
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else if (id == R.id.btn7){
            if (screenTextMath.length()<72) {
                if (checkSubmit == 1)
                {
                    //screenTextMath = new StringBuilder("");
                    //textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("7");
                screenTextMath.append("7");
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else if (id == R.id.btn8){
            if (screenTextMath.length()<72) {
                if (checkSubmit == 1)
                {
                   // screenTextMath = new StringBuilder("");
                    //textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("8");
                screenTextMath.append("8");
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else if (id == R.id.btn9){
            if (screenTextMath.length()<72) {
                if (checkSubmit == 1)
                {
                    //screenTextMath = new StringBuilder("");
                    //textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("9");
                screenTextMath.append("9");
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else if (id == R.id.btnDot){
            if (screenTextMath.length()<72) {
                if (checkSubmit == 1)
                {
                   // screenTextMath = new StringBuilder("");
                   // textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append(".");
                screenTextMath.append(".");
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else if (id == R.id.btnTenToPow){
            if(btnTenToPow.getText()=="x10^") {
                if (screenTextMath.length() <72) {
                    if (checkSubmit == 1) {
                       // screenTextMath = new StringBuilder("");
                       // textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    if(screenTextMath.length()>0) {
                        char p = screenTextMath.charAt(screenTextMath.length() - 1);
                        if (p == '+' || p == '-' || p == '*' || p == '/') {
                            textMath = new StringBuilder(textMath.substring(0, textMath.length() - 1));
                            screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 1));
                            textMath.append("m(");
                            screenTextMath.append("*^10(");
                        } else {
                            textMath.append("m(");
                            screenTextMath.append("*10^(");
                        }
                    }
                    else
                    {
                        textMath.append("m(");
                        screenTextMath.append("*10^(");
                    }

                }
            }
            else if(btnTenToPow.getText()=="π"){
                if (screenTextMath.length() < 48) {
                    if (checkSubmit == 1) {
                        screenTextMath = new StringBuilder("");
                        textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    textMath.append("π");
                    screenTextMath.append("π");
                }
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }


        else if (id == R.id.btnPlus){
            if (screenTextMath.length()<72) {
                if (checkSubmit == 1)
                {
                   // screenTextMath = new StringBuilder("");
                   // textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                if(screenTextMath.length()>0) {
                    char p = screenTextMath.charAt(screenTextMath.length() - 1);
                    if (p == '+' || p == '-' || p == '*' || p == '/') {
                        textMath = new StringBuilder(textMath.substring(0, textMath.length() - 1));
                        screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 1));
                        textMath.append("+");
                        screenTextMath.append("+");
                    } else {
                        textMath.append("+");
                        screenTextMath.append("+");
                    }
                }
                else
                {
                    textMath.append("+");
                    screenTextMath.append("+");
                }
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else  if (id == R.id.btnMinus){
            if (screenTextMath.length()<72) {
                if (checkSubmit == 1)
                {
                  //  screenTextMath = new StringBuilder("");
                  //  textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                if(screenTextMath.length()>0) {
                    char p = screenTextMath.charAt(screenTextMath.length() - 1);
                    if (p == '+' || p == '-' || p == '*' || p == '/') {
                        textMath = new StringBuilder(textMath.substring(0, textMath.length() - 1));
                        screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 1));
                        textMath.append("-");
                        screenTextMath.append("-");
                    } else {
                        textMath.append("-");
                        screenTextMath.append("-");
                    }
                }
                else
                {
                    textMath.append("-");
                    screenTextMath.append("-");
                }
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else if (id == R.id.btnMplus){
            if(btnMplus.getText()=="M+")
            {
                if (screenTextMath.length()<72 && screenTextMath.length()>=1) {
                    if (checkSubmit == 1)
                    {
                      //  screenTextMath = new StringBuilder("");
                      //  textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    submit(elementMath);
                    screenTextMath.append("M+");
                    M=textAns;
                }
            }
            else if(btnMplus.getText()=="M")
            {
                if (screenTextMath.length()<72) {
                    if (checkSubmit == 1)
                    {
                      //  screenTextMath = new StringBuilder("");
                       // textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    textMath.append(M);
                    screenTextMath.append("M");
                }
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else  if (id == R.id.btnMul){
            if (screenTextMath.length()<72) {
                if (checkSubmit == 1)
                {
                  //  screenTextMath = new StringBuilder("");
                  //  textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                if(screenTextMath.length()>0) {
                    char p = screenTextMath.charAt(screenTextMath.length() - 1);
                    if (p == '+' || p == '-' || p == '*' || p == '/') {
                        textMath = new StringBuilder(textMath.substring(0, textMath.length() - 1));
                        screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 1));
                        textMath.append("*");
                        screenTextMath.append("*");
                    } else {
                        textMath.append("*");
                        screenTextMath.append("*");
                    }
                }
                else
                {
                    textMath.append("*");
                    screenTextMath.append("*");
                }
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }



        else if (id == R.id.btnDiv){
            if (screenTextMath.length()<72) {
                if (checkSubmit == 1)
                {
                  //  screenTextMath = new StringBuilder("");
                   // textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                if(screenTextMath.length()>0) {
                    char p = screenTextMath.charAt(screenTextMath.length() - 1);
                    if (p == '+' || p == '-' || p == '*' || p == '/') {
                        textMath = new StringBuilder(textMath.substring(0, textMath.length() - 1));
                        screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 1));
                        textMath.append("/");
                        screenTextMath.append("/");
                    } else {
                        textMath.append("/");
                        screenTextMath.append("/");
                    }
                }
                else
                {
                    textMath.append("/");
                    screenTextMath.append("/");
                }
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");

        }

        else   if (id == R.id.btnSquareRoot){
            if (screenTextMath.length()<72) {
                if (checkSubmit == 1)
                {
                  //  screenTextMath = new StringBuilder("");
                  //  textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("@");
                screenTextMath.append("√");
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else   if (id == R.id.btnPow){
            if(btnPow.getText()=="x^2") {
                if (screenTextMath.length() < 72) {
                    if (checkSubmit == 1) {
                        //  screenTextMath = new StringBuilder("");
                        //  textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    if(screenTextMath.length()>0) {
                        char p = screenTextMath.charAt(screenTextMath.length() - 1);
                        if (p == '+' || p == '-' || p == '*' || p == '/') {
                            textMath = new StringBuilder(textMath.substring(0, textMath.length() - 1));
                            screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 1));
                            textMath.append("#");
                            screenTextMath.append("^(2)");
                        } else {
                            textMath.append("#");
                            screenTextMath.append("^(2)");
                        }
                    }
                    else
                    {
                        textMath.append("#");
                    screenTextMath.append("^(2)");
                    }

                }
            }
            else if(btnPow.getText()=="^")
            {
                if (screenTextMath.length() < 72) {
                    if (checkSubmit == 1) {
                        //  screenTextMath = new StringBuilder("");
                        //  textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    if(screenTextMath.length()>0) {
                        char p = screenTextMath.charAt(screenTextMath.length() - 1);
                        if (p == '+' || p == '-' || p == '*' || p == '/') {
                            textMath = new StringBuilder(textMath.substring(0, textMath.length() - 1));
                            screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 1));
                            textMath.append("^(");
                            screenTextMath.append("^(");
                        } else {
                            textMath.append("^(");
                            screenTextMath.append("^(");
                        }
                    }
                    else
                    {
                        textMath.append("^(");
                        screenTextMath.append("^(");
                    }

                }
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else if (id == R.id.btnAns){
            if (screenTextMath.length()<72) {
                if (checkSubmit == 1)
                {
                    //screenTextMath = new StringBuilder("");
                    //textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append(textAns);
                screenTextMath.append("Ans");
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }
        else   if (id == R.id.btnShift){
            if (btnnPr.getText()=="nPr") {
                btnnPr.setText("nCr");
                btnnPr.setTextColor(getResources().getColor(R.color.colorAccent));
                btnShift.setTextColor(getResources().getColor(R.color.colorAccent));

            }
            else {
                btnnPr.setText("nPr");
                btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }

            if (btnSin.getText()=="sin") {
                btnSin.setText("sin-1");
                btnSin.setTextColor(getResources().getColor(R.color.colorAccent));
            }

            else {
                btnSin.setText("sin");
                btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }

            if (btnCos.getText()=="cos") {
                btnCos.setText("cos-1");
                btnCos.setTextColor(getResources().getColor(R.color.colorAccent));
            }

            else {
                btnCos.setText("cos");
                btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }

            if (btnTan.getText()=="tan") {
                btnTan.setText("tan-1");
                btnTan.setTextColor(getResources().getColor(R.color.colorAccent));
            }

            else {
                btnTan.setText("tan");
                btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }

            if (btnClear.getText()=="AC") {
                btnClear.setText("OFF");
                btnClear.setTextColor(getResources().getColor(R.color.colorAccent));
            }
            else {
                btnClear.setText("AC");
                btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }

            if (btnLog.getText()=="log") {
                btnLog.setText("x10^");
                btnLog.setTextColor(getResources().getColor(R.color.colorAccent));
            }
            else {
                btnLog.setText("log");
                btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }

            if (btnLn.getText()=="ln") {
                btnLn.setText("e^");
                btnLn.setTextColor(getResources().getColor(R.color.colorAccent));
            }
            else {
                btnLn.setText("ln");
                btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
            if (btnTenToPow.getText()=="x10^") {
                btnTenToPow.setText("π");
                btnTenToPow.setTextColor(getResources().getColor(R.color.colorAccent));
            }
            else {
                btnTenToPow.setText("x10^");
                btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
            if (btnBracketsOpen.getText()=="(") {
                btnBracketsOpen.setText("X");
                btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorAccent));
            }
            else {
                btnBracketsOpen.setText("(");
                btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
            if (btnbracketClose.getText()==")") {
                btnbracketClose.setText("Y");
                btnbracketClose.setTextColor(getResources().getColor(R.color.colorAccent));
            }
            else {
                btnbracketClose.setText(")");
                btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
            if (btnPow.getText()=="x^2") {
                btnPow.setText("^");
                btnPow.setTextColor(getResources().getColor(R.color.colorAccent));
            }
            else {
                btnPow.setText("x^2");
                btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }

            if (btnMplus.getText()=="M+") {
                btnMplus.setText("M");
                btnMplus.setTextColor(getResources().getColor(R.color.colorAccent));
            }
            else {
                btnMplus.setText("M+");
                btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }


        }


        else  if (id == R.id.btnSin){
            if(btnSin.getText()=="sin")
            {
                if (screenTextMath.length()<72) {
                    if (checkSubmit == 1)
                    {
                       // screenTextMath = new StringBuilder("");
                       // textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    textMath.append("s(");
                    screenTextMath.append("sin(");
                }
                screenMath.setText(screenTextMath);
            }
            else if(btnSin.getText()=="sin-1")
            {
                if (screenTextMath.length()<72) {
                    if (checkSubmit == 1)
                    {
                      //  screenTextMath = new StringBuilder("");
                      //  textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    textMath.append("x(");
                    screenTextMath.append("sin-1(");
                }
                screenMath.setText(screenTextMath);
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }


        else   if (id == R.id.btnCos){
            if(btnCos.getText()=="cos")
            {
                if (screenTextMath.length()<72) {
                    if (checkSubmit == 1)
                    {
                      //  screenTextMath = new StringBuilder("");
                      //  textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    textMath.append("c(");
                    screenTextMath.append("cos(");
                }
                screenMath.setText(screenTextMath);
            }

            else if(btnCos.getText()=="cos-1")
            {
                if (screenTextMath.length()<72) {
                    if (checkSubmit == 1)
                    {
                     //   screenTextMath = new StringBuilder("");
                      //  textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    textMath.append("y(");
                    screenTextMath.append("cos-1(");
                }
                screenMath.setText(screenTextMath);
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else  if (id == R.id.btnTan){
            if(btnTan.getText()=="tan")
            {
                if (screenTextMath.length()<72) {
                    if (checkSubmit == 1)
                    {
                      //  screenTextMath = new StringBuilder("");
                      //  textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    textMath.append("t(");
                    screenTextMath.append("tan(");
                }
                screenMath.setText(screenTextMath);
            }

            else if(btnTan.getText()=="tan-1")
            {
                if (screenTextMath.length()<72) {
                    if (checkSubmit == 1)
                    {
                      //  screenTextMath = new StringBuilder("");
                      //  textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    textMath.append("z(");
                    screenTextMath.append("tan-1(");
                }
                screenMath.setText(screenTextMath);
            }

            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else  if (id == R.id.btnLn){
            if(btnLn.getText()=="ln")
            {
                if (screenTextMath.length()<72) {
                    if (checkSubmit == 1)
                    {
                     //   screenTextMath = new StringBuilder("");
                     //   textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    textMath.append("v(");
                    screenTextMath.append("ln(");
                }
            }
            else if(btnLn.getText()=="e^")
            {
                if (screenTextMath.length()<72) {
                    if (checkSubmit == 1)
                    {
                     //   screenTextMath = new StringBuilder("");
                     //   textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    textMath.append("n(");
                    screenTextMath.append("e^(");
                }
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else  if (id == R.id.btnLog){
            if(btnLog.getText()=="log")
            {
                if (screenTextMath.length()<72) {
                    if (checkSubmit == 1)
                    {
                      //  screenTextMath = new StringBuilder("");
                      //  textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    textMath.append("l(");
                    screenTextMath.append("log(");
                }
            }
            else if(btnLog.getText()=="x10^")
            {
                if (screenTextMath.length()<72) {
                    if (checkSubmit == 1)
                    {
                      //  screenTextMath = new StringBuilder("");
                      //  textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    if(screenTextMath.length()>0) {
                        char p = screenTextMath.charAt(screenTextMath.length() - 1);
                        if (p == '+' || p == '-' || p == '*' || p == '/') {
                            textMath = new StringBuilder(textMath.substring(0, textMath.length() - 1));
                            screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 1));
                            textMath.append("m(");
                            screenTextMath.append("*10^(");
                        } else {
                            textMath.append("m(");
                            screenTextMath.append("*10^(");
                        }
                    }
                    else
                    {
                        textMath.append("m(");
                        screenTextMath.append("*10^(");
                    }
                }
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else  if (id == R.id.btnFactorial){
            if (screenTextMath.length()<72) {
                if (checkSubmit == 1)
                {
                  //  screenTextMath = new StringBuilder("");
                  //  textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                if(screenTextMath.length()>0) {
                    char p = screenTextMath.charAt(screenTextMath.length() - 1);
                    if (p == '+' || p == '-' || p == '*' || p == '/') {
                        textMath = new StringBuilder(textMath.substring(0, textMath.length() - 1));
                        screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 1));
                        textMath.append("!");
                        screenTextMath.append("!");
                    } else {
                        textMath.append("!");
                        screenTextMath.append("!");
                    }
                }
                else
                {
                    textMath.append("!");
                    screenTextMath.append("!");
                }
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else  if (id == R.id.btnnPr){
            if (screenTextMath.length()<72) {
                if (checkSubmit == 1)
                {
                  //  screenTextMath = new StringBuilder("");
                  //  textMath = new StringBuilder("");
                    checkSubmit = 0;
                }

                if(btnnPr.getText()=="nPr") {
                    textMath.append("p");
                    screenTextMath.append("P");

                }
                else if(btnnPr.getText()=="nCr") {
                    textMath.append("a");
                    screenTextMath.append("C");

                }
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else if (id == R.id.btnBracketOpen){
            if(btnBracketsOpen.getText()=="(")
            {
                if (screenTextMath.length()<72) {
                    if (checkSubmit == 1)
                    {
                        //  screenTextMath = new StringBuilder("");
                        //  textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    textMath.append("(");
                    screenTextMath.append("(");
                }
            }
            else if(btnBracketsOpen.getText()=="X")
            {
                if (screenTextMath.length()<72) {
                    if (checkSubmit == 1)
                    {
                        //  screenTextMath = new StringBuilder("");
                        //  textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    textMath.append("");
                    screenTextMath.append("X");
                }
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else  if (id == R.id.btnbracketClose){
            if(btnbracketClose.getText()==")")
            {
                if (screenTextMath.length()<72) {
                    if (checkSubmit == 1)
                    {
                        //  screenTextMath = new StringBuilder("");
                        //  textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    textMath.append(")");
                    screenTextMath.append(")");
                }
            }
            else if(btnbracketClose.getText()=="Y")
            {
                if (screenTextMath.length()<72) {
                    if (checkSubmit == 1)
                    {
                        //  screenTextMath = new StringBuilder("");
                        //  textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    textMath.append("");
                    screenTextMath.append("Y");
                }
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else    if (id == R.id.btnInverse){

            if (screenTextMath.length()<72) {
                if (checkSubmit == 1)
                {
                  //  screenTextMath = new StringBuilder("");
                  //  textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                if(screenTextMath.length()>0) {
                    char p = screenTextMath.charAt(screenTextMath.length() - 1);
                    if (p == '+' || p == '-' || p == '*' || p == '/') {
                        textMath = new StringBuilder(textMath.substring(0, textMath.length() - 1));
                        screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 1));
                        textMath.append("~");
                        screenTextMath.append("^(-1)");
                    } else {
                        textMath.append("~");
                        screenTextMath.append("^(-1)");
                    }
                }
                else
                {
                    textMath.append("~");
                    screenTextMath.append("^(-1)");
                }
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else if (id == R.id.btnEqual){
            if(screenTextMath.length()!=0)
            {
            submit(elementMath);
            screenMath.setText(screenTextMath);}
            else
            {
                 screenAns.setText(" ");
            }
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else if(id == R.id.btnAc){

            if(btnClear.getText()=="AC")
            {
                textMath = new StringBuilder("");
                screenTextMath = new StringBuilder("");
                //textAns = new StringBuilder("");
                screenAns.setText(" ");
                screenMath.setText("");

            }
            else if(btnClear.getText()=="OFF")
            {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }

        else if(id == R.id.btnMode){

                textMath = new StringBuilder("");
                screenTextMath = new StringBuilder("");
                //textAns = new StringBuilder("");
                screenAns.setText(" ");
                screenMath.setText("");

            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }
        else  if (id == R.id.btnDif){
                if (screenTextMath.length()<70) {
                    if (checkSubmit == 1)
                    {
                        //  screenTextMath = new StringBuilder("");
                        //  textMath = new StringBuilder("");
                        checkSubmit = 0;
                    }
                    if(screenTextMath.length()>0) {
                        char p = screenTextMath.charAt(screenTextMath.length() - 1);
                        if (p == '+' || p == '-' || p == '*' || p == '/') {
                            textMath = new StringBuilder(textMath.substring(0, textMath.length() - 1));
                            screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 1));
                            textMath.append("$");
                            screenTextMath.append("^(3)");
                        } else {
                            textMath.append("$");
                            screenTextMath.append("^(3)");
                        }
                    }
                    else
                    {
                        textMath.append("$");
                        screenTextMath.append("^(3)");
                    }
                }

            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
        }


        else if(id == R.id.btnDel){
            if(screenMath.length()>0) {
                if (screenMath.length() > 0) {
                    c = textMath.charAt(textMath.length() - 1);
                    a = screenTextMath.charAt(screenTextMath.length() - 1);
                }
                if (screenMath.length() > 1) {
                    b = screenTextMath.charAt(screenTextMath.length() - 2);
                }
                if (screenMath.length() > 2) {
                    e = screenTextMath.charAt(screenTextMath.length() - 3);
                }
                if (textMath.length() > 0 && c == '(' && (textMath.charAt(textMath.length() - 2) == '^')) {
                    screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 2));
                    textMath = new StringBuilder(textMath.substring(0, textMath.length() - 1));
                } else if (textMath.length() > 0 && c == '(' && (textMath.charAt(textMath.length() - 2) == 's' || textMath.charAt(textMath.length() - 2) == 'c' ||
                        textMath.charAt(textMath.length() - 2) == 't' || textMath.charAt(textMath.length() - 2) == 'l')) {
                    textMath = new StringBuilder(textMath.substring(0, textMath.length() - 2));
                    screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 4));
                } else if (textMath.length() > 0 && c == '(' && (textMath.charAt(textMath.length() - 2) == 'x' || textMath.charAt(textMath.length() - 2) == 'y' ||
                        textMath.charAt(textMath.length() - 2) == 'z')) {
                    textMath = new StringBuilder(textMath.substring(0, textMath.length() - 2));
                    screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 6));
                } else if (textMath.length() > 0 && c == '(' && (textMath.charAt(textMath.length() - 2) == 'v' || textMath.charAt(textMath.length() - 2) == 'n')) {
                    textMath = new StringBuilder(textMath.substring(0, textMath.length() - 2));
                    screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 3));
                } else if (textMath.length() > 0 && c == '(' && (textMath.charAt(textMath.length() - 2) == 'm')) {
                    textMath = new StringBuilder(textMath.substring(0, textMath.length() - 2));
                    screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 5));
                } else if (textMath.length() > 0 && c == '#') {
                    textMath = new StringBuilder(textMath.substring(0, textMath.length() - 1));
                    screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 4));
                } else if (textMath.length() > 0 && c == '$') {
                    textMath = new StringBuilder(textMath.substring(0, textMath.length() - 1));
                    screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 4));
                } else if (textMath.length() > 0 && a == '+' && c != '+' && b == 'M') {
                    //textMath = new StringBuilder(textMath.substring(0,textMath.length()-textAns.length()));
                    screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 2));
                } else if (textMath.length() > 0 && a == 'M') {
                    textMath = new StringBuilder(textMath.substring(0, textMath.length() - M.length()));
                    screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 1));
                } else if (textMath.length() > 0 && c == '~') {
                    textMath = new StringBuilder(textMath.substring(0, textMath.length() - 1));
                    screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 5));
                } else if (screenTextMath.length() > 0 && a == 's' && b == 'n' && e == 'A') {
                    textMath = new StringBuilder(textMath.substring(0, textMath.length() - textAns.length()));
                    screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 3));
                } else {
                    textMath = new StringBuilder(textMath.substring(0, textMath.length() - 1));
                    screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 1));
                }

            }
            screenMath.setText(screenTextMath);
            btnShift.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnnPr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnClear.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnSin.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnCos.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLog.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnLn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnTenToPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnPow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnBracketsOpen.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnbracketClose.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnMplus.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnDif.setText("d/dx");
            btnPow.setText("x^2");
            btnBracketsOpen.setText("(");
            btnbracketClose.setText(")");
            btnMplus.setText("M+");
            btnTenToPow.setText("x10^");
            btnnPr.setText("nPr");
            btnClear.setText("AC");
            btnSin.setText("sin");
            btnCos.setText("cos");
            btnTan.setText("tan");
            btnMplus.setText("M+");
            btnLog.setText("log");
            btnLn.setText("ln");
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
            if(event2.getX()<event1.getX())
            {
             Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                finish();
                startActivity(intent);
            }
           /* else if(event2.getX()<event1.getX())
            {
                Intent intent=new Intent(MainActivity.this,Main3Activity.class);
                finish();
                startActivity(intent);
            }*/
            return true;
        }
    }
}

