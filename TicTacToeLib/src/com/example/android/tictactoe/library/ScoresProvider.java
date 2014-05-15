package com.example.android.tictactoe.library;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

public class ScoresProvider extends ContentProvider {

	// Field names
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String SCORE = "score";

	// Our datastore: a MatrixCursor that holds top scores
	MatrixCursor mScores;
	
	// The columns in our scores table
	String[] mColumns = {ID, NAME, SCORE};
	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreate() {
		// Create a scores table using fixed data
		mScores = new MatrixCursor(mColumns);
		
		// Here's a Q&D way to add two rows of data to the table
		// Schema: id, name, score
		mScores.newRow().add(1).add("Ralphie").add("2200");
		mScores.newRow().add(2).add("Lester").add("1400");
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// We don't need the selection args, we can simply return
		// the score table
		return mScores;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
