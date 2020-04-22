package com.zwl.mygallerydemo;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.zwl.mygallerydemo.discretescrollview.DiscreteScrollView;
import com.zwl.mygallerydemo.discretescrollview.transform.ScaleTransformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DiscreteScrollView.OnItemChangedListener<RecyclerView.ViewHolder>, DiscreteScrollView.ScrollStateChangeListener<RecyclerView.ViewHolder> {

    DiscreteScrollView mDiscreteScrollView;
    SeekBar mSeekBar;
    private ListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDiscreteScrollView = findViewById(R.id.list);
        mSeekBar = findViewById(R.id.seekbar);

        mDiscreteScrollView.addOnItemChangedListener(this);
        mDiscreteScrollView.addScrollStateChangeListener(this);
        mDiscreteScrollView.setItemTransitionTimeMillis(110);

//        mDiscreteScrollView.setSlideOnFling(true);//顺滑

        mDiscreteScrollView.setItemTransformer(new ScaleTransformer.Builder()
                .build());


        mListAdapter = new ListAdapter(getList());
        mDiscreteScrollView.setAdapter(mListAdapter);


        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mDiscreteScrollView.setItemTransitionTimeMillis(100 + i * 2);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public List<String> getList() {
        List<String> arr = new ArrayList<>();
        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");
        arr.add("5");
        arr.add("6");
        arr.add("7");
        arr.add("8");
        return arr;
    }

    /**
     * 当前item改变
     *
     * @param viewHolder
     * @param adapterPosition
     */
    @Override
    public void onCurrentItemChanged(@Nullable RecyclerView.ViewHolder viewHolder, int adapterPosition) {
        toast("当前选中=" + adapterPosition);
    }

    /**
     * 开始滚动
     *
     * @param currentItemHolder
     * @param adapterPosition
     */
    @Override
    public void onScrollStart(@NonNull RecyclerView.ViewHolder currentItemHolder, int adapterPosition) {

    }

    /**
     * 滚动结束
     *
     * @param currentItemHolder
     * @param adapterPosition
     */
    @Override
    public void onScrollEnd(@NonNull RecyclerView.ViewHolder currentItemHolder, int adapterPosition) {

    }

    /**
     * 滚动中
     *
     * @param scrollPosition
     * @param currentPosition
     * @param newPosition
     * @param currentHolder
     * @param newCurrent
     */
    @Override
    public void onScroll(float scrollPosition, int currentPosition, int newPosition, @Nullable RecyclerView.ViewHolder currentHolder, @Nullable RecyclerView.ViewHolder newCurrent) {

    }


    public void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
