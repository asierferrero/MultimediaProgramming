package eus.urko.recyclerviewfragments;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ElementsViewModel extends AndroidViewModel {

    private ElementsRepository elementsRepository;
    private MutableLiveData<List<Element>> elementsLiveData = new MutableLiveData<>();
    private MutableLiveData<Element> elementSelected = new MutableLiveData<>();

    public ElementsViewModel(@NonNull Application application) {
        super(application);

        elementsRepository = new ElementsRepository();

        // Initialize elementsLiveData with the initial data (e.g., data from the repository)
        elementsLiveData.setValue(elementsRepository.get());
    }

    // Expose LiveData for observing the list of elements
    public LiveData<List<Element>> getElementsLiveData() {
        return elementsLiveData;
    }

    public void add(Element element) {
        elementsRepository.insert(element, new ElementsRepository.Callback() {
            @Override
            public void whenFinish(List<Element> elements) {
                elementsLiveData.setValue(elements);
            }
        });
    }

    public void delete(Element element) {
        elementsRepository.delete(element, new ElementsRepository.Callback() {
            @Override
            public void whenFinish(List<Element> elements) {
                elementsLiveData.setValue(elements);
            }
        });
    }

    public void update(Element element, float rating) {
        elementsRepository.update(element, rating, new ElementsRepository.Callback() {
            @Override
            public void whenFinish(List<Element> elements) {
                elementsLiveData.setValue(elements);
            }
        });
    }

    void select(Element element){
        elementSelected.setValue(element);
    }

    MutableLiveData<Element> selected(){
        return elementSelected;
    }

    public LiveData<Element> getSelectedElement() {
        return elementSelected;
    }
}
