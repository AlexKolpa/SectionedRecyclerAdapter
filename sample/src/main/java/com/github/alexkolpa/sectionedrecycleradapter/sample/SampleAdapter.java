package com.github.alexkolpa.sectionedrecycleradapter.sample;

import java.util.Collection;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.github.alexkolpa.sectionedrecycleradapter.lib.SectionedRecyclerAdapter;

public class SampleAdapter extends SectionedRecyclerAdapter<SampleSection, Row, SampleSectionViewHolder,
		SampleRowViewHolder> {

	public SampleAdapter(Collection<SampleSection> initialCollection) {
		super(initialCollection);
	}

	@NonNull
	@Override
	protected SampleSectionViewHolder onCreateSectionViewHolder(ViewGroup parent) {
		return new SampleSectionViewHolder(
				LayoutInflater.from(parent.getContext()).inflate(R.layout.header, parent, false));
	}

	@NonNull
	@Override
	protected SampleRowViewHolder onCreateRowViewHolder(ViewGroup parent) {
		return new SampleRowViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false));
	}

	@Override
	protected void onBindSectionViewHolder(SampleSectionViewHolder holder, SampleSection section) {
		holder.text.setText(section.getTitle());
	}

	@Override
	protected void onBindRowViewHolder(SampleRowViewHolder holder, Row row) {
		holder.text.setText(row.getText());
	}

}
