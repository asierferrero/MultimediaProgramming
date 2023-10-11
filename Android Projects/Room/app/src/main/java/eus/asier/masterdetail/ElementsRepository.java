package eus.asier.masterdetail;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ElementsRepository {
    private ElementsDB.ElementsDAO elementsDAO;

    public ElementsRepository(Application application) {
        elementsDAO = ElementsDB.obtainInstance(application).getElementsDAO();
    }

    public LiveData<List<Element>> get() {
        return elementsDAO.getElements();
    }

    LiveData<List<Element>> bestRated() {
        return elementsDAO.bestRated();
    }

    LiveData<List<Element>> search(String t) {
        return elementsDAO.search(t);
    }

    private Executor executor = Executors.newSingleThreadExecutor();

    public void insert(Element element) {
        executor.execute(() -> elementsDAO.insert(element));
    }

    public void delete(Element element) {
        executor.execute(() -> elementsDAO.delete(element));
    }

    public void update(Element element, float rating) {
        executor.execute(() -> {
            element.rating = rating;
            elementsDAO.update(element);
        });
    }
}
