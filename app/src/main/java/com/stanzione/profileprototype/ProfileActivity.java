package com.stanzione.profileprototype;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    private RecyclerView friendsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("My Profile");
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);

        //disappearing the title when expanded
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);

        friendsRecyclerView = (RecyclerView) findViewById(R.id.friendsRecyclerView);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        createFriends();

    }

    private void createFriends(){

        ArrayList<Friend> friendArrayList = new ArrayList<Friend>();
        friendArrayList.add(new Friend("Bryan Thorne", 10, 8, 2, Friend.FriendStatus.STATUS_OFFLINE, true));
        friendArrayList.add(new Friend("Bernardo Richardson", 32, 11, 21, Friend.FriendStatus.STATUS_ONLINE, false));
        friendArrayList.add(new Friend("Lesley Hardy", 115, 72, 43, Friend.FriendStatus.STATUS_ONLINE, true));
        friendArrayList.add(new Friend("Kevin Rivera", 7, 7, 0, Friend.FriendStatus.STATUS_OFFLINE, true));
        friendArrayList.add(new Friend("Michelle Scott", 12, 7, 5, Friend.FriendStatus.STATUS_OFFLINE, false));

        friendsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        FriendRecyclerAdapter friendRecyclerAdapter = new FriendRecyclerAdapter(ProfileActivity.this, friendArrayList);

        friendsRecyclerView.setAdapter(friendRecyclerAdapter);
        friendsRecyclerView.addItemDecoration(new FriendDecorationColumns(20));

    }

}
