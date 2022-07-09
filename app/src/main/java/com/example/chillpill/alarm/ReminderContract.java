package com.example.chillpill.alarm;

import com.example.chillpill.BasePresenter;
import com.example.chillpill.BaseView;
import com.example.chillpill.data.source.MedicineAlarm;

import com.example.chillpill.data.source.History;




public interface ReminderContract {

    interface View extends BaseView<Presenter> {

        void showMedicine(MedicineAlarm medicineAlarm);

        void showNoData();

        boolean isActive();

        void onFinish();

    }

    interface Presenter extends BasePresenter {

        void finishActivity();

        void onStart(long id);

        void loadMedicineById(long id);

        void addPillsToHistory(History history);

    }
}
