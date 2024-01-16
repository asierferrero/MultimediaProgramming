package eus.asier.personalproject;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class TeamsViewModel extends AndroidViewModel {

    ElementsRepository elementsRepository;

    MutableLiveData<Element> elementSelected = new MutableLiveData<>();

    public TeamsViewModel(@NonNull Application application) {
        super(application);

        elementsRepository = new ElementsRepository(application);
    }

    void insert(Element element){
        elementsRepository.insert(element);
    }

    void delete(Element element){
        elementsRepository.delete(element);
    }

    void update(Element element){
        elementsRepository.update(element);
    }

    void select(Element element){
        elementSelected.setValue(element);
    }

    MutableLiveData<Element> selected(){
        return elementSelected;
    }

    LiveData<List<Element>> obtain(){
        return elementsRepository.get();
    }

}