package com.example.hello;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hello.util.ToastUtil;

public class DialogActivity extends AppCompatActivity {
    private Button mBtnD1,mBtnD2,mBtnD3,mBtnD4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mBtnD1 = findViewById(R.id.btn_dialog1);
        mBtnD2 = findViewById(R.id.btn_dialog2);
        mBtnD3 = findViewById(R.id.btn_dialog3);
        mBtnD4 = findViewById(R.id.btn_dialog4);
        OnClick onClick = new OnClick();
        mBtnD1.setOnClickListener(onClick);
        mBtnD2.setOnClickListener(onClick);
        mBtnD3.setOnClickListener(onClick);
        mBtnD4.setOnClickListener(onClick);
    }

   private class  OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("请回答").setMessage("你觉得如何？")
                            .setIcon(R.drawable.icon_user_48)
                            .setPositiveButton("棒", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(DialogActivity.this,"你很诚实",Toast.LENGTH_LONG).show();
                                }
                            }).setNeutralButton("还行", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(DialogActivity.this,"你再瞅瞅",Toast.LENGTH_LONG).show();
                        }
                    }).setNegativeButton("不好", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(DialogActivity.this,"净说瞎话",Toast.LENGTH_LONG).show();
                        }
                    }).show();
                    break;
                case R.id.btn_dialog2:
                    final String[] array =new String[]{"男","女"};
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(DialogActivity.this);
                    builder1.setTitle("请选择性别").setItems(array, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(DialogActivity.this,array[which],Toast.LENGTH_LONG).show();
                        }
                    }).show();
                    break;
                case R.id.btn_dialog3:
                    final String[] array3 =new String[]{"男","女"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("选择性别")
                            .setSingleChoiceItems(array3, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(DialogActivity.this,array3[which],Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.btn_dialog4:
                    final String[] array4 =new String[]{"唱歌","跳舞","写代码"};
                    boolean[] isSelected = new boolean[]{false,false,true};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("选择兴趣").setMultiChoiceItems(array4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtil.showMsg(DialogActivity.this,array4[which]+':'+isChecked);
                        }
                    }).setPositiveButton("确定", null)
                            .setNegativeButton("取消",null)
                            .show();
                    break;
            }
        }
    }

}
