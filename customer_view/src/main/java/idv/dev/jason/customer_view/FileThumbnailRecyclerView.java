package idv.dev.jason.customer_view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jason on 2017/11/15.
 */

public class FileThumbnailRecyclerView extends RecyclerView
                                       implements OnFileThumbnailAdapterListener {

    private OnFileThumbnailRecyclerViewListener listener;

    private List<String> paths;
    private FileThumbnailAdapter adapter;


    public FileThumbnailRecyclerView(Context context) {
        super(context);

        init(context);
    }

    public FileThumbnailRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public FileThumbnailRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        init(context);
    }


    @Override
    public void onFileThumbnailItemClick(View view, int position) {
        if (null != listener)
            listener.onFileThumbnailItemClick(position);
    }


    public void setOnFileThumbnailRecyclerViewListener(OnFileThumbnailRecyclerViewListener listener) {
        this.listener = listener;
    }


    public void add(String url) {
        int oldSize = paths.size();
        paths.add(url);
        adapter.notifyItemRangeInserted(oldSize, 1);
    }

    public void clear() {
        int oldSize = paths.size();
        paths.clear();
        adapter.notifyItemRangeRemoved(0, oldSize);
    }


    private void init(Context context) {
        paths = new ArrayList<>();
        adapter = new FileThumbnailAdapter(context, paths);
        adapter.setOnFileThumbnailAdapterListener(this);

        setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        setLayoutManager(linearLayoutManager);
    }

}
