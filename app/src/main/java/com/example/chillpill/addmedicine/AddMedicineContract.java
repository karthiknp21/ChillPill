package com.example.chillpill.addmedicine;

import com.example.chillpill.BasePresenter;
import com.example.chillpill.BaseView;
import com.example.chillpill.data.source.MedicineAlarm;
import com.example.chillpill.data.source.Pills;

import java.util.List;



public interface AddMedicineContract {

    interface View extends BaseView<Presenter> {

        void showEmptyMedicineError();

        void showMedicineList();

        boolean isActive();

    }

    interface  Presenter extends BasePresenter{


        void saveMedicine(MedicineAlarm alarm, Pills pills);


        boolean isDataMissing();

        boolean isMedicineExits(String pillName);

        long addPills(Pills pills);

        Pills getPillsByName(String pillName);

        List<MedicineAlarm> getMedicineByPillName(String pillName);

        List<Long> tempIds();

        void deleteMedicineAlarm(long alarmId);

    }
}
