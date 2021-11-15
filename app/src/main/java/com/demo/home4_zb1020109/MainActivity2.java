package com.demo.home4_zb1020109;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private Spinner sp1;
    private Spinner sp2;
    private RadioGroup rg;
    private RadioButton radioButton;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private RatingBar ratingBar;
    private EditText etm;

    private String system,ratingpoint,totalpoint;

    private CheckBox checkBox,checkBox2,checkBox3,checkBox4,checkBox5,
                     checkBox6,checkBox7,checkBox8,checkBox9,checkBox10;
    private List<CheckBox> checkBoxList = new ArrayList<CheckBox>();



    private int[]cities = {R.array.cities,R.array.beijing,R.array.tianjin,R.array.hebei,R.array.shanxi,R.array.neimengdu,R.array.liaoning, R.array.jilin,
                           R.array.heilongjaing,R.array.shanghai,R.array.jiangsu,R.array.zhejiang,R.array.anhui,R.array.fujian,R.array.jiangxi,
                           R.array.shandong,R.array.henan,R.array.hubei,R.array.hunan,R.array.guangdong,R.array.guangxi,R.array.hainan,
                           R.array.chongqing,R.array.sichuan,R.array.guizhou,R.array.yunnan,R.array.xizang,R.array.shaanxi,R.array.gansu,
                           R.array.qinghai,R.array.ningxia,R.array.xinjiang,R.array.xianggang,R.array.aomen,R.array.taiwan};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        setListeners();
    }

    private void setListeners() {
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                // 改变spinner2绑定的数组，动态给spinner2设置下拉列表，需要通过适配器
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity2.this,
                        cities[position], android.R.layout.simple_dropdown_item_1line);
                //绑定适配器到spinner2
                sp2.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch(checkedId) {
                    case R.id.radioButton:
                        system = radioButton.getText().toString();
                        break;
                    case R.id.radioButton2:
                        system = radioButton2.getText().toString();
                        break;
                    case R.id.radioButton3:
                        system = radioButton3.getText().toString();
                        break;
                    case R.id.radioButton4:
                        system = radioButton4.getText().toString();
                        break;
                }
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {
                ratingpoint = String.valueOf(rating) + "分";
                totalpoint = String.valueOf(ratingBar.getNumStars()) + "分";
            }
        });
    }

    private void init() {
        sp1 = (Spinner) findViewById(R.id.spinner);
        sp2 = (Spinner) findViewById(R.id.spinner2);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox5 = (CheckBox) findViewById(R.id.checkBox5);
        checkBox6 = (CheckBox) findViewById(R.id.checkBox6);
        checkBox7 = (CheckBox) findViewById(R.id.checkBox7);
        checkBox8 = (CheckBox) findViewById(R.id.checkBox8);
        checkBox9 = (CheckBox) findViewById(R.id.checkBox9);
        checkBox10 = (CheckBox) findViewById(R.id.checkBox10);
        checkBoxList.add(checkBox);
        checkBoxList.add(checkBox2);
        checkBoxList.add(checkBox3);
        checkBoxList.add(checkBox4);
        checkBoxList.add(checkBox5);
        checkBoxList.add(checkBox6);
        checkBoxList.add(checkBox7);
        checkBoxList.add(checkBox8);
        checkBoxList.add(checkBox9);
        checkBoxList.add(checkBox10);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        etm = (EditText) findViewById(R.id.editTextTextMultiLine);
    }

    public void submit(View view) {
        // 获取两个spinner中选定的文字
        String provice = sp1.getSelectedItem().toString();
        String city = sp2.getSelectedItem().toString();

        String APPs="",function;

        StringBuilder sb = new StringBuilder(APPs);
        for(CheckBox checkbox : checkBoxList) {
            if(checkbox.isChecked()) {
                sb.append(checkbox.getText().toString() + ",");
            }
        }
        APPs = sb.toString();

        function = etm.getText().toString();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("调查问卷");
        builder.setMessage("你提交的信息如下：\n" +
                "所在省市：" + provice + "," + city + "\n" +
                "使用最长的手机系统：" + system + "\n" +
                "最常用的APP：" + APPs + "\n" +
                "对Android整体性能的打分：" + ratingpoint + "/" + totalpoint + "\n" +
                "您希望设计的APP的功能：" + function
                );

        builder.setPositiveButton("ok",null);
        builder.show();
    }
}