package com.paad.todolist;

import java.util.ArrayList;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ToDoListActivity extends FragmentActivity implements
		NewItemFragment.OnNewItemAddedListener {

	private ArrayAdapter<String> aa;
	private ArrayList<String> todoItems;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Inflate your View
		setContentView(R.layout.main);

		// Get references to the Fragments
		android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
		ToDoListFragment todoListFragment = (ToDoListFragment) fm
				.findFragmentById(R.id.TodoListFragment);

		// Create the array list of to do items
		todoItems = new ArrayList<String>();

	    // Create the array adapter to bind the array to the ListView
	    int resID = R.layout.todolist_item;
	    aa = new ArrayAdapter<String>(this, resID, todoItems);

		// Bind the array adapter to the listview.
		todoListFragment.setListAdapter(aa);

	}

	public void onNewItemAdded(String newItem) {
		todoItems.add(newItem);
		aa.notifyDataSetChanged();
	}

}