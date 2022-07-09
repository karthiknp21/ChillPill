package com.example.chillpill;

import android.content.Context;
import androidx.annotation.NonNull;

import com.example.chillpill.data.source.MedicineRepository;
import com.example.chillpill.data.source.local.MedicinesLocalDataSource;



public class Injection {

    public static MedicineRepository provideMedicineRepository(@NonNull Context context) {
        return MedicineRepository.getInstance(MedicinesLocalDataSource.getInstance(context));
    }
}