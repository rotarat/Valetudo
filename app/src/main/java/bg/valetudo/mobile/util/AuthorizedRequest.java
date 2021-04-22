package bg.valetudo.mobile.util;

import androidx.annotation.Nullable;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import bg.valetudo.mobile.UserPreferences;

public class AuthorizedRequest extends JsonObjectRequest {
    public AuthorizedRequest(int method, String url, @Nullable JSONObject jsonRequest, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
    }

    @Override
    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();

        if(UserPreferences.getInstance().getToken() != null)
            headers.put("Authorization", UserPreferences.getInstance().getToken());

        return headers;
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        if (response.data.length == 0) {
            byte[] responseData = "{}".getBytes(StandardCharsets.UTF_8);
            response = new NetworkResponse(response.statusCode, responseData, response.notModified, 1000, response.allHeaders);
        }
        return super.parseNetworkResponse(response);
    }
}
