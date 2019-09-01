package com.isil.am2template.presenter;

import com.isil.am2template.storage.request.ApiClient;
import com.isil.am2template.storage.request.StorageConstant;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by emedinaa on 17/11/17.
 */

public class RemoveNotePresenter {

    private RemoveNoteContract.View view;

    public void remove(String token,String noteId){

        Map<String, String> map = new HashMap<>();
        map.put("user-token",token);
        Call<Object> call= ApiClient.getMyApiClient().deleteNoteBL(
                StorageConstant.APPLICATIONID, StorageConstant.RESTAPIKEY,map,noteId);

        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                view.hideLoading();
                if(response!=null){

                    if(response.isSuccessful()){
                        view.removeOperationSuccess();
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

    public void attachView(RemoveNoteContract.View view){
        this.view=view;
    }

    public void detachView(){
        this.view=null;
    }
}
