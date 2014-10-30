package eg.fragmentorientedapp.BackStackHandling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.Session;

import eg.fragmentorientedapp.R;
import eg.fragmentorientedapp.base.BaseFragment;
import eg.fragmentorientedapp.utils.FacebookUtils;

public class ThirdStepFragment extends BaseFragment {
	public static final String TAG = "Third Step Fragment";
	
	private RelativeLayout facebookButton;
	private ImageView facebookImage;
	private TextView facebookText;
	
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
		return inflater.inflate(R.layout.third_step_fragment, null);
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		initUI();
		setListeners();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		Session facebookSession = Session.getActiveSession();
		if(facebookSession.isOpened()) {
			facebookImage.setBackgroundResource(R.drawable.facebook_active_states);
			facebookButton.setBackgroundColor(getResources().getColor(R.color.light_blue));
			facebookText.setTextColor(getResources().getColor(android.R.color.white));
		} else {
			facebookImage.setBackgroundResource(R.drawable.facebook_inactive_states);
			facebookButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
			facebookText.setTextColor(getResources().getColor(R.color.text_gray));
		}
	}
	
	private void initUI() {
		facebookButton = (RelativeLayout) getView().findViewById(R.id.third_step_fragment_facebook_button);
		facebookImage = (ImageView) getView().findViewById(R.id.third_step_fragment_facebook_button_image);
		facebookText = (TextView) getView().findViewById(R.id.third_step_fragment_facebook_text);
	}
	
	private void setListeners() {
		facebookButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Session facebookSession = Session.getActiveSession();
				if(facebookSession.isOpened()) {
					FacebookUtils.postOnWall(getActivity(), "From Single Activity Fragment", "I reached to the top of the world!", "www.google.com");
				} else {
					facebookInterface.onClickLogin();
				}
			}
		});
		
		// Go back 1 step Button
		((Button) getView().findViewById(R.id.third_step_fragment_go_back_1)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Call popBackStack to move back one step
				hostActivityInterface.popBackStack();
			}
		});

		// Go back 2 steps Button
		((Button) getView().findViewById(R.id.third_step_fragment_go_back_2)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Call popBackStackTillTag to move back multiple steps
				hostActivityInterface.popBackStackTillTag(SecondStepFragment.TAG);
			}
		});

		// Go back 3 steps Button
		((Button) getView().findViewById(R.id.third_step_fragment_go_back_3)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Call popBackStackTillTag to move back multiple steps
				hostActivityInterface.popBackStackTillTag(FirstStepFragment.TAG);
			}
		});
	}
}
