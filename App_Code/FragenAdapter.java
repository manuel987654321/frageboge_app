package com.example.fragebogen_test;

import java.util.List;

import android.app.Activity;
import android.content.Context;
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

	public View getView(int position, View convertView, ViewGroup parent) {
		FrageHolder holder;
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
		Frage f = fragen.get(position);
		holder.frage.setText(f.getFrage());
		holder.input.setHint(f.getHint());
		return convertView;
	}

	private class FrageHolder {
		public TextView frage;
		public EditText input;
	}

}
