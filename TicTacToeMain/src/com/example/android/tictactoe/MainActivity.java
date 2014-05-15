/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.android.tictactoe.library.GameActivity;
import com.example.android.tictactoe.library.GameView.State;
import com.example.android.tictactoe.library.ScoresProvider;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.start_player).setOnClickListener(
                new OnClickListener() {
            public void onClick(View v) {
                startGame(true);
            }
        });

        findViewById(R.id.start_comp).setOnClickListener(
                new OnClickListener() {
            public void onClick(View v) {
                startGame(false);
            }
        });

        // Quick hack: dump all scores to the log
        dumpScores();
    }

    private void startGame(boolean startWithHuman) {
        Intent i = new Intent(this, GameActivity.class);
        i.putExtra(GameActivity.EXTRA_START_PLAYER,
                startWithHuman ? State.PLAYER1.getValue() : State.PLAYER2.getValue());
        startActivity(i);
    }

    // Dump all scores to the log
    public void dumpScores() {
    	String URL = "content://com.example.android.tictactoe.Scores";
    	Uri scores = Uri.parse(URL);
    	Cursor c = getContentResolver().query(scores, null, null, null, "name");
    	String scoreLine;

    	if (!c.moveToFirst()) {
    		Log.d("MainActivity", "No scores present!!");
    	}
    	else {
    		do {
    			scoreLine = c.getString(c.getColumnIndex(ScoresProvider.NAME));
    			scoreLine += ": " + c.getString(c.getColumnIndex(ScoresProvider.SCORE));
    			Log.d("MainActivity", scoreLine);
    		} while (c.moveToNext());
    	}
    }
}