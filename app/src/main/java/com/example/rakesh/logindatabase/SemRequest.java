package com.example.rakesh.logindatabase;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SemRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "https://rakeshemperor.000webhostapp.com/semselect.php";
    private Map<String, String> params;

    public SemRequest(String username, String semester, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("sem", semester);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
