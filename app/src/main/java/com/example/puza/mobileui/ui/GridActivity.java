package com.example.puza.mobileui.ui;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import com.example.puza.mobileui.R;
import com.example.puza.mobileui.adapter.AlbumsAdapter;
import com.example.puza.mobileui.models.Album;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AlbumsAdapter albumsAdapter;
    private List<Album> albumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();
        albumsAdapter = new AlbumsAdapter(this, albumList);

        RecyclerView.LayoutManager nLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(nLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(albumsAdapter);

        prepareAlbums();
    }

    private void prepareAlbums(){
        int[] covers = new int[]{
                R.drawable.a1,
                R.drawable.a2,
                R.drawable.a3,
                R.drawable.a4,
                R.drawable.a5,
                R.drawable.a6,
                R.drawable.a7,
                R.drawable.a8,
                R.drawable.a9,
                R.drawable.a10
        };
        Album a =new Album("Pashmina", 13, covers[0]);
        albumList.add(a);

        a =new Album("T-Shirt", 8, covers[1]);
        albumList.add(a);
        a =new Album("Pant", 13, covers[2]);
        albumList.add(a);
        a =new Album("Bag", 12, covers[3]);
        albumList.add(a);
        a =new Album("Furniture", 14, covers[4]);
        albumList.add(a);
        a =new Album("Antique", 1, covers[5]);
        albumList.add(a);
        a =new Album("Agriculture", 11, covers[6]);
        albumList.add(a);
        a =new Album("Gems", 14, covers[7]);
        albumList.add(a);
        a =new Album("Pushmina", 11, covers[8]);
        albumList.add(a);
        a =new Album("Dolls", 17, covers[9]);
        albumList.add(a);

        albumsAdapter.notifyDataSetChanged();
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration{

        private int spanCount;
        private int spacing;
        private boolean inclidEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean inclidEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.inclidEdge = inclidEdge;
        }

        public void getItemOffsets(Rect outrect, View view, RecyclerView parent, RecyclerView.State state){
            int position = parent.getChildAdapterPosition(view); //item position
            int column = position % spanCount; //item columns

            if (inclidEdge){
                outrect.left = spacing - column * spacing / spanCount;
                outrect.right = (column + 1) * spacing / spanCount;

                if (position < spanCount){
                    outrect.top = spacing;
                }
                outrect.bottom = spacing;
            }else {
                outrect.left = column * spacing / spanCount;
                outrect.right = spacing - (column + 1) * spacing / spanCount;
                if(position>=spanCount){
                    outrect.top = spacing;
                }
            }
        }
    }

    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
