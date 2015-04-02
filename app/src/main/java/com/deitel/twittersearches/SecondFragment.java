package com.deitel.twittersearches;


import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


/**
 * A simple {@link android.app.Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class SecondFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "query";

    private String query;
    private WebView queryView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param query Parameter 1.
     * @return A new instance of fragment SecondFragment.
     */
    public static SecondFragment newInstance(String query) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, query);
        fragment.setArguments(args);
        return fragment;
    }

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            query = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.second_fragment, container, false);

        // Set the adapter
        queryView = (WebView) myView.findViewById(R.id.queryView);
        queryView.getSettings().setJavaScriptEnabled(true);
        queryView.getSettings().setBuiltInZoomControls(true);
        queryView.loadUrl(query);
        queryView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView nView, String url) {
                nView.loadUrl(url);
                return true;
            }
            @Override
            public void onReceivedError(WebView nView, int errorCode,
                                        String description, String failingUrl) {
                Toast.makeText(getActivity(), "Sorry," + description, Toast.LENGTH_SHORT).show();
            }
        });
        return myView;
    }
}
