package learner.sukesh.socialwelf.activeLists;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;

import learner.sukesh.socialwelf.R;
import learner.sukesh.socialwelf.model.Pojo;

/**
 * Created by Sukesh on 27-03-2016.
 */
public class ActiveListAdapter extends FirebaseListAdapter<Pojo> {
    public ActiveListAdapter(Activity activity, Class<Pojo> modelClass, int modelLayout, Firebase ref) {
        super(activity, modelClass, modelLayout, ref);
        this.mActivity=activity;
    }


    @Override
    protected void populateView(View view, Pojo list) {
        TextView textViewListName = (TextView) view.findViewById(R.id.text_view_list_name);
        TextView textViewCreatedByUser = (TextView) view.findViewById(R.id.text_view_created_by_user);

        /* Set the list name and owner */
        textViewListName.setText(list.getTitle());
        textViewCreatedByUser.setText(list.getOwner());
    }
}

