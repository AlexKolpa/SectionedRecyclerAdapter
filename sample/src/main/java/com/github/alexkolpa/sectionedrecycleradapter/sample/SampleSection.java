package com.github.alexkolpa.sectionedrecycleradapter.sample;

import java.util.Collection;
import java.util.List;

import android.support.annotation.NonNull;
import com.github.alexkolpa.sectionedrecycleradapter.lib.Section;

public class SampleSection implements Section<Row> {

	private final String title;
	private final List<Row> rows;

	public SampleSection(String title, List<Row> rows) {
		this.title = title;
		this.rows = rows;
	}

	public String getTitle() {
		return title;
	}

	@NonNull
	@Override
	public Collection<Row> getContent() {
		return rows;
	}
}
