package chou.aric.com.mydao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import chou.aric.com.mydao.dbutils.DBHelper;
import chou.aric.com.mydao.dbutils.Father;
import chou.aric.com.mydao.dbutils.Son;

public class FlashActivity extends AppCompatActivity {
    private static final String TAG = "FlashActivity";

    EditText father_edit_age;
    EditText father_edit_name;
    EditText Son_edit_age;
    EditText Son_edit_name;
    TextView db_father_content;
    TextView db_son_content;
    EditText query_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        initView();
    }

    private void initView() {
        father_edit_age = (EditText) findViewById(R.id.father_edit_age);
        father_edit_name = (EditText) findViewById(R.id.father_edit_name);
        Son_edit_age = (EditText) findViewById(R.id.Son_edit_age);
        Son_edit_name = (EditText) findViewById(R.id.Son_edit_name);
        db_father_content = (TextView) findViewById(R.id.db_father_content);
        db_son_content = (TextView) findViewById(R.id.db_son_content);
        query_input = (EditText) findViewById(R.id.query_input);
        showDbContent();
    }

    private void showDbContent() {
        List<Father> fathers = DBHelper.queryAllFather();
        db_father_content.setText(fathers.toString());
        List<Son> sons = DBHelper.queryAllSon();
        db_son_content.setText(sons.toString());
    }


    public void query(View view){
        Son son = DBHelper.querySonByName(query_input.getText().toString());
        Toast.makeText(this, son.toString(), Toast.LENGTH_SHORT).show();
    }

    public void addData(View view) {

        Father father = new Father();
        father.setAge(Integer.valueOf(father_edit_age.getText().toString()));
        father.setName(father_edit_name.getText().toString());

        Son son = new Son();
        son.setAge(Integer.valueOf(Son_edit_age.getText().toString().replace(" ","")));
        son.setName(Son_edit_name.getText().toString());
        father_edit_age.setText("");
        father_edit_name.setText("");
        Son_edit_age.setText("");
        Son_edit_name.setText("");
        DBHelper.addPerson(father, son);
        showDbContent();


    }
}
