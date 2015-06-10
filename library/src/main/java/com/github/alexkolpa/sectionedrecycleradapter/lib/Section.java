package com.github.alexkolpa.sectionedrecycleradapter.lib;

import java.util.Collection;

import android.support.annotation.NonNull;

public interface Section<T> {
	@NonNull Collection<T> getContent();
}
