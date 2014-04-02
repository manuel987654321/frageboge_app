package com.example.fragebogen_test;

import java.util.List;

import com.example.fragebogen_test.R;
import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

public class FragenAdapter extends ArrayAdapter<Frage> {
	private int resource;
	private List<Frage> fragen;
	private Context context;

	public FragenAdapter(Context context, int resource, List<Frage> objects) {
		super(context, resource, objects);
		this.context = context;
		this.resource = resource;
		this.fragen = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final FrageHolder holder;
		LayoutInflater inflater = ((Activity) context).getLayoutInflater();
		if (null == convertView) {
			convertView = inflater.inflate(resource, null);
			holder = new FrageHolder();
			holder.frage = (TextView) convertView
					.findViewById(R.id.fragebogen_list_item_frage);
			holder.input = (EditText) convertView
					.findViewById(R.id.fragebogen_list_item_antwort);
			convertView.setTag(holder);
		} else {
			holder = (FrageHolder) convertView.getTag();
		}
		final Frage f = fragen.get(position);
		holder.frage.setText(f.getFrage());
		holder.input.setHint(f.getHint());
		holder.input.addTextChangedListener(new TextWatcher() {

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				String antwort = f.setAntwort(holder.input.getText()
						.toString());
			}

		});
		return convertView;
	}

	private class FrageHolder {
		public TextView frage;
		public EditText input;
	}

}
