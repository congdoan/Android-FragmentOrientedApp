package eg.fragmentorientedapp.BackStackHandling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

import eg.fragmentorientedapp.R;
import eg.fragmentorientedapp.base.BaseFragment;

public class SecondStepFragment extends BaseFragment {
	public static final String TAG = "Second Step Fragment";
	
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
		return inflater.inflate(R.layout.second_step_fragment, null);
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		// Go to step 3 Button
		((Button) view.findViewById(R.id.second_step_fragment_go_to_3)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				hostActivityInterface.addFragment(new ThirdStepFragment(), true);
			}
		});
		
		// Go back 1 step Button
		((Button) view.findViewById(R.id.second_step_fragment_go_back_1)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Call popBackStack to move back one step
				hostActivityInterface.popBackStack();
			}
		});
		
		// Go back 2 steps Button
		((Button) view.findViewById(R.id.second_step_fragment_go_back_2)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Call popBackStackTillTag to move back multiple steps
				hostActivityInterface.popBackStackTillTag(FirstStepFragment.TAG);
			}
		});
	}
}
