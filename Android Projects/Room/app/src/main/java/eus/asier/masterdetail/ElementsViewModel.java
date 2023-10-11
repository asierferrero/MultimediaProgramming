package eus.asier.masterdetail;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.util.List;

public class ElementsViewModel extends AndroidViewModel {

    public ElementsRepository elementsRepository;
    private MutableLiveData<Element> elementSelected = new MutableLiveData<>();
    private MutableLiveData<List<Element>> listElementsMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<String> termSearch = new MutableLiveData<>();
    private LiveData<List<Element>> resultSearch;

    public ElementsViewModel(@NonNull Application application) {
        super(application);
        elementsRepository = new ElementsRepository(application);
        elementsRepository.get().observeForever(elements -> {
            listElementsMutableLiveData.postValue(elements);
        });

        resultSearch = Transformations.switchMap(termSearch, input -> elementsRepository.search(input));
    }

    public void select(Element element){
        elementSelected.setValue(element);
    }

    public LiveData<Element> selected(){
        return elementSelected;
    }

    public LiveData<String> termSearch(){
        return termSearch;
    }

    public LiveData<List<Element>> search(){
        return resultSearch;
    }

    public LiveData<List<Element>> obtain(){
        return elementsRepository.get();
    }

    public LiveData<List<Element>> bestRated(){
        return elementsRepository.bestRated();
    }

    public void putTermSearch(String t){
        termSearch.setValue(t);
    }

    public void insert(Element element){
        elementsRepository.insert(element);
    }

    public void delete(Element element){
        elementsRepository.delete(element);
    }

    public void update(Element element, float rating){
        elementsRepository.update(element, rating);
    }
}
