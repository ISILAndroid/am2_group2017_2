package com.isil.am2template.presenter;

import com.isil.am2template.storage.request.ApiClient;
import com.isil.am2template.storage.request.StorageConstant;
import com.isil.am2template.storage.request.entity.NoteBLRaw;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by emedinaa on 17/11/17.
 */

public class AddNotePresenter {

    private AddNoteContract.View view;

    public void add(String token,String title,
                    String description){

        NoteBLRaw noteBLRaw= new NoteBLRaw();
        noteBLRaw.setTitle(title);
        noteBLRaw.setDescription(description);
        Map<String, String> map = new HashMap<>();
        map.put("user-token",token);
        Call<Object> call= ApiClient.getMyApiClient().addNoteBL(
                StorageConstant.APPLICATIONID, StorageConstant.RESTAPIKEY,map,noteBLRaw);

        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                view.hideLoading();
                if(response!=null){

                    if(response.isSuccessful()){
                        view.operationSuccess();
                    }else{
                        view.showMessage("Ocurrió un error");
                    }
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                view.hideLoading();
                view.showMessage(t.getMessage());
            }
        });
    }

    public void attachView(AddNoteContract.View view){
        this.view=view;
    }

    public void detachView(){
        this.view=null;
    }
}
