package eg.fragmentorientedapp.BackStackHandling;

import eg.fragmentorientedapp.R;
import eg.fragmentorientedapp.base.BaseFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FirstStepFragment extends BaseFragment {
	public static final String TAG = "First Step Fragment";
	
	@Override
	public String getTagText() {
		return TAG;
	}

	@Override
	public boolean onBackPressed() {
		hostActivityInterface.popBackStack();
		return true;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.first_step_fragment, null);
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		// Go to step 2 Button
		((Button) view.findViewById(R.id.first_step_fragment_go_to_2)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				hostActivityInterface.addFragment(new SecondStepFragment(), true);
			}
		});
		
		// Go back one step Button
		((Button) view.findViewById(R.id.first_step_fragment_go_back_1)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Call popBackStack to move back one step
				hostActivityInterface.popBackStack();
			}
		});
	}
}