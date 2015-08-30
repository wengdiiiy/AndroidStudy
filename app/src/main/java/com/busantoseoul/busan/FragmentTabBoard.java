package com.busantoseoul.busan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.busantoseoul.busan.model.Board;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FragmentTabBoard extends Fragment implements View.OnClickListener{

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Fragment2.
     */

    public static FragmentTabBoard newInstance() {
        return new FragmentTabBoard();
    }

    public FragmentTabBoard() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_board, container, false);
    }

    private List<Board> boardList = new ArrayList<Board>();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        for (int i = 0; i < 20; i++) {
            Board board = new Board();
            board.setTitle("제목 " + i);
            board.setNum("조회수 " + i);
            boardList.add(board);
        }

        MyAdapter adapter = new MyAdapter(getActivity(), R.layout.tab_board_item, boardList);
        ListView listView = (ListView) getActivity().findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_ok:
            Toast.makeText(getActivity(), "board", Toast.LENGTH_SHORT)
            .show();
            break;
        }
    }
}
