package com.zzy.question.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zzy.common.constants.ScmConstants;
import com.zzy.common.constants.SpConstants;
import com.zzy.common.utils.TimeUtils;
import com.zzy.commonlib.base.BaseActivity;
import com.zzy.commonlib.log.MyLog;
import com.zzy.core.serverCenter.SCM;
import com.zzy.core.serverCenter.ScCallback;
import com.zzy.flysp.core.spHelper.SPHelper;
import com.zzy.question.R;


public class QuestionBankActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "QuestionBankActivity";
    private Button btnOk;
    private int selectedBank = 1;
    private LinearLayout llCar1,llCar2,llCar3,llCar4;
    private ImageView ivCar1,ivCar2,ivCar3,ivCar4;
    private TextView tvYear;
/*******************************************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_bank);
        setupViews();

    }

    private void setupViews() {
        btnOk = findViewById(R.id.btnOk);
        llCar1 = findViewById(R.id.llCar1);
        llCar2 = findViewById(R.id.llCar2);
        llCar3 = findViewById(R.id.llCar3);
        llCar4 = findViewById(R.id.llCar4);
        ivCar1 = findViewById(R.id.ivCar1);
        ivCar2 = findViewById(R.id.ivCar2);
        ivCar3 = findViewById(R.id.ivCar3);
        ivCar4 = findViewById(R.id.ivCar4);
        tvYear = findViewById(R.id.tvYear);

        btnOk.setOnClickListener(this);
        llCar1.setOnClickListener(this);
        llCar2.setOnClickListener(this);
        llCar3.setOnClickListener(this);
        llCar4.setOnClickListener(this);

        tvYear.setText("已更新至"+ TimeUtils.getCurrentYear() +"年官方题库");
    }

    private void entryMain() {
        try {
            SCM.getInstance().req(this, ScmConstants.API_ENTRY_HOME,new ScCallback() {
                @Override
                public void onCallback(boolean b, Bundle data, String tag) {
                    if(b){
                        finish();
                    }else {
                        MyLog.e(TAG,"return:"+data);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnOk){
            entryMain();
            SPHelper.save(SpConstants.QUESTION_BANK,selectedBank);
        }else if(v.getId() == R.id.llCar1){
            clearAll();
            ivCar1.setImageResource(R.mipmap.question_car1_selected);
            selectedBank = 1;
        }else if(v.getId() == R.id.llCar2){
            clearAll();
            ivCar2.setImageResource(R.mipmap.question_car2_selected);
            selectedBank = 2;
        }else if(v.getId() == R.id.llCar3){
            clearAll();
            ivCar3.setImageResource(R.mipmap.question_car3_selected);
            selectedBank = 3;
        }else if(v.getId() == R.id.llCar4){
            clearAll();
            ivCar4.setImageResource(R.mipmap.question_car4_selected);
            selectedBank = 4;
        }
    }

    private void clearAll() {
        ivCar1.setImageResource(R.mipmap.question_car1_normal);
        ivCar2.setImageResource(R.mipmap.question_car2_normal);
        ivCar3.setImageResource(R.mipmap.question_car3_normal);
        ivCar4.setImageResource(R.mipmap.question_car4_normal);
    }
}
