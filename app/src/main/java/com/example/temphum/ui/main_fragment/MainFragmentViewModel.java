package com.example.temphum.ui.main_fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.temphum.domain.TemperatureRepository;
import com.example.temphum.model.TempAnswer;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainFragmentViewModel extends ViewModel {

private final MutableLiveData<TempAnswer> tempAnswerMutableLiveData = new MutableLiveData<>();
private final TemperatureRepository temperatureRepository = new TemperatureRepository();
public LiveData<TempAnswer> getTemperature() {
    return tempAnswerMutableLiveData;
}

    void loadTemp() {
    temperatureRepository.getTemperature()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<TempAnswer>() {
                @Override
                public void onSubscribe(Disposable d) {}

                @Override
                public void onNext(TempAnswer temp) {
                    tempAnswerMutableLiveData.postValue(temp);
                }

                @Override
                public void onError(Throwable e) {
                    tempAnswerMutableLiveData.postValue(null);
                }

                @Override
                public void onComplete() {
                    // Updates UI with data

                }
            });

}


}

