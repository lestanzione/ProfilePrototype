package com.stanzione.profileprototype;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.like.IconType;
import com.like.LikeButton;

import java.util.ArrayList;

/**
 * Created by lstanzione on 2/15/2016.
 */
public class FriendRecyclerAdapter extends RecyclerView.Adapter<FriendRecyclerAdapter.ViewHolder>{

    private ArrayList<Friend> friendArrayList;
    private Context context;

    public FriendRecyclerAdapter(Context context, ArrayList<Friend> friendArrayList) {
        this.friendArrayList = friendArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_cell, null);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final Friend friend = friendArrayList.get(position);
        Drawable friendStatusDrawable;

        switch(friend.getStatus()){
            case STATUS_OFFLINE:
                friendStatusDrawable = ContextCompat.getDrawable(context, android.R.drawable.presence_offline);
                break;
            case STATUS_ONLINE:
                friendStatusDrawable = ContextCompat.getDrawable(context, android.R.drawable.presence_online);
                break;
            default:
                friendStatusDrawable = ContextCompat.getDrawable(context, android.R.drawable.presence_offline);
                break;
        }

        holder.friendStatusImageView.setImageDrawable(friendStatusDrawable);
        holder.friendUsernameTextView.setText(friend.getName());
        holder.friendGameStatusTextView.setText(friend.getGamesStatus());

        holder.friendFavoriteButton.setIcon(IconType.Star);
        holder.friendFavoriteButton.setLiked(friend.isFavorite());

    }

    @Override
    public int getItemCount() {
        return (null != friendArrayList ? friendArrayList.size() : 0);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CardView friendCardView;
        public ImageView friendPhotoImageView;
        public ImageView friendStatusImageView;
        public TextView friendUsernameTextView;
        public TextView friendGameStatusTextView;
        public LikeButton friendFavoriteButton;

        public ViewHolder(View itemView) {
            super(itemView);
            this.friendCardView = (CardView) itemView.findViewById(R.id.friendCardView);
            this.friendPhotoImageView = (ImageView) itemView.findViewById(R.id.friendPhotoImageView);
            this.friendStatusImageView = (ImageView) itemView.findViewById(R.id.friendStatusImageView);
            this.friendUsernameTextView = (TextView) itemView.findViewById(R.id.friendUsernameTextView);
            this.friendGameStatusTextView = (TextView) itemView.findViewById(R.id.friendGameStatusTextView);
            this.friendFavoriteButton = (LikeButton) itemView.findViewById(R.id.friendFavoriteButton);
        }
    }

}