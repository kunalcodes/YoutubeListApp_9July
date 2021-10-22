package com.example.youtube_list_app;



public interface ItemClickListener {

    /*this method is called from the view holder when item is clicked
    and implemented in the activity
     */
    void onItemClicked(int position, String s);

}
