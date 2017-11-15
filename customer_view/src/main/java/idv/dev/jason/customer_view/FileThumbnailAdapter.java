package idv.dev.jason.customer_view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.net.URLConnection;
import java.util.List;

/**
 * Created by jason on 2017/7/3.
 */

public class FileThumbnailAdapter extends RecyclerView.Adapter<FileThumbnailAdapter.ViewHolder> {

    private OnFileThumbnailAdapterListener listener;

    private Context context;
    private List<String> paths;


    public FileThumbnailAdapter(Context context, List<String> paths) {
        this.context = context;
        this.paths = paths;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_file_thumbnail, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String path = paths.get(position);
        String type = URLConnection.guessContentTypeFromName(path);
        if (type.startsWith("image") || type.startsWith("video"))
            Glide.with(context).load(path).into(holder.iv);
        else
            Glide.with(context).load(null).into(holder.iv);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != listener)
                    listener.onFileThumbnailItemClick(view, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return null != paths ? paths.size() : 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv;


        public ViewHolder(View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.iv);
        }
    }


    public void setOnFileThumbnailAdapterListener(OnFileThumbnailAdapterListener listener) {
        this.listener = listener;
    }

}
