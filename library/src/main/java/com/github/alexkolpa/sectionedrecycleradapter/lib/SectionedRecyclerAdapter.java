package com.github.alexkolpa.sectionedrecycleradapter.lib;

import java.util.Collection;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.ViewGroup;

/**
 * The SectionedRecyclerAdapter provides a {@link RecyclerView.Adapter} implementation which handles data which
 * consists of two types, specifically sectioned data, separated by headers. The data model is provided as a collection
 * of {@link Section} objects, which in turn should provide the inner contents for each section. For both layouts a
 * view holder extending {@link RecyclerView.ViewHolder} has to be provided.
 * @param <S> The class of the section containing the rows
 * @param <T> The class of the rows
 * @param <SV> The ViewHolder for the section headers
 * @param <RV> The ViewHolder for the rows
 */
public abstract class SectionedRecyclerAdapter<S extends Section<T>, T, SV extends RecyclerView.ViewHolder,
		RV extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<ViewHolder> {

	private final SparseArray<S> sections = new SparseArray<>();
	private final SparseArray<T> rows = new SparseArray<>();

	public SectionedRecyclerAdapter() {
	}

	public SectionedRecyclerAdapter(Collection<S> initialCollection) {
		addAll(initialCollection);
	}

	@Override
	public int getItemViewType(int position) {
		return rows.get(position) == null ? 0 : 1;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		switch (viewType) {
			case 0:
				return onCreateSectionViewHolder(parent);
			case 1:
				return onCreateRowViewHolder(parent);
			default:
				throw new IllegalArgumentException("No view type with id " + viewType);
		}
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		if (getItemViewType(position) == 1) {
			T row = rows.get(position);
			onBindRowViewHolder((RV) holder, row);
		}
		else {
			S section = sections.get(position);
			onBindSectionViewHolder((SV) holder, section);
		}
	}

	protected abstract
	@NonNull
	SV onCreateSectionViewHolder(ViewGroup parent);

	protected abstract
	@NonNull
	RV onCreateRowViewHolder(ViewGroup parent);

	protected abstract void onBindSectionViewHolder(SV holder, S section);

	protected abstract void onBindRowViewHolder(RV holder, T row);

	@Override
	public int getItemCount() {
		return rows.size() + sections.size();
	}

	public void add(S newSection) {
		int lastPosition = getLastPosition();

		sections.append(++lastPosition, newSection);

		for (T row : newSection.getContent()) {
			rows.append(++lastPosition, row);
		}

		notifyDataSetChanged();
	}

	public void addAll(Collection<S> newSections) {
		int lastPosition = getLastPosition();

		for (S section : newSections) {
			sections.append(++lastPosition, section);

			for (T row : section.getContent()) {
				rows.append(++lastPosition, row);
			}
		}

		notifyDataSetChanged();
	}

	public void clear() {
		sections.clear();
		rows.clear();
		notifyDataSetChanged();
	}

	/**
	 * Returns the last position in the adapter
	 */
	private int getLastPosition() {
		return Math.max(rows.size() == 0 ? -1 : rows.keyAt(rows.size() - 1),
				sections.size() == 0 ? -1 : sections.keyAt(sections.size() - 1));
	}
}
