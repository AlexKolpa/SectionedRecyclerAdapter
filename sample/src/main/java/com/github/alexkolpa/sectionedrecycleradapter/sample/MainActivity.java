package com.github.alexkolpa.sectionedrecycleradapter.sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import com.github.alexkolpa.sectionedrecycleradapter.lib.Section;


public class MainActivity extends AppCompatActivity {

	private static final int SECTIONS = 10;
	private static final int ROWS_PER_SECTION = 5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.sectioned_list);

		SampleAdapter adapter = new SampleAdapter(generateSections());

		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setAdapter(adapter);
	}

	public Collection<SampleSection> generateSections() {
		List<SampleSection> sectionList = new ArrayList<>(SECTIONS);
		for(int i = 0; i < SECTIONS; i++) {

			List<Row> rows = new ArrayList<>(ROWS_PER_SECTION);
			for(int j = 0; j < ROWS_PER_SECTION; j++) {
				rows.add(new Row("Row " + j));
			}

			sectionList.add(new SampleSection("Section " + i, rows));
		}

		return sectionList;
	}
}
