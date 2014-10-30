package eg.fragmentorientedapp.BackStackHandling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import eg.fragmentorientedapp.R;
import eg.fragmentorientedapp.base.BaseFragment;
import eg.fragmentorientedapp.base.DrawerItemBaseFragment;

public class BackStackHandlerFragment extends DrawerItemBaseFragment {
	private static final String TAG = "Back Stack Handler Fragment";
	
	@Override
	public String getTagText() {
		return TAG;
	}

	@Override
	public boolean onBackPressed() {
		return false;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.step_fragment, null);
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		// Go to First Step Button
		((Button) view.findViewById(R.id.step_fragment_go_to_1)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				hostActivityInterface.addFragment(new FirstStepFragment(), true);
			}
		});
		
		// Add Multiple Fragments Button
		((Button) view.findViewById(R.id.step_fragment_go_to_2)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				BaseFragment[] secondTierFragments = new BaseFragment[2];
				secondTierFragments[0] = new FirstStepFragment();
				secondTierFragments[1] = new SecondStepFragment();
				hostActivityInterface.addMultipleFragments(secondTierFragments);
			}
		});
	}
}
