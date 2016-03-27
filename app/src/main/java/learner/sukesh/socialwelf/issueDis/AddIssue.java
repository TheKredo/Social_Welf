package learner.sukesh.socialwelf.issueDis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

import learner.sukesh.socialwelf.R;
import learner.sukesh.socialwelf.model.Pojo;
import learner.sukesh.socialwelf.utils.Constants;

public class AddIssue extends AppCompatActivity {
    Firebase mrefAdd;
    Button mButtonAdd;
    //MainActivity obj;
   // public TextView mTextViewTitle,mTextViewUser;
    EditText mEditTextTitle, mEditTextDisc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_issue);
        Firebase.setAndroidContext(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mButtonAdd= (Button) findViewById(R.id.buttonAdd);
        mEditTextTitle= (EditText) findViewById(R.id.editText);
        mEditTextDisc= (EditText) findViewById(R.id.editText2);

        mrefAdd=new Firebase(Constants.FIREBASE_URL).child("Welfare");


        //what happens when Button for submit is clicked
        mButtonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                addIssueList();
            }
        });

       /* mrefAdd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Pojo pojoList = dataSnapshot.getValue(Pojo.class);
                mTextViewTitle.setText(pojoList.getTitle());
                mTextViewUser.setText(pojoList.getDisc());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });*/
       /* mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = Toast.makeText(AddIssue.this, "addIssue button clicked", Toast.LENGTH_SHORT);
                toast.show();
            }
        });*/


    }

    public void addIssueList() //throws IOException
    {
        String title=mEditTextTitle.getText().toString();
        String disc=mEditTextDisc.getText().toString();

        Pojo pojoList=new Pojo(title,disc,"chuchu");
        Log.d("sukesh","before push()");
        mrefAdd.push().setValue(pojoList);
        Log.d("AddIssue.java", "after push()");

    }
}
