package eus.asier.masterdetail;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ElementsViewModel extends AndroidViewModel {

    ElementsRepository elementsRepository;

    MutableLiveData<Element> elementSelected = new MutableLiveData<>();

    public ElementsViewModel(@NonNull Application application) {
        super(application);

        elementsRepository = new ElementsRepository(application);
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

    void insert(Element elemento){
        elementsRepository.insert(elemento);
    }

    void delete(Element elemento){
        elementsRepository.delete(elemento);
    }

    void update(Element elemento, float valoracion){
        elementsRepository.update(elemento, valoracion);
    }
}
