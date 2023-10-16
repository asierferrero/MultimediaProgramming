package eus.asier.masterdetail;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RecyclerSearchFragment extends RecyclerFragment {
    private ElementsViewModel elementsViewModel;
    @Override
    LiveData<List<Element>> getElements() {
        return elementsViewModel.search();
    }
}