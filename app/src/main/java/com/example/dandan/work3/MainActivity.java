package com.example.dandan.work3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv1,tv2;
    Button bt;
    CheckBox cb1,cb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText)findViewById(R.id.editText);
        tv1=(TextView)findViewById(R.id.textView5);
        tv2=(TextView)findViewById(R.id.textView6);
        bt=(Button)findViewById(R.id.button);
        cb1=(CheckBox)findViewById(R.id.checkBox);
        cb2=(CheckBox)findViewById(R.id.checkBox2);
        View.OnClickListener listener=new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.button){
                    if(!et.getText().toString().trim().equals("")){//判断是否输入了体重
                        if(cb1.isChecked()||cb2.isChecked()){
                            double weight;
                            weight= Double.parseDouble(et.getText().toString());
                            if(cb1.isChecked()){
                                double result=countHeight(weight,1);
                                tv1.setText("男性标准身高："+(int)result+"厘米");
                            }
                            if(cb2.isChecked()){
                                double result=countHeight(weight,2);
                                tv2.setText("女性标准身高："+(int)+result+"厘米");
                            }
                        }
                        else
                            showMwssage("请选择性别！！");
                    }
                    else
                        showMwssage("请输入体重！！");
                }
            }


        };
        bt.setOnClickListener(listener);
    }
    public double countHeight(double weight, int i) {//计算身高的方法
        double height;
        if(i==1){
            height=170-(62-weight)/0.6;
        }
        else{
            height=158-(50-weight)/0.5;
        }
        return height;
    }
    public void showMwssage(String s){
        AlertDialog alert = new AlertDialog.Builder(this).create();
        alert.setTitle("提示信息");
        alert.setMessage(s);
        alert.setButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });
        alert.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
