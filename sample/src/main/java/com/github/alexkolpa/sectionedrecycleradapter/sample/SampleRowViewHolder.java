package com.github.alexkolpa.sectionedrecycleradapter.sample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class SampleRowViewHolder extends RecyclerView.ViewHolder {

	public final TextView text;

	public SampleRowViewHolder(View itemView) {
		super(itemView);

		text = (TextView) itemView.findViewById(R.id.row_text);
	}
}
