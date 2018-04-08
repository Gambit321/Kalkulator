package com.example.danko.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, btSum, btMinus, btDevide, btMultiple, btEqual,
            btClear, btComa;

    TextView tv, sc;
    String s = "";

    double num1 = 0, num2 = 0, num3 = 0;
    boolean plus = false, minus = false, multiple = false, divide = false;
    boolean plus1 = false, minus1 = false, multiple1 = false, divide1 = false, equal = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sc = findViewById(R.id.editScreen);
        tv = findViewById(R.id.textView);

        bt0 = findViewById(R.id.btn0);
        bt1 = findViewById(R.id.btn1);
        bt2 = findViewById(R.id.btn2);
        bt3 = findViewById(R.id.btn3);
        bt4 = findViewById(R.id.btn4);
        bt5 = findViewById(R.id.btn5);
        bt6 = findViewById(R.id.btn6);
        bt7 = findViewById(R.id.btn7);
        bt8 = findViewById(R.id.btn8);
        bt9 = findViewById(R.id.btn9);
        btSum = findViewById(R.id.btnSum);
        btMinus = findViewById(R.id.btnMin);
        btDevide = findViewById(R.id.btnDevide);
        btMultiple = findViewById(R.id.btnMul);
        btEqual = findViewById(R.id.btnEqual);
        btClear = findViewById(R.id.btnC);
        btComa = findViewById(R.id.btnComa);


        btComa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!sc.getText().toString().contains(".")) {
                    sc.setText(sc.getText() + ".");
                }
                if (divide  || minus  || multiple|| plus ) {
                    return;
                }

            }
        });

        btEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv.setText("");

                num2 = Double.parseDouble(sc.getText().toString());

                if (plus1) {
                    num3 = num1 + num2;
                    plus = false;
                }
                if (minus1) {
                    num3 = num1 - num2;
                    minus = false;
                }
                if (multiple1) {
                    num3 = num1 * num2;
                    multiple = false;
                }
                if (divide1 && num2 != 0) {
                    num3 = num1 / num2;
                    divide1 = false;
                } else if (num2 == 0) {
                    Toast.makeText(MainActivity.this, "Don't divide with 0", Toast.LENGTH_LONG).show();
                    sc.setText("0");
                    num1 = 0;
                    num2 = 0;
                    num3 = 0;
                    plus = false;
                    minus = false;
                    divide = false;
                    multiple = false;
                    plus1 = false;
                    minus1 = false;
                    divide1 = false;
                    multiple1 = false;
                    return;
                }

                sc.setText(String.valueOf(Math.round(num3 * 100.0) / 100.0));
                num1 = 0;
                num2 = 0;
                num3 = 0;
                plus = false;
                minus = false;
                divide = false;
                multiple = false;
                plus1 = false;
                minus1 = false;
                divide1 = false;
                multiple1 = false;

                equal = true;
            }
        });

        btSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sc.getText().toString().equals("0") || sc.getText().toString().equals("0.0")) {
                    return;
                }
                if (divide == true || minus == true || multiple == true || plus == true) {
                    return;
                }

                if (plus1) {
                    num2 = Double.parseDouble(sc.getText().toString());
                    num3 = num2 + num1;
                    num1 = num3;
                    sc.setText(String.valueOf(Math.round(num3 * 100.0) / 100.0));
                    plus = true;
                    tv.append(Double.toString(num2) + "+");
                } else if (divide1) {
                    num2 = Double.parseDouble(sc.getText().toString());
                    num3 = num2 / num1;
                    num1 = num3;
                    sc.setText(String.valueOf(Math.round(num3 * 100.0) / 100.0));

                    divide = false;
                    divide1 = false;
                    plus = true;
                    tv.append(Double.toString(num2) + "+");
                } else if (minus1) {
                    num2 = Double.parseDouble(sc.getText().toString());

                    num3 = num1 - num2;
                    num1 = num3;
                    sc.setText(String.valueOf(Math.round(num3 * 100.0) / 100.0));

                    minus = false;
                    minus1 = false;
                    plus = true;
                    if (num3 != 0) {
                        tv.append(Double.toString(num2) + "+");
                    }
                } else if (multiple1) {
                    num2 = Double.parseDouble(sc.getText().toString());
                    num3 = num2 * num1;
                    num1 = num3;
                    sc.setText(String.valueOf(Math.round(num3 * 100.0) / 100.0));

                    multiple = false;
                    multiple1 = false;
                    plus = true;
                    tv.append(Double.toString(num2) + "+");
                } else {
                    plus = true;
                    num1 = Double.parseDouble(sc.getText().toString());

                    tv.append(Double.toString(num1) + "+");
                }


            }
        });

        btMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sc.getText().toString().equals("0") || sc.getText().toString().equals("0.0")) {
                    return;
                }
                if (divide == true || minus == true || multiple == true || plus == true) {
                    return;
                }
                if (minus1) {
                    num2 = Double.parseDouble(sc.getText().toString());

                    num3 = num1 - num2;
                    num1 = num3;
                    sc.setText(String.valueOf(Math.round(num3 * 100.0) / 100.0));

                    minus = true;
                    if (num3 != 0) {
                        tv.append(Double.toString(num2) + "-");
                    }
                } else if (plus1) {
                    num2 = Double.parseDouble(sc.getText().toString());
                    num3 = num2 + num1;
                    num1 = num3;
                    sc.setText(String.valueOf(Math.round(num3 * 100.0) / 100.0));
                    plus = false;
                    plus1 = false;
                    minus = true;
                    tv.append(Double.toString(num2) + "-");
                } else if (multiple1) {
                    num2 = Double.parseDouble(sc.getText().toString());
                    num3 = num2 * num1;
                    num1 = num3;
                    sc.setText(String.valueOf(Math.round(num3 * 100.0) / 100.0));

                    multiple = false;
                    multiple1 = false;
                    minus = true;
                    tv.append(Double.toString(num2) + "-");
                } else if (divide1) {
                    num2 = Double.parseDouble(sc.getText().toString());
                    num3 = num2 / num1;
                    num1 = num3;
                    sc.setText(String.valueOf(Math.round(num3 * 100.0) / 100.0));

                    divide = false;
                    divide1 = false;
                    minus = true;
                    tv.append(Double.toString(num2) + "-");
                } else {
                    minus = true;
                    num1 = Double.parseDouble(sc.getText().toString());

                    tv.append(Double.toString(num1) + "-");
                }

            }
        });

        btMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sc.getText().toString().equals("0") || sc.getText().toString().equals("0.0")) {
                    return;
                }
                if (divide == true || minus == true || multiple == true || plus == true) {
                    return;
                }
                if (multiple1) {
                    num2 = Double.parseDouble(sc.getText().toString());
                    num3 = num2 * num1;
                    num1 = num3;
                    sc.setText(String.valueOf(Math.round(num3 * 100.0) / 100.0));

                    multiple = true;
                    tv.append(Double.toString(num2) + "*");
                }
                if (divide1) {
                    num2 = Double.parseDouble(sc.getText().toString());
                    num3 = num2 / num1;
                    num1 = num3;
                    sc.setText(String.valueOf(Math.round(num3 * 100.0) / 100.0));

                    divide = false;
                    divide1 = false;
                    multiple = true;
                    tv.append(Double.toString(num2) + "*");
                }
                if (minus1) {
                    num2 = Double.parseDouble(sc.getText().toString());

                    num3 = num1 - num2;
                    num1 = num3;
                    sc.setText(String.valueOf(Math.round(num3 * 100.0) / 100.0));

                    minus = false;
                    minus1 = false;
                    multiple = true;
                    if (num3 != 0) {
                        tv.append(Double.toString(num2) + "*");
                    }
                }
                if (plus1) {
                    num2 = Double.parseDouble(sc.getText().toString());
                    num3 = num2 + num1;
                    num1 = num3;
                    sc.setText(String.valueOf(Math.round(num3 * 100.0) / 100.0));
                    plus = false;
                    plus1 = false;
                    multiple = true;
                    tv.append(Double.toString(num2) + "*");
                } else {
                    multiple = true;
                    num1 = Double.parseDouble(sc.getText().toString());

                    tv.append(Double.toString(num1) + "*");
                }


            }
        });
        btDevide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sc.getText().toString().equals("0") || sc.getText().toString().equals("0.0")) {
                    return;
                }
                if (divide == true || minus == true || multiple == true || plus == true) {
                    return;
                }
                if (divide1) {
                    num2 = Double.parseDouble(sc.getText().toString());
                    num3 = num1 / num2;
                    num1 = num3;
                    sc.setText(String.valueOf(Math.round(num3 * 100.0) / 100.0));

                    divide = true;
                    tv.append(Double.toString(num2) + "/");
                }

                if (minus1) {
                    num2 = Double.parseDouble(sc.getText().toString());

                    num3 = num1 - num2;
                    num1 = num3;
                    sc.setText(String.valueOf(num3));

                    minus = false;
                    minus1 = false;
                    divide = true;
                    if (num3 != 0) {
                        tv.append(Double.toString(num2) + "/");
                    }
                }
                if (plus1) {
                    num2 = Double.parseDouble(sc.getText().toString());
                    num3 = num2 + num1;
                    num1 = num3;
                    sc.setText(String.valueOf(Math.round(num3 * 100.0) / 100.0));
                    plus = false;
                    plus1 = false;
                    divide = true;
                    tv.append(Double.toString(num2) + "/");
                }
                if (multiple1) {
                    num2 = Double.parseDouble(sc.getText().toString());
                    num3 = num2 * num1;
                    num1 = num3;
                    sc.setText(String.valueOf(Math.round(num3 * 100.0) / 100.0));

                    multiple = false;
                    multiple1 = false;
                    divide = true;
                    tv.append(Double.toString(num2) + "/");
                } else {
                    divide = true;
                    num1 = Double.parseDouble(sc.getText().toString());

                    tv.append(Double.toString(num1) + "/");
                }

            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sc.setText("0");
                num1 = 0;
                num2 = 0;
                num3 = 0;
                plus = false;
                minus = false;
                divide = false;
                multiple = false;
                plus1 = false;
                minus1 = false;
                divide1 = false;
                multiple1 = false;
                tv.setText("");
            }


        });

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sc.getText().toString().equals("0") || sc.getText().toString().equals("0.0")
                        || plus == true || minus == true || multiple == true || divide == true || equal == true) {
                    sc.setText("");
                    if (plus) {
                        plus1 = true;
                        plus = false;
                    }
                    if (minus) {
                        minus1 = true;
                        minus = false;
                    }
                    if (multiple) {
                        multiple1 = true;
                        multiple = false;
                    }
                    if (divide) {
                        divide1 = true;
                        divide = false;
                    }
                    equal = false;

                }
                sc.setText(sc.getText() + "0");
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sc.getText().toString().equals("0") || sc.getText().toString().equals("0.0")
                        || plus == true || minus == true || multiple == true || divide == true || equal == true) {

                    sc.setText("");
                    if (plus) {
                        plus1 = true;
                        plus = false;
                    }
                    if (minus) {
                        minus1 = true;
                        minus = false;
                    }
                    if (multiple) {
                        multiple1 = true;
                        multiple = false;
                    }
                    if (divide) {
                        divide1 = true;
                        divide = false;
                    }
                    equal = false;
                }

                sc.setText(sc.getText() + "1");
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sc.getText().toString().equals("0") || sc.getText().toString().equals("0.0")
                        || plus == true || minus == true || multiple == true || divide == true || equal == true) {

                    sc.setText("");
                    if (plus) {
                        plus1 = true;
                        plus = false;
                    }
                    if (minus) {
                        minus1 = true;
                        minus = false;
                    }
                    if (multiple) {
                        multiple1 = true;
                        multiple = false;
                    }
                    if (divide) {
                        divide1 = true;
                        divide = false;
                    }
                    equal = false;
                }
                sc.setText(sc.getText() + "2");
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sc.getText().toString().equals("0") || sc.getText().toString().equals("0.0")
                        || plus == true || minus == true || multiple == true || divide == true || equal == true) {

                    sc.setText("");
                    if (plus) {
                        plus1 = true;
                        plus = false;
                    }
                    if (minus) {
                        minus1 = true;
                        minus = false;
                    }
                    if (multiple) {
                        multiple1 = true;
                        multiple = false;
                    }
                    if (divide) {
                        divide1 = true;
                        divide = false;
                    }
                    equal = false;
                }
                sc.setText(sc.getText() + "3");
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sc.getText().toString().equals("0") || sc.getText().toString().equals("0.0")
                        || plus == true || minus == true || multiple == true || divide == true || equal == true) {
                    sc.setText("");
                    if (plus) {
                        plus1 = true;
                        plus = false;
                    }
                    if (minus) {
                        minus1 = true;
                        minus = false;
                    }
                    if (multiple) {
                        multiple1 = true;
                        multiple = false;
                    }
                    if (divide) {
                        divide1 = true;
                        divide = false;
                    }
                    equal = false;
                }
                sc.setText(sc.getText() + "4");
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sc.getText().toString().equals("0") || sc.getText().toString().equals("0.0")
                        || plus == true || minus == true || multiple == true || divide == true || equal == true) {
                    sc.setText("");
                    if (plus) {
                        plus1 = true;
                        plus = false;
                    }
                    if (minus) {
                        minus1 = true;
                        minus = false;
                    }
                    if (multiple) {
                        multiple1 = true;
                        multiple = false;
                    }
                    if (divide) {
                        divide1 = true;
                        divide = false;
                    }
                    equal = false;
                }
                sc.setText(sc.getText() + "5");
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sc.getText().toString().equals("0") || sc.getText().toString().equals("0.0")
                        || plus == true || minus == true || multiple == true || divide == true || equal == true) {
                    sc.setText("");
                    if (plus) {
                        plus1 = true;
                        plus = false;
                    }
                    if (minus) {
                        minus1 = true;
                        minus = false;
                    }
                    if (multiple) {
                        multiple1 = true;
                        multiple = false;
                    }
                    if (divide) {
                        divide1 = true;
                        divide = false;
                    }
                    equal = false;
                }
                sc.setText(sc.getText() + "6");
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sc.getText().toString().equals("0") || sc.getText().toString().equals("0.0")
                        || plus == true || minus == true || multiple == true || divide == true || equal == true) {
                    sc.setText("");
                    if (plus) {
                        plus1 = true;
                        plus = false;
                    }
                    if (minus) {
                        minus1 = true;
                        minus = false;
                    }
                    if (multiple) {
                        multiple1 = true;
                        multiple = false;
                    }
                    if (divide) {
                        divide1 = true;
                        divide = false;
                    }
                    equal = false;
                }
                sc.setText(sc.getText() + "7");
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sc.getText().toString().equals("0") || sc.getText().toString().equals("0.0")
                        || plus == true || minus == true || multiple == true || divide == true || equal == true) {
                    sc.setText("");
                    if (plus) {
                        plus1 = true;
                        plus = false;
                    }
                    if (minus) {
                        minus1 = true;
                        minus = false;
                    }
                    if (multiple) {
                        multiple1 = true;
                        multiple = false;
                    }
                    if (divide) {
                        divide1 = true;
                        divide = false;
                    }
                    equal = false;
                }
                sc.setText(sc.getText() + "8");
            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sc.getText().toString().equals("0") || sc.getText().toString().equals("0.0")
                        || plus == true || minus == true || multiple == true || divide == true || equal == true) {
                    sc.setText("");
                    if (plus) {
                        plus1 = true;
                        plus = false;
                    }
                    if (minus) {
                        minus1 = true;
                        minus = false;
                    }
                    if (multiple) {
                        multiple1 = true;
                        multiple = false;
                    }
                    if (divide) {
                        divide1 = true;
                        divide = false;
                    }
                    equal = false;
                }
                sc.setText(sc.getText() + "9");
            }
        });

    }

}
