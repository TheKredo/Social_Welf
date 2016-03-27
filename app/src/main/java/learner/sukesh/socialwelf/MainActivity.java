package learner.sukesh.socialwelf;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import learner.sukesh.socialwelf.activeLists.ActiveListAdapter;
import learner.sukesh.socialwelf.model.Pojo;
import learner.sukesh.socialwelf.utils.Constants;

public class MainActivity extends AppCompatActivity {
private Firebase mref;
    public TextView mTextViewTitle,mTextViewUser;
ActiveListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        ListView IssueView = (ListView) findViewById(R.id.listView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mref=new Firebase(Constants.FIREBASE_URL).child("Welfare");

        mTextViewTitle= (TextView) findViewById(R.id.text_view_list_name);
        mTextViewUser= (TextView) findViewById(R.id.text_view_created_by_user);


       //for FireBase UI LIST VIEW
        mAdapter = new ActiveListAdapter(this, Pojo.class,R.layout.content_main, mref);
        IssueView.setAdapter(mAdapter);



        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Pojo pojoList = dataSnapshot.getValue(Pojo.class);
                mTextViewTitle.setText(pojoList.getTitle());
                mTextViewUser.setText(pojoList.getOwner());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        //mref=new Firebase(Constants.FIREBASE_URL).child("welfare");
    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

            Intent intent=new Intent("learner.sukesh.socialwelf.issueDis.AddIssue");
            startActivity(intent);
        }
    });
}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.cleanup();
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
