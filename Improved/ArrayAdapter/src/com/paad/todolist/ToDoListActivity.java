package com.paad.todolist;

import java.util.ArrayList;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

public class ToDoListActivity extends FragmentActivity implements
		NewItemFragment.OnNewItemAddedListener {

	private ToDoItemAdapter aa;
	private ArrayList<ToDoItem> todoItems;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Inflate your View
		setContentView(R.layout.main);

		// Get references to the Fragments
		android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
		ToDoListFragment todoListFragment = (ToDoListFragment) fm
				.findFragmentById(R.id.TodoListFragment);

		// Create the array list of to do items
		todoItems = new ArrayList<ToDoItem>();

	    // Create the array adapter to bind the array to the ListView
	    int resID = R.layout.todolist_item;
	    aa = new ToDoItemAdapter(this, resID, todoItems);

		// Bind the array adapter to the listview.
		todoListFragment.setListAdapter(aa);

	}

	public void onNewItemAdded(String newItem) {
		ToDoItem newTodoItem = new ToDoItem(newItem);
		todoItems.add(0, newTodoItem);
		aa.notifyDataSetChanged();
	}

}