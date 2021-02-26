package com.example.dcal;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView Display;
    String Equation="";
    List<String> MyHistory = new ArrayList<>();
    int Id=0;
    int H=0;
    int NewH=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Display=findViewById(R.id.screen);
    }
    public void zeroIT(View view){
        Equation=Equation+"0";
        Display.setText(Equation);
    }
    public void oneIT(View view){
        Equation=Equation+"1";
        Display.setText(Equation);
    }
    public void twoIT(View view){
        Equation=Equation+"2";
        Display.setText(Equation);
    }
    public void treeIT(View view){
        Equation=Equation+"3";
        Display.setText(Equation);
    }
    public void fourIT(View view){
        Equation=Equation+"4";
        Display.setText(Equation);
    }
    public void fiveIT(View view){
        Equation=Equation+"5";
        Display.setText(Equation);
    }
    public void sixIT(View view){
        Equation=Equation+"6";
        Display.setText(Equation);
    }
    public void sevenIT(View view){
        Equation=Equation+"7";
        Display.setText(Equation);
    }
    public void eightIT(View view){
        Equation=Equation+"8";
        Display.setText(Equation);
    }
    public void nineIT(View view){
        Equation=Equation+"9";
        Display.setText(Equation);
    }
    public void addIT(View view){
        if (Equation.length()==0){
            Equation=Equation+"0+";
        }
        else{
            String CheckOP=Equation.substring(Equation.length() - 1);
        if(CheckOP.equals("+") || CheckOP.equals("-") ||
                CheckOP.equals("*") || CheckOP.equals(".")||
                CheckOP.equals("/") || CheckOP.equals("%")){
            Equation=Equation+"0+";
        }else{
            Equation=Equation+"+";
        }}
        Display.setText(Equation);
    }
    public void minIT(View view){
        if (Equation.length()==0){
            Equation=Equation+"0-";
        }
        else{String CheckOP=Equation.substring(Equation.length() - 1);

        if(CheckOP.equals("+") || CheckOP.equals("-") ||
                CheckOP.equals("*") || CheckOP.equals(".")||
                CheckOP.equals("/") || CheckOP.equals("%")){
            Equation=Equation+"0-";
        }else{
            Equation=Equation+"-";
        }}
        Display.setText(Equation);

    }
    public void mulIT(View view){
        if (Equation.length()==0){

            Equation=Equation+"0*";
        }
        else{String CheckOP=Equation.substring(Equation.length() - 1);

        if(CheckOP.equals("+") || CheckOP.equals("-") ||
                CheckOP.equals("*") || CheckOP.equals(".")||
                CheckOP.equals("/") || CheckOP.equals("%")){
            Equation=Equation+"0*";
        }
        else{
            Equation=Equation+"*";
        }}
        Display.setText(Equation);
    }
    public void divIT(View view){
        if (Equation.length()==0){
            Equation=Equation+"0/";
        }else{String CheckOP=Equation.substring(Equation.length() - 1);

        if(CheckOP.equals("+") || CheckOP.equals("-") ||
                CheckOP.equals("*") || CheckOP.equals(".")||
                CheckOP.equals("/") || CheckOP.equals("%")){
            Equation=Equation+"0/";
        }
        else{
            Equation=Equation+"/";
        }}
        Display.setText(Equation);
    }
    public void modIT(View view){
        if (Equation.length()==0){
            Equation=Equation+"0%";
        }else{String CheckOP=Equation.substring(Equation.length() - 1);

        if(CheckOP.equals("+") || CheckOP.equals("-") ||
                CheckOP.equals("*") || CheckOP.equals(".")||
                CheckOP.equals("/") || CheckOP.equals("%")){
            Equation=Equation+"0%";
        }
        else{
            Equation=Equation+"%";
        }}
        Display.setText(Equation);
    }
    public void AnsIT(View view){
        InsertNow();
    Expression expression = new ExpressionBuilder(Equation).build();
        try {
        double result = expression.evaluate();
        Equation = (result+"");
        Display.setText(result+"");
//ERROR -- CANNOT FIND
//            AppDatabase.getDatabase(getApplicationContext())
//                    .userDao()
//                    .insertAll(Equation+"",Equation);

    } catch (Exception Error) {
        Equation = ("");
        Display.setText(Error.getMessage());
    }


    }
    public void acIT(View view){
        Display.setText("");
        Equation=("");
    }
    public void delIT(View view){
        Equation = String.valueOf(Display.getText());
        if (Equation != null && Equation.length() > 0 )  {
            String Equation2 = Equation.substring(0, Equation.length() - 1);
            Display.setText(Equation2);
            Equation=Equation2;
        }
    }
    public void dotIT(View view){

        if (Equation.length()==0){

            Equation=Equation+"0.";
        }else{String CheckOP=Equation.substring(Equation.length() - 1);

        if(CheckOP.equals("+") || CheckOP.equals("-") ||
                CheckOP.equals("*") ||
                CheckOP.equals("/") || CheckOP.equals("%")){
            Equation=Equation+"0.";
        }else{
            Equation=Equation+".";
        }
    }Display.setText(Equation);}
    public void hisIT(View view){
                AppDatabase.databaseWriteExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        List<User> Hist=AppDatabase.getDatabase(getApplicationContext())
                                .userDao()
                                .getAll();
                        try {
                            for (int i = 0; i < Hist.size(); i++) {
                                MyHistory.add(Hist.get(i).Recent+"");
                            }
                            int GetVal=Hist.size()-H;
                            if (GetVal<0){
                                H=1;
                                Display.setText(MyHistory.get(Hist.size()-H));
                            }else{
                                Display.setText(MyHistory.get(GetVal));
                            }
                        }catch(Exception Emo){
                            Display.setText("Error"+Emo);
                        }
                        NewH = Hist.size();
                        }
                });H=H+1;
        }
        public void InsertNow(){
                    User random= new User();
                    random.uid=Id;
                   random.Recent=Equation;
                    AppDatabase.databaseWriteExecutor.execute(new Runnable() {
                        @Override
                        public void run() {
                            AppDatabase.getDatabase(getApplicationContext())
                                    .userDao()
                                    .insertAll(random);
                        }
                    });
            Id=Id+1;

    }


}