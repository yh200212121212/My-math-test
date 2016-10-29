package test.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        new AlertDialog.Builder(Main2Activity.this).setTitle("提示")
                .setMessage("前两个空格为两边长度，后一个为夹角度数！")//设置显示的内容  
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        dialog.dismiss();
                    }//添加确定按钮   
                }).show();
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) throws ArithmeticException {
                try {
                    EditText editText1 = (EditText) findViewById(R.id.editText5);
                    EditText editText2 = (EditText) findViewById(R.id.editText6);
                    EditText editText3 = (EditText) findViewById(R.id.editText7);
                    EditText editText4 = (EditText) findViewById(R.id.editText8);
                    String a, b, c;
                    a = editText1.getText().toString();
                    b = editText2.getText().toString();
                    c = editText3.getText().toString();
                    double d, e, f;
                    e = Double.parseDouble(b);
                    f = Double.parseDouble(c);
                    d = Double.parseDouble(a);
                    Test test=new Test();
                    double result=test.Get(e,d,f);
                    if(Double.isNaN(result))
                    {
                        //Toast.makeText(Main2Activity.this, "发生错误", Toast.LENGTH_LONG).show();
                        throw new ArithmeticException();
                    }
                    NumberFormat ddf1=NumberFormat.getNumberInstance() ;
                    ddf1.setMaximumFractionDigits(2);
                    char[] chars = String.format(Locale.getDefault(), "三角形面积为 %s", ddf1.format(result)).toCharArray();
                    editText4.setText(chars, 0, chars.length);
                } catch (Exception e) {
                    Toast.makeText(Main2Activity.this, "发生错误", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}