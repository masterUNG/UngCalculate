package masterung.androidthai.in.th.ungcalculate.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import masterung.androidthai.in.th.ungcalculate.MainActivity;
import masterung.androidthai.in.th.ungcalculate.R;

/**
 * Created by masterung on 9/1/2018 AD.
 */

public class CalculateFragment extends Fragment implements View.OnClickListener {

    //    Explicit
    private TextView textView;
    private Button buttonC, button1, button2,
            button3, button4, button5,
            button6, button7, button8,
            button9, button0, buttonDivide,
            buttonMuliply, buttonAdd, buttonMinus, buttonEqual;
    private String displayString = "";
    private double num1ADouble = 0, displayADouble;
    private String tag = "23JanV1";
    private boolean addABoolean = false;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create Toolbar
        createToolbar();

//        Initial View
        initialView();

//        One Controller
        oneController();

//        Two Controller
        twoController();

//        Three Controller
        threeController();

//        Four Controller
        fourController();

//        Number Controller
        numberController();


    }   // Main Method

    private void numberController() {
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMuliply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonC.setOnClickListener(this);
    }

    private void fourController() {
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDisplay("4");
            }
        });
    }

    private void threeController() {
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDisplay("3");
            }
        });
    }

    private void twoController() {
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDisplay("2");
            }
        });
    }

    private void oneController() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Show Display
                showDisplay("1");

            }
        });
    }

    private void showDisplay(String strDisplay) {
        StringBuilder stringBuilder = new StringBuilder();
        displayString = displayString + stringBuilder.append(strDisplay).toString();
        textView.setText(displayString);
    }

    private void initialView() {

        textView = getView().findViewById(R.id.txtDisplay);
        buttonC = getView().findViewById(R.id.btnC);
        button1 = getView().findViewById(R.id.btn1);
        button2 = getView().findViewById(R.id.btn2);
        button3 = getView().findViewById(R.id.btn3);
        button4 = getView().findViewById(R.id.btn4);
        button5 = getView().findViewById(R.id.btn5);
        button6 = getView().findViewById(R.id.btn6);
        button7 = getView().findViewById(R.id.btn7);
        button8 = getView().findViewById(R.id.btn8);
        button9 = getView().findViewById(R.id.btn9);
        button0 = getView().findViewById(R.id.btn0);
        buttonAdd = getView().findViewById(R.id.btnAdd);
        buttonMinus = getView().findViewById(R.id.btnMinus);
        buttonMuliply = getView().findViewById(R.id.btnMultiply);
        buttonDivide = getView().findViewById(R.id.btnDivide);
        buttonEqual = getView().findViewById(R.id.btnEqual);


    }

    private void createToolbar() {

        Toolbar toolbar = getView().findViewById(R.id.toolbarCalculate);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);

        ((MainActivity) getActivity()).getSupportActionBar()
                .setTitle("Calculate");

        ((MainActivity) getActivity()).getSupportActionBar()
                .setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculate, container, false);
        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn5:
                showDisplay("5");
                break;

            case R.id.btn6:
                showDisplay("6");
                break;

            case R.id.btn7:
                showDisplay("7");
                break;

            case R.id.btn8:
                showDisplay("8");
                break;

            case R.id.btn9:
                showDisplay("9");
                break;

            case R.id.btn0:
                showDisplay("0");
                break;

            case R.id.btnC:
//                Clear Display
                clearDisplay();
                break;

            case R.id.btnAdd:

                addABoolean = true;

                displayADouble = Double.parseDouble(displayString);

                if (num1ADouble == 0) {
                    num1ADouble = displayADouble;
                } else {
                    num1ADouble = num1ADouble + displayADouble;
                }

                Log.d(tag, "num1 ==> " + num1ADouble);

                clearDisplay();

                break;

            case R.id.btnEqual:

                displayADouble = Double.parseDouble(displayString);

                Log.d(tag, "num1Adouble ==> " + num1ADouble);
                Log.d(tag, "displayAdouble ==> " + displayADouble);
                Log.d(tag, "addABoolean ==> " + addABoolean);

                if (addABoolean) {
                    num1ADouble = num1ADouble + displayADouble;
                    addABoolean = false;
                }

                Log.d(tag, "num1Adouble after if ==> " + num1ADouble);

                textView.setText(Double.toString(num1ADouble));

                break;

            case R.id.btnMinus:

                if (num1ADouble == 0) {

                    num1ADouble = Double.parseDouble(displayString);

                } else {

                    num1ADouble = num1ADouble - Double.parseDouble(displayString);

                }

                Log.d(tag, "num1 at btnMinus ==> " + num1ADouble);
                clearDisplay();

                break;



        }   // switch


    }   // onClick

    private void clearDisplay() {

        textView.setText("");
        displayString = "";
        displayADouble = 0;

    }

}   // Main Class
