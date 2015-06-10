package com.github.alexkolpa.sectionedrecycleradapter.sample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class SampleSectionViewHolder extends RecyclerView.ViewHolder {

	public final TextView text;

	public SampleSectionViewHolder(View itemView) {
		super(itemView);

		text = (TextView) itemView.findViewById(R.id.header_text);
	}
}
