package eus.asier.masterdetail;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.util.List;

import kotlin.jvm.functions.Function1;

public class ElementsViewModel extends AndroidViewModel {

    ElementsRepository elementsRepository;

    MutableLiveData<List<Element>> listElementsMutableLiveData =
            new MutableLiveData<>();
    MutableLiveData<Element> elementSelected = new MutableLiveData<>();

    MutableLiveData<String> termSearch = new MutableLiveData<>();

    LiveData<List<Element>> resultSearch = Transformations.switchMap(termSearch, new Function1<String, LiveData<List<Element>>>() {
        @Override
        public LiveData<List<Element>> invoke(String input) {
            return elementsRepository.search(input);
        }
    });

    public ElementsViewModel(@NonNull Application application) {
        super(application);

        elementsRepository = new ElementsRepository(application);
    }

    void insert(Element element){
        elementsRepository.insert(element);
    }

    void delete(Element element){
        elementsRepository.delete(element);
    }

    void update(Element element, float rating){
        elementsRepository.update(element, rating);
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

    LiveData<List<Element>> bestRated(){
        return elementsRepository.bestRated();
    }

    LiveData<List<Element>> search(){
        return resultSearch;
    }
}